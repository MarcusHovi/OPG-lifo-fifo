import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Karaoke {

    private static FIFO fifo;
    private  static JLabel label;
    static String[] words = {"Look", "Up", "at", "the", "stars", "They're", "like", "piece", "of", "art"};
    static int order = 0;

    private static int generator() {
        return (int)  Math.round( Math.random() );
    }

    private static void makeAction() {

        switch (generator()) {
            case 1 -> {
                if (order <= 9)
                    fifo.insert(words[order]);
                order++;
                System.out.println("Insert");
            }
            case 0 -> {
                label.setText(fifo.pickUp());
                System.out.println("Picked up");
            }
        }
    }

    static class MKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent event) {

            int keyCode = event.getKeyCode();

            if (keyCode == KeyEvent.VK_ENTER)
                makeAction();

            if (keyCode == KeyEvent.VK_SPACE)
                System.out.println(fifo.toString());
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }


    public static void main(String[] args) {
        String[] words = {"Look", "Up", "at", "the", "stars", "They're", "like", "piece", "of", "art"};

        fifo = new FIFO(10);

        label = new JLabel("Song",JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);


        JFrame jframe = new JFrame("Karaoke");

        jframe.addKeyListener(new MKeyListener());

        jframe.add(label);

        jframe.setSize(400, 350);

        jframe.setVisible(true);

    }

}
