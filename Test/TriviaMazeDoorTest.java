package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.*;

/**
 * Provides JUnit tests for the TriviaMazeDoor class in the Model package.
 * It tests various functionalities of the TriviaMazeDoor such as
 * locking and unlocking mechanism, retrieving the question and its answer,
 * and checking the initial state of the door.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
class TriviaMazeDoorTest {

    private TriviaMazeDoor door; // Instance of the TriviaMazeDoor to be tested

    /**
     * Sets up the test environment before each test method.
     * Initializes a new instance of TriviaMazeDoor.
     */
    @BeforeEach
    void setUp() {
        door = new TriviaMazeDoor(); // Instantiate a new TriviaMazeDoor before each test
    }

    /**
     * Tests the initial state of the door to ensure it is locked and not permanently locked.
     */
    @Test
    void testInitialLockState() {
        assertTrue(door.isMyDoorLocked(), "Door should be initially locked");
        assertFalse(door.isMyDoorLockedPermanent(), "Door should not be permanently locked initially");
    }

    /**
     * Tests the functionality of unlocking the door by providing the correct answer.
     */
    @Test
    void testUnlockDoor() {
        String correctAnswer = door.getQuestionAnswer(); // Retrieve the correct answer
        door.isRightAnswer(correctAnswer); // Attempt to unlock the door with the correct answer
        assertFalse(door.isMyDoorLocked(), "Door should be unlocked after providing the correct answer");
    }

    /**
     * Tests locking the door permanently by providing a wrong answer.
     */
    @Test
    void testLockDoorPermanentlyWithWrongAnswer() {
        door.isRightAnswer("wrong answer"); // Attempt to unlock the door with a wrong answer
        assertTrue(door.isMyDoorLockedPermanent(), "Door should be permanently locked after providing the wrong answer");
    }

    /**
     * Tests the functionality of setting the door's lock to permanent.
     */
    @Test
    void testSetLockPermanent() {
        door.setTheLockPermanent(true); // Set the door's lock to permanent
        assertTrue(door.isMyDoorLockedPermanent(), "Door should be permanently locked after setting it to permanent");
    }

    /**
     * Tests if the method getQuestionText returns a non-null question text.
     */
    @Test
    void testGetQuestionText() {
        assertNotNull(door.getQuestionText(), "Question text should not be null");
    }

    /**
     * Tests if the method getQuestionAnswer returns a non-null answer.
     */
    @Test
    void testGetQuestionAnswer() {
        assertNotNull(door.getQuestionAnswer(), "Question answer should not be null");
    }

    /**
     * Tests if the method getQuestion returns the same text as getQuestionText.
     */
    @Test
    void testGetQuestion() {
        assertEquals(door.getQuestionText(), door.getQuestion(), "getQuestion should return the same text as getQuestionText");
    }
}
