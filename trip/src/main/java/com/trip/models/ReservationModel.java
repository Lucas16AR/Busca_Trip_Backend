package com.trip.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class ReservationModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingModel booking;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private Date date;

    @Column(name = "price")
    private int price;

    @ManyToMany
    @JoinTable(name = "reservation_passenger",
               joinColumns = @JoinColumn(name = "reservation_id"),
               inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    private List<PassengerModel> passengers;

    public ReservationModel() {
        // Empty constructor required by JPA
    }

    public ReservationModel(UserModel user, BookingModel booking, String status, Date date, int price) {
        this.user = user;
        this.booking = booking;
        this.status = status;
        this.date = date;
        this.price = price;
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

    public BookingModel getBooking() {
        return booking;
    }

    public void setBooking(BookingModel booking) {
        this.booking = booking;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<PassengerModel> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerModel> passengers) {
        this.passengers = passengers;
    }
}
