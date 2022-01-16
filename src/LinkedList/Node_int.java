package LinkedList;

public class Node_int {
    int value;
    Node_int next;

    public Node_int( int value ) {
        this.value = value;
//        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node_int getNext() {
        return next;
    }

    public void setNext( Node_int next ) {
        this.next = next;
    }
}
