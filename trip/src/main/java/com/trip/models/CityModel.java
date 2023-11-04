package com.trip.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cities")
public class CityModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "originCity")
    private List<TripModel> originTrips;

    @OneToMany(mappedBy = "destinationCity")
    private List<TripModel> destinationTrips;

    public CityModel() {
    }

    public CityModel(String name) {
        this.name = name;
    }

    // Getters and Setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TripModel> getOriginTrips() {
        return originTrips;
    }

    public void setOriginTrips(List<TripModel> originTrips) {
        this.originTrips = originTrips;
    }

    public List<TripModel> getDestinationTrips() {
        return destinationTrips;
    }

    public void setDestinationTrips(List<TripModel> destinationTrips) {
        this.destinationTrips = destinationTrips;
    }
}
