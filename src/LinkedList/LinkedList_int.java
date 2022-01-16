package LinkedList;

public class LinkedList_int {
    private Node_int head;
    private int size;

    public LinkedList_int() {
        this.size = 0;
        this.head = null;
    }

    public void prependNode( int value ) {

        Node_int newNode = new Node_int( value );

        if (head == null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void prependNodeByIndex(int index, int value) {
        if (index > size || index < 0)
            return;

        Node_int newNode = new Node_int( value );

        if (head == null)
            head = newNode;
        else {
            int loop = 0;
            Node_int previous = head;
            for ( Node_int i = head; i != null; i = i.next ) {
                if ( loop == index ) {
                    newNode.next = i;
                    previous.next = newNode;

                    break;
                }
                previous = i;
                loop++;
            }
        }
        size++;
    }


    public void prependNodeByNode( Node_int node, int value ) {
        if ( node == null )
            return;

        Node_int newNode = new Node_int( value );

        if ( head == null )
            head = newNode;
        else if ( head == node ) {
            newNode.next = head;
            head = newNode;
        } else {
            Node_int previous = head;
            for ( Node_int i = head; i != null; i = i.next ) {
                if ( i == node ) {
                    newNode.next = i;
                    previous.next = newNode;
                    break;
                }
                previous = i;
            }
        }
        size++;
    }

    public void appendNode(int value) {
        Node_int newNode = new Node_int( value );

        if (head == null)
            head = newNode;

        else {
            Node_int i = head;
            while (true) {
                if (i.next == null) {
                    i.next = newNode;
                    break;
                }
                i = i.next;
            }
        }
        size++;
    }

    public void appendNodeByNode( Node_int node, int value ) {
        if ( node == null )
            return;

        Node_int newNode = new Node_int( value );

        if ( head == null ) head = newNode;
        else {
            Node_int i = head;
            while ( true ) {
                if ( i == null ) break;
                if (i == node) {
                    newNode.next = node.next;
                    node.next = newNode;
                    break;
                }
                i = i.next;
            }
        }
        size++;
    }

    public void appendNodeByIndex(int index, int value) {
        if (index > size || index < 0)
            return;

        Node_int newNode = new Node_int( value );

        if (head == null)
            head = newNode;
        else {
            int loop = 0;
            for ( Node_int i = head; i != null; i = i.next ) {
                if ( loop == index ) {
                    i.next = newNode;
                    break;
                }
                loop++;
            }
        }
        size++;
    }


    public void changeValue(int index, int value) {
        if (index > size || index < 0)
            return;

        int loop = 0;
        for ( Node_int i = head; i != null; i = i.next ) {
            if ( loop == index ) {
                i.value = value;
                break;
            }
            loop++;
        }
    }

    public void changeValue( Node_int node, int value ) {
        if ( node == null ) return;
        node.value = value;
    }

    public Node_int getNodeByIndex( int index ) {
        if ( index > size || index < 0 )
            return null;

        int loop = 0;
        for ( Node_int i = head; i != null; i = i.next ) {
            if ( loop == index ) {
                return i;
            }
            loop++;
        }
        return null;
    }

    public Node_int getNode( int value ) {

        for ( Node_int i = head; i != null; i = i.next ) {
            if ( i.value == value ) return i;
        }
        return null;
    }

    public int getIndex( Node_int node ) {
        if ( node == null ) return -1;

        int loop = 0;
        for ( Node_int i = head; i != null; i = i.next ) {
            if ( i == node ) return loop;
            loop++;
        }
        return -1;
    }

    public int getIndex(int value) {
        int loop = 0;
        for ( Node_int i = head; i != null; i = i.next ) {
            if ( i.value == value ) return loop;
            loop++;
        }
        return -1;
    }

    public int getLen() {
//        int length = 0;
//        for (Node i = first; i != null; i = i.next) {
//            length++;
//        }
//        return length;
        return size;
    }

    public void printNodes() {


        for ( Node_int i = head; i != null; i = i.next ) {
            System.out.println( i.value + " " );
        }
        // Alternative
//        Node i = first;
//        while ( i!= null ){
//            System.out.println(i.value);
//            i = i.next;
//        }

    }

    public void removeNode( Node_int node ) {
        if ( node == null ) return;


        if ( head == node ) {

            head = head.next;

        } else {

            Node_int previous = head;
            for ( Node_int i = head; i != null; i = i.next ) {
                if ( node == i ) {
                    previous.next = node.next;
                    node.next = null;
                    break;
                }
                previous = i;
            }
        }
        size--;

    }

    public void removeNode(int value) {

        if (head.value == value) {

            head = head.next;

        } else {

            Node_int previous = head;
            Node_int i;
            for ( i = head; i != null; i = i.next ) {
                if ( value == i.value ) {
                    previous.next = i.next;
                    i.next = null;

                    break;
                }
                previous = i;
            }
        }
        size--;

    }

    public void removeNodeByIndex(int index) {
        if (index > size || index < 0) return;

        if (index == 0) {

            head = head.next;

        } else {
            Node_int previous = head;
            Node_int node = head;
            for ( int i = 0; i < size; i++ ) {

                if ( index == i ) {
                    previous.next = node.next;
                    node.next = null;

                    break;
                }
                previous = node;
                node = node.next;

            }
        }

        size--;

    }

    public int getSize() {
        return size;
    }
}
