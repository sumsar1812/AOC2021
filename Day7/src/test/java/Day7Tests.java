import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day7Tests {

    private Day7 uut;


    @Test
    public void solvePart1Tests() throws IOException {
        uut = new Day7("37", "testdata.txt", true);
        String a = uut.solve();
        Assert.assertEquals(uut.getAnswer(), a);
    }

    @Test
    public void solvePart2Tests() throws IOException {
        uut = new Day7("168", "testdata.txt", false);
        String a = uut.solve();
        Assert.assertEquals(uut.getAnswer(), a);
    }

}
