public class Room {
    private Door[] myDoors;

    public Room() {
        // Constructor
    }

    public Room(Door[] myDoors) {
        this.myDoors = myDoors;
    }

    public Door[] getMyDoors() {
        return myDoors;
    }

    public void setMyDoors(Door[] myDoors) {
        this.myDoors = myDoors;
    }

    public boolean unlockDoor(int index) {
        // Implement your code to unlock the door at the specified index
        if (index >= 0 && index < myDoors.length) {
            myDoors[index].setLocked(false);
            return true;
        } else {
            return false; // Index out of bounds
        }
    }
}
