public class TriviaDisplay {
    private TrivaMaze myMaze;

    public Display(TrivaMaze myMaze) {
        this.myMaze = myMaze;
    }

    public TrivaMaze getMyMaze() {
        return myMaze;
    }

    public void setMyMaze(TrivaMaze myMaze) {
        this.myMaze = myMaze;
    }

    public void displayRoom() {
        // Implement your code to display current room details
        System.out.println("Displaying current room details...");
        System.out.println("Room name: " + myMaze.getCurrentRoom().getName());
        System.out.println("Room description: " + myMaze.getCurrentRoom().getDescription());
        // Add more details if needed
    }

    public void displayMaze() {
        // Implement your code to display the entire maze
        System.out.println("Displaying the entire maze...");
        Room[][] rooms = myMaze.getMazeLayout();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (myMaze.getCurrentRoom() == rooms[i][j]) {
                    System.out.print("[X]"); // Mark the current room with 'X'
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println(); // Move to the next row
        }
    }
}
