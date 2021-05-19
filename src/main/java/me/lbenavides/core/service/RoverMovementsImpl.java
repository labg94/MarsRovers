package me.lbenavides.core.service;

import me.lbenavides.core.RoverMovements;
import me.lbenavides.core.model.Rover;
import me.lbenavides.core.secondary.PrinterPort;

public class RoverMovementsImpl implements RoverMovements {

    private final PrinterPort printerPort;

    public RoverMovementsImpl(PrinterPort printerPort) {
        this.printerPort = printerPort;
    }

    @Override
    public void processMovements(Rover rover) {
        rover.process();
        printerPort.printCoordinates(rover);
    }
}
