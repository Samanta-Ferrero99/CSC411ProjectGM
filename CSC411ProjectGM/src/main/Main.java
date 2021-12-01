package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import object.Game;
import object.IO;

public class Main {
    /**
     * Main method
     *
     * @param args
     *            the arguments passed
     * @throws IOException
     */
    public static void main ( final String[] args ) throws IOException {
        final ArrayList<Game> arr = IO.read( "file.txt" );
        final LinkedList<Game> list = new LinkedList<Game>();
        final Iterator<Game> I = arr.iterator();
        while ( I.hasNext() ) {
            list.add( I.next() );
        }
        IO.write( list, "solution.txt" );

    }
}
