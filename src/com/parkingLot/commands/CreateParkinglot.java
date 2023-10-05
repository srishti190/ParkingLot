package com.parkingLot.commands;

import com.parkingLot.Exception.BadCommandException;
import com.parkingLot.Exception.ParkingLotException;
import com.parkingLot.model.ParkingLot;
import com.parkingLot.model.ParkingLotStrategy;
import com.parkingLot.service.ParkingLotService;

public class CreateParkinglot implements ICommand{
    private static CreateParkinglot createParkinglotInstance;
    ParkingLotService parkingLotService;

    private CreateParkinglot(){
        parkingLotService = ParkingLotService.getInstance();
    }

    public static CreateParkinglot getInstance(){
        if(createParkinglotInstance == null){
            createParkinglotInstance = new CreateParkinglot();
        }
        return createParkinglotInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, ParkingLotException{
        if(cmd.length != 2) {
            throw new BadCommandException("Incorrect User Command");
        }
        int capacity = Integer.parseInt(cmd[1]);
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLotService.createParkingLot(parkingLot,new ParkingLotStrategy());
        System.out.println("Created a parking lot with " + parkingLot.getCapacity() + " slots");
    }
}
