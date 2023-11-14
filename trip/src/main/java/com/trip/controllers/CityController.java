package com.trip.controllers;

import com.trip.models.CityModel;
import com.trip.services.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityModel>> getAllCities() {
        List<CityModel> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityModel> getCityById(@PathVariable("id") Long id) {
        CityModel city = cityService.getCity(id);
        if (city != null) {
            return new ResponseEntity<>(city, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CityModel> addCity(@Valid @RequestBody CityModel city) {
        CityModel savedCity = cityService.addCity(city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityModel> updateCity(@PathVariable("id") Long id, @Valid @RequestBody CityModel city) {
        CityModel existingCity = cityService.getCity(id);

        if (existingCity != null) {
            city.setId(id);
            CityModel updatedCity = cityService.updateCity(city);
            return new ResponseEntity<>(updatedCity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Long id) {
        CityModel existingCity = cityService.getCity(id);

        if (existingCity != null) {
            cityService.deleteCity(id);
            return new ResponseEntity<>("City deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("City not found", HttpStatus.NOT_FOUND);
        }
    }
}

