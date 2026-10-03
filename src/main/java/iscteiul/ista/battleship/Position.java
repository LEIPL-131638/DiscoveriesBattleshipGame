package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Represents a position on the Battleship game board.
 *
 * <p>A position is defined by its row and column and keeps track
 * of whether it is occupied by a ship and whether it has been hit.</p>
 */
public class Position implements IPosition {
    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Creates a new position with the specified row and column.
     *
     * <p>A newly created position is not occupied and has not been hit.</p>
     *
     * @param row the row of the position
     * @param column the column of the position
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Returns the row of this position.
     *
     * @return the row of the position
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of this position.
     *
     * @return the column of the position
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Returns the hash code of this position.
     *
     * @return the hash code calculated from the position state
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compares this position with another object.
     *
     * <p>Two positions are considered equal when they have the same
     * row and column.</p>
     *
     * @param otherPosition the object to compare with
     * @return {@code true} if both positions have the same row and column,
     *         otherwise {@code false}
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Checks whether another position is adjacent to this position.
     *
     * @param other the position to check
     * @return {@code true} if the other position is adjacent, otherwise {@code false}
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marks this position as occupied by a ship.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marks this position as having been hit.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Checks whether this position is occupied by a ship.
     *
     * @return {@code true} if the position is occupied, otherwise {@code false}
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Checks whether this position has been hit.
     *
     * @return {@code true} if the position has been hit, otherwise {@code false}
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Returns a textual representation of this position.
     *
     * @return a string containing the row and column of the position
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }
}
