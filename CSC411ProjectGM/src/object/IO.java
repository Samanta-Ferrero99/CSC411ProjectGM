package object;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
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
    public static void write ( final LinkedList<Node> list, final String file, final float time ) {

        if ( list.isEmpty() ) {
            System.out.print( "No Nodes Exists, something went wrong" );
            return;
        }
        try {
            boolean sero = false;
            final LinkedList<Game> solutionFinal = new LinkedList<Game>();
            int runs = 0;
            while ( !sero && runs < 10 ) {
                final LinkedList<Game> solution = new LinkedList<Game>();
                final Iterator<Node> i = list.iterator();
                float timeLeft = time;
                while ( i.hasNext() ) {
                    final LinkedList<Game> games = i.next().getgames();
                    if ( games.size() == 0 ) {
                        System.out.print( "There is not a combination of games fullfilling your request." );
                        return;
                    }
                    final Random rand = new Random();
                    final Game g = games.get( rand.nextInt( games.size() ) );
                    solution.add( g );
                    timeLeft = timeLeft - g.getTime();
                    if ( timeLeft == 0 || ( timeLeft > 0 && !i.hasNext() ) ) {
                        sero = true;
                        solutionFinal.addAll( solution );
                    }
                    else if ( timeLeft < 0 && i.hasNext() ) {
                        break;
                    }
                }
                runs++;
            }
            final FileWriter stream = new FileWriter( file );
            final Iterator<Game> i2 = solutionFinal.iterator();
            while ( i2.hasNext() ) {
                stream.write( i2.next().toString() + '\n' );
            }
            stream.close();
        }
        catch ( final IOException e ) {
            System.out.print( "Could not write to file " + file );
        }
    }
}
