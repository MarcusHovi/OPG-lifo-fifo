package LinkedList;

public class Node_Str {
    String value;
    Node_Str next;

    public Node_Str( String value ) {
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

    public String getValue() {
        return value;
    }

    public void setValue( String value ) {
        this.value = value;
    }

    public Node_Str getNext() {
        return next;
    }

    public void setNext( Node_Str next ) {
        this.next = next;
    }
}
