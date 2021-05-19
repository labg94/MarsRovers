package me.lbenavides.core.model;

import me.lbenavides.core.exception.OutOfLimitsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static me.lbenavides.core.model.Direction.*;
import static me.lbenavides.core.model.Movement.*;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("Given a Rover with its commands should have the correct coordinates case 1")
    void moveCorrectlyCase1() {
        Position initialPosition = new Position(1, 2);
        Position upperCorner = new Position(10, 20);

        Rover rover = Rover.builder().position(initialPosition)
                           .direction(N)
                           .movements(Arrays.asList(L, M, L, M, L, M, L, M, M))
                           .plateau(new Plateau(upperCorner))
                           .build();

        rover.process();

        assertEquals(3, rover.getPosition().getY());
        assertEquals(1, rover.getPosition().getX());
        assertEquals(N, rover.getCardinality());

    }

    @Test
    @DisplayName("Given a Rover with its commands should have the correct coordinates case 2")
    void moveCorrectlyCase2() {
        Position initialPosition = new Position(3, 3);
        Position upperCorner = new Position(10, 20);

        Rover rover = Rover.builder()
                           .position(initialPosition)
                           .direction(E)
                           .movements(Arrays.asList(M, M, R, M, M, R, M, R, R, M))
                           .plateau(new Plateau(upperCorner))
                           .build();

        rover.process();

        assertEquals(1, rover.getPosition().getY());
        assertEquals(5, rover.getPosition().getX());
        assertEquals(E, rover.getCardinality());

    }

    @Test
    @DisplayName("when a Rover exceeds the limit should return an exception")
    void moveToRestrictedArea() {
        Position initialPosition = new Position(1, 1);
        Position upperCorner = new Position(2, 2);

        Rover rover = Rover.builder()
                           .position(initialPosition)
                           .direction(E)
                           .movements(Arrays.asList(M, M))
                           .plateau(new Plateau(upperCorner))
                           .build();

        OutOfLimitsException outOfLimitsException = assertThrows(OutOfLimitsException.class, rover::process);

        assertEquals("we lost a rover, last known position => 3 1", outOfLimitsException.getMessage());
    }


    @Test
    @DisplayName("when a new Rover is created outside the plateau should throw an exception")
    void creatingARoverOutsideThePlateau() {

        Position upperCorner = new Position(1, 1);
        Position roverPosition = new Position(4, 4);


        OutOfLimitsException outOfLimitsException = assertThrows(OutOfLimitsException.class,
                () -> Rover.builder().plateau(new Plateau(upperCorner)).position(roverPosition).build());

        assertEquals("This rover was lost from the beginning", outOfLimitsException.getMessage());

    }
}