package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.model.Car;
import com.demo.model.Lease;
import com.demo.model.User;
import com.demo.repository.UserRepository;
import com.demo.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}/status")
    public String getCarStatus(@PathVariable Long id) {
        return carService.getCarStatus(id);
    }

    @PostMapping("/register")
    public Car registerCar(@RequestBody Car car, @RequestParam Long ownerId) {
        User owner = userRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("User not found"));
        return carService.registerCar(car, owner);
    }

    @GetMapping("/{id}/leases")
    public List<Lease> getLeaseHistory(@PathVariable Long id) {
        return carService.getLeaseHistory(id);
    }
}
