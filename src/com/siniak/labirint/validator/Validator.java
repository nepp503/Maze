package com.siniak.labirint.validator;

import java.util.regex.Pattern;

public class Validator {
    private static final String VALIDLINE = "[(\\.),#]*[\\S]?[(\\.),#]*[X]?[(\\.),#]*[\\S]?[(\\.),#]*";

    public static boolean isLineExceptable(String line) {
        /*
        validates line according to string pattern
         */
        boolean isLineOk = false;
        if(line == null){
            return isLineOk;
        }
        isLineOk = Pattern.matches(VALIDLINE, line);
        return isLineOk;
    }

    public boolean isMazeCorrect(char[][] maze) {
        /*
        checks is maze correct or not
         */
        if (checkSizeOfMaze(maze) && checkNumberOfStartsAndEscapes(maze)) {
            return true;
        }
        return false;
    }

    private boolean checkNumberOfStartsAndEscapes(char[][] maze) {
        int height = maze.length;
        int width = maze[0].length;
        int numOfStarts = 0;
        int numOfEscapes = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == 'S') {
                    numOfStarts++;
                }else if (maze[i][j] == 'X'){
                    numOfEscapes++;
                }
            }
        }
        if (numOfStarts == 1 && numOfEscapes == 1) {
            return true;
        }
        return false;
    }

    private boolean checkSizeOfMaze(char[][] maze) {
        for (int i = 0; i < maze.length-1; i++) {
            if (maze[i].length != maze[i + 1].length) {
                return false;
            }
        }
        return true;
    }
}
