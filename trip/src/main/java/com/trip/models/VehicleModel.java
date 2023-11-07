package com.trip.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

// import java.util.List;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
// import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "vehicle")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @ManyToOne
    // @JoinColumn(name = "trip")
    // private TripModel trip;

    // @Column(name = "name")
    // private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "capacity")
    private Integer capacity;

    //@JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "origin_city")
    private CityModel origin_city;

    //@JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "destination_city")
    private CityModel destination_city;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    // public String getName() {
        //return name;
    //}

    //public void setName(String name) {
        //this.name = name;
    //}

    // public TripModel getTrip() {
    //     return trip;
    // }

    // public void setTrip(TripModel trip) {
    //     this.trip = trip;
    // }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public CityModel getOrigin_city() {
        return origin_city;
    }

    public void setOrigin_city(CityModel origin_city) {
        this.origin_city = origin_city;
    }

    public CityModel getDestination_city() {
        return destination_city;
    }
    public void setDestination_city(CityModel destination_city) {
        this.destination_city = destination_city;
    }

}