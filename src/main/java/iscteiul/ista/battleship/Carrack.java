```java
package iscteiul.ista.battleship;

/**
 * Represents a carrack ship in the Battleship game.
 *
 * <p>A carrack occupies three consecutive positions on the board.
 * Its positions are determined by its initial position and bearing.</p>
 */
public class Carrack extends Ship {

    /** The number of positions occupied by a carrack. */
    private static final Integer SIZE = 3;

    /** The name used to identify a carrack. */
    private static final String NAME = "Nau";

    /**
     * Creates a new carrack with the specified bearing and initial position.
     *
     * <p>If the bearing is {@code NORTH} or {@code SOUTH}, the carrack
     * occupies three positions vertically. If the bearing is {@code EAST}
     * or {@code WEST}, it occupies three positions horizontally.</p>
     *
     * @param bearing the direction in which the carrack is oriented
     * @param pos the initial position of the carrack
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Carrack(Compass bearing, IPosition pos)
            throws IllegalArgumentException {

        super(Carrack.NAME, bearing, pos);

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
                        "ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Returns the number of positions occupied by the carrack.
     *
     * @return the size of the carrack, which is {@value #SIZE}
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }
}
```
