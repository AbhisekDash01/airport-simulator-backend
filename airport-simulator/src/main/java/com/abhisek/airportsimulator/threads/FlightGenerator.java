package com.abhisek.airportsimulator.threads;
import com.abhisek.airportsimulator.model.Flight;
import com.abhisek.airportsimulator.service.AirportService;

import java.util.Random;

public class FlightGenerator implements Runnable {
    private AirportService airportService;
    private Random random = new Random();

    public FlightGenerator(AirportService airportService) {

        this.airportService = airportService;
    }

    @Override
    public void run() {
        int normalCount = 100;
        int emergencyCount = 1000;
        while (true) {
            Flight flight;
            int chance= random.nextInt(10);
            if(chance==0){
                flight=new Flight("EM"+emergencyCount++,1,"WAITING");
            }
            else{
                flight=new Flight("AD"+normalCount++,2,"WAITING");
            }
            airportService.addFlight(flight);
            try {
                Thread.sleep(3000);
            } catch (Exception e) {

                e.printStackTrace();
            }
            }
            // Thread t = new Thread(new FlightGenerator(airportService));
            //t.start();
            //String flightId = "AD" + count++;
            //int priority = random.nextInt(10) == 0 ? 1 : 2;

           /* Flight flight = new Flight(
                    flightId,
                    priority,
                    "WAITING"
            );
            airportService.addFlight(flight);
*/

    }
}
