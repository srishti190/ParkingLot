package com.parkingLot.commands;

import com.parkingLot.Exception.BadCommandException;
import com.parkingLot.Exception.InvalidSlotException;
import com.parkingLot.service.ParkingLotService;

public class Leave implements ICommand{
    private static Leave leaveInstance;
    ParkingLotService parkingLotService;

    private Leave(){
        parkingLotService = ParkingLotService.getInstance();
    }

    public static Leave getInstance(){
        if(leaveInstance == null){
            leaveInstance=new Leave();
        }
        return leaveInstance;
    }

    @Override
    public void executeCommand(String cmd[]) throws BadCommandException, InvalidSlotException {
        if(cmd.length!=2){
            throw new BadCommandException("Invalid user command");
        }
        int slotNo = Integer.parseInt(cmd[1]);
        parkingLotService.leaveParkingLot(slotNo);
        System.out.println("Slot number "+ slotNo +" is free");
    }
}
