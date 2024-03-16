package Model;

import Model.questionClasses.*;

import java.io.Serializable;

/**
 * Represents a door in the trivia maze game, containing logic related to its locked state,
 * the question associated with it, and methods to interact with these elements.
 * Each door has a trivia question from the TriviaMazeDatabase and can be either locked, unlocked, or permanently
 * locked based on player interactions.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
public class TriviaMazeDoor implements Serializable {
    private static final long serialVersionUID = 1335969823606736557L;
    private boolean myDoorLocked; // Indicates if the door is currently locked
    private boolean myDoorLockedPermanent; // Indicates if the door has been permanently locked
    private final Question myDoorQuestion; // The trivia question associated with this door

    /**
     * Constructs a TriviaMazeDoor with a trivia question retrieved from the database.
     * Initially, the door is locked but not permanently.
     */
    public TriviaMazeDoor() {
        myDoorLocked = true;
        myDoorLockedPermanent = false;
        myDoorQuestion = TriviaMazeQuestionFactory.getQuestion();
    }

    /**
     * Checks whether the door is locked.
     * @return true if the door is locked, false otherwise.
     */
    public boolean isMyDoorLocked() {
        return myDoorLocked;
    }

    /**
     * Checks whether the door is permanently locked.
     * @return true if the door is permanently locked, false otherwise.
     */
    public boolean isMyDoorLockedPermanent() {
        return myDoorLockedPermanent;
    }

    /**
     * Determines whether the player's answer is correct and updates the door's locked state accordingly.
     * If the answer is correct, unlocks the door. If the answer is incorrect, locks the door permanently.
     * @param thePlayersAnswer The player's answer to the door's question.
     */
    public void isRightAnswer(final String thePlayersAnswer) {
        if (thePlayersAnswer.equals(myDoorQuestion.getCorrectAnswer())) {
            myDoorLocked = false;
        } else {
            myDoorLockedPermanent = true;
        }
    }

    /**
     * Retrieves the text of the question associated with this door.
     * @return The question text.
     */
    public String getQuestionText() {
        return myDoorQuestion.getQuestionText();
    }

    /**
     * Retrieves the correct answer for the question associated with this door.
     * @return The correct answer.
     */
    public String getQuestionAnswer() {
        return myDoorQuestion.getCorrectAnswer();
    }

    /**
     * Sets the locked state of the door to be permanent.
     * @param theLockPermanent Whether the lock should be made permanent.
     */
    public void setTheLockPermanent(final boolean theLockPermanent) {
        myDoorLockedPermanent = theLockPermanent;
    }

    /**
     * Retrieves the full text of the question associated with this door (same as getQuestionText).
     * @return The question text.
     */
    public String getQuestion() {
        return myDoorQuestion.getQuestionText();
    }
}
