package iscteiul.ista.battleship;

import iscteiul.ista.battleship.IFleet;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Battleship game.
 *
 * <p>The game keeps track of the fleet, the positions where shots have
 * been fired, and statistics such as invalid shots, repeated shots,
 * hits, and sunk ships.</p>
 */
public class Game implements IGame {

    /** The fleet used in the game. */
    private IFleet fleet;

    /** The positions where valid shots have been fired. */
    private List<IPosition> shots;

    /** The number of invalid shots. */
    private Integer countInvalidShots;

    /** The number of repeated shots. */
    private Integer countRepeatedShots;

    /** The number of successful hits. */
    private Integer countHits;

    /** The number of ships that have been sunk. */
    private Integer countSinks;

    /**
     * Creates a new game using the specified fleet.
     *
     * @param fleet the fleet used in the game
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
    }

    /**
     * Fires a shot at the specified position.
     *
     * <p>If the position is invalid, the invalid-shot counter is
     * incremented. If the position has already been targeted, the
     * repeated-shot counter is incremented. Otherwise, the shot is
     * registered and, if a ship occupies the position, the ship is
     * hit.</p>
     *
     * @param pos the position at which the shot is fired
     * @return the ship if the shot sinks it; {@code null} otherwise
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else {
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);

                if (s != null) {
                    s.shoot(pos);
                    countHits++;

                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }

        return null;
    }

    /**
     * Returns the positions where valid shots have been fired.
     *
     * @return the list of fired shot positions
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Returns the number of repeated shots.
     *
     * @return the number of repeated shots
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Returns the number of invalid shots.
     *
     * @return the number of invalid shots
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Returns the number of successful hits.
     *
     * @return the number of hits
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Returns the number of ships that have been sunk.
     *
     * @return the number of sunk ships
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Returns the number of ships that are still floating.
     *
     * @return the number of remaining ships
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Checks whether a shot position is within the game board.
     *
     * @param pos the position to validate
     * @return {@code true} if the position is valid;
     *         {@code false} otherwise
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0
                && pos.getRow() <= Fleet.BOARD_SIZE
                && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * Checks whether a shot has already been fired at the specified position.
     *
     * @param pos the position to check
     * @return {@code true} if the position has already been targeted;
     *         {@code false} otherwise
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;

        return false;
    }

    /**
     * Prints a board containing the specified positions using the given marker.
     *
     * @param positions the positions to display on the board
     * @param marker the character used to mark the positions
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);

            System.out.println();
        }
    }

    /**
     * Prints the board showing the positions where valid shots have been fired.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Prints the board showing the positions occupied by the fleet.
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }
}