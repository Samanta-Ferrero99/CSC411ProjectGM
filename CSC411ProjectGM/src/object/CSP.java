package object;

import java.util.LinkedList;
import java.util.Queue;

/**
 * CSP class
 *
 * @author ykim38
 *
 */
public class CSP {
    private final LinkedList<Game> games;
    private final LinkedList<Node> domain;
    private final Queue<Arc>       arcs;
    private float                  timeLeft;
    private Node                   current;
    private int                    currentPos;

    /**
     * Constructor for CSP
     *
     * @param nodes
     *            list of nodes
     * @param arcs
     *            queue of arcs
     * @param timeLeft
     *            the time left
     */
    public CSP ( final LinkedList<Node> nodes, final Queue<Arc> arcs, final float timeLeft,
            final LinkedList<Game> games ) {
        this.domain = nodes;
        this.arcs = arcs;
        this.timeLeft = timeLeft;
        this.current = null;
        currentPos = -1;
        this.games = games;
    }

    /**
     * Gets the timeLeft
     *
     * @return time left
     */
    public float getTimeLeft () {
        return timeLeft;
    }

    /**
     * Sets the timeLeft to the new value
     *
     * @param newTimeLeft
     *            new value for timeLeft
     */
    public void setTimeLeft ( final float newTimeLeft ) {
        timeLeft = newTimeLeft;
    }

    /**
     * Gets the next node in the list of nodes
     *
     * @return next node in the list
     */
    public Node getNextNode () {
        if ( current == null ) {
            current = domain.getFirst();
            currentPos = 0;
            return current;
        }
        currentPos += 1;
        if ( currentPos >= domain.size() ) {
            return null;
        }
        current = domain.get( currentPos );
        return current;
    }

    public LinkedList<Node> getDomains () {
        return domain;
    }

    public int getCurrentPos () {
        return currentPos;
    }

    /**
     * Gets the queue of arcs
     *
     * @return queue
     */
    public Queue<Arc> getQueue () {
        return arcs;
    }

    /**
     * Gets the games
     *
     * @return games
     */
    public LinkedList<Game> getGames () {
        return games;
    }
}
