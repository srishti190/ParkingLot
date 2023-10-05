package com.parkingLot.model;

public class Slot {
    private Car parkedCar;
    private final int slotNo;

    public Slot(int slotNo){
        this.slotNo=slotNo;
    }

    public int getSlotNo(){
        return slotNo;
    }

    public void assignCar(Car car){
        this.parkedCar = car;
    }

    public void unAssignCar(){
        this.parkedCar=null;
    }

    public boolean isSlotFree(){
        return parkedCar == null;
    }

    public Car getParkedCar(){
        return parkedCar;
    }
}
