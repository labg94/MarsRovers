package me.lbenavides.infrastructure.primary;

import me.lbenavides.core.RoverMovements;
import me.lbenavides.core.model.Direction;
import me.lbenavides.core.model.Plateau;
import me.lbenavides.core.model.Position;
import me.lbenavides.core.model.Rover;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static me.lbenavides.core.model.Movement.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CommandsReaderTest {

    @Mock
    RoverMovements roverMovements;

    @InjectMocks
    CommandsReader commandsReader;

    @Captor
    ArgumentCaptor<Rover> roverCaptor;

    @Test
    void givenAGoodFile() throws Exception {
        String path = this.getClass().getResource("/testingExamples/example.txt")
                          .getPath()
                          .replaceAll("%20", " ");

        commandsReader.readFile(path);

        Mockito.verify(roverMovements, Mockito.times(2))
               .processMovements(roverCaptor.capture());

        List<Rover> allValues = roverCaptor.getAllValues();

        Plateau plateau = new Plateau(new Position(5 ,5));

        Rover firstRover = Rover.builder()
                                .position(new Position(1, 2))
                                .direction(Direction.N)
                                .movements(Arrays.asList(L, M, L, M, L, M, L, M, M))
                                .plateau(plateau)
                                .build();


        Rover secondRover = Rover.builder()
                                 .position(new Position(3, 3))
                                 .direction(Direction.E)
                                 .movements(Arrays.asList(M, M, R, M, M, R, M, R, R, M))
                                 .plateau(plateau)
                                 .build();

        assertEquals(firstRover, allValues.get(0));
        assertEquals(secondRover, allValues.get(1));

    }
    @Test
    void givenAGoodFileLargeNumber() throws Exception {
        String path = this.getClass().getResource("/testingExamples/example2.txt")
                          .getPath()
                          .replaceAll("%20", " ");

        commandsReader.readFile(path);

        Mockito.verify(roverMovements, Mockito.times(2))
               .processMovements(roverCaptor.capture());

        List<Rover> allValues = roverCaptor.getAllValues();

        Plateau plateau = new Plateau(new Position(500 ,500));

        Rover firstRover = Rover.builder().position(new Position(10, 223))
                                .direction(Direction.N)
                                .movements(Arrays.asList(L, M, L, M, L, M, L, M, M))
                                .plateau(plateau)
                                .build();


        Rover secondRover = Rover.builder().position(new Position(30, 33))
                                 .plateau(plateau)
                                 .direction(Direction.E)
                                 .movements(Arrays.asList(M, M, R, M, M, R, M, R, R, M))
                                 .build();

        assertEquals(firstRover, allValues.get(0));
        assertEquals(secondRover, allValues.get(1));

    }
}