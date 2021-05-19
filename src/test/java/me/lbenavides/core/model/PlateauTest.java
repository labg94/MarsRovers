package me.lbenavides.core.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlateauTest {

    Plateau plateau = new Plateau(new Position(10,10));


    @Test
    @DisplayName("given a point further than the plateau upper y axis limits should return true")
    void surpassingTheYUpper() {
        Position position = new Position(5, 11);

        boolean isInvalid = plateau.isInvalidPosition(position);

        assertTrue(isInvalid);
    }

    @Test
    @DisplayName("given a point further than the plateau upper x axis limits should return true")
    void surpassingTheXUpper() {
        Position position = new Position(11, 5);

        boolean isInvalid = plateau.isInvalidPosition(position);

        assertTrue(isInvalid);
    }

    @Test
    @DisplayName("given a point further than the plateau lower x axis limits should return true")
    void surpassingTheXLower() {
        Position position = new Position(-1, 5);

        boolean isInvalid = plateau.isInvalidPosition(position);

        assertTrue(isInvalid);
    }

    @Test
    @DisplayName("given a point further than the plateau lower Y axis limits should return true")
    void surpassingTheYLower() {
        Position position = new Position(5, -1);

        boolean isInvalid = plateau.isInvalidPosition(position);

        assertTrue(isInvalid);
    }
    @Test
    @DisplayName("given a point inside the plateau limits should return false")
    void goodPosition() {
        Position position = new Position(5, 5);

        boolean isInvalid = plateau.isInvalidPosition(position);

        assertFalse(isInvalid);
    }
}