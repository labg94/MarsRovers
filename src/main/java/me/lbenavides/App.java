package me.lbenavides;

import me.lbenavides.infrastructure.config.InstanceManager;
import me.lbenavides.infrastructure.primary.CommandsReader;

import java.io.Console;


public class App {
    public static void main(String[] args) throws Exception {

        Console console = System.console();

        if (console != null) {
            System.out.println("give me the file path");

            CommandsReader commandsReader = InstanceManager.getInstance().commandsReader();
            String filePath = console.readLine();
            commandsReader.readFile(filePath);
        } else {
            throw new RuntimeException("no console");
        }

    }
}
