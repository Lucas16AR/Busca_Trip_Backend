package com.trip.services;

import com.trip.repositories.CityRepository;
import com.trip.models.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.validation.Valid;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

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
        return (List<CityModel>) cityRepository.findAll();
    }

    public List<CityModel> findAll() {
        return null;
    }

    public CityModel save(@Valid CityModel city) {
        return null;
    }

    public void deleteById(Long id) {
    }
}