package com.trip.models;

import javax.persistence.*;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "trip")
public class TripModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // @Column(name = "client_id")
    // private Integer client_id;

    // @Column(name = "host_id")
    // private Integer host_id;

    // @Column(name = "house_id")
    // private Integer house_id;

    @Column(name = "date")
    private Date date;



    @ManyToOne
    @JoinColumn(name = "user")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "vehicle")
    private VehicleModel vehicle;

    public void setId(Long id) {
        this.id = id;
    }

    // public void setVehicle(VehicleModel vehicle) {
    //     this.vehicle = vehicle;
    // }

    // public VehicleModel getVehicle() {
    //     return vehicle;
    // }

    public Long getId() {
        return id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}