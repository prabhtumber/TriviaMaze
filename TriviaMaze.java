public class TriviaMaze {
    private Room[][] myRooms;

    public TriviaMaze() {
        // Constructor
    }

    public TriviaMaze(Room[][] myRooms) {
        this.myRooms = myRooms;
    }

    public Room[][] getMyRooms() {
        return myRooms;
    }

    public void setMyRooms(Room[][] myRooms) {
        this.myRooms = myRooms;
    }

    public void generateMaze() {
        // Implement your code to generate the maze
    }

    public boolean isGameWon() {
        // Implement your code to check if the game is won
        return false; // Placeholder, change this according to your logic
    }

    public Room getRoomAt(int x, int y) {
        // Implement your code to get the room at coordinates (x, y)
        return null; // Placeholder, change this according to your logic
    }

    @Override
    public String toString() {
        // Implement your code to represent the TriviaMaze as a string
        return "TriviaMaze{" +
                "myRooms=" + Arrays.toString(myRooms) +
                '}';
    }
}
