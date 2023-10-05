package com.parkingLot.commands;

import com.parkingLot.Exception.BadCommandException;
import com.parkingLot.service.ParkingLotService;

import java.util.List;

public class SlotNumberForRegisterationNumber implements ICommand{
    ParkingLotService parkingLotService;
    private static SlotNumberForRegisterationNumber slotNumberForRegisterationNumberInstance;

    private SlotNumberForRegisterationNumber(){
        parkingLotService = ParkingLotService.getInstance();
    }

    public static SlotNumberForRegisterationNumber getInstance(){
        if(slotNumberForRegisterationNumberInstance==null){
            slotNumberForRegisterationNumberInstance=new SlotNumberForRegisterationNumber();
        }
        return slotNumberForRegisterationNumberInstance;
    }

    @Override
    public void executeCommand(String cmd[]) throws BadCommandException {
        if(cmd.length!=2){
            throw new BadCommandException("Invalid User Command");
        }
        String regNo = cmd[1];
        List<Integer> slotNumbers = parkingLotService.getSlotNumberForRegNo(regNo);
        if(slotNumbers.isEmpty()){
            System.out.println("Not found");
        }
        else {
            System.out.println(slotNumbers);
        }
    }
}
