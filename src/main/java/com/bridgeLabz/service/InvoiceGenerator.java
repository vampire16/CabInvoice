package com.bridgeLabz.service;

public class InvoiceGenerator {
    private static final double COST_PER_KILOMETER = 10;
    private static final int COST_PER_TIME = 1;

    public double calculateFare(double distance, int time) {
        return distance * COST_PER_KILOMETER + time * COST_PER_TIME;
    }

    public static void main(String[] args){
        System.out.println("Welcome");
    }
}
