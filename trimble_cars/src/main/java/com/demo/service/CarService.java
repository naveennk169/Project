package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Car;
import com.demo.model.Lease;
import com.demo.model.User;
import com.demo.repository.CarRepository;
import com.demo.repository.LeaseRepository;

import jakarta.persistence.*;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private LeaseRepository leaseRepository;

    // Check Car Status
    public String getCarStatus(Long carId) {
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
        return car.getStatus();
    }

    // Register and enroll the car (for Car Owner)
    public Car registerCar(Car car, User owner) {
        car.setOwner(owner);
        return carRepository.save(car);
    }

    // Lease History (for Car Owner)
    public List<Lease> getLeaseHistory(Long carId) {
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
        return car.getLeases();
    }
}