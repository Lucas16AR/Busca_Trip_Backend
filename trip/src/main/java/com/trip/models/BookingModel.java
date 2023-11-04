package com.trip.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bookings")
public class BookingModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "origin_city_id")
    private CityModel originCity;

    @ManyToOne
    @JoinColumn(name = "destination_city_id")
    private CityModel destinationCity;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private TripModel trip;

    @OneToMany(mappedBy = "booking")
    private List<ReservationModel> reservations;

    @ManyToMany
    @JoinTable(name = "booking_passenger",
               joinColumns = @JoinColumn(name = "booking_id"),
               inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    private List<PassengerModel> passengers;

    public BookingModel() {
        // Empty constructor required by JPA
    }

    public BookingModel(CityModel originCity, CityModel destinationCity, CompanyModel company, TripModel trip) {
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.company = company;
        this.trip = trip;
    }

    // Getters and Setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
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

    public CompanyModel getCompany() {
        return company;
    }

    public void setCompany(CompanyModel company) {
        this.company = company;
    }

    public TripModel getTrip() {
        return trip;
    }

    public void setTrip(TripModel trip) {
        this.trip = trip;
    }

    public List<ReservationModel> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationModel> reservations) {
        this.reservations = reservations;
    }

    public List<PassengerModel> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerModel> passengers) {
        this.passengers = passengers;
    }
}