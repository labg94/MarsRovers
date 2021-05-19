package me.lbenavides.infrastructure.primary;

import java.util.Collections;
import java.util.List;

public class RoverDto {
    private final int x;
    private final int y;
    private final String direction;
    private final List<String> movements;

    private final int upperX;
    private final int upperY;

    private RoverDto(int x, int y, String direction, List<String> movements, int upperX, int upperY) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.movements = movements;
        this.upperX = upperX;
        this.upperY = upperY;
    }

    public static RoverDtoBuilder builder() {
        return new RoverDtoBuilder();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public List<String> getMovements() {
        return movements;
    }

    public int getUpperX() {
        return upperX;
    }

    public int getUpperY() {
        return upperY;
    }

    public static class RoverDtoBuilder {

        private int x;
        private int y;
        private String direction;
        private List<String> movements;

        private int upperX;
        private int upperY;

        public RoverDtoBuilder() {
            this.upperY = 0;
            this.upperX = 0;
            defaultValues();
        }

        private void defaultValues() {
            this.x = 0;
            this.y = 0;
            this.direction = "N";
            this.movements = Collections.emptyList();
        }

        public RoverDtoBuilder movements(List<String> movements) {
            this.movements = List.copyOf(movements);
            return this;
        }


        public RoverDto build() {
            RoverDto roverDto = new RoverDto(x, y, direction, movements, upperX, upperY);

            defaultValues();

            return roverDto;
        }


        public RoverDtoBuilder addXYAndDirection(String positionValues) {
            String[] s = positionValues.split(" ");

            this.x = Integer.parseInt(s[0]);
            this.y = Integer.parseInt(s[1]);
            this.direction = s[2];
            return this;
        }

        public RoverDtoBuilder plateauCoordinates(String positionValues) {
            String[] s = positionValues.split(" ");

            this.upperX = Integer.parseInt(s[0]);
            this.upperY = Integer.parseInt(s[1]);
            return this;
        }
    }

}
