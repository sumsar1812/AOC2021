import java.util.List;

public class GasManager {

    public int getGas(List<Integer> data, int position, boolean isConstant) {
        return isConstant ? getConstantGas(data, position) : getIncreasingGas(data, position);
    }

    private int getConstantGas(List<Integer> data, int position) {
        return data.stream().mapToInt(i -> Math.abs(position - i)).sum();
    }

    private int getIncreasingGas(List<Integer> data, int position) {
        return data.stream().mapToInt(i -> getGas(Math.abs(position -i))).sum();
    }

    public static void main(String[] args) {
        System.out.println(getGas(10));
    }

    private static int getGas(int moved) {
        if (moved == 0) {
            return 0;
        }
        return moved + getGas(moved - 1);
    }

}
