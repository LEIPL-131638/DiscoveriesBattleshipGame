package iscteiul.ista.battleship;

/**
 * Defines the contract for a position on the Battleship game board.
 *
 * <p>A position is identified by its row and column and can keep
 * track of whether it is occupied and whether it has been hit.</p>
 */
public interface IPosition {

    /**
     * Returns the row of this position.
     *
     * @return the row index of the position
     */
    int getRow();

    /**
     * Returns the column of this position.
     *
     * @return the column index of the position
     */
    int getColumn();

    /**
     * Compares this position with another object.
     *
     * @param other the object to compare with
     * @return {@code true} if the positions are equal, otherwise {@code false}
     */
    boolean equals(Object other);

    /**
     * Checks whether another position is adjacent to this position.
     *
     * @param other the position to check
     * @return {@code true} if the other position is adjacent, otherwise {@code false}
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marks this position as occupied by a ship.
     */
    void occupy();

    /**
     * Marks this position as having been shot.
     */
    void shoot();

    /**
     * Checks whether this position is occupied by a ship.
     *
     * @return {@code true} if the position is occupied, otherwise {@code false}
     */
    boolean isOccupied();

    /**
     * Checks whether this position has been hit.
     *
     * @return {@code true} if the position has been hit, otherwise {@code false}
     */
    boolean isHit();
}
