public class TriviaMazeRoom extends TriviaMazeDoor {
    private TriviaMazeRoom[] myDoors;
    private Question_Answer myQuestion;

    public TriviaMazeRoom(int numberOfDoors) {
        myDoors = new TriviaMazeRoom[numberOfDoors];
        for (int i = 1; i < numberOfDoors; i++) {

        }
        myQuestion = new Question_Answer();
    }

    public boolean unlockDoor(int index) {
        if (index >= 0 && index < myDoors.length && !myDoors[index].isMyDoorLocked()) {
            myDoors[index].unlock();
            return true;
        }
        return false;
    }

    public Question getQuestion() {
        return myQuestion.getQuestion();
    }

    public class Question {
    }

    public class Question_Answer {
        public Question getQuestion() {
            return new Question();
        }
    }
}
