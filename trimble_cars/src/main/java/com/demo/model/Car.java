package com.trimblecars.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String variant;
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    @ManyToOne
    private User owner;

    public enum CarStatus {
        IDLE,
        ON_LEASE,
        ON_SERVICE
    }

    // Constructors
    public Car() {}

    // Getters and setters
    public Long getId() {
	    return id;
    }
    public void setId(Long id) {
	    this.id = id;
    }
    public String getModel() { 
	    return model; 
    }
    public void setModel(String model) { 
	    this.model = model; 
    }
    public String getVariant() { 
	    return variant;
    }
    public void setVariant(String variant) { 
	    this.variant = variant; 
    }
    public String getRegistrationNumber() {
	    return registrationNumber; 
    }
    public void setRegistrationNumber(String registrationNumber) { 
	    this.registrationNumber = registrationNumber;
    }
    public CarStatus getStatus() {
	    return status; 
    }
    public void setStatus(CarStatus status) { 
	    this.status = status;
    }
    public User getOwner() {
	    return owner; 
    }
    public void setOwner(User owner) {
	    this.owner = owner; 
    }
}
