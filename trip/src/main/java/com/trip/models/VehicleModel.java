package com.trip.models;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "vehicles")
public class VehicleModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "seats")
    private int seats;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    @OneToMany(mappedBy = "vehicle")
    private List<TripModel> trips;

    @OneToMany(mappedBy = "vehicle")
    private List<BookingModel> bookings;

    public VehicleModel() {
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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }

    public List<TripModel> getTrips() {
        return trips;
    }

    public void setTrips(List<TripModel> trips) {
        this.trips = trips;
    }

    public List<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingModel> bookings) {
        this.bookings = bookings;
    }
}
