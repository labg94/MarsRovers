package me.lbenavides.core.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static me.lbenavides.core.model.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Nested
    @DisplayName("Rotate to the left")
    class RotateLeft {

        @Test
        @DisplayName("Given the North when is rotated to the left should return the West")
        void NorthToTheLeft() {
            assertEquals(W, N.rotateLeft());
        }

        @Test
        @DisplayName("Given the East when is rotated to the left should return the North")
        void EastToTheLeft() {
            assertEquals(N, E.rotateLeft());
        }

        @Test
        @DisplayName("Given the South when is rotated to the left should return the East")
        void SouthToTheLeft() {
            assertEquals(E, S.rotateLeft());
        }

        @Test
        @DisplayName("Given the West when is rotated to the left should return the South")
        void WestToTheLeft() {
            assertEquals(S, W.rotateLeft());
        }
    }
    @Nested
    @DisplayName("Rotate to the right")
    class RotateRight {

        @Test
        @DisplayName("Given the North when is rotated to the right should return the East")
        void NorthToTheLeft() {
            assertEquals(E, N.rotateRight());
        }

        @Test
        @DisplayName("Given the East when is rotated to the right should return the South")
        void EastToTheLeft() {
            assertEquals(S, E.rotateRight());
        }

        @Test
        @DisplayName("Given the South when is rotated to the right should return the West")
        void SouthToTheLeft() {
            assertEquals(W, S.rotateRight());
        }

        @Test
        @DisplayName("Given the West when is rotated to the right should return the North")
        void WestToTheLeft() {
            assertEquals(N, W.rotateRight());
        }
    }


}