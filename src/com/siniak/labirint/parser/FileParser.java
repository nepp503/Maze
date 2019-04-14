package com.siniak.labirint.parser;

import com.siniak.labirint.exception.IncorrectInputDataException;
import com.siniak.labirint.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public char[][] parseFromFile(List<String> lines) throws IncorrectInputDataException {
        /*
        accepts lines from readed file or console
        and parses input information into maze
         */
        if (lines.isEmpty()) {
            throw new IncorrectInputDataException("No valid lines in input data");
        }
        List<String> correctLines = chooseCorrectLines(lines);
        int size = correctLines.size();
        String[][] mazeToParse = new String[size][];
        for (int i = 0; i < size; i++) {
            String[] row = correctLines.get(i).split("");
            mazeToParse[i] = row;
        }
        char[][] maze = parseIntoCharMaze(mazeToParse);
        return maze;
    }

    private char[][] parseIntoCharMaze(String[][] mazeToParse) {
        int height = mazeToParse.length;
        int width = mazeToParse[0].length;
        char[][] maze = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = mazeToParse[i][j].charAt(0);
            }
        }
        return maze;
    }

    private List<String> chooseCorrectLines(List<String> lines) {
        List<String> linesForParsing = new ArrayList<String>();
        for (String line : lines) {
            if (Validator.isLineExceptable(line)){
                linesForParsing.add(line);
            }
        }
        return linesForParsing;
    }
}
