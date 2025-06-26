package com.geoffrey.practice.parkinglot;

public interface Vehicle {
    boolean canParkInSpot(ParkingSpot parkingSpot);
    /*
     * @throws exception when vehicle does not fit in parkingSpot
     */
    void parkInSpot(ParkingSpot parkingSpot) throws Exception;
    /*
     * @throws exception when not parked anywhere
     */
    void leaveSpot() throws Exception;
}
