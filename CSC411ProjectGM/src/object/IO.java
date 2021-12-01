package object;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class for the IO
 *
 * @author spferrer
 * @author srdeange
 *
 */
public class IO {
    /**
     * Method for reading in the games and generating the list of game objects
     *
     * @param file
     *            the file name
     * @return the list of games
     */
    @SuppressWarnings ( "resource" )
    public static ArrayList<Game> read ( final String file ) {
        final File f = new File( file );
        Scanner filescan = null;
        try {
            filescan = new Scanner( f );
        }
        catch ( final FileNotFoundException e ) {
            System.out.println( "Invalid File name" );
            return null;
        }

        final ArrayList<Game> arr = new ArrayList<Game>();
        int gameCount = 0;
        while ( filescan.hasNextLine() ) {
            gameCount++;
            final String line = filescan.nextLine();
            final Scanner linescan = new Scanner( line );
            linescan.useDelimiter( "," );
            try {
                final String name = linescan.next().trim();
                final String splayers = linescan.next().trim();
                final String genre = linescan.next().trim();
                final String splays = linescan.next().trim();
                final String ftime = linescan.next().trim();
                // String image = linescan.next();

                final int players = Integer.valueOf( splayers );
                final int plays = Integer.valueOf( splays );
                final float time = Float.valueOf( ftime );

                final Game g = new Game( name, players, genre, plays, time );
                arr.add( g );

            }
            catch ( final Exception e ) {
                System.out.println( "Invalid Game on line " + ( gameCount ) );
            }
        }

        return arr;
    }

    /**
     * Method to write the list of games to a save file
     *
     * @param list
     *            the list of games
     * @throws IOException
     */
    public static void write ( final LinkedList<Game> list, final String file ) {

        try {
            final FileWriter stream = new FileWriter( file );
            if ( !list.isEmpty() ) {
                final Iterator<Game> i = list.iterator();
                while ( i.hasNext() ) {
                    String game = i.next().toString();
                    game = game + "\n";
                    stream.write( game );
                }
                stream.close();
            }
            else {
                System.out.print( "List is empty" );
            }
        }
        catch ( final IOException e ) {
            System.out.print( "Could not write to file " + file );
        }
    }
}
