package com.trip.services;

import com.trip.repositories.TripRepository;
import com.trip.models.CityModel;
import com.trip.models.TripModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.sql.Date;
import java.sql.Timestamp;
@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private CityService cityService;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public TripModel addTrip(TripModel trip) {
        return tripRepository.save(trip);
    }

    public TripModel updateTrip(Long id, TripModel trip) {
        TripModel existingTrip = tripRepository.findById(id).orElse(null);
        if (existingTrip != null) {
            trip.setId(id);
            return tripRepository.save(trip);
        } else {
            return null;
        }
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public TripModel getTrip(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public List<TripModel> getAllTrips() {
        return (List<TripModel>) tripRepository.findAll();
    }

    public List<TripModel> getTripsByOriginAndDestination(String originCity, String destinationCity, String date) {
        CityModel origin = cityService.getCityByName(originCity);
        CityModel destination = cityService.getCityByName(destinationCity);
    
        DateTimeFormatter formatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        DateTimeFormatter formatterWithoutTime = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ZonedDateTime departureDateTime;
    
        try {
            departureDateTime = ZonedDateTime.parse(date, formatterWithTime.withZone(ZoneId.of("UTC")));
        } catch (DateTimeParseException e) {
            departureDateTime = LocalDate.parse(date, formatterWithoutTime).atStartOfDay(ZoneId.of("UTC"));
        }
    
        ZonedDateTime startOfDay = departureDateTime.toLocalDate().atStartOfDay(departureDateTime.getZone());
        ZonedDateTime endOfDay = startOfDay.plusDays(1);
        Timestamp departureTimeStart = Timestamp.valueOf(startOfDay.toLocalDateTime());
        Timestamp departureTimeEnd = Timestamp.valueOf(endOfDay.toLocalDateTime());
    
        return tripRepository.findByOriginAndDestination(origin, destination, departureTimeStart, departureTimeEnd);
    }
    
    
}
