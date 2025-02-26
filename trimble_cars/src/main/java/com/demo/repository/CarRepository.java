package com.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> { }
