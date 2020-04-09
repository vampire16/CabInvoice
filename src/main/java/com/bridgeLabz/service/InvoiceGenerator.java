package com.bridgeLabz.service;

public class InvoiceGenerator {
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MIN_FARE = 5;

    RideRepository rideRepository = new RideRepository();

    public static void main(String[] args) {
        System.out.println("Welcome");
    }

    public double calculateFare(double distance, int time) {
        double fare = distance * COST_PER_KILOMETER + time * COST_PER_TIME;
        return fare < MIN_FARE ? MIN_FARE : fare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double fare = 0;
        for (Ride ride : rides) {
            fare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, fare);
    }

    public void userRides(String userId, Ride[] rides) {
        rideRepository.userRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
