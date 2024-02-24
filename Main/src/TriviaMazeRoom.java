import questionClasses.*;

public class TriviaMazeRoom extends TriviaMazeDoor {
    private TriviaMazeRoom[] myDoors;
    private Question myQuestion;

    public TriviaMazeRoom(int numberOfDoors) {
        myDoors = new TriviaMazeRoom[numberOfDoors];
        for (int i = 1; i < numberOfDoors; i++) {

        }

    }

    public boolean unlockDoor(int index) {
        if (index >= 0 && index < myDoors.length && !myDoors[index].isMyDoorLocked()) {
            myDoors[index].isMyDoorLocked();
            return true;
        }
        return false;
    }

}
