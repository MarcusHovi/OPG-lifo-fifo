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

    public String pickUp(){




        if (head == tail) {
            return "NO DATA";
        }
        else {
            if (head == buffer.length)
                head = 0;
            String aux = buffer[head];
            buffer[head] = "";
            head++;

            return aux;
        }


    }

    public String toString() {
        return Arrays.toString(buffer) + this.getHead() + " " + this.getTail();
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
