package object;

/**
 * Class for the game object
 *
 * @author spferrer
 *
 */
public class Game {
    private String name;
    private int    players;
    private String genre;
    private int    plays;
    private float  time;

    /**
     * Constructor for game
     *
     * @param name
     *            the name
     * @param players
     *            the number of players
     * @param genre
     *            the genre
     * @param plays
     *            the amount of times played
     * @param time
     *            the playtime
     */
    public Game ( final String name, final int players, final String genre, final int plays, final float time ) {
        super();
        this.name = name;
        this.players = players;
        this.genre = genre;
        this.plays = plays;
        this.time = time;
    }

    /**
     * Gets the name
     *
     * @return name
     */
    public String getName () {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name
     *            the name
     */
    public void setName ( final String name ) {
        this.name = name;
    }

    /**
     * Gets the number of players
     *
     * @return players
     */
    public int getPlayers () {
        return players;
    }

    /**
     * Sets the players
     *
     * @param players
     *            the player number
     */
    public void setPlayers ( final int players ) {
        this.players = players;
    }

    /**
     * Gets the genre
     *
     * @return genre
     */
    public String getGenre () {
        return genre;
    }

    /**
     * Sets the genre
     *
     * @param genre
     *            the genre
     */
    public void setGenre ( final String genre ) {
        this.genre = genre;
    }

    /**
     * Get the number of times played
     *
     * @return
     */
    public int getPlays () {
        return plays;
    }

    /**
     * Sets the plays
     *
     * @param plays
     *            the amount of times played
     */
    public void setPlays ( final int plays ) {
        this.plays = plays;
    }

    /**
     * Gets the play time
     *
     * @return the play time
     */
    public float getTime () {
        return time;
    }

    /**
     * Sets the play time
     *
     * @param time
     *            the play time
     */
    public void setTime ( final float time ) {
        this.time = time;
    }

    /**
     * Method to add one play after playing
     */
    public void incrementPlays () {
        plays++;
    }

    @Override
    public String toString () {
        return name + ", " + players + ", " + genre + ", " + plays + ", " + time;
    }

}
