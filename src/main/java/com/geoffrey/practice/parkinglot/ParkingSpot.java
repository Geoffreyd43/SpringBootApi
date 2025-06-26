package com.geoffrey.practice.parkinglot;

public class ParkingSpot {
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE,
    }
    
    final Size size;
    final int id;
    Vehicle vehicle;
    
    public ParkingSpot(int id, Size size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }
    
    public Size getSize() {
        return size;
    }

    public Vehicle getVehicleOrNull() {
        return vehicle; // null if parking spot is empty
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle() throws Exception {
        if (this.vehicle == null) throw new Exception("There is no vehicle to remove");

        this.vehicle = null;
    }
    
    public boolean isAvailable() {
        return vehicle == null;
    }
}
