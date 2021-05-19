package me.lbenavides.core.model;

import java.util.function.Consumer;

public enum Movement {
    L(Rover::rotateLeft), R(Rover::rotateRight), M(Rover::move);
    private final Consumer<Rover> activate;

    Movement(Consumer<Rover> activate) {
        this.activate = activate;
    }

    public void act(Rover rover) {
        activate.accept(rover);
    }

}
