import java.io.Serializable;

public class TriviaMaze implements Serializable {
    private static final long serialVersionUID = -5203829590803086033L;

    private int playerPosX;
    private int playerPosY;
    private final TriviaRoom[][] mazeLayout;
    private static final int MAZE_SIZE = 4;
    private TriviaDoor currentDoor;

    public TriviaMaze() {
        playerPosX = 0;
        playerPosY = 0;
        mazeLayout = new TriviaRoom[MAZE_SIZE][MAZE_SIZE];
        initializeMaze();
    }

    public void initializeMaze() {
        for (int x = 0; x < MAZE_SIZE; x++) {
            for (int y = 0; y < MAZE_SIZE; y++) {
                TriviaDoor north = null;
                TriviaDoor west = null;
                TriviaDoor east = new TriviaDoor();
                TriviaDoor south = new TriviaDoor();
                if (x > 0) {
                    north = mazeLayout[x - 1][y].getDoor("south");
                }
                if (y > 0) {
                    west = mazeLayout[x][y - 1].getDoor("east");
                }
                mazeLayout[x][y] = new TriviaRoom(x, y, north, west, south, east);
            }
        }
    }

    public TriviaRoom[][] getMazeLayout() {
        return mazeLayout;
    }

    public int[] getPlayerPosition() {
        int[] position = {playerPosX, playerPosY};
        return position;
    }

    public void setPlayerPosition(int x, int y) {
        playerPosY = y;
        playerPosX = x;
    }

    public boolean isGameCompleted() {
        return playerPosX == MAZE_SIZE - 1 && playerPosY == MAZE_SIZE - 1;
    }

    public void setCurrentDoor(String direction) {
        currentDoor = mazeLayout[playerPosX][playerPosY].getDoor(direction);
    }

    public boolean canMove() {
        return currentDoor != null && !currentDoor.isLockedForever();
    }

    public boolean isDoorLocked() {
        return currentDoor.isLocked();
    }

    public boolean isDoorPermanentlyLocked() {
        return currentDoor.isLockedForever();
    }

    public String getQuestionForDoor() {
        return currentDoor.getQuestion();
    }

    public String getAnswerForDoor() {
        return currentDoor.getAnswer();
    }

    public void evaluatePlayerAnswer(String answer) {
        currentDoor.answer(answer);
    }

    public String getRoomInfo() {
        return mazeLayout[playerPosX][playerPosY].toString();
    }

    public void movePlayer(String direction) {
        switch (direction) {
            case "north" -> playerPosX--;
            case "west" -> playerPosY--;
            case "south" -> playerPosX++;
            case "east" -> playerPosY++;
        }
    }

    public boolean hasPossiblePath() {
        for (TriviaRoom[] roomArray : mazeLayout) {
            for (TriviaRoom room : roomArray) {
                room.markVisited(false);
            }
        }
        return explore(playerPosX, playerPosY);
    }

    private boolean explore(int x, int y) {
        boolean success = false;
        if (isValidMove(x, y)) {
            mazeLayout[x][y].markVisited(true);
            if (isExitReached(x, y)) {
                return true;
            }
            if (canMove(mazeLayout[x][y].getDoor("north"))) {
                success = explore(x - 1, y);
            }
            if (!success && canMove(mazeLayout[x][y].getDoor("west"))) {
                success = explore(x, y - 1);
            }
            if (!success && canMove(mazeLayout[x][y].getDoor("south"))) {
                success = explore(x + 1, y);
            }
            if (!success && canMove(mazeLayout[x][y].getDoor("east"))) {
                success = explore(x, y + 1);
            }
        }
        return success;
    }

    private boolean isExitReached(int x, int y) {
        return x == mazeLayout.length - 1 && y == mazeLayout[x].length - 1;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < MAZE_SIZE && col >= 0 && col < MAZE_SIZE && !(mazeLayout[row][col].visited());
    }

    @Override
    public String toString() {
        StringBuilder mazeString = new StringBuilder();
        for (int i = 0; i < MAZE_SIZE; i++) {
            mazeString.append("\n\t\t");
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (i == 0 && j == 0 && !(playerPosX == i && playerPosY == j)) {
                    mazeString.append("|ST|");
                } else if (playerPosX == i && playerPosY == j) {
                    mazeString.append("|PL|");
                } else if (i == MAZE_SIZE - 1 && j == MAZE_SIZE - 1) {
                    mazeString.append("|ED|");
                } else {
                    mazeString.append("|RM|");
                }
            }
        }
        mazeString.append('\n');
        return mazeString.toString();
    }
}
