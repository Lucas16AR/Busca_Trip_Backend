package com.trip.models;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
// import jakarta.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "cities")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CityModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    // @OneToMany
    // @Column(name = "origin_city")
    // private List<VehicleModel> vehiclesFromThisCity;

    // @OneToMany
    // @Column(name = "destination_city")
    // private List<VehicleModel> vehiclesToThisCity;
   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public List<VehicleModel> getVehiclesFromThisCity() {
    //     return vehiclesFromThisCity;
    // }

    // public void setVehiclesFromThisCity(List<VehicleModel> vehiclesFromThisCity) {
    //     this.vehiclesFromThisCity = vehiclesFromThisCity;
    // }

    // public List<VehicleModel> getVehiclesToThisCity() {
    //     return vehiclesToThisCity;
    // }

    // public void setVehiclesToThisCity(List<VehicleModel> vehiclesToThisCity) {
    //     this.vehiclesToThisCity = vehiclesToThisCity;
    // }
    
}