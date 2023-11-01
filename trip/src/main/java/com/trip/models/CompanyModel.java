package com.trip.models;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;

@Entity
@Table(name = "companies")
public class CompanyModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;

    @OneToMany(mappedBy = "company")
    private List<VehicleModel> vehicles;

    @OneToMany(mappedBy = "company")
    private List<BookingModel> bookings;

    @OneToMany(mappedBy = "company")
    private List<TripModel> trips;

    @ManyToMany
    @JoinTable(
        name = "company_city",
        joinColumns = @JoinColumn(name = "company_id"),
        inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private List<CityModel> cities;

    public CompanyModel() {
    }

    public CompanyModel(String name, String state) {
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

    public List<VehicleModel> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleModel> vehicles) {
        this.vehicles = vehicles;
    }

    public List<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingModel> bookings) {
        this.bookings = bookings;
    }

    public List<TripModel> getTrips() {
        return trips;
    }

    public void setTrips(List<TripModel> trips) {
        this.trips = trips;
    }

    public List<CityModel> getCities() {
        return cities;
    }

    public void setCities(List<CityModel> cities) {
        this.cities = cities;
    }
}