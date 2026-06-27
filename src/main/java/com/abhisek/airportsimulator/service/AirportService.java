package com.abhisek.airportsimulator.service;
private Thread generatorThread;
private FlightGenerator flightGenerator;

import com.abhisek.airportsimulator.threads.FlightGenerator;

//Added
import com.abhisek.airportsimulator.model.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

@Service
public class AirportService {
    private PriorityQueue<Flight> runwayQueue = new PriorityQueue<>(Comparator.comparingInt(Flight::getPriority));

    /* {
         Comparator.comparingInt(Flight::getPriority);
     }*/
    private ArrayList<Flight> completedFlights = new ArrayList<>();

    private HashMap<String, Flight> flightMap = new HashMap<>();

    /* public void testQueue(){
         Flight flight1=new Flight1("EM999", 1, "WAITING");
         Flight flight2=new Flight2("AD101", 2, "WAITING");
         Flight flight3=new Flight3("AD124", 3, "WAITING");
         runwayQueue.add(flight1);
         runwayQueue.add(flight2);
         runwayQueue.add(flight3);

         while(!runwayQueue.isEmpty()){
             Flight flight= runwayQueue.poll();

             System.out.println(flight.getFlightId());

         }

     }
 }*/
    public synchronized void addFlight(Flight flight) {
        runwayQueue.add(flight);

        flightMap.put(
                flight.getFlightid(),
                flight
        );
//System.out.println("Added : "+ flight.getFlightid());
        System.out.println("Added : " + flight.getFlightid() + " | " + (flight.getPriority() == 1 ? "EMERGENCY" : "NORMAL"));
    }

    //Highestpriprity landing
    public synchronized void processFlight() {
        if (runwayQueue.isEmpty()) {
            return;
        }
        Flight flight = runwayQueue.poll();
        flight.setstatus("COMPLETED");
        completedFlights.add(flight);
//System.out.println("Landed"+flight.getFlightid());
        System.out.println("Landed : " + flight.getFlightid() + " | " + (flight.getPriority() == 1 ? "EMERGENCY" : "NORMAL")
        );

    }
        public PriorityQueue<Flight> getRunwayQueue() {
            return runwayQueue;
        }
        public ArrayList<Flight> getCompletedFlights () {
            return completedFlights;
        }
    }