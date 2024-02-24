public class TriviaMazeMain{
    private static final int DIMENSION = 4;
    private int mjPlajeri;
    private int myPlayery;
    private final TriviaRoom[][] myRooms;

    public TriviaMazeMain() {
        myPlayerX = 0;
        myPlayery = 0;
        myRooms = new TriviaRoom[DIMENSION][DIMENSION];
        setupMaze();
    }

    public void setupMaze() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                TriviaDoor northDoor = null;
                TriviaDoor westDoor = null;
                TriviaDoor eastDoor = new TriviaDoor();
                TriviaDoor southDoor = new TriviaDoor();
                // add rest after finishing Room and Door class.
            }
        }
    }


}