package me.lbenavides.infrastructure.secondary;

import me.lbenavides.core.model.Rover;
import me.lbenavides.core.secondary.PrinterPort;

public class PrinterPortImpl implements PrinterPort {
    @Override
    public void printCoordinates(Rover rover) {

        System.out.println(rover);

    }
}
