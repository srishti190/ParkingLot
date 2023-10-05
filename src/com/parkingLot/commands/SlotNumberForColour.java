package com.parkingLot.commands;

import com.parkingLot.Exception.BadCommandException;
import com.parkingLot.service.ParkingLotService;

import java.util.List;

public class SlotNumberForColour implements ICommand{
    ParkingLotService parkingLotService;
    private static SlotNumberForColour slotNumberForColourInstance;

    private SlotNumberForColour(){
        parkingLotService = ParkingLotService.getInstance();
    }

    public static SlotNumberForColour getInstance(){
        if(slotNumberForColourInstance==null){
            slotNumberForColourInstance=new SlotNumberForColour();
        }
        return slotNumberForColourInstance;
    }

    @Override
    public void executeCommand(String cmd[]) throws BadCommandException {
        if(cmd.length!=2){
            throw new BadCommandException("Invalid User Command");
        }
        String colour = cmd[1];
        List<Integer> slotNumbers = parkingLotService.getSlotNumberForColour(colour);
        if(slotNumbers.isEmpty()){
            System.out.println("Not found");
        }
        else {
            System.out.println(slotNumbers);
        }
    }
}
