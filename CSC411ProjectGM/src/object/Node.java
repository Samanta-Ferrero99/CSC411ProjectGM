package object;

import java.util.LinkedList;

/**
 * Class for nodes for algorithm
 *
 * @author srdeange
 * @author spferrer
 *
 */
public class Node {
    private final LinkedList<Game> games;

    /**
     * Constructor
     *
     * @param list
     */
    public Node ( final LinkedList<Game> list ) {
        this.games = list;
    }

    /**
     * Add game to the list
     *
     * @param g
     *            game to add
     * @return boolean if added
     */
    public boolean add ( final Game g ) {
        return games.add( g );
    }

    /**
     * Remove game from the list
     *
     * @param g
     *            game to remove
     * @return boolean if removed
     */
    public boolean remove ( final Game g ) {
        return games.remove( g );
    }

    /**
     * Returns the list of games
     *
     * @return list of games
     */
    public LinkedList<Game> getgames () {
        return games;
    }
}
