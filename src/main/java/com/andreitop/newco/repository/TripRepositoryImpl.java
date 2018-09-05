package com.andreitop.newco.repository;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.exceptions.TripNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TripRepositoryImpl implements CustomRepository<TripDto> {

    private final List<TripDto> trips = new ArrayList<>();

    @Override
    public List<TripDto> findAll() {
        return trips;
    }

    @Override
    public TripDto findById(final Long id) {
        return trips.stream()
                    .filter(t -> t.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new TripNotFoundException("Trip with id = " + id + " not found"));
    }

    @Override
    public void save(final TripDto trip) {
        trip.setId((long) (trips.size() + 1));
        trips.add(trip);
    }

    @Override
    public void delete(final Long id) {
        trips.stream()
             .filter(t -> t.getId().equals(id))
             .findFirst()
             .ifPresent(trips::remove);
    }

    @Override
    public void update(final TripDto newTrip) {
        TripDto trip = trips.stream()
                               .filter(t -> t.getId().equals(newTrip.getId()))
                               .findFirst()
                               .orElseThrow(() -> new TripNotFoundException("Trip with id = " + newTrip.getId() + " not found"));
        trips.set(trips.indexOf(trip), newTrip);
    }
}
