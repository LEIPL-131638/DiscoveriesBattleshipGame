```java
package iscteiul.ista.battleship;

/**
 * Represents a galleon ship in the Battleship game.
 *
 * <p>A galleon occupies five positions on the board. Its positions
 * depend on the bearing specified when the ship is created.</p>
 */
public class Galleon extends Ship {

    /** The number of positions occupied by a galleon. */
    private static final Integer SIZE = 5;

    /** The name used to identify a galleon. */
    private static final String NAME = "Galeao";

    /**
     * Creates a new galleon with the specified bearing and initial position.
     *
     * <p>The position of the galleon is calculated according to its
     * bearing: {@code NORTH}, {@code EAST}, {@code SOUTH}, or
     * {@code WEST}.</p>
     *
     * @param bearing the direction in which the galleon is oriented
     * @param pos the initial position of the galleon
     * @throws NullPointerException if {@code bearing} is {@code null}
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Galleon(Compass bearing, IPosition pos)
            throws IllegalArgumentException {

        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException(
                    "ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;

            case EAST:
                fillEast(pos);
                break;

            case SOUTH:
                fillSouth(pos);
                break;

            case WEST:
                fillWest(pos);
                break;

            default:
                throw new IllegalArgumentException(
                        "ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Returns the number of positions occupied by the galleon.
     *
     * @return the size of the galleon, which is {@value #SIZE}
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Fills the positions occupied by the galleon when it is facing north.
     *
     * @param pos the initial position of the galleon
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(
                    new Position(pos.getRow(), pos.getColumn() + i));
        }

        getPositions().add(
                new Position(pos.getRow() + 1, pos.getColumn() + 1));

        getPositions().add(
                new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Fills the positions occupied by the galleon when it is facing south.
     *
     * @param pos the initial position of the galleon
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(
                    new Position(pos.getRow() + i, pos.getColumn()));
        }

        for (int j = 2; j < 5; j++) {
            getPositions().add(
                    new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Fills the positions occupied by the galleon when it is facing east.
     *
     * @param pos the initial position of the galleon
     */
    private void fillEast(IPosition pos) {
        getPositions().add(
                new Position(pos.getRow(), pos.getColumn()));

        for (int i = 1; i < 4; i++) {
            getPositions().add(
                    new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }

        getPositions().add(
                new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Fills the positions occupied by the galleon when it is facing west.
     *
     * @param pos the initial position of the galleon
     */
    private void fillWest(IPosition pos) {
        getPositions().add(
                new Position(pos.getRow(), pos.getColumn()));

        for (int i = 1; i < 4; i++) {
            getPositions().add(
                    new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }

        getPositions().add(
                new Position(pos.getRow() + 2, pos.getColumn()));
    }
}
```
