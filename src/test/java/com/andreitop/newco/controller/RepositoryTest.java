package com.andreitop.newco.controller;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private TripRepository tripRepository;

    @Test
    public void savePlusFindByIdTest() {
        TripDto newTrip = new TripDto();
        newTrip.setId(5L);
        newTrip.setOrigin("MOW");
        newTrip.setDestination("LED");
        newTrip.setPrice(1005);

        tripRepository.save(newTrip);

        Optional<TripDto> trip = tripRepository.findById(5L);
        assert trip.isPresent() &&
                trip.get().getOrigin().equals("MOW") &&
                trip.get().getDestination().equals("LED") &&
                trip.get().getPrice() == 1005;
    }

    @Test
    public void updateTest() {
        TripDto newTrip = new TripDto();
        newTrip.setId(5L);
        newTrip.setOrigin("MOW");
        newTrip.setDestination("LED");
        newTrip.setPrice(2075);

        Optional<TripDto> trip = tripRepository.findById(5L);
        System.out.println(trip);

        tripRepository.save(newTrip);

        trip = tripRepository.findById(5L);
        assert trip.isPresent() &&
                trip.get().getOrigin().equals("MOW") &&
                trip.get().getDestination().equals("LED") &&
                trip.get().getPrice() == 2075;
    }

    @Test
    public void deleteTest() {
        tripRepository.deleteById(5L);
        assert tripRepository.findAll().isEmpty();
    }
}
