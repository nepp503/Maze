package test.com.siniak.labirint.parser;

import com.siniak.labirint.exception.IncorrectInputDataException;
import com.siniak.labirint.parser.FileParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParserTest {
    char[][] expected = {{'.', '.', '.', '#'}, {'S', '.', '.', '#'}, {'.', '#', '.', '#'}, {'.', 'X', '.', '.'}};
    List<String> lines = new ArrayList<String >();
    List<String> incorrectLines = new ArrayList<String >();
    List<String> emtyLines = new ArrayList<String >();
    FileParser parser = new FileParser();

    @BeforeClass()
    public void setUp() {
        lines = Arrays.asList("...#", "S..#", ".#.#", ".X..");
        incorrectLines = Arrays.asList(".5.#", "S..#", "4#.#", ".X..");
    }

    @Test
    public void parseIntoCoordinatesTestTrue() throws IncorrectInputDataException {
        char[][] actual = parser.parseFromFile(lines);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void parseIntoCoordinatesTestFalse() throws IncorrectInputDataException {
        char[][] actual = parser.parseFromFile(incorrectLines);
        Assert.assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = IncorrectInputDataException.class)
    public void parseIntoCoordinatesTestException() throws IncorrectInputDataException {
        char[][] actual = parser.parseFromFile(emtyLines);
        Assert.assertNotEquals(actual, expected);
    }
}
