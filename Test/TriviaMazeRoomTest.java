package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.*;

/**
 * Provides JUnit tests for the TriviaMazeRoom class in the Model package.
 * It tests the room's functionality in the context of a trivia maze game,
 * including the management of doors in different directions, room visitation status,
 * and the textual representation of the room's current state.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
class TriviaMazeRoomTest {

    private TriviaMazeRoom room; // Instance of TriviaMazeRoom to be tested
    private TriviaMazeDoor northDoor, southDoor, eastDoor, westDoor; // Doors in each direction of the room

    /**
     * Sets up the test environment before each test method.
     * Initializes doors in all four directions and a new room with these doors.
     */
    @BeforeEach
    void setUp() {
        // Initialize doors for each direction
        northDoor = new TriviaMazeDoor();
        southDoor = new TriviaMazeDoor();
        eastDoor = new TriviaMazeDoor();
        westDoor = new TriviaMazeDoor();
        // Create a new room with the initialized doors
        room = new TriviaMazeRoom(0, 0, northDoor, westDoor, southDoor, eastDoor);
    }

    /**
     * Tests retrieval of doors from the room in all valid directions.
     */
    @Test
    void getDoor_ValidDirections() {
        assertSame(northDoor, room.getDoor("north"), "North door should be correctly retrieved");
        assertSame(southDoor, room.getDoor("south"), "South door should be correctly retrieved");
        assertSame(eastDoor, room.getDoor("east"), "East door should be correctly retrieved");
        assertSame(westDoor, room.getDoor("west"), "West door should be correctly retrieved");
    }

    /**
     * Tests retrieval of a door from the room using an invalid direction.
     */
    @Test
    void getDoor_InvalidDirection() {
        assertNull(room.getDoor("invalid_direction"), "No door should be retrieved for an invalid direction");
    }

    /**
     * Tests the initial visitation status of the room.
     */
    @Test
    void visited_InitiallyFalse() {
        assertFalse(room.visited(), "New room should initially be marked as unvisited");
    }

    /**
     * Tests marking the room as visited and unvisited.
     */
    @Test
    void markVisited() {
        room.markVisited(true); // Mark the room as visited
        assertTrue(room.visited(), "Room should be marked as visited");

        room.markVisited(false); // Mark the room as unvisited
        assertFalse(room.visited(), "Room should be marked as unvisited");
    }

    /**
     * Tests the initial string representation of the room.
     */
    @Test
    void toString_InitialRoomState() {
        String initialRoomString = room.toString(); // Get the initial string representation of the room
        assertNotNull(initialRoomString, "String representation of the room should not be null");
        assertTrue(initialRoomString.contains("PL"), "String representation should contain the player placeholder 'PL'");
        assertTrue(initialRoomString.contains("LK"), "Expected 'LK' (locked door placeholder) in the room's string representation");
    }
}
