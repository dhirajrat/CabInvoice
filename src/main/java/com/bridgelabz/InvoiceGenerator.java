package com.bridgelabz;

public class InvoiceGenerator {
    private static final double MINIUM_COST_PER_KILOMETER = 10.0;
    private static final int COST_PER_TIME =1 ;
    private static final double MINIUM_FARE = 5;
    private  RideRepository rideRepository;

    /**
     * Calculate Fare Method using distance and time
     * @param distance
     * @param time
     * @return
     */
    public double calculateFare(double distance, int time) {
        double totalFare= distance*MINIUM_COST_PER_KILOMETER+time*COST_PER_TIME;

        return Math.max(totalFare,MINIUM_FARE);

    }

    /**
     * Constructor
     */
    public InvoiceGenerator(){
        this.rideRepository = new RideRepository();
    }

    /**
     * Calculate Fare using Rides
     * @param rides
     * @return
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare=0;
        for (Ride ride:rides){
            totalFare+=this.calculateFare(ride.distance, ride.time);

        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * Calculate Fare
     * @param rides
     * @param type
     * @return
     */
    public InvoiceSummary calculateFare(Ride[] rides,String type) {
        double totalFare = 0;
        if(type == "premium"){
            for (Ride ride :rides) {
                totalFare += this.calculateFare(ride.distance,ride.time);
            }
            return new InvoiceSummary(rides.length,totalFare);
        }
        for (Ride ride :rides) {
            totalFare += this.calculateFare(ride.distance,ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId,rides);
    }

    /**
     * Get Invoice Summary
     * @param userId
     * @return
     */
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId),"normal");
    }
}