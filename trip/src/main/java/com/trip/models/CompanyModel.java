package com.trip.models;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
// import jakarta.persistence.ManyToMany;

// import java.io.Serializable;
// import java.util.List;

@Entity
@Table(name = "companies")
@Data
public class CompanyModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "vehicle")
    private List<Object> vehicles;

    @Column(name = "name")
    private String name;

}
    