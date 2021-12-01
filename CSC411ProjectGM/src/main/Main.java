package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import algorithm.Algorithm;
import object.Game;
import object.IO;
import object.Arc;
import object.CSP;
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
        final Iterator<Game> I = arr.iterator();
        
        System.out.println("Please enter amount of games: ");
        Scanner in = new Scanner(System.in);
        int amountGames = in.nextInt();
        
        System.out.println("Please enter amount of players: ");
        int amountPlayers = in.nextInt();
        
        System.out.println("Please enter amount of time: ");
        int timeLeft = in.nextInt();
        
        in.close();
        
        LinkedList<Node> nodes = new LinkedList<Node>();
        
        for (int i = 0; i < arr.size(); i++) {
        	if (arr.get(i).getPlayers() <= amountPlayers) {
        		list.add(arr.get(i));
        	}
        }
        
        for (int i = 0; i < amountGames; i++) {
        	nodes.add(new Node(list));
        }
        
        Queue<Arc> queue = new LinkedList<Arc>();
        
        for (int i = 0; i < nodes.size(); i++) {
        	for ( int j = 0; j < nodes.size(); j++) {
        		if (i != j) {
        			queue.add(new Arc(nodes.get(i), nodes.get(j)));
        		}
        	}
        }
        
        CSP csp = new CSP(nodes, queue, timeLeft, list);
        
        Algorithm.AC(csp);
        LinkedList<Node> sol = Algorithm.backSearch(csp);
        
        for (int i = 0; i < sol.size(); i++) {
        	
        }
        
        
        while ( I.hasNext() ) {
            list.add( I.next() );
        }
        IO.write( list, "solution.txt" );

    }
}
