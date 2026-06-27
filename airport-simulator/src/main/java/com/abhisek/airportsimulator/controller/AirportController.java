package com.abhisek.airportsimulator.controller;
import com.abhisek.airportsimulator.model.Flight;
import com.abhisek.airportsimulator.service.AirportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@RestController
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/waiting")
    public PriorityQueue<Flight> getWaitingFlights() {
        return airportService.getRunwayQueue();

    }

    @GetMapping("/completed")
    public ArrayList<Flight> getCompletedFlights() {
        return airportService.getCompletedFlights();
    }

    @GetMapping("/stats")
    public Map<String, Integer> getStats() {
        Map<String, Integer> stats = new HashMap<>();

        stats.put("waiting", airportService.getRunwayQueue().size());
        stats.put("Landed", airportService.getCompletedFlights().size());
        return stats;
    }
}


