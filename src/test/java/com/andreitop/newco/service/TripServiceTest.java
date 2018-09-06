package com.andreitop.newco.service;

import com.andreitop.newco.BaseTest;
import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.CustomRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TripServiceTest extends BaseTest {

    @MockBean
    private CustomRepository<TripDto> tripRepository;

    @Autowired
    private TripService tripService;

    @Test
    public void findAll() {
        when(tripRepository.findAll()).thenReturn(allTrips);

        List<TripDto> trips = tripService.findAll();
        assertThat(trips.size(), is(allTrips.size()));

        verify(tripRepository, times(WANTED_NUMBER_OF_INVOCATIONS)).findAll();
    }

    @Test
    public void findById() {
        when(tripRepository.findById(TRIP_DTO_ID)).thenReturn(tripDto);

        TripDto tripDtoResult = tripService.findById(TRIP_DTO_ID);
        assertEquals(tripDtoResult, tripDto);

        verify(tripRepository, times(WANTED_NUMBER_OF_INVOCATIONS)).findById(TRIP_DTO_ID);
    }

    @Test
    public void save() {
        tripService.save(tripDto);

        verify(tripRepository, times(WANTED_NUMBER_OF_INVOCATIONS)).save(tripDto);
    }

    @Test
    public void delete() {
        tripService.delete(TRIP_DTO_ID);

        verify(tripRepository, times(WANTED_NUMBER_OF_INVOCATIONS)).delete(TRIP_DTO_ID);
    }

    @Test
    public void update() {
        tripService.update(tripDtoForUpdate);

        verify(tripRepository, times(WANTED_NUMBER_OF_INVOCATIONS)).update(tripDtoForUpdate);
    }
}