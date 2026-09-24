```java
package iscteiul.ista.battleship;

/**
 * Represents a caravel ship in the Battleship game.
 *
 * <p>A caravel occupies two consecutive positions on the board.
 * Its positions are determined by its initial position and bearing.</p>
 */
public class Caravel extends Ship {

    /** The number of positions occupied by a caravel. */
    private static final Integer SIZE = 2;

    /** The name used to identify a caravel. */
    private static final String NAME = "Caravela";

    /**
     * Creates a new caravel with the specified bearing and initial position.
     *
     * <p>If the bearing is {@code NORTH} or {@code SOUTH}, the caravel
     * occupies two positions vertically. If the bearing is {@code EAST}
     * or {@code WEST}, it occupies two positions horizontally.</p>
     *
     * @param bearing the direction in which the caravel is oriented
     * @param pos the initial position of the caravel
     * @throws NullPointerException if {@code bearing} is {@code null}
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Caravel(Compass bearing, IPosition pos)
            throws NullPointerException, IllegalArgumentException {

        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException(
                    "ERROR! invalid bearing for the caravel");

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
                        "ERROR! invalid bearing for the caravel");
        }
    }

    /**
     * Returns the number of positions occupied by the caravel.
     *
     * @return the size of the caravel, which is {@value #SIZE}
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
```
