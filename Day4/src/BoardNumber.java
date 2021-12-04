public class BoardNumber {
    private final int number;
    private boolean marked = false;

    public BoardNumber(int number) {
        this.number = number;
    }

    public void mark() {
        marked = true;
    }

    public boolean isMarked() {
        return marked;
    }

    public int getNumber() {
        return number;
    }
}
