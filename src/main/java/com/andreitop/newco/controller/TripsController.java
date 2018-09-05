package com.andreitop.newco.controller;

import com.andreitop.newco.common.ApiConstant;
import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_V_1 + "/trips")
public class TripsController implements CustomRestController<TripDto> {

    private final TripService tripService;

    @Autowired
    public TripsController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public ResponseEntity<List<TripDto>> findAll() {
        return new ResponseEntity<>(tripService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDto> findById(@PathVariable("id") final Long id) {
        return new ResponseEntity<>(tripService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody final TripDto trip) {
        tripService.save(trip);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") final Long id) {
        tripService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final TripDto newTrip) {
        tripService.update(newTrip);
        return new ResponseEntity(HttpStatus.OK);
    }
}
