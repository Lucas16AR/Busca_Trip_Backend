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
import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "cities")
public class CityModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "code")
    private int code;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "originCity")
    private List<TripModel> originTrips;

    @OneToMany(mappedBy = "destinationCity")
    private List<TripModel> destinationTrips;

    @ManyToMany(mappedBy = "cities")
    private List<CompanyModel> companies;

    @OneToMany(mappedBy = "originCity")
    private List<BookingModel> originBookings;

    @OneToMany(mappedBy = "destinationCity")
    private List<BookingModel> destinationBookings;

    @OneToMany(mappedBy = "city")
    private List<VehicleModel> vehicles;

    public CityModel() {
        // Constructor vacío requerido por JPA
    }

    public CityModel(int code, String name, String state) {
        this.code = code;
        this.name = name;
        this.state = state;
    }

    // Getters and Setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public List<CompanyModel> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyModel> companies) {
        this.companies = companies;
    }

    public List<BookingModel> getOriginBookings() {
        return originBookings;
    }

    public void setOriginBookings(List<BookingModel> originBookings) {
        this.originBookings = originBookings;
    }

    public List<BookingModel> getDestinationBookings() {
        return destinationBookings;
    }

    public void setDestinationBookings(List<BookingModel> destinationBookings) {
        this.destinationBookings = destinationBookings;
    }

    public List<VehicleModel> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleModel> vehicles) {
        this.vehicles = vehicles;
    }
}