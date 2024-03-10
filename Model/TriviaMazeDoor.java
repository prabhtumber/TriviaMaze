package Model;

import Model.questionClasses.*;

import java.io.Serializable;

public class TriviaMazeDoor implements Serializable {
    private static final long serialVersionUID = 1335969823606736557L;
    private boolean myDoorLocked;
    private boolean myDoorLockedPermanent;
    private final Question myDoorQuestion;

    public TriviaMazeDoor() {

        myDoorLocked = true;
        myDoorLockedPermanent = false;
        myDoorQuestion = TriviaMazeDatabase.getQuestion();
    }

    public boolean isMyDoorLocked() {
        return myDoorLocked;
    }

    public boolean isMyDoorLockedPermanent() {
        return myDoorLockedPermanent;
    }

    public void isRightAnswer(final String thePlayersAnswer) {
        if (thePlayersAnswer.equals(myDoorQuestion.getCorrectAnswer())) {
            myDoorLocked = false;
        } else {
            myDoorLockedPermanent = true;
        }
    }

    public String getQuestionText() {
        return myDoorQuestion.getQuestionText();
    }

    public String getQuestionAnswer() {
        return myDoorQuestion.getCorrectAnswer();
    }

    public void setTheLockPermanent(final boolean theLockPermanent) {
        myDoorLockedPermanent = theLockPermanent;
    }

    public String getQuestion() {
        return myDoorQuestion.getQuestionText();
    }

}