package com.andreitop.newco.repository;

import java.util.List;

public interface CustomRepository<T> {

    List<T> findAll();

    T findById(final Long id);

    void save(final T trip);

    void delete(final Long id);

    void update(final T newTrip);
}
