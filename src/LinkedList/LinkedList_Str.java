package LinkedList;

import java.util.Objects;

public class LinkedList_Str {
    private Node_Str head;
    private int size;

    public LinkedList_Str() {
        this.size = 0;
        this.head = null;
    }

    public void prependNode( String value ) {

        Node_Str newNode = new Node_Str( value );

        if ( head == null )
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void prependNodeByIndex( int index, String value ) {
        if ( index > size || index < 0 )
            return;

        Node_Str newNode = new Node_Str( value );

        if ( head == null )
            head = newNode;
        else {
            int loop = 0;
            Node_Str previous = head;
            for ( Node_Str i = head; i != null; i = i.next ) {
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


    public void prependNodeByNode( Node_Str node, String value ) {
        if ( node == null )
            return;

        Node_Str newNode = new Node_Str( value );

        if ( head == null )
            head = newNode;
        else if ( head == node ) {
            newNode.next = head;
            head = newNode;
        } else {
            Node_Str previous = head;
            for ( Node_Str i = head; i != null; i = i.next ) {
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

    public void appendNode( String value ) {
        Node_Str newNode = new Node_Str( value );

        if ( head == null )
            head = newNode;

        else {
            Node_Str i = head;
            while ( true ) {
                if ( i.next == null ) {
                    i.next = newNode;
                    break;
                }
                i = i.next;
            }
        }
        size++;
    }

    public void appendNodeByNode( Node_Str node, String value ) {
        if ( node == null )
            return;

        Node_Str newNode = new Node_Str( value );

        if ( head == null ) head = newNode;
        else {
            Node_Str i = head;
            while ( true ) {
                if ( i == null ) break;
                if ( i == node ) {
                    newNode.next = node.next;
                    node.next = newNode;
                    break;
                }
                i = i.next;
            }
        }
        size++;
    }

    public void appendNodeByIndex( int index, String value ) {
        if ( index > size || index < 0 )
            return;

        Node_Str newNode = new Node_Str( value );

        if ( head == null )
            head = newNode;
        else {
            int loop = 0;
            for ( Node_Str i = head; i != null; i = i.next ) {
                if ( loop == index ) {
                    i.next = newNode;
                    break;
                }
                loop++;
            }
        }
        size++;
    }


    public void changeValue( int index, String value ) {
        if ( index > size || index < 0 )
            return;

        int loop = 0;
        for ( Node_Str i = head; i != null; i = i.next ) {
            if ( loop == index ) {
                i.value = value;
                break;
            }
            loop++;
        }
    }

    public void changeValue( Node_Str node, String value ) {
        if ( node == null ) return;
        node.value = value;
    }

    public Node_Str getNodeByIndex( int index ) {
        if ( index > size || index < 0 )
            return null;

        int loop = 0;
        for ( Node_Str i = head; i != null; i = i.next ) {
            if ( loop == index ) {
                return i;
            }
            loop++;
        }
        return null;
    }

    public Node_Str getNode( String value ) {

        for ( Node_Str i = head; i != null; i = i.next ) {
            if ( Objects.equals( i.value, value ) ) return i;
        }
        return null;
    }

    public int getIndex( Node_Str node ) {
        if ( node == null ) return -1;

        int loop = 0;
        for ( Node_Str i = head; i != null; i = i.next ) {
            if ( i == node ) return loop;
            loop++;
        }
        return -1;
    }

    public int getIndex( String value ) {
        int loop = 0;
        for ( Node_Str i = head; i != null; i = i.next ) {
            if ( Objects.equals( i.value, value ) ) return loop;
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

    public String printNodes() {

        String nodes = "";
        for ( Node_Str i = head; i != null; i = i.next ) {
            nodes += i.value + ", ";
        }
        return nodes;
        // Alternative
//        Node i = first;
//        while ( i!= null ){
//            System.out.println(i.value);
//            i = i.next;
//        }

    }

    public void removeNode( Node_Str node ) {
        if ( node == null ) return;


        if ( head == node ) {

            head = head.next;

        } else {

            Node_Str previous = head;
            for ( Node_Str i = head; i != null; i = i.next ) {
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

    public void removeNode( String value ) {

        if ( Objects.equals( head.value, value ) ) {

            head = head.next;

        } else {

            Node_Str previous = head;
            Node_Str i;
            for ( i = head; i != null; i = i.next ) {
                if ( Objects.equals( value, i.value ) ) {
                    previous.next = i.next;
                    i.next = null;

                    break;
                }
                previous = i;
            }
        }
        size--;

    }

    public void removeNodeByIndex( int index ) {
        if ( index > size || index < 0 ) return;

        if ( index == 0 ) {

            head = head.next;

        } else {
            Node_Str previous = head;
            Node_Str node = head;
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
