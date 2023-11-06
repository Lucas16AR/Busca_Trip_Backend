package com.trip.models;

import javax.persistence.*;
// import javax.persistence.Entity;
// import javax.persistence.GenerationType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Table;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Column;
import com.trip.models.UserModel;
import com.trip.models.VehicleModel;
import java.io.Serializable;
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

    @OneToMany
    @JoinColumn(name = "origin_city")
    private CityModel origin_city;

    @OneToMany
    @JoinColumn(name = "destination_city")
    private CityModel destination_city;

    @ManyToOne
    @JoinColumn(name = "user")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "vehicle")
    private VehicleModel vehicle;

    public void setId(Long id) {
        this.id = id;
    }

    public void setVehicle(VehicleModel vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleModel getVehicle() {
        return vehicle;
    }

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

    public CityModel getOrigin_city() {
        return origin_city;
    }

    public void setOrigin_city(CityModel origin_city) {
        this.origin_city = origin_city;
    }

    public CityModel getDestination_city() {
        return destination_city;
    }
    public void setDestination_city(CityModel destination_city) {
        this.destination_city = destination_city;
    }

}