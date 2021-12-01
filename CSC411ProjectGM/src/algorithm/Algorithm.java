package algorithm;

import java.util.LinkedList;
import java.util.Queue;

import object.Arc;
import object.CSP;
import object.Game;
import object.Node;

public class Algorithm {
    public static LinkedList<Node> backSearch ( final CSP csp ) {
        final LinkedList<Node> assign = new LinkedList<Node>();

        return recBackSearch( assign, csp );
    }

    public static LinkedList<Node> recBackSearch ( final LinkedList<Node> assign, final CSP csp ) {
        if ( csp.getTimeLeft() == 0 /* something like that */ ) {
            return assign;
        }
        final Node n = csp.getNextNode();
        if ( n == null ) {
            return new LinkedList<Node>();
        }
        for ( final Game g : csp.getGames() ) {
            if ( g.getTime() <= csp.getTimeLeft() ) {
                n.add( g );
                LinkedList<Node> result = new LinkedList<Node>();
                result = recBackSearch( assign, csp );
                if ( !result.isEmpty() ) {
                    return result;
                }
                n.remove( g );
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
        for ( final Game g : arc.getnode1().getgames() ) {
            boolean exist = false;
            for ( final Game g2 : arc.getnode2().getgames() ) {
                if ( !g.getGenre().equals( g2.getGenre() ) ) {
                    exist = true;
                }
            }
            if ( !exist ) {
                arc.getnode1().remove( g );
                removed = true;
            }
        }
        return removed;
    }
}
