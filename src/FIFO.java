import java.util.Arrays;

public class FIFO {
    private static String[] buffer;
    private int head;
    private int tail;
    private String status;


    public FIFO( int size ) {
        head = 0;
        tail = 0;
        buffer = new String[ size ];

        int loop = buffer.length;
        for ( int i = 0; i < loop; i++ ) {
            buffer[ i ] = "";
        }
    }

    public void insert( String word ) {

        boolean isDataLost = false;

        if ( tail == buffer.length ) {
            tail = 0;
            isDataLost = true;
        }

        if ( !buffer[ tail ].isEmpty() && !buffer[ tail ].equals( "" ) )
            isDataLost = true;


        buffer[ tail ] = word;
        tail++;

        if ( isDataLost )
            status = "DATA LOST";
        else
            status = "Inserted";
    }

    public String pickUp() {


        if ( head == tail ) {

            status = "NO DATA";
            return "---";
        } else {
            if ( head == buffer.length )
                head = 0;
            String aux = buffer[ head ];
            buffer[ head ] = "";
            head++;
            status = "Picked up";

            return aux;
        }


    }

    public String toString() {
        return Arrays.toString( buffer ) + "\r\n H:" + this.getHead() + " T:" + this.getTail();
    }

    public int getHead() {
        return head;
    }


    public int getTail() {
        return tail;
    }


    public String getStatus() {
        return status;
    }

}
