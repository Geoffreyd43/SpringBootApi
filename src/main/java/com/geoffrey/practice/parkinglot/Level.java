package com.geoffrey.practice.parkinglot;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.List;

public class Level {

    private ParkingSpot[][] spots;
    private int availableSpots;
    private int id;

    private class Index {
        public int row;
        public int col;

        public Index(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Level(int id, int rows, int rowLength) {
        this.id = id;
        spots = new ParkingSpot[rows][rowLength];
        int spotId = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rowLength; j++) {
                // for now...
                spots[i][j] = new ParkingSpot(spotId++, ParkingSpot.Size.MEDIUM);
            }
        }

        availableSpots = rows * rowLength;
    }

    public boolean hasOpenSpots() {
        return availableSpots == 0;
    }

    public void parkVehicle(Vehicle vehicle) throws Exception {
        Index available = findNextAvailableSpot(vehicle);
        if (available.row == -1 || available.col == -1) throw new Exception("We're full! Park sommewhere else");
        vehicle.parkInSpot(spots[available.row][available.col]);
    }

    public void removeVehicle(Vehicle vehicle) throws Exception {
        if (vehicle == null) throw new Exception("Vehicle can't be null");

        Index vehicleIndex = findVehicleIndex(vehicle);
        vehicle.leaveSpot();
    }

    private Index findVehicleIndex(Vehicle vehicle) {
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[0].length; j++) {
                if (spots[i][j].getVehicleOrNull() != null && spots[i][j].getVehicleOrNull().equals(vehicle)) {
                    return new Index(i,j);
                }
            }
        }
        // not found
        return new Index(-1, -1);
    }

    private Index findNextAvailableSpot(Vehicle vehicle) {
        if (availableSpots == 0) return new Index(-1, -1);

        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[0].length; j++) {
                if (spots[i][j].isAvailable() && vehicle.canParkInSpot(spots[i][j])) {
                    return new Index(i,j);
                }
            }
        }

        // not found - this level is full
        return new Index(-1,-1);
    }

    public void printLevel() {
        System.out.println("Parking level " + id + ": ");
        for (ParkingSpot[] spot : spots) {
            for (int j = 0; j < spots[0].length; j++) {
                System.out.print(spot[j] + " ");
            }
            System.out.println();
        }
    }
}
