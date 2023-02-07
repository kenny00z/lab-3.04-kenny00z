package com.ironhack.lab304.repository;

import com.ironhack.lab304.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findByNumber(String number);

    List<Flight> findByMileageGreaterThan(long l);
}
