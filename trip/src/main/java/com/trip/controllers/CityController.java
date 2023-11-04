package com.trip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.trip.models.CityModel;
import com.trip.services.CityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    
    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityModel>> getAllCities() {
        List<CityModel> cities = cityService.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CityModel> addCity(@Valid @RequestBody CityModel city) {
        CityModel savedCity = cityService.save(city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CityModel> updateCity(@Valid @RequestBody CityModel city) {
        CityModel updatedCity = cityService.updateCity(city);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Long id) {
        cityService.deleteById(id);
        return new ResponseEntity<>("City deleted successfully", HttpStatus.OK);
    }
}