package com.parkingLot.service;

import com.parkingLot.Exception.InvalidSlotException;
import com.parkingLot.Exception.ParkingLotException;
import com.parkingLot.Exception.SlotAlreadyOccupiedException;
import com.parkingLot.model.Car;
import com.parkingLot.model.ParkingLot;
import com.parkingLot.model.ParkingLotStrategy;
import com.parkingLot.model.Slot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotService {

    ParkingLotStrategy parkingLotStrategy;
    ParkingLot parkingLot;
    private static ParkingLotService parkingLotServiceInstance;

    private ParkingLotService(){
    }

    public static ParkingLotService getInstance(){
        if(parkingLotServiceInstance==null){
            parkingLotServiceInstance=new ParkingLotService();
        }
        return parkingLotServiceInstance;
    }

    public void createParkingLot(ParkingLot parkingLot, ParkingLotStrategy parkingLotStrategy) throws ParkingLotException{
        if(this.parkingLot!=null){
            throw new ParkingLotException("Parking Lot already exists");
        }
        this.parkingLot=parkingLot;
        this.parkingLotStrategy=parkingLotStrategy;
        for(int i=1;i<=parkingLot.getCapacity();i++){
            parkingLotStrategy.addSlot(i);
        }
    }

    public Integer parkCar(Car car) throws InvalidSlotException, SlotAlreadyOccupiedException {
        try {
            Integer nextFreeSlot= parkingLotStrategy.getNextSlot();
            parkingLot.park(car,nextFreeSlot);
            parkingLotStrategy.removeSlot(nextFreeSlot);
            return nextFreeSlot;
        }catch (SlotAlreadyOccupiedException e){
            System.out.println("Sorry parking lot is full");
            return 0;
        }
    }

    public void leaveParkingLot(Integer slotNumber) throws InvalidSlotException {
        parkingLot.makeSlotFree(slotNumber);
        parkingLotStrategy.addSlot(slotNumber);
    }

    public List<Slot> getOccupiedSlots(){
        List<Slot> occupiedSlotList = new ArrayList<>();
        Map<Integer,Slot> allSlots = parkingLot.getSlots();
        for(int i=1;i<=parkingLot.getCapacity();i++){
            if(allSlots.containsKey(i)){
                Slot slot= allSlots.get(i);
                if(!slot.isSlotFree()){
                    occupiedSlotList.add(slot);
                }
            }
        }
        return occupiedSlotList;
    }

    public List<String> getRegNumberForColour(String colour){
        List<Slot> slotList = getOccupiedSlots();
        List<String> regNumberList = new ArrayList<>();
        for(Slot slot: slotList){
            Car parkedCar = slot.getParkedCar();
            if(parkedCar.getColor().equals(colour)){
                regNumberList.add(parkedCar.getRegistrationNumber());
            }
        }
        return regNumberList;
    }

    public List<Integer> getSlotNumberForColour(String colour){
        List<Slot> slotList = getOccupiedSlots();
        List<Integer> slotNumbers = new ArrayList<>();
        for(Slot slot: slotList){
            Car parkedCar = slot.getParkedCar();
            if(parkedCar.getColor().equals(colour)){
                slotNumbers.add(slot.getSlotNo());
            }
        }
        return slotNumbers;
    }

    public List<Integer> getSlotNumberForRegNo(String regNo){
        List<Slot> slotList = getOccupiedSlots();
        List<Integer> slotNumbers = new ArrayList<>();
        for(Slot slot: slotList){
            Car parkedCar = slot.getParkedCar();
            if(parkedCar.getRegistrationNumber().equals(regNo)){
                slotNumbers.add(slot.getSlotNo());
            }
        }
        return slotNumbers;
    }
}
