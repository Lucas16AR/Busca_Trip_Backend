package com.trip.models;

// import javax.persistence.*;
import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.util.Date;


@Entity
@Data
@Table(name = "trips")
public class TripModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "vehicle")
    private VehicleModel vehicle;

    @ManyToOne
    @JoinColumn(name = "origin_city")
    private CityModel origin_city;

    @ManyToOne
    @JoinColumn(name = "destination_city")
    private CityModel destination_city;

    @Column(name = "price")
    private Double price;

    @Column(name = "available_seats")
    private Integer available_seats;

    @Column(name = "departure_time")
    private String departure_time;

    @Column(name = "arrival_time")
    private String arrival_time;
   
}