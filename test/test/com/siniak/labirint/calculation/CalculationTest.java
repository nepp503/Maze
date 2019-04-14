package test.com.siniak.labirint.calculation;

import com.siniak.labirint.calculation.Calculation;
import com.siniak.labirint.entity.Coordinate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculationTest {
    char[][] maze = {
            {'.', '.', '.', '#', '.'},
            {'.', 'S', '#', '.', '.'},
            {'.', '.', '#', '.', '.'},
            {'#', '.', '.', '#', '.'},
            {'.', '#', '.', '.', 'X'}};
    char[][] incorrectMaze = {
            {'.', '.', '#', '#', '.'},
            {'.', 'S', '#', '.', '.'},
            {'.', '.', '#', '.', '.'},
            {'#', '.', '#', '#', '.'},
            {'.', '#', '#', '.', 'X'}};
    Calculation calculationTrue;
    Calculation calculationWrong;
    List<String> rightMazeWay;
    List<String> wrongMazeWay;

    @BeforeClass
    public void setUp() {
        rightMazeWay = Arrays.asList("l", "d", "r", "d", "r", "d", "r", "r");
        wrongMazeWay = new ArrayList<>();
        calculationTrue = new Calculation(maze, new Coordinate(4,4));
        calculationWrong = new Calculation(incorrectMaze, new Coordinate(4,4));
    }

    @Test
    public void getTheWayOutTestTrue() {
        calculationTrue.calculateThePath(1, 1);
        List<String> actual = calculationTrue.getTheWayOut();
        Assert.assertEquals(actual, rightMazeWay);
    }

    @Test
    public void getTheWayOutTestFalse() {
        calculationTrue.calculateThePath(1, 1);
        List<String> actual = calculationWrong.getTheWayOut();
        Assert.assertEquals(actual, wrongMazeWay);
    }
}
