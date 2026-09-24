```java
/**
 * 
 */
package iscteiul.ista.battleship;

/**
 * Represents a barge in the Battleship game.
 *
 * <p>A barge occupies a single position on the game board.</p>
 */
public class Barge extends Ship {

    /** The number of positions occupied by a barge. */
    private static final Integer SIZE = 1;

    /** The name used to identify a barge. */
    private static final String NAME = "Barca";

    /**
     * Creates a new barge with the specified bearing and position.
     *
     * @param bearing the bearing of the barge
     * @param pos the upper-left position of the barge
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Returns the number of positions occupied by the barge.
     *
     * @return the size of the barge, which is {@value #SIZE}
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
```
