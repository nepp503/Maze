package com.siniak.labirint.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MazeFileReader extends AbstractReader{
    private final static String DEFAULT_PATH = "input/input.txt";
    static Logger logger = LogManager.getLogger();

    public List<String> readMaze(String path) {
        if (path == null) {
            path = DEFAULT_PATH;
        }
        List<String> lines = new ArrayList<>();
        try (Stream<String> lineStream = Files.lines(Paths.get(path))) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException ex) {
            logger.log(Level.FATAL, "File not found or damaged");
            throw new RuntimeException();
        }
        return lines;
    }
}
