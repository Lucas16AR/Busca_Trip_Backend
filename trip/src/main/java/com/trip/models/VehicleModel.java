package com.trip.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

// import java.util.List;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
// import jakarta.persistence.ManyToMany;

@Entity
@Data
@Table(name = "vehicles")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @ManyToOne
    // @JoinColumn(name = "trip")
    // private TripModel trip;

    // @Column(name = "name")
    // private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "capacity")
    private Integer capacity;

    //@JsonIdentityReference(alwaysAsId = true)

    @ManyToOne
    @JoinColumn(name = "company")
    private CompanyModel company;
}