package com.trimblecars.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Lease {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Car car;

    @ManyToOne
    private User customer;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private LeaseStatus status;

    public enum LeaseStatus {
        ACTIVE, ENDED
    }

    // Constructors
    public Lease() {}

    // Getters and setters
    public Long getId() { 
        return id;
    }
    public void setId(Long id) {
        this.id = id; 
    }
    public Car getCar() {
        return car; 
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public User getCustomer() {
        return customer; 
    }
    public void setCustomer(User customer) { 
        this.customer = customer;
    }
    public LocalDateTime getStartDate() {
        return startDate; 
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public LocalDateTime getEndDate() { 
        return endDate; 
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public LeaseStatus getStatus() { 
        return status;
    }
    public void setStatus(LeaseStatus status) {
        this.status = status; 
    }
}
