package Model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Represents a room within the trivia maze game.
 * Each room is connected to four other rooms in the North, South, East, and West directions.
 * Each connection is represented by a door, which may be locked, unlocked, or permanently locked based on the
 * game's progress.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
public class TriviaMazeRoom implements Serializable {
    private static final long serialVersionUID = 638649015203610635L;

    // Constants representing the index for each direction.
    private static final int NORTH = 0;
    private static final int WEST = 1;
    private static final int SOUTH = 2;
    private static final int EAST = 3;

    // Array to hold the doors for the four directions of the room.
    private final TriviaMazeDoor[] myDoors;

    // Flag to track whether this room has been visited by the player.
    private boolean myHasVisited;

    /**
     * Constructs a TriviaMazeRoom with doors in the specified directions.
     * Initially, the room is marked as not visited.
     * @param theRow The row location of this room in the maze.
     * @param theCol The column location of this room in the maze.
     * @param theNorth The door leading to the North.
     * @param theWest The door leading to the West.
     * @param theSouth The door leading to the South.
     * @param theEast The door leading to the East.
     */
    public TriviaMazeRoom(final int theRow, final int theCol, final TriviaMazeDoor theNorth, final TriviaMazeDoor theWest,
                          final TriviaMazeDoor theSouth, final TriviaMazeDoor theEast) {
        myHasVisited = false;
        myDoors = new TriviaMazeDoor[4];
        // Initialize doors based on the parameters and room's position.
        myDoors[NORTH] = theNorth;
        myDoors[WEST] = theWest;
        myDoors[SOUTH] = theSouth;
        myDoors[EAST] = theEast;
    }

    /**
     * Retrieves the door in the specified direction.
     * @param theDirection The direction of the door to retrieve (e.g., "north", "south", "east", "west").
     * @return The TriviaMazeDoor in the specified direction, or null if no door exists in that direction.
     */
    public TriviaMazeDoor getDoor(final String theDirection) {
        return switch (theDirection.toLowerCase(Locale.ENGLISH)) {
            case "north" -> myDoors[NORTH];
            case "west" -> myDoors[WEST];
            case "south" -> myDoors[SOUTH];
            case "east" -> myDoors[EAST];
            default -> null; // No door for an invalid direction.
        };
    }

    /**
     * Checks whether this room has been visited.
     * @return true if the room has been visited; false otherwise.
     */
    public boolean visited() {
        return myHasVisited;
    }

    /**
     * Marks the room as visited or not visited.
     * @param theVisit True to mark the room as visited, false otherwise.
     */
    public void markVisited(boolean theVisit) {
        myHasVisited = theVisit;
    }

    /**
     * Provides a string representation of the room's state, including the status of each door.
     * @return A string detailing the state of the doors in this room.
     */
    @Override
    public String toString() {
        String[] doorStates = new String[4];
        for (int i = 0; i < myDoors.length; i++) {
            if (myDoors[i] == null) {
                doorStates[i] = "XX"; // No door or inaccessible.
            } else if (myDoors[i].isMyDoorLocked() && !myDoors[i].isMyDoorLockedPermanent()) {
                doorStates[i] = "LK"; // Locked but can be opened.
            } else if (myDoors[i].isMyDoorLockedPermanent()) {
                doorStates[i] = "XX"; // Permanently locked.
            } else {
                doorStates[i] = "OP"; // Open.
            }
        }

        // Build the room representation with even spacing
        return String.format("""
                             ROOM
                ______________________________
                =============|%s|============-
                |                            |
                |                            |
                |                            |
                |%s|          PL            |%s|
                |                            |
                |                            |
                |                            |
                |            |%s|            |
                ==============================
                ------------------------------
                """,
                doorStates[0], doorStates[1], doorStates[3],doorStates[2]);

    }
}
