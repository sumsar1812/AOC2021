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

    @Override
    public boolean equals(Object o) {
        if (o instanceof BoardNumber) {
            return ((BoardNumber) o).getNumber() == number;
        }
        return false;
    }

}
