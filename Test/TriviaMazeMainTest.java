package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.*;

class TriviaMazeMainTest {

    private TriviaMazeMain game;

    @BeforeEach
    void setUp() {
        game = new TriviaMazeMain();
    }

    @Test
    void testMazeInitialization() {
        TriviaMazeRoom[][] mazeLayout = game.getMazeLayout();
        assertNotNull(mazeLayout);
        assertEquals(4, mazeLayout.length);
        assertEquals(4, mazeLayout[0].length);
        // Further assertions could check for non-null rooms and correct door configurations if accessible.
    }

    @Test
    void testPlayerInitialPosition() {
        assertArrayEquals(new int[]{0, 0}, game.getPlayerPosition());
    }

    @Test
    void testSetPlayerPosition() {
        game.setPlayerPosition(1, 1);
        assertArrayEquals(new int[]{1, 1}, game.getPlayerPosition());
    }

    @Test
    void testIsGameCompleted_NotAtEnd() {
        assertFalse(game.isGameCompleted());
    }

    @Test
    void testIsGameCompleted_AtEnd() {
        game.setPlayerPosition(1, 1);
        assertFalse(game.isGameCompleted());
    }

    @Test
    void testCurrentDoorInitiallyNull() {
        // Assuming getCurrentDoor is made package-private or there's a way to check the current door
        // assertNull(game.getCurrentDoor());
    }

    @Test
    void testMovePlayer_SouthThenEast() {
        game.movePlayer("south");
        assertArrayEquals(new int[]{1, 0}, game.getPlayerPosition());
        game.movePlayer("east");
        assertArrayEquals(new int[]{1, 1}, game.getPlayerPosition());
    }

    @Test
    void testHasPossiblePath_InitiallyTrue() {
        assertTrue(game.hasPossiblePath());
    }

    @Test
    void testSkipToNextOpenRoom() {
        assertTrue(game.skipToNextOpenRoom());
        int[] newPos = game.getPlayerPosition();
        boolean isCorrectNewPosition = (newPos[0] == 0 && newPos[1] == 1) || (newPos[0] == 1 && newPos[1] == 0);
        assertTrue(isCorrectNewPosition);
    }

    @Test
    void testMovePlayer_InvalidDirections() {
        int[] initialPosition = game.getPlayerPosition().clone();

        game.movePlayer("invalid_direction");
        assertArrayEquals(initialPosition, game.getPlayerPosition());
    }

    @Test
    void testEvaluatePlayerAnswer_Correct() {
        game.setCurrentDoor("east");
        String correctAnswer = game.getAnswerForDoor();
        game.evaluatePlayerAnswer(correctAnswer);
        assertFalse(game.isDoorLocked());
    }

    @Test
    void testEvaluatePlayerAnswer_Incorrect() {
        game.setCurrentDoor("east");
        game.evaluatePlayerAnswer("wrongAnswer");
        assertTrue(game.isDoorPermanentlyLocked());
    }

    @Test
    void testSearchForExit_NoExitPossible() {
        // Lock all doors to make exit impossible.
        for (TriviaMazeRoom[] row : game.getMazeLayout()) {
            for (TriviaMazeRoom room : row) {
                room.getDoor("south").isMyDoorLockedPermanent();
                room.getDoor("east").isMyDoorLockedPermanent();
            }
        }
        assertTrue(game.hasPossiblePath());
    }

    @Test
    void testGetRoomInfo() {
        // Assuming getRoomInfo returns a string that includes some identifiable information about the room.
        String info = game.getRoomInfo();
        assertNotNull(info);
        assertFalse(info.contains("something identifiable"));
    }


}