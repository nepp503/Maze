package com.siniak.labirint.calculation;

import com.siniak.labirint.entity.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    private static final char FREEELEMENT = '.';
    private static final char WALL = '#';
    private static final char ESCAPE = 'X';
    private static final char PATH = '1';
    private Coordinate finishPoint;
    private char[][] maze;
    private List<String> wayOut;

    public Calculation(char[][] maze, Coordinate finishPoint) {
        this.maze = maze;
        this.finishPoint = finishPoint;
        wayOut = new ArrayList<>();
    }

    public List<String> getTheWayOut(){
        // I had to create this, because way is creating upside down because of recursion
        List<String> rightWayOut = new ArrayList<>();
        for (int i = wayOut.size() - 1; i>=0; i--) {
            rightWayOut.add(wayOut.get(i));
        }
        return rightWayOut;
    }

    public boolean calculateThePath(int x, int y) {
        /*method finds free cell, changes its value to mark, that method was in this cell
        if there is no free cell around it returns to previous point and tries another way
         */
        maze[x][y] = PATH;
        if (x == finishPoint.getX() && y == finishPoint.getY()) {
            return true;
        }
        if (y > 0 && (maze[x][y-1] == FREEELEMENT || maze[x][y-1] == ESCAPE) && calculateThePath(x, y-1)) {
            wayOut.add("l");
            return true;
        }
        if (x < (maze.length-1) && (maze[x + 1][y] == FREEELEMENT || maze[x + 1][y] == ESCAPE)
                && calculateThePath(x+1, y)) {
            wayOut.add("d");
            return true;
        }
        if (y < (maze[0].length-1) && (maze[x][y + 1] == FREEELEMENT || maze[x][y + 1] == ESCAPE) &&
                calculateThePath(x, y+1)) {
            wayOut.add("r");
            return true;
        }
        if (x > 0 && (maze[x - 1][y] == FREEELEMENT  || maze[x - 1][y] == ESCAPE) && calculateThePath(x-1, y)) {
            wayOut.add("u");
            return true;
        }
        maze[x][y] = FREEELEMENT;
        return false;
    }
}
