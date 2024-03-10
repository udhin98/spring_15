package com.example.es15.Controllers;

import com.example.es15.Entities.Flight;
import com.example.es15.Entities.Status;
import com.example.es15.Repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightControllers {
    @Autowired
    FlightRepository flightRepository;
    @PostMapping("/random")
    public List<Flight> createRandomFlight () {
        List<Flight> flightList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + i);
            flight.setFromAirport("Airport " + random.nextInt(10));
            flight.setToAirport("Airport " + random.nextInt(10));
            flight.setStatus(Status.ONTIME);
            flightList.add(flight);
        }
          return flightRepository.saveAll(flightList);

    }
    @GetMapping("/all")
    public List<Flight> getAll () {
        return flightRepository.retrieveAllFlights();
    }
}
