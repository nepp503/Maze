package test.com.siniak.labirint.validator;

import com.siniak.labirint.validator.Validator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidatorTest {
    char[][] maze = {{'.', '.', '.', '#'}, {'S', '.', '.', '#'}, {'.', '#', '.', '#'}, {'.', 'X', '.', '.'}};
    char[][] incorrectMaze = {{'X', '.', '.', '#'}, {'S', '.', '.', '#'}, {'.', '#', '.', '#'}, {'.', 'X', '.'}};
    Validator validator = new Validator();

    @Test
    public void isMazeCorrectTestTrue() {
        boolean actual = validator.isMazeCorrect(maze);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isMazeCorrectTestFalse() {
        boolean actual = validator.isMazeCorrect(incorrectMaze);
        boolean expected = false;
        Assert.assertEquals(actual, expected);
    }
}
