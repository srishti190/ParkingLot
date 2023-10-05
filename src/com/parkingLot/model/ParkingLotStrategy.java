package com.parkingLot.model;

import com.parkingLot.Exception.InvalidSlotException;
import com.parkingLot.Exception.SlotAlreadyOccupiedException;

import java.util.TreeSet;

public class ParkingLotStrategy {

    TreeSet<Integer> slotTreeSet;

    public ParkingLotStrategy() {
        this.slotTreeSet = new TreeSet<>();
    }

    public void addSlot(int slotNumber){
        this.slotTreeSet.add(slotNumber);
    }

    public void removeSlot(int slotNumber){
        this.slotTreeSet.remove(slotNumber);
    }

    public Integer getNextSlot() throws SlotAlreadyOccupiedException{
        if(slotTreeSet.isEmpty()){
            throw new SlotAlreadyOccupiedException("Sorry, parking lot is full");
        }
        return this.slotTreeSet.first();
    }
}
