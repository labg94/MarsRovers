package me.lbenavides.infrastructure.config;

import me.lbenavides.core.RoverMovements;
import me.lbenavides.core.service.RoverMovementsImpl;
import me.lbenavides.infrastructure.primary.CommandsReader;
import me.lbenavides.infrastructure.secondary.PrinterPortImpl;

public class InstanceManager {

    private static InstanceManager INSTANCE;

    private InstanceManager() {
    }


    public static InstanceManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InstanceManager();
        }
        return INSTANCE;
    }


    private RoverMovements roverMovements() {
        return new RoverMovementsImpl(new PrinterPortImpl());
    }

    public CommandsReader commandsReader() {
        return new CommandsReader(this.roverMovements());
    }

}
