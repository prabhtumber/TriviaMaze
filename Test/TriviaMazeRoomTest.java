package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.*;

class TriviaMazeRoomTest {

    private TriviaMazeRoom room;
    private TriviaMazeDoor northDoor, southDoor, eastDoor, westDoor;

    @BeforeEach
    void setUp() {
        northDoor = new TriviaMazeDoor();
        southDoor = new TriviaMazeDoor();
        eastDoor = new TriviaMazeDoor();
        westDoor = new TriviaMazeDoor();
        room = new TriviaMazeRoom(0, 0, northDoor, westDoor, southDoor, eastDoor);
    }

    @Test
    void getDoor_ValidDirections() {
        assertSame(northDoor, room.getDoor("north"));
        assertSame(southDoor, room.getDoor("south"));
        assertSame(eastDoor, room.getDoor("east"));
        assertSame(westDoor, room.getDoor("west"));
    }

    @Test
    void getDoor_InvalidDirection() {
        assertNull(room.getDoor("invalid_direction"));
    }

    @Test
    void visited_InitiallyFalse() {
        assertFalse(room.visited());
    }

    @Test
    void markVisited() {
        room.markVisited(true);
        assertTrue(room.visited());

        room.markVisited(false);
        assertFalse(room.visited());
    }

    @Test
    void toString_InitialRoomState() {
        String initialRoomString = room.toString();
        assertNotNull(initialRoomString);
        assertTrue(initialRoomString.contains("PL")); // Check for player placeholder
        assertTrue(initialRoomString.contains("LK"), "Expected 'LK' in the room's string representation");
    }

}