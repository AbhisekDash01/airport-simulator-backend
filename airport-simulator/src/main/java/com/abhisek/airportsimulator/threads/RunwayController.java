package com.abhisek.airportsimulator.threads;

import com.abhisek.airportsimulator.service.AirportService;

public class RunwayController implements Runnable {
    private AirportService airportService;
        public RunwayController(AirportService airportService) {
            this.airportService = airportService;
        }
        @Override
        public void run(){
            while (true) {
                airportService.processFlight();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

