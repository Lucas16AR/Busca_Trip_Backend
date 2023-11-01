package com.trip.models;

import javax.persistence.*;
import java.util.Date;
import java.sql.Time;
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

@Entity
@Table(name = "trips")
public class TripModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "origin_city_id")
    private CityModel originCity;

    @ManyToOne
    @JoinColumn(name = "destination_city_id")
    private CityModel destinationCity;

    @Column(name = "trip_time")
    private Time tripTime;

    @Column(name = "distance")
    private int distance;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleModel vehicle;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    @OneToMany(mappedBy = "trip")
    private List<BookingModel> bookings;

    @OneToMany(mappedBy = "trip")
    private List<ReservationModel> reservations;

    public TripModel() {
    }

    // Getters and Setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CityModel getOriginCity() {
        return originCity;
    }

    public void setOriginCity(CityModel originCity) {
        this.originCity = originCity;
    }

    public CityModel getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(CityModel destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Time getTripTime() {
        return tripTime;
    }

    public void setTripTime(Time tripTime) {
        this.tripTime = tripTime;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public VehicleModel getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleModel vehicle) {
        this.vehicle = vehicle;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }

    public List<BookingModel> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingModel> bookings) {
        this.bookings = bookings;
    }

    public List<ReservationModel> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationModel> reservations) {
        this.reservations = reservations;
    }
}
