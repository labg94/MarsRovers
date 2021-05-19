package me.lbenavides.infrastructure.primary;

import me.lbenavides.core.RoverMovements;
import me.lbenavides.infrastructure.primary.mapper.RoverMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CommandsReader {
    private final RoverMovements roverMovements;

    private final Pattern plateauPositionRegex = Pattern.compile("\\d+ \\d+");
    private final Pattern positionRegex = Pattern.compile("\\d+ \\d+ [NESW]");
    private final Pattern movementsRegex = Pattern.compile("[MLR]+");


    public CommandsReader(RoverMovements roverMovements) {
        this.roverMovements = roverMovements;
    }


    public void readFile(String filePath) throws Exception {
        Path path = Path.of(filePath);
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            handlePath(path);
        } else {
            throw new Exception("the file does not exists");
        }


    }

    private void handlePath(Path path) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            handleBuffer(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleBuffer(BufferedReader bufferedReader) throws IOException {
        String value;
        RoverDto.RoverDtoBuilder builder = RoverDto.builder();
        while ((value = bufferedReader.readLine()) != null) {
            if (plateauPositionRegex.matcher(value).matches()) builder = builder.plateauCoordinates(value);

            if (positionRegex.matcher(value).matches()) builder = builder.addXYAndDirection(value);

            if (movementsRegex.matcher(value).matches()) processData(value, builder);
        }
    }

    private void processData(String value, RoverDto.RoverDtoBuilder builder) {
        List<String> stringStream = value.chars()
                                         .mapToObj(character -> (char) character)
                                         .map(String::valueOf).collect(Collectors.toList());

        RoverDto build = builder.movements(stringStream).build();

        roverMovements.processMovements(RoverMapper.toRover(build));

    }


}
