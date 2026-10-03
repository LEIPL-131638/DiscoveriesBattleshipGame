package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface that defines the contract for a player's fleet.
 * Manages the ships on the board, including adding ships, retrieving
 * specific ships, and checking the fleet's status.
 */
public interface IFleet {
    
    /**
     * The standard size of the game board.
     */
    Integer BOARD_SIZE = 10;
    
    /**
     * The total number of ships allowed in the fleet.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Gets all the ships currently in the fleet.
     *
     * @return A list of all ships.
     */
    List<IShip> getShips();

    /**
     * Adds a new ship to the fleet.
     *
     * @param s The ship to be added.
     * @return true if the ship was successfully added, false otherwise.
     */
    boolean addShip(IShip s);

    /**
     * Retrieves a list of ships that match a specific category/type.
     *
     * @param category The name of the ship category (e.g., "Caravel", "Galleon").
     * @return A list of ships matching the given category.
     */
    List<IShip> getShipsLike(String category);

    /**
     * Retrieves a list of all ships that are still afloat (not completely sunk).
     *
     * @return A list of floating ships.
     */
    List<IShip> getFloatingShips();

    /**
     * Finds the ship located at a specific position on the board.
     *
     * @param pos The position to check on the board.
     * @return The ship at the given position, or null if there is no ship there.
     */
    IShip shipAt(IPosition pos);

    /**
     * Prints the current status of the fleet to the console.
     */
    void printStatus();
}
