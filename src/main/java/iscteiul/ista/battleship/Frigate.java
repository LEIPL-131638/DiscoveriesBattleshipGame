```java
package iscteiul.ista.battleship;

/**
 * Represents a frigate ship in the Battleship game.
 *
 * <p>A frigate occupies four consecutive positions on the board.
 * Its positions are determined by its initial position and bearing.</p>
 */
public class Frigate extends Ship {

    /** The number of positions occupied by a frigate. */
    private static final Integer SIZE = 4;

    /** The name used to identify a frigate. */
    private static final String NAME = "Fragata";

    /**
     * Creates a new frigate with the specified bearing and initial position.
     *
     * <p>If the bearing is {@code NORTH} or {@code SOUTH}, the frigate
     * occupies four positions vertically. If the bearing is {@code EAST}
     * or {@code WEST}, it occupies four positions horizontally.</p>
     *
     * @param bearing the direction in which the frigate is oriented
     * @param pos the initial position of the frigate
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Frigate(Compass bearing, IPosition pos)
            throws IllegalArgumentException {

        super(Frigate.NAME, bearing, pos);

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(
                            new Position(pos.getRow() + r, pos.getColumn()));
                break;

            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(
                            new Position(pos.getRow(), pos.getColumn() + c));
                break;

            default:
                throw new IllegalArgumentException(
                        "ERROR! invalid bearing for thr frigate");
        }
    }

    /**
     * Returns the number of positions occupied by the frigate.
     *
     * @return the size of the frigate, which is {@value #SIZE}
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }
}
```
