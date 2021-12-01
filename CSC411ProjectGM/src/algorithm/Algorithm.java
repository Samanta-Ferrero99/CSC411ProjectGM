package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import object.Arc;
import object.CSP;
import object.Game;
import object.Node;

public class Algorithm {
    public static LinkedList<Node> backSearch ( final CSP csp ) {
        final LinkedList<Node> assign = new LinkedList<Node>();
        for ( int i = 0; i < csp.getDomains().size(); i++ ) {
            assign.add( new Node( new LinkedList<Game>() ) );
        }
        final Random rand = new Random();
        final Game g = csp.getGames().get( rand.nextInt( csp.getGames().size() ) );

        if ( g.getTime() < csp.getTimeLeft() ) {
            assign.getFirst().getgames().add( g );
        }

        return recBackSearch( assign, csp );
    }

    public static LinkedList<Node> recBackSearch ( final LinkedList<Node> assign, final CSP csp ) {
        if ( csp.getTimeLeft() == 0 /* something like that */ ) {
            return assign;
        }
        final Node n = csp.getNextNode();
        if ( n == null ) {
            return assign;
        }
        for ( final Game g : n.getgames() ) {
            boolean same = false;
            for ( int i = 0; i < csp.getCurrentPos(); i++ ) {
                if ( assign.get( i ).getgames().contains( g ) ) {
                    same = true;
                }
            }
            if ( g.getTime() <= csp.getTimeLeft() && !same ) {
                assign.get( csp.getCurrentPos() ).add( g );
                csp.setTimeLeft( csp.getTimeLeft() - g.getTime() );
                LinkedList<Node> result = new LinkedList<Node>();
                result = recBackSearch( assign, csp );
                if ( !result.isEmpty() ) {
                    return result;
                }
                assign.get( csp.getCurrentPos() ).remove( g );
                csp.setTimeLeft( csp.getTimeLeft() + g.getTime() );
            }
        }
        return new LinkedList<Node>();
    }

    public static CSP AC ( final CSP csp ) {
        final Queue<Arc> q = csp.getQueue();

        while ( !q.isEmpty() ) {
            final Arc a = q.poll();
            removeInconsistentValue( a );
        }
        // MODIFY THIS SOMEHOW
        return csp;
    }

    public static boolean removeInconsistentValue ( final Arc arc ) {
        boolean removed = false;
        final LinkedList<Game> games1 = arc.getnode1().getgames();
        final LinkedList<Game> games2 = arc.getnode2().getgames();

        for ( int i = 0; i < games1.size(); i++ ) {
            boolean exist = false;
            for ( int j = 0; j < games2.size(); j++ ) {
                if ( !games1.get( i ).getGenre().equals( games2.get( j ).getGenre() ) ) {
                    exist = true;
                }
            }

            if ( !exist ) {
                games1.remove( i );
                removed = true;
            }
        }
        return removed;
    }
}
