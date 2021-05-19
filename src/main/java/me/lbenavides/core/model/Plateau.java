package me.lbenavides.core.model;

import me.lbenavides.core.exception.OutOfLimitsException;

public class Plateau {

    private final Position upperRightCorner;

    public Plateau(Position upperRightCorner) {
        this.upperRightCorner = upperRightCorner;
    }

    public boolean isInvalidPosition(Position position) {
        return passingTheLowerLimits(position) || passingTheUpperLimit(position);
    }

    private boolean passingTheLowerLimits(Position position) {
        return position.getX() < 0 || position.getY() < 0;
    }

    private boolean passingTheUpperLimit(Position position) {
        return position.getY() > upperRightCorner.getY() || position.getX() > upperRightCorner.getX();
    }


}
