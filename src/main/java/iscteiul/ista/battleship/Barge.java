package iscteiul.ista.battleship;

/**
 * Represents a Barge ship in the Discoveries Battleship Game.
 *
 * <p>A Barge occupies one position on the game board and is
 * identified by the name "Barca".</p>
 */
public class Barge extends Ship {
    private static final Integer SIZE = 1;
    private static final String NAME = "Barca";

    /**
     * Creates a new Barge at the specified position and with the
     * specified bearing.
     *
     * @param bearing the bearing of the barge
     * @param pos     the upper-left position of the barge
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Returns the size of the barge.
     *
     * @return the size of the barge, which is 1
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
