package com.parkingLot.model;


import com.parkingLot.Exception.InvalidSlotException;
import com.parkingLot.Exception.ParkingLotException;
import com.parkingLot.Exception.SlotAlreadyOccupiedException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static int MAX_CAPACITY=100000;
    private int capacity;
    private Map<Integer,Slot> slots;

    public ParkingLot(int capacity) throws ParkingLotException {
        if(capacity<=0 || capacity>MAX_CAPACITY){
            throw new ParkingLotException("Invalid capacity given for parking lot.");
        }
        this.capacity=capacity;
        this.slots=new HashMap<>();
    }

    public Map<Integer,Slot> getSlots(){
        return slots;
    }

    public Slot getSlot(int slotNumber) throws InvalidSlotException {
        if(slotNumber<=0 || slotNumber>MAX_CAPACITY){
            throw new InvalidSlotException("slot number is invalid");
        }
        Map<Integer,Slot> allSlots = getSlots();
        if(!allSlots.containsKey(slotNumber)){
            slots.put(slotNumber,new Slot(slotNumber));
        }
        return slots.get(slotNumber);
    }

    public void park(Car car, int slotNumber) throws InvalidSlotException, SlotAlreadyOccupiedException {
        Slot slot = getSlot(slotNumber);
        if(!slot.isSlotFree()){
            throw new SlotAlreadyOccupiedException("slot unavailable");
        }
        slot.assignCar(car);
    }

    public void makeSlotFree(int slotNumber) throws InvalidSlotException{
        Slot slot = getSlot(slotNumber);
        slot.unAssignCar();
    }

    public int getCapacity(){
        return capacity;
    }
}
