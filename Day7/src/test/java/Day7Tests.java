import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class Day7Tests {

    private Day7 day7;
    private GasManager gasManager;


    @Test
    public void solvePart1Tests() throws IOException {
        day7 = new Day7("37", "testdata.txt", true);
        String a = day7.solve();
        Assert.assertEquals(day7.getAnswer(), a);
    }

    @Test
    public void solvePart2Tests() throws IOException {
        day7 = new Day7("168", "testdata.txt", false);
        String a = day7.solve();
        Assert.assertEquals(day7.getAnswer(), a);
    }

    @Test
    public void getGasConstantPosition4Test() {
        gasManager = new GasManager();
        int gas = gasManager.getGas(Arrays.asList(16,1,2,0,4,2,7,1,2,14), 4, true);
        Assert.assertEquals(41, gas);

    }
    @Test
    public void getGasConstantPosition10Test() {
        gasManager = new GasManager();
        int gas = gasManager.getGas(Arrays.asList(16,1,2,0,4,2,7,1,2,14), 10, true);
        Assert.assertEquals(71, gas);
    }
    @Test
    public void getGasConstantPosition1Test() {
        gasManager = new GasManager();
        int gas = gasManager.getGas(Arrays.asList(16,1,2,0,4,2,7,1,2,14), 1, true);
        Assert.assertEquals(41, gas);
    }


    @Test
    public void getGasIncreasingPosition2Test() {
        gasManager = new GasManager();
        int gas = gasManager.getGas(Arrays.asList(16,1,2,0,4,2,7,1,2,14), 2, false);
        Assert.assertEquals(206, gas);
    }
    @Test
    public void getGasIncreasingPosition5Test() {
        gasManager = new GasManager();
        int gas = gasManager.getGas(Arrays.asList(16,1,2,0,4,2,7,1,2,14), 5, false);
        Assert.assertEquals(168, gas);
    }



}
