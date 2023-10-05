package com.parkingLot.commands;

import com.parkingLot.Exception.BadCommandException;
import com.parkingLot.Exception.InvalidSlotException;
import com.parkingLot.Exception.SlotAlreadyOccupiedException;
import com.parkingLot.model.Car;
import com.parkingLot.service.ParkingLotService;

public class Park implements ICommand {

    private static Park parkInstance;
    ParkingLotService parkingLotService;

    private Park(){
        parkingLotService = ParkingLotService.getInstance();
    }

    public static Park getInstance(){
        if(parkInstance == null){
            parkInstance = new Park();
        }
        return parkInstance;
    }
    @Override
    public void executeCommand(String cmd[]) throws BadCommandException, SlotAlreadyOccupiedException, InvalidSlotException {
        if(cmd.length!=3){
            throw new BadCommandException("Incorrect User Command");
        }
        String regNo = cmd[1];
        String colour = cmd[2];
        int slotNumber = parkingLotService.parkCar(new Car(regNo, colour));
        if(slotNumber!=0){
            System.out.println("Allocated slot number: "+ slotNumber);
        }
    }
}
