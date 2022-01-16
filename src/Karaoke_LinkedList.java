import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Karaoke_LinkedList {

    static String[] words;
    static int order = 0;
    private static FIFO_LinkedList fifo;
    private static JLabel labelText;
    private static JLabel labelStatus;
    private static JLabel labelBufferStatus;

    private static int generator() {
        return ( int ) Math.round( Math.random() );
    }

    private static void makeAction() {

        switch ( generator() ) {
            case 1:
                if ( order > words.length - 1 )
                    order = 0;

                fifo.insert( words[ order ] );

                order++;
                break;
            case 0:
                labelText.setText( fifo.pickUp() );
                break;
        }

        labelStatus.setText( fifo.getStatus() );

        labelBufferStatus.setText( fifo.toString() ); // comment this row in case you do not want to auto update displayed buffer values
    }

    public static void main( String[] args ) throws IOException {

        FileReader fr = new FileReader( "src/resources/Look up at the stars - lyrics.txt" );
        BufferedReader br = new BufferedReader( fr );

        int i;
        StringBuilder input = new StringBuilder();
        while ( ( i = br.read() ) != -1 ) {
            input.append( ( char ) i );
        }
        br.close();
        fr.close();

        // replace new line chars to a space
        input = new StringBuilder( input.toString().trim().replaceAll( "[\\r\\n]+", " " ) );

        words = input.toString().split( " " );

        // size of buffer is same as number of words in txt file
        fifo = new FIFO_LinkedList( words.length );

        labelText = new JLabel( "Song", JLabel.CENTER );
        labelText.setHorizontalTextPosition( JLabel.CENTER );
        labelText.setVerticalTextPosition( JLabel.CENTER );
        labelText.setFont( new Font( "SansSerif", Font.BOLD, 20 ) );


        labelStatus = new JLabel( "Status", JLabel.CENTER );
        labelStatus.setHorizontalTextPosition( JLabel.CENTER );
        labelStatus.setVerticalTextPosition( JLabel.BOTTOM );


        labelBufferStatus = new JLabel( "Buffer values", JLabel.CENTER );
        labelBufferStatus.setHorizontalTextPosition( JLabel.CENTER );
        labelBufferStatus.setVerticalTextPosition( JLabel.BOTTOM );


        JFrame jframe = new JFrame( "Karaoke" );

        jframe.addKeyListener( new MKeyListener() );
        jframe.setLayout( new GridLayout( 3, 1 ) );
        jframe.setSize( 800, 700 );

        jframe.add( labelText );
        jframe.add( labelStatus );
        jframe.add( labelBufferStatus );

        jframe.setVisible( true );

    }

    static class MKeyListener implements KeyListener {

        @Override
        public void keyPressed( KeyEvent event ) {

            int keyCode = event.getKeyCode();

            if ( keyCode == KeyEvent.VK_ENTER )
                makeAction();
            System.out.println( fifo.toString() );

            if ( keyCode == KeyEvent.VK_SPACE )
                labelBufferStatus.setText( fifo.toString() );
        }

        @Override
        public void keyTyped( KeyEvent keyEvent ) {
        }

        @Override
        public void keyReleased( KeyEvent keyEvent ) {
        }
    }


}
