package com.trip.services;

import com.trip.repositories.CityRepository;
import com.trip.models.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CityModel addCity(CityModel city) {
        return cityRepository.save(city);
    }

    public CityModel updateCity(CityModel city) {
        return cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public CityModel getCity(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public List<CityModel> getAllCities() {
        return cityRepository.findAll();
    }
}