package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a fleet of ships in the Battleship game.
 *
 * <p>A fleet maintains a collection of ships and provides operations
 * to add ships, search for ships, and display their status.</p>
 */
public class Fleet implements IFleet {

    /**
     * Prints all the ships in the specified list.
     *
     * @param ships the list of ships to print
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    /** The ships belonging to this fleet. */
    private List<IShip> ships;

    /**
     * Creates an empty fleet.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Returns the list of ships belonging to this fleet.
     *
     * @return the list of ships in the fleet
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adds a ship to the fleet if it can be placed on the board
     * without exceeding the fleet size or colliding with another ship.
     *
     * @param s the ship to add
     * @return {@code true} if the ship was successfully added;
     *         {@code false} otherwise
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;

        if ((ships.size() <= FLEET_SIZE)
                && (isInsideBoard(s))
                && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }

        return result;
    }

    /**
     * Returns all ships belonging to the specified category.
     *
     * @param category the category of ships to search for
     * @return a list containing the ships that belong to the specified category
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();

        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Returns all ships in the fleet that are still floating.
     *
     * @return a list containing the ships that have not been sunk
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();

        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Returns the ship occupying the specified position.
     *
     * @param pos the position to search
     * @return the ship occupying the position, or {@code null} if
     *         no ship occupies it
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);

        return null;
    }

    /**
     * Checks whether a ship is completely inside the game board.
     *
     * @param s the ship whose position is checked
     * @return {@code true} if the ship is inside the board;
     *         {@code false} otherwise
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0
                && s.getRightMostPos() <= BOARD_SIZE - 1
                && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Checks whether placing a ship would cause a collision
     * or violate the minimum distance between ships.
     *
     * @param s the ship to check
     * @return {@code true} if the ship is too close to another ship;
     *         {@code false} otherwise
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }

        return false;
    }

    /**
     * Displays the current status of the fleet.
     *
     * <p>The status includes all ships, floating ships, and ships
     * grouped by category.</p>
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Prints all ships belonging to the specified category.
     *
     * @param category the category of ships to print
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    /**
     * Prints all ships in the fleet that are still floating.
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Prints all ships currently belonging to the fleet.
     */
    void printAllShips() {
        printShips(ships);
    }
}