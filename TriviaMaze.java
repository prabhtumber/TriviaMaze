import java.util.Random;
public class TriviaMaze {
    private int playerXCoordinate;
    private int playerYCoordinate;
    private static final int MAZE_SIZE = 4;
    private final Cell[][] mazeCells;
    public TriviaMaze() {
        playerXCoordinate = 0;
        playerYCoordinate = 0;
        mazeCells = new Cell[MAZE_SIZE][MAZE_SIZE];
        generateMaze();
    }
    public void generateMaze() {
        Random random = new Random();
        for (int x = 0; x < MAZE_SIZE; x++) {
            for (int y = 0; y < MAZE_SIZE; y++) {
                boolean hasNorthDoor = y > 0;
                boolean hasWestDoor = x > 0;
                boolean hasEastDoor = x < MAZE_SIZE - 1;
                boolean hasSouthDoor = y < MAZE_SIZE - 1;
                mazeCells[x][y] = new Cell(hasNorthDoor, hasWestDoor, hasEastDoor, hasSouthDoor);
            }
        }
    }
    public void movePlayer(final String direction) {
        switch (direction) {
            case "north" -> {
                if (playerYCoordinate > 0) {
                    playerYCoordinate--;
                }
            }
            case "west" -> {
                if (playerXCoordinate > 0) {
                    playerXCoordinate--;
                }
            }
            case "south" -> {
                if (playerYCoordinate < MAZE_SIZE - 1) {
                    playerYCoordinate++;
                }
            }
            case "east" -> {
                if (playerXCoordinate < MAZE_SIZE - 1) {
                    playerXCoordinate++;
                }
            }
        }
    }
    public boolean isGameWon() {
        return playerXCoordinate == MAZE_SIZE - 1 && playerYCoordinate == MAZE_SIZE - 1;
    }
    @Override
    public String toString() {
        StringBuilder mazeRepresentation = new StringBuilder();
        for (int i = 0; i < MAZE_SIZE; i++) {
            mazeRepresentation.append("\n\t\t");
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (i == 0 && j == 0 && !(playerXCoordinate == i && playerYCoordinate == j)) {
                    mazeRepresentation.append("|ST|");
                } else if (playerXCoordinate == i && playerYCoordinate == j) {
                    mazeRepresentation.append("|PL|");
                } else if (i == MAZE_SIZE - 1 && j == MAZE_SIZE - 1) {
                    mazeRepresentation.append("|ED|");
                } else {
                    mazeRepresentation.append("|RM|");
                }
            }
        }
        mazeRepresentation.append('\n');
        return mazeRepresentation.toString();
    }
    private static class Cell implements Serializable {
        private static final long serialVersionUID = 1L;
        private final boolean hasNorthDoor;
        private final boolean hasWestDoor;
        private final boolean hasEastDoor;
        private final boolean hasSouthDoor;
        public Cell(boolean hasNorthDoor, boolean hasWestDoor, boolean hasEastDoor, boolean hasSouthDoor) {
            this.hasNorthDoor = hasNorthDoor;
            this.hasWestDoor = hasWestDoor;
            this.hasEastDoor = hasEastDoor;
            this.hasSouthDoor = hasSouthDoor;
        }
    }
}