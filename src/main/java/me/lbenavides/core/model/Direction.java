package me.lbenavides.core.model;

import java.util.function.Consumer;

public enum Direction {
    N(Position::translateY), E(Position::translateX), S(Position::translateYNegative), W(Position::translateXNegative);

    private final int movementValue = 1;
    Consumer<Position> move;

    Direction(Consumer<Position> move) {
        this.move = move;
    }

    public void move(Position position) {
        move.accept(position);
    }

    public Direction rotateLeft() {
        int length = values().length;
        int rotatedPosition = (this.ordinal() + length - movementValue) % length;
        return values()[rotatedPosition];
    }

    public Direction rotateRight() {
        int length = values().length;
        int rotatedPosition = (this.ordinal() + length + movementValue) % length;
        return values()[rotatedPosition];
    }

}
