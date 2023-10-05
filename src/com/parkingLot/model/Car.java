package com.parkingLot.model;

public class Car {
    private final String regNo;
    private final String colour;

    public Car(String regNo, String colour){
        this.colour=colour;
        this.regNo=regNo;
    }

    public String getRegistrationNumber() {
        return regNo;
    }

    public String getColor() {
        return colour;
    }
}
