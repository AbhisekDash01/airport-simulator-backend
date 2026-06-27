package com.abhisek.airportsimulator.model;

public class Flight {
    private String flightid;
    private int priority;
    private String status;

    public Flight(String flightid, int priority, String status) {
        this.flightid = flightid;
        this.priority = priority;
        this.status = status;
    }

    public String getFlightid() {
        return flightid;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return flightid + "[ " + status + " ]";
    }
}
