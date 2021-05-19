package me.lbenavides.infrastructure.primary.mapper;

import me.lbenavides.core.model.*;
import me.lbenavides.infrastructure.primary.RoverDto;

import java.util.List;
import java.util.stream.Collectors;

public class RoverMapper {

    private RoverMapper() {
    }

    public static Rover toRover(RoverDto roverDto) {


        List<Movement> collect = roverDto.getMovements().stream()
                                         .map(Movement::valueOf)
                                         .collect(Collectors.toList());

        Direction directionFound = Direction.valueOf(roverDto.getDirection());
        return Rover.builder()
                    .position(new Position(roverDto.getX(), roverDto.getY()))
                    .direction(directionFound)
                    .movements(collect)
                    .plateau(new Plateau(new Position(roverDto.getUpperX(), roverDto.getUpperY())))
                    .build();
    }

}
