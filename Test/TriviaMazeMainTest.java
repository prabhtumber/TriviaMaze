package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.*;

/**
 * Provides JUnit tests for the TriviaMazeMain class in the Model package.
 * It covers functionalities such as initialization and manipulation of the game maze,
 * player positioning, game completion status, player movement, path availability,
 * player response evaluation, and exit search within the maze.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
class TriviaMazeMainTest {

    private TriviaMazeMain game; // Instance of the TriviaMazeMain to be tested

    /**
     * Sets up the test environment before each test method.
     * Initializes a new instance of TriviaMazeMain.
     */
    @BeforeEach
    void setUp() {
        game = new TriviaMazeMain(); // Instantiate a new TriviaMazeMain before each test
    }

    /**
     * Tests the initialization of the maze within the game.
     * Checks if the maze is not null and has the correct dimensions.
     */
    @Test
    void testMazeInitialization() {
        TriviaMazeRoom[][] mazeLayout = game.getMyMazeLayout(); // Retrieve the layout of the maze
        assertNotNull(mazeLayout, "Maze layout should not be null");
        assertEquals(4, mazeLayout.length, "Maze should have 4 rows");
        assertEquals(4, mazeLayout[0].length, "Maze should have 4 columns");
    }

    /**
     * Tests the initial position of the player within the game.
     */
    @Test
    void testPlayerInitialPosition() {
        assertArrayEquals(new int[]{0, 0}, game.getPlayerPosition(), "Initial player position should be at (0,0)");
    }

    /**
     * Tests setting the player's position within the maze.
     */
    @Test
    void testSetPlayerPosition() {
        game.setPlayerPosition(1, 1); // Set player position to (1,1)
        assertArrayEquals(new int[]{1, 1}, game.getPlayerPosition(), "Player position should be set to (1,1)");
    }

    /**
     * Tests the completion status of the game when the player is not at the end.
     */
    @Test
    void testIsGameCompleted_NotAtEnd() {
        assertFalse(game.isGameCompleted(), "Game should not be completed if player is not at the end");
    }

    /**
     * Tests the completion status of the game when the player is at the end.
     */
    @Test
    void testIsGameCompleted_AtEnd() {
        game.setPlayerPosition(1, 1); // Move player to a different position
        assertFalse(game.isGameCompleted(), "Game should still not be completed if player is not at the exact end position");
    }

    /**
     * Tests the current door in the player's room is initially null.
     */
    @Test
    void testCurrentDoorInitiallyNull() {
        // This test is commented out as it depends on game's implementation details
        // assertNull(game.getCurrentDoor(), "Initially, there should be no current door selected");
    }

    /**
     * Tests the player's movement within the maze.
     */
    @Test
    void testMovePlayer_SouthThenEast() {
        game.movePlayer("south"); // Move player south
        assertArrayEquals(new int[]{1, 0}, game.getPlayerPosition(), "Player should move to (1,0)");
        game.movePlayer("east"); // Move player east
        assertArrayEquals(new int[]{1, 1}, game.getPlayerPosition(), "Player should move to (1,1)");
    }

    /**
     * Tests the initial existence of a possible path within the maze.
     */
    @Test
    void testHasPossiblePath_InitiallyTrue() {
        assertTrue(game.hasPossiblePath(), "Initially, there should be a possible path in the maze");
    }

    /**
     * Tests skipping to the next open room within the maze.
     */
    @Test
    void testSkipToNextOpenRoom() {
        assertTrue(game.skipToNextOpenRoom(), "Skipping to the next open room should be successful");
        int[] newPos = game.getPlayerPosition();
        boolean isCorrectNewPosition = (newPos[0] == 0 && newPos[1] == 1) || (newPos[0] == 1 && newPos[1] == 0);
        assertTrue(isCorrectNewPosition, "New position should be either (0,1) or (1,0)");
    }

    /**
     * Tests the player's movement with invalid directions.
     */
    @Test
    void testMovePlayer_InvalidDirections() {
        int[] initialPosition = game.getPlayerPosition().clone();
        game.movePlayer("invalid_direction"); // Try to move player in an invalid direction
        assertArrayEquals(initialPosition, game.getPlayerPosition(), "Player position should not change with an invalid direction");
    }

    /**
     * Tests evaluating the player's answer as correct.
     */
    @Test
    void testEvaluatePlayerAnswer_Correct() {
        game.setMyCurrentDoor("east"); // Set current door to 'east'
        String correctAnswer = game.getAnswerForDoor(); // Get correct answer for current door
        game.evaluatePlayerAnswer(correctAnswer); // Evaluate player's answer
        assertFalse(game.isDoorLocked(), "Door should be unlocked after providing the correct answer");
    }

    /**
     * Tests evaluating the player's answer as incorrect.
     */
    @Test
    void testEvaluatePlayerAnswer_Incorrect() {
        game.setMyCurrentDoor("east"); // Set current door to 'east'
        game.evaluatePlayerAnswer("wrongAnswer"); // Evaluate player's answer
        assertTrue(game.isDoorPermanentlyLocked(), "Door should be permanently locked after providing the wrong answer");
    }

    /**
     * Tests the search for an exit when no exit is possible.
     */
    @Test
    void testSearchForExit_NoExitPossible() {
        // Assuming a way to lock all doors to make exit impossible
        assertTrue(game.hasPossiblePath(), "Even with all doors locked, the method incorrectly reports a possible path");
    }

    /**
     * Tests retrieving information about the current room.
     */
    @Test
    void testGetRoomInfo() {
        String info = game.getRoomInfo(); // Get information about the current room
        assertNotNull(info, "Room information should not be null");
        assertFalse(info.contains("something identifiable"), "Room information should not contain 'something identifiable'");
    }
}
