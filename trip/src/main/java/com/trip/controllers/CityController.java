package com.trip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.trip.models.CityModel;
import com.trip.repositories.CityRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {
    
    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public ResponseEntity<List<CityModel>> getAllCities() {
        List<CityModel> cities = (List<CityModel>) cityRepository.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityModel> getCityById(@PathVariable("id") Long id) {
        Optional<CityModel> city = cityRepository.findById(id);
        if (city.isPresent()) {
            return new ResponseEntity<>(city.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CityModel> addCity(@Valid @RequestBody CityModel city) {
        CityModel savedCity = cityRepository.save(city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CityModel> updateCity(@Valid @RequestBody CityModel city) {
        CityModel updatedCity = cityRepository.save(city);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable("id") Long id) {
        Optional<CityModel> city = cityRepository.findById(id);
        if (city.isPresent()) {
            cityRepository.deleteById(id);
            return new ResponseEntity<>("City deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("City not found", HttpStatus.NOT_FOUND);
        }
    }
}
