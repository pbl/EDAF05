public class Pair{

    private final int element0;
    private final Edge element1;

    public Pair(int element0, Edge element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public int getCity() {
        return element0;
    }

    public Edge getEdge() {
        return element1;
    }

}