package com.example.es15.Repositories;

import com.example.es15.Entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query(value = "SELECT * FROM FLIGHT", nativeQuery = true)
    List<Flight> retrieveAllFlights();
}
