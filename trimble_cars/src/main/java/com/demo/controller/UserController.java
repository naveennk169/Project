package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Car;
import com.demo.model.Lease;
import com.demo.model.User;
import com.demo.repository.CarRepository;
import com.demo.repository.LeaseRepository;
import com.demo.repository.UserRepository;
import com.demo.service.CarService;
import com.demo.service.LeaseService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private CarService carService;

    @Autowired
    private LeaseService leaseService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private LeaseRepository leaseRepository;

    @Autowired
    private UserRepository userRepository;

    // Admin can perform all operations available to Car Owner and End Customer
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/leases")
    public List<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }

    @PostMapping("/cars/register")
    public Car registerCar(@RequestBody Car car, @RequestParam Long ownerId) {
        User owner = userRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("User not found"));
        return carService.registerCar(car, owner);
    }

    @GetMapping("/healthCheck")
    public String getHealth(){
        return "Running";
    }
}
