package com.parkingLot.commands;


import com.parkingLot.Exception.BadCommandException;
import com.parkingLot.Exception.InvalidSlotException;
import com.parkingLot.Exception.ParkingLotException;
import com.parkingLot.Exception.SlotAlreadyOccupiedException;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory implements ICommand{
    Map<String, ICommand> commandMap;

    private static CommandFactory commandFactoryInstance;

    private CommandFactory(){
        commandMap = new HashMap<>();
        commandMap.put("create_parking_lot", CreateParkinglot.getInstance());
        commandMap.put("park", Park.getInstance());
        commandMap.put("leave", Leave.getInstance());
        commandMap.put("status",Status.getInstance());
        commandMap.put("registration_numbers_for_cars_with_colour", RegistrationNumberForColour.getInstance());
        commandMap.put("slot_numbers_for_cars_with_colour",SlotNumberForColour.getInstance());
        commandMap.put("slot_number_for_registration_number",SlotNumberForRegisterationNumber.getInstance());
    }

    public static CommandFactory getInstance(){
        if(commandFactoryInstance==null){
            commandFactoryInstance=new CommandFactory();
        }
        return commandFactoryInstance;
    }

    @Override
    public void executeCommand(String[] cmd) throws BadCommandException, ParkingLotException, SlotAlreadyOccupiedException, InvalidSlotException {
        if(!commandMap.containsKey(cmd[0])){
            throw new BadCommandException("InCorrect/Illegal Command ->" + cmd[0]);
        }
        commandMap.get(cmd[0]).executeCommand(cmd);
    }
}
