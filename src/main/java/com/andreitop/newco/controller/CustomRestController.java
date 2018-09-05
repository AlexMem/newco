package com.andreitop.newco.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomRestController<T> {

    ResponseEntity<List<T>> findAll();

    ResponseEntity<T> findById(final Long id);

    ResponseEntity create(final T trip);

    ResponseEntity delete(final Long id);

    ResponseEntity update(final T newTrip);
}
