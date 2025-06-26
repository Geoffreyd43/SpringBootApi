package com.geoffrey.practice.parkinglot;

public class ParkingDriver {
    public static void main(String[] args) {
        Level levelOne = new Level(1, 1, 2);

        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle car3 = new Car();
        assert(!car1.equals(car2));
        assert(!car1.equals(car3));

        try {
            levelOne.parkVehicle(car1);
            levelOne.parkVehicle(car2);
            levelOne.removeVehicle(car1);
            levelOne.parkVehicle(car3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
