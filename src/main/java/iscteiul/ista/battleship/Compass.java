package iscteiul.ista.battleship;

/**
 * Represents the possible directions of a ship in the Battleship game.
 *
 * <p>Each direction is associated with a character used to represent it:
 * {@code n} for north, {@code s} for south, {@code e} for east and
 * {@code o} for west. {@link #UNKNOWN} represents an unknown direction.</p>
 */
public enum Compass {

    /** North direction, represented by {@code n}. */
    NORTH('n'),

    /** South direction, represented by {@code s}. */
    SOUTH('s'),

    /** East direction, represented by {@code e}. */
    EAST('e'),

    /** West direction, represented by {@code o}. */
    WEST('o'),

    /** Unknown or invalid direction, represented by {@code u}. */
    UNKNOWN('u');

    /** Character associated with the direction. */
    private final char c;

    /**
     * Creates a compass direction associated with the specified character.
     *
     * @param c the character representing the direction
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Returns the character associated with this direction.
     *
     * @return the character representing the direction
     */
    public char getDirection() {
        return c;
    }

    /**
     * Returns the character representation of this direction as a string.
     *
     * @return a string containing the character representing the direction
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converts a character into the corresponding compass direction.
     *
     * <p>If the character does not represent a valid direction,
     * {@link #UNKNOWN} is returned.</p>
     *
     * @param ch the character representing the direction
     * @return the corresponding compass direction, or {@link #UNKNOWN}
     *         if the character is not recognized
     */
    static Compass charToCompass(char ch) {
        Compass bearing;

        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}

