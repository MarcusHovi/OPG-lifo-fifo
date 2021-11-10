import java.util.Arrays;

public class FIFO {
    private static String[] buffer;
    private int head;
    private int tail;

    public FIFO(int size) {
        head = 0;
        tail = 0;
        buffer = new String[size];
    }

//    public static LinkedList<String> getFifo() {
//        return fifo;
//    }
//
//    public static void setFifo(LinkedList<String> fifo) {
//        FIFO.fifo = fifo;
//    }

    public void insert(String word) {
        if (tail == buffer.length) {
            System.out.println("DATA LOST");
            tail = 0;
        }

        buffer[tail] = word;
        tail++;
    }

    public void pickUp(){

        if (head == buffer.length)
            head = 0;

        if (head == tail) {
            System.out.println("NO DATA");
        }

        else {
            String aux = buffer[head];
            buffer[head] = "";
            head++;

            System.out.println(aux);
        }

    }

    public void printOutQueue() {
        System.out.println(Arrays.toString(buffer));
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }
}
