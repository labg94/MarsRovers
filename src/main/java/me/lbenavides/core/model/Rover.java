package me.lbenavides.core.model;

import me.lbenavides.core.exception.OutOfLimitsException;

import java.util.List;
import java.util.Objects;

public class Rover {

    private final Position position;
    private final List<Movement> movements;
    private final Plateau plateau;
    private Direction direction;


    private Rover(Position position, Direction direction, List<Movement> movements, Plateau plateau) {
        this.position = position;
        this.direction = direction;
        this.movements = movements;
        this.plateau = plateau;
    }

    public static RoverBuilder builder() {
        return new RoverBuilder();
    }

    public Position getPosition() {
        return position;
    }

    public Direction getCardinality() {
        return direction;
    }

    public void process() {
        movements.forEach(movement -> movement.act(this));
    }

    void rotateLeft() {
        direction = direction.rotateLeft();
    }

    void rotateRight() {
        direction = direction.rotateRight();
    }

    void move() {

        direction.move(position);

        if (plateau.isInvalidPosition(position)) {
            throw new OutOfLimitsException("we lost a rover, last known position => " + position);
        }
    }

    @Override
    public String toString() {
        return position.toString() + " " + direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return position.equals(rover.position) && movements.equals(rover.movements) && direction == rover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, movements, direction);
    }

    public static class RoverBuilder {
        private Position position;
        private Direction direction;
        private List<Movement> movements;

        private Plateau plateau;

        private RoverBuilder() {
        }

        public RoverBuilder position(Position position) {
            this.position = position;
            return this;
        }

        public RoverBuilder direction(Direction direction) {
            this.direction = direction;
            return this;
        }

        public RoverBuilder movements(List<Movement> movements) {
            this.movements = movements;
            return this;
        }

        public RoverBuilder plateau(Plateau plateau) {
            this.plateau = plateau;
            return this;
        }


        public Rover build() {

            if (plateau.isInvalidPosition(position)) {
                throw new OutOfLimitsException("This rover was lost from the beginning");
            }

            return new Rover(position, direction, movements, plateau);
        }
    }
}
