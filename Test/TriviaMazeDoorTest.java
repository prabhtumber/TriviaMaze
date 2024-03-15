package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.*;

class TriviaMazeDoorTest {

    private TriviaMazeDoor door;

    @BeforeEach
    void setUp() {
        door = new TriviaMazeDoor();
    }

    @Test
    void testInitialLockState() {
        assertTrue(door.isMyDoorLocked());
        assertFalse(door.isMyDoorLockedPermanent());
    }

    @Test
    void testUnlockDoor() {
        String correctAnswer = door.getQuestionAnswer();
        door.isRightAnswer(correctAnswer);
        assertFalse(door.isMyDoorLocked());
    }

    @Test
    void testLockDoorPermanentlyWithWrongAnswer() {
        door.isRightAnswer("wrong answer");
        assertTrue(door.isMyDoorLockedPermanent());
    }

    @Test
    void testSetLockPermanent() {
        door.setTheLockPermanent(true);
        assertTrue(door.isMyDoorLockedPermanent());
    }

    @Test
    void testGetQuestionText() {
        assertNotNull(door.getQuestionText());
    }

    @Test
    void testGetQuestionAnswer() {
        assertNotNull(door.getQuestionAnswer());
    }

    @Test
    void testGetQuestion() {
        assertEquals(door.getQuestionText(), door.getQuestion());
    }
}