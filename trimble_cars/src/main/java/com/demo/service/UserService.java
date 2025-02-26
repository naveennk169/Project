package com.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Car;
import com.demo.model.Status;
import com.demo.model.User;
import com.demo.repository.CarRepository;
import com.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    
     // Retrieve all cars from the repository.
     
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    
     //Register a new car for a given owner.
     
    public Car registerCar(Car car, Long ownerId) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Car Owner not found with ID: " + ownerId));

        car.setOwner(owner);
        car.setStatus(Status.IDEAL);
        return carRepository.save(car);
    }
}
