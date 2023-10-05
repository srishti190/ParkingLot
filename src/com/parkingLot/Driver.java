package com.parkingLot;


import com.parkingLot.Exception.BadCommandException;
import com.parkingLot.Exception.InvalidSlotException;
import com.parkingLot.Exception.ParkingLotException;
import com.parkingLot.Exception.SlotAlreadyOccupiedException;
import com.parkingLot.commands.CommandFactory;

import java.util.Scanner;

public class Driver {
    public static void main(String args[]) throws InvalidSlotException,BadCommandException, ParkingLotException, SlotAlreadyOccupiedException {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(">");
            String[] cmd = sc.nextLine().split(" ");
            if(cmd[0].equals("exit")){
                break;
            }
            try {
                CommandFactory.getInstance().executeCommand(cmd);
            } catch (BadCommandException b){
                System.out.println("BadCommand Exception due to ==>" + b.getCause());
            }
        }
    }
}
