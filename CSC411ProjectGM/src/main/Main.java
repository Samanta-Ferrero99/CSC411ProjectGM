package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import algorithm.Algorithm;
import object.Arc;
import object.CSP;
import object.Game;
import object.IO;
import object.Node;

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

        System.out.println( "Please enter amount of games: " );
        final Scanner in = new Scanner( System.in );
        final int amountGames = in.nextInt();

        System.out.println( "Please enter amount of players: " );
        final int amountPlayers = in.nextInt();

        System.out.println( "Please enter amount of time: " );
        final float timeLeft = in.nextFloat();

        in.close();

        final LinkedList<Node> nodes = new LinkedList<Node>();

        for ( int i = 0; i < arr.size(); i++ ) {
            if ( arr.get( i ).getPlayers() <= amountPlayers ) {
                list.add( arr.get( i ) );
            }
        }

        for ( int i = 0; i < amountGames; i++ ) {
            final LinkedList<Game> games = new LinkedList<Game>();
            for ( int j = 0; j < list.size(); j++ ) {
                games.add( list.get( j ) );
            }
            final Node node = new Node( games );
            nodes.add( node );
        }

        final Queue<Arc> queue = new LinkedList<Arc>();

        for ( int i = 0; i < nodes.size(); i++ ) {
            for ( int j = 0; j < nodes.size(); j++ ) {
                if ( i != j ) {
                    queue.add( new Arc( nodes.get( i ), nodes.get( j ) ) );
                }
            }
        }

        final CSP csp = new CSP( nodes, queue, timeLeft, list );

        Algorithm.AC( csp );
        final LinkedList<Node> sol = Algorithm.backSearch( csp );

        IO.write( sol, "solution.txt", timeLeft );

    }
}
