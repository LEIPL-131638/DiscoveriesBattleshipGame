package iscteiul.ista.battleship;

import java.util.List;

/**
 * Defines the contract for a ship in the Discoveries Battleship Game.
 *
 * <p>A ship has a category, size, position, and bearing. It also
 * provides operations to determine its location on the board,
 * proximity to other ships, and whether it is still floating.</p>
 */
public interface IShip {

    /**
     * Returns the category of the ship.
     *
     * @return the category of the ship
     */
    String getCategory();

    /**
     * Returns the size of the ship.
     *
     * @return the number of positions occupied by the ship
     */
    Integer getSize();

    /**
     * Returns all positions occupied by the ship.
     *
     * @return the list of positions occupied by the ship
     */
    List<IPosition> getPositions();

    /**
     * Returns the main position of the ship.
     *
     * @return the position of the ship
     */
    IPosition getPosition();

    /**
     * Returns the bearing of the ship.
     *
     * @return the ship's bearing
     */
    Compass getBearing();

    /**
     * Checks whether the ship is still floating.
     *
     * @return {@code true} if the ship is still floating, otherwise {@code false}
     */
    boolean stillFloating();

    /**
     * Returns the topmost row occupied by the ship.
     *
     * @return the topmost row occupied by the ship
     */
    int getTopMostPos();

    /**
     * Returns the bottommost row occupied by the ship.
     *
     * @return the bottommost row occupied by the ship
     */
    int getBottomMostPos();

    /**
     * Returns the leftmost column occupied by the ship.
     *
     * @return the leftmost column occupied by the ship
     */
    int getLeftMostPos();

    /**
     * Returns the rightmost column occupied by the ship.
     *
     * @return the rightmost column occupied by the ship
     */
    int getRightMostPos();

    /**
     * Checks whether the ship occupies the specified position.
     *
     * @param pos the position to check
     * @return {@code true} if the ship occupies the position, otherwise {@code false}
     */
    boolean occupies(IPosition pos);

    /**
     * Checks whether this ship is too close to another ship.
     *
     * @param other the other ship to check
     * @return {@code true} if the ships are too close, otherwise {@code false}
     */
    boolean tooCloseTo(IShip other);

    /**
     * Checks whether the ship is too close to the specified position.
     *
     * @param pos the position to check
     * @return {@code true} if the ship is too close, otherwise {@code false}
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Shoots at the specified position of the ship.
     *
     * @param pos the position being shot
     */
    void shoot(IPosition pos);
}
