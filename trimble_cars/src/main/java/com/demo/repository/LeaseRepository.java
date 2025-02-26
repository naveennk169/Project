package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Lease;

public interface LeaseRepository extends JpaRepository<Lease, Long> { }
