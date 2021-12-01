package object;

public class Arc {
    private final Node node1;
    private final Node node2;

    public Arc ( final Node node1, final Node node2 ) {
        this.node1 = node1;
        this.node2 = node2;
    }

    public Node getnode1 () {
        return node1;
    }

    public Node getnode2 () {
        return node2;
    }
}
