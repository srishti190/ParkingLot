package com.parkingLot.commands;

import com.parkingLot.Exception.BadCommandException;
import com.parkingLot.model.Slot;
import com.parkingLot.service.ParkingLotService;

import java.util.List;

public class Status implements ICommand{
    private static Status statusInstance;
    ParkingLotService parkingLotService;

    private Status(){
        parkingLotService = ParkingLotService.getInstance();
    }

    public static Status getInstance(){
        if(statusInstance==null){
            statusInstance=new Status();
        }
        return statusInstance;
    }

    @Override
    public void executeCommand(String cmd[]) throws BadCommandException {
        if (cmd.length!=1){
            throw new BadCommandException("Incorrect User Command");
        }
        List<Slot> occupiedSlotList = parkingLotService.getOccupiedSlots();
        if(occupiedSlotList.isEmpty()){
            System.out.println("Parking lot is empty!");
            return;
        }
        System.out.println("Slot No. Registration No Colour");
        for(Slot slot:occupiedSlotList){
            System.out.println(slot.getSlotNo()+" "+slot.getParkedCar().getRegistrationNumber()+
                    " "+slot.getParkedCar().getColor());
        }
    }
}
