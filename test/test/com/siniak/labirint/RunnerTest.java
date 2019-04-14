package test.com.siniak.labirint;

import com.siniak.labirint.creator.WayCreator;
import com.siniak.labirint.exception.IncorrectInputDataException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class RunnerTest {
    String path = "input/input.txt";
    List<String> wayOut;
    WayCreator creator;

    @BeforeClass
    public void setUp() {
        wayOut = Arrays.asList("l", "l", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d", "d",
                "d", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r",
                "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "r", "u", "l", "l", "l", "l",
                "u", "r", "r", "r","r");
        creator = new WayCreator();
    }

    @Test
    public void mainTest() throws IncorrectInputDataException {
        List<String> actual = creator.createWayOut(path);
        Assert.assertEquals(actual, wayOut);
    }
}
