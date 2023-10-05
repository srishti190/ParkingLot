package com.parkingLot.commands;

import com.parkingLot.Exception.BadCommandException;
import com.parkingLot.service.ParkingLotService;

import java.util.List;

public class RegistrationNumberForColour implements ICommand{
    ParkingLotService parkingLotService;
    private static RegistrationNumberForColour registrationNumberForColourInstance;

    private RegistrationNumberForColour(){
        parkingLotService = ParkingLotService.getInstance();
    }

    public static RegistrationNumberForColour getInstance(){
        if(registrationNumberForColourInstance ==null){
            registrationNumberForColourInstance = new RegistrationNumberForColour();
        }
        return registrationNumberForColourInstance;
    }

    @Override
    public void executeCommand(String cmd[]) throws BadCommandException {
        if(cmd.length!=2){
            throw new BadCommandException("Invalid user command");
        }
        String colour = cmd[1];
        List<String> regNoList = parkingLotService.getRegNumberForColour(colour);
        if(regNoList.isEmpty()){
            System.out.println("Not found");
        }
        else {
            System.out.println(regNoList);
        }
    }
}
