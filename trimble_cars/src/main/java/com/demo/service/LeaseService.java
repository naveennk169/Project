package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Car;
import com.demo.model.Lease;
import com.demo.model.User;
import com.demo.repository.CarRepository;
import com.demo.repository.LeaseRepository;
import com.demo.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaseService {
    @Autowired
    private LeaseRepository leaseRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    // Start Lease (for End Customer)
    public Lease startLease(Long carId, Long customerId) {
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
        User customer = userRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));

        if (customer.getLeases().size() >= 2) {
            throw new RuntimeException("Customer can have a maximum of 2 active leases.");
        }

        Lease lease = new Lease();
        lease.setCar(car);
        lease.setCustomer(customer);
        lease.setStartDate(LocalDate.now());
        leaseRepository.save(lease);

        car.setStatus("On Lease");
        carRepository.save(car);

        return lease;
    }

    // End Lease (for End Customer)
    public Lease endLease(Long leaseId) {
        Lease lease = leaseRepository.findById(leaseId).orElseThrow(() -> new RuntimeException("Lease not found"));

        lease.setEndDate(LocalDate.now());
        leaseRepository.save(lease);

        Car car = lease.getCar();
        car.setStatus("Ideal");
        carRepository.save(car);

        return lease;
    }

    // Lease History (for End Customer)
    public List<Lease> getLeaseHistory(Long customerId) {
        User customer = userRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        return customer.getLeases();
    }
}
