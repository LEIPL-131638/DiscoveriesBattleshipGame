/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface that defines the contract for the Battleship game.
 * Contains the main methods for game mechanics, such as firing
 * and getting match statistics.
 */
public interface IGame {
    
    /**
     * Fires a shot at a specific position on the opponent's board.
     *
     * @param pos The position (coordinates) where the shot will be fired.
     * @return The hit ship, or null if the shot missed.
     */
    IShip fire(IPosition pos);
    
    /**
     * Gets the history of all shots fired.
     *
     * @return A list containing the positions of all shots.
     */
    List<IPosition> getShots();

    /**
     * Returns the number of repeated shots (at the same position).
     *
     * @return The number of repeated shots.
     */
    int getRepeatedShots();

    /**
     * Returns the number of invalid shots (e.g., out of bounds).
     *
     * @return The number of invalid shots.
     */
    int getInvalidShots();

    /**
     * Returns the number of successful shots that hit a ship.
     *
     * @return The number of hits.
     */
    int getHits();

    /**
     * Returns the number of ships that have been completely sunk.
     *
     * @return The number of sunk ships.
     */
    int getSunkShips();

    /**
     * Returns the number of ships still surviving in the fleet.
     *
     * @return The number of remaining ships.
     */
    int getRemainingShips();
    
    /**
     * Prints the list of valid shots fired so far to the console.
    */
    void printValidShots();

    /**
     * Prints the current state of the fleet to the console.
     */
    void printFleet();
}
