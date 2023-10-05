package com.parkingLot.commands;

import com.parkingLot.Exception.BadCommandException;
import com.parkingLot.Exception.InvalidSlotException;
import com.parkingLot.Exception.ParkingLotException;
import com.parkingLot.Exception.SlotAlreadyOccupiedException;

public interface ICommand {
    public void executeCommand(String cmd[]) throws BadCommandException, ParkingLotException, SlotAlreadyOccupiedException, InvalidSlotException;
}
