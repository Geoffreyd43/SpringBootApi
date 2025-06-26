package com.geoffrey.practice.parkinglot;

public class Car implements Vehicle {
    private static final ParkingSpot.Size SIZE = ParkingSpot.Size.MEDIUM;
    private static final int spotsRequired = 1;
    private ParkingSpot parkingSpot;
    
    @Override
    public boolean canParkInSpot(final ParkingSpot parkingSpot) {
        return parkingSpot.getSize() == ParkingSpot.Size.MEDIUM || parkingSpot.getSize() == ParkingSpot.Size.LARGE;
    }
    
    
    @Override
    public void parkInSpot(final ParkingSpot parkingSpot) throws Exception {
        if (!canParkInSpot(parkingSpot)) throw new Exception("You can't fit a car in that spot!");
        if (this.parkingSpot != null) throw new Exception("You've already parked somewhere!");
        
        this.parkingSpot = parkingSpot;
        parkingSpot.setVehicle(this);
        System.out.println("Ah, finally found a spot! Parking in spot " + parkingSpot.getId());
    }

    @Override
    public void leaveSpot() throws Exception {
        System.out.println("Car is leaving spot " + parkingSpot.getId());
        this.parkingSpot.removeVehicle();
        this.parkingSpot = null;
    }
}
