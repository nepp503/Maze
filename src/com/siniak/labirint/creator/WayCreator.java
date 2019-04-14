package com.siniak.labirint.creator;

import com.siniak.labirint.calculation.Calculation;
import com.siniak.labirint.entity.Coordinate;
import com.siniak.labirint.exception.IncorrectInputDataException;

import java.util.List;

public class WayCreator {
    private Coordinate startingPoint;
    private Coordinate finishPoint;

    public List<String> createWayOut(String path) throws IncorrectInputDataException {
        /*
        caluculates the path from start to finish
        and returns list of moves
         */
        MazeCreator creator = new MazeCreator();
        char[][] maze = creator.createMaze(path);
        calculateStartAndFinish(maze);
        Calculation calculation = new Calculation(maze, finishPoint);
        calculation.calculateThePath(startingPoint.getX(), startingPoint.getY());
        List<String> wayOut = calculation.getTheWayOut();
        return wayOut;
    }

    private void calculateStartAndFinish(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'S') {
                    startingPoint = new Coordinate(i, j);
                }else if (maze[i][j] == 'X'){
                    finishPoint = new Coordinate(i, j);
                }
            }
        }
    }
}
