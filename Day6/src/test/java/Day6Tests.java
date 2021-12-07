import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Day6Tests {

    private Day6 uut;


    @Test
    public void solve_18days_Test() throws IOException {
        uut = new Day6( "26", "testdata.txt", 18);
        String a = uut.solve();
        Assert.assertEquals(uut.getAnswer(), a);
    }
    @Test
    public void solve_80days_Test() throws IOException {
        uut = new Day6( "5934", "testdata.txt", 80);
        String a = uut.solve();
        Assert.assertEquals(uut.getAnswer(), a);
    }
    @Test
    public void solve_256days_Test() throws IOException {
        uut = new Day6( "26984457539", "testdata.txt", 256);
        String a = uut.solve();
        Assert.assertEquals(uut.getAnswer(), a);
    }


}
