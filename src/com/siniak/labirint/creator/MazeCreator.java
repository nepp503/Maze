package com.siniak.labirint.creator;

import com.siniak.labirint.exception.IncorrectInputDataException;
import com.siniak.labirint.parser.FileParser;
import com.siniak.labirint.reader.AbstractReader;
import com.siniak.labirint.reader.MazeFileReader;
import com.siniak.labirint.validator.Validator;

import java.util.List;

public class MazeCreator {

    public char[][] createMaze(String path) throws IncorrectInputDataException {
        /*
        creates maze from input file (can change option and create maze from console input)
        and returns maze if it is correct
        otherwise throws exception
         */
        AbstractReader reader = new MazeFileReader();
        List<String> lines = reader.readMaze(path);
        FileParser parser = new FileParser();
        char[][] maze = parser.parseFromFile(lines);
        Validator validator = new Validator();
        if(!validator.isMazeCorrect(maze)){
            throw new IncorrectInputDataException("Incorrect input data");
        }
        return maze;
    }
}
