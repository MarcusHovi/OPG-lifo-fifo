import LinkedList.LinkedList_Str;

public class FIFO_LinkedList {
    private static LinkedList_Str buffer;
    private String status;


    public FIFO_LinkedList( int size ) {

        buffer = new LinkedList_Str();

//        for ( int i = 0; i < size; i++ ) {
//            buffer.prependNode("");
//        }
    }


    public void insert( String word ) {

        buffer.appendNode( word );
        status = "Inserted";
    }

    public String pickUp() {

        if ( buffer.getNodeByIndex( 0 ) != null ) {
            String aux = buffer.getNodeByIndex( 0 ).getValue();
            buffer.removeNodeByIndex( 0 );
            status = "Picked up";
            return aux;
        } else {
            status = "NO DATA";
            return "---";
        }

    }

    public String toString() {

        return buffer.printNodes();
    }


    public String getStatus() {
        return status;
    }

}
