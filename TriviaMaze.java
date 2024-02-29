import java.util.Random;

/**
 * Represents a trivia maze game.
 */
public class TriviaMaze {
    /** The x-coordinate of the player's position. */
    private int playerXCoordinate;
    /** The y-coordinate of the player's position. */
    private int playerYCoordinate;
    /** The size of the maze. */
    private static final int MAZE_SIZE = 4;
    /** The cells composing the maze. */
    private final Cell[][] mazeCells;

    /**
     * Constructs a new TriviaMaze object.
     */
    public TriviaMaze() {
        playerXCoordinate = 0;
        playerYCoordinate = 0;
        mazeCells = new Cell[MAZE_SIZE][MAZE_SIZE];
        generateMaze();
    }

    /**
     * Generates the maze cells.
     */
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

    /**
     * Moves the player in the specified direction.
     * @param direction The direction in which the player wants to move.
     */
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

    /**
     * Checks if the game is won.
     * @return true if the game is won, otherwise false.
     */
    public boolean isGameWon() {
        return playerXCoordinate == MAZE_SIZE - 1 && playerYCoordinate == MAZE_SIZE - 1;
    }

    /**
     * Generates a string representation of the maze.
     * @return The string representation of the maze.
     */
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

    /**
     * Represents a cell in the maze.
     */
    private static class Cell {
        /** Whether the cell has a north door. */
        private final boolean hasNorthDoor;
        /** Whether the cell has a west door. */
        private final boolean hasWestDoor;
        /** Whether the cell has an east door. */
        private final boolean hasEastDoor;
        /** Whether the cell has a south door. */
        private final boolean hasSouthDoor;

        /**
         * Constructs a new Cell object.
         * @param hasNorthDoor Whether the cell has a north door.
         * @param hasWestDoor Whether the cell has a west door.
         * @param hasEastDoor Whether the cell has an east door.
         * @param hasSouthDoor Whether the cell has a south door.
         */
        public Cell(boolean hasNorthDoor, boolean hasWestDoor, boolean hasEastDoor, boolean hasSouthDoor) {
            this.hasNorthDoor = hasNorthDoor;
            this.hasWestDoor = hasWestDoor;
            this.hasEastDoor = hasEastDoor;
            this.hasSouthDoor = hasSouthDoor;
        }
    }
}
