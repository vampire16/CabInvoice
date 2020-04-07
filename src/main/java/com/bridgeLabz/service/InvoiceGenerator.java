package com.bridgeLabz.service;

public class InvoiceGenerator {
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MIN_FARE = 5;

    public double calculateFare(double distance, int time) {
        double fare = distance * COST_PER_KILOMETER + time * COST_PER_TIME;
        if(fare < MIN_FARE)
            return MIN_FARE;
        return fare;
    }

    public static void main(String[] args){
        System.out.println("Welcome");
    }
}
