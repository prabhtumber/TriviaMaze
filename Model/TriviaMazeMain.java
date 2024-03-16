package Model;

import java.io.Serializable;

/**
 * The TriviaMazeMain class represents the main game logic for a trivia maze game.
 * It handles player movements, room and door management, and game state.
 * The maze is represented as a 2D array of TriviaMazeRoom objects,
 * and the player navigates through by answering trivia questions associated with the doors.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
public class TriviaMazeMain implements Serializable {
    private static final long serialVersionUID = 7609898967214411735L;
    private int myPlayerPosX;
    private int myPlayerPosY;
    private final TriviaMazeRoom[][] myMazeLayout;
    private static final int MAZE_SIZE =4;
    private TriviaMazeDoor myCurrentDoor;

    /**
     * Constructs a new TriviaMazeMain instance.
     * Initializes the starting position of the player and the layout of the maze.
     */
    public TriviaMazeMain() {
        myPlayerPosX = myPlayerPosY = 0;
        myMazeLayout = new TriviaMazeRoom[MAZE_SIZE][MAZE_SIZE];
        maze_Initialization();
    }

    /**
     * Configures the maze's initial state, setting up rooms and linking them with doors.
     * Each room is instantiated with doors leading to adjacent rooms, with some doors shared between rooms
     * to maintain maze consistency.
     */
    public void maze_Initialization() {
        for (int rowIndex = 0; rowIndex < MAZE_SIZE; rowIndex++) {
            for (int columnIndex = 0; columnIndex < MAZE_SIZE; columnIndex++) {
                // Establish connections to adjacent rooms if applicable
                TriviaMazeDoor doorToNorth = rowIndex > 0 ? myMazeLayout[rowIndex - 1][columnIndex].getDoor("south") : null;
                TriviaMazeDoor doorToWest = columnIndex > 0 ? myMazeLayout[rowIndex][columnIndex - 1].getDoor("east") : null;
                // Doors to the south and east are always new as this initializes row by row, column by column
                TriviaMazeDoor doorToSouth = new TriviaMazeDoor();
                TriviaMazeDoor doorToEast = new TriviaMazeDoor();
                // Set the current room with its respective doors
                myMazeLayout[rowIndex][columnIndex] = new TriviaMazeRoom(rowIndex, columnIndex, doorToNorth, doorToWest, doorToSouth, doorToEast);
            }
        }
    }

    /**
     * Returns the layout of the maze as a 2D array of TriviaMazeRoom objects.
     *
     * @return The current maze layout.
     */
    public TriviaMazeRoom[][] getMyMazeLayout() {
        return myMazeLayout;
    }

    /**
     * Returns the current position of the player in the maze as an array [x, y].
     *
     * @return An array containing the player's current x and y coordinates in the maze.
     */
    public int[] getPlayerPosition() {
        int[] position = {myPlayerPosX, myPlayerPosY};
        return position;
    }

    /**
     * Sets the player's position in the maze to the specified coordinates.
     *
     * @param theX The new theX-coordinate of the player.
     * @param theY The new theY-coordinate of the player.
     */
    public void setPlayerPosition(int theX, int theY) {
        myPlayerPosY = theY;
        myPlayerPosX = theX;
    }

    /**
     * Checks if the player has reached the end of the maze.
     *
     * @return true if the player has reached the bottom-right corner of the maze; false otherwise.
     */
    public boolean isGameCompleted() {
        return myPlayerPosX == MAZE_SIZE - 1 && myPlayerPosY == MAZE_SIZE - 1;
    }

    /**
     * Sets the current door based on the theDirection the player intends to move.
     *
     * @param theDirection The theDirection of the door to set as the current door ('north', 'south', 'east', 'west').
     */
    public void setMyCurrentDoor(String theDirection) {
        myCurrentDoor = myMazeLayout[myPlayerPosX][myPlayerPosY].getDoor(theDirection);
    }


    /**
     * Checks if the specified door can be moved through (i.e., it exists and is not permanently locked).
     *
     * @param theDoor The door to check.
     * @return true if the door can be moved through; false otherwise.
     */
    private boolean canMove(final TriviaMazeDoor theDoor) {
        return theDoor != null && !theDoor.isMyDoorLockedPermanent();
    }

    /**
     * Checks if the current door can be moved through.
     *
     * @return true if the current door can be moved through; false otherwise.
     */
    public boolean canMove() {
        return myCurrentDoor != null && !myCurrentDoor.isMyDoorLockedPermanent();
    }

    /**
     * Checks if the current door is locked.
     *
     * @return true if the current door is locked; false otherwise.
     */
    public boolean isDoorLocked() {
        return myCurrentDoor.isMyDoorLocked();
    }

    /**
     * Checks if the current door is permanently locked.
     *
     * @return true if the current door is permanently locked; false otherwise.
     */
    public boolean isDoorPermanentlyLocked() {
        return myCurrentDoor.isMyDoorLockedPermanent();
    }

    /**
     * Gets the question associated with the current door.
     *
     * @return The question of the current door.
     */
    public String getQuestionForDoor() {
        return myCurrentDoor.getQuestion();
    }

    /**
     * Gets the answer for the question associated with the current door.
     *
     * @return The answer to the current door's question.
     */
    public String getAnswerForDoor() {
        return myCurrentDoor.getQuestionAnswer();
    }

    /**
     * Evaluates the player's answer to the current door's question.
     *
     * @param answer The player's answer to the question.
     */
    public void evaluatePlayerAnswer(String answer) {
        myCurrentDoor.isRightAnswer(answer);
    }

    /**
     * Retrieves information about the current room the player is in.
     *
     * @return A string representation of the current room.
     */
    public String getRoomInfo() {
        return myMazeLayout[myPlayerPosX][myPlayerPosY].toString();
    }

    /**
     * Moves the player in the specified direction, if possible.
     *
     * @param direction The direction to move the player ('north', 'south', 'east', 'west').
     */
    public void movePlayer(String direction) {
        switch (direction) {
            case "north" -> myPlayerPosX--;
            case "west" -> myPlayerPosY--;
            case "south" -> myPlayerPosX++;
            case "east" -> myPlayerPosY++;
        }
    }

    /**
     * Determines if there is a possible path from the player's current position to the exit.
     *
     * @return true if a path exists; false otherwise.
     */
    public boolean hasPossiblePath() {
        for (TriviaMazeRoom[] roomArray : myMazeLayout) {
            for (TriviaMazeRoom room : roomArray) {
                room.markVisited(false);
            }
        }
        return searchForExit(myPlayerPosX, myPlayerPosY);
    }

    /**
     * Recursively searches the maze from the specified location to find a path to the exit.
     * Marks each visited room to prevent circular paths and checks all possible directions.
     *
     * @param currentX The current horizontal coordinate in the maze.
     * @param currentY The current vertical coordinate in the maze.
     * @return True if a path to the exit is found from the current location, otherwise false.
     */
    private boolean searchForExit(int currentX, int currentY) {
        boolean pathFound = false;
        if (isValidMove(currentX, currentY)) {
            myMazeLayout[currentX][currentY].markVisited(true);
            if (isExitReached(currentX, currentY)) {
                return true;
            }
            if (canMove(myMazeLayout[currentX][currentY].getDoor("north"))) {
                pathFound = searchForExit(currentX - 1, currentY);
            }
            if (!pathFound && canMove(myMazeLayout[currentX][currentY].getDoor("west"))) {
                pathFound = searchForExit(currentX, currentY - 1);
            }
            if (!pathFound && canMove(myMazeLayout[currentX][currentY].getDoor("south"))) {
                pathFound = searchForExit(currentX + 1, currentY);
            }
            if (!pathFound && canMove(myMazeLayout[currentX][currentY].getDoor("east"))) {
                pathFound = searchForExit(currentX, currentY + 1);
            }
        }
        return pathFound;
    }

    /**
     * Checks if the specified coordinates reach the exit of the maze.
     *
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return true if the coordinates reach the exit; false otherwise.
     */
    private boolean isExitReached(int x, int y) {
        return x == myMazeLayout.length - 1 && y == myMazeLayout[x].length - 1;
    }

    /**
     * Checks if moving to the specified coordinates is a valid move within the maze.
     *
     * @param row The row to move to.
     * @param col The column to move to.
     * @return true if the move is valid; false otherwise.
     */
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < MAZE_SIZE && col >= 0 && col < MAZE_SIZE && !(myMazeLayout[row][col].visited());
    }

    /**
     * Returns a string representation of the maze, indicating the player's position, start, and end locations.
     *
     * @return A string representing the maze.
     */
    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        for (int row = 0; row < MAZE_SIZE; row++) {
            display.append("\n\t\t");
            for (int col = 0; col < MAZE_SIZE; col++) {
                if (row == 0 && col == 0 && !(myPlayerPosX == row && myPlayerPosY == col)) {
                    display.append("|ST|");
                } else if (myPlayerPosX == row && myPlayerPosY == col) {
                    display.append("| PL |");
                } else if (row == MAZE_SIZE - 1 && col == MAZE_SIZE - 1) {
                    display.append("| ED |");
                } else {
                    display.append("|Room|");
                }
            }
        }
        display.append('\n');
        return display.toString();
    }

    public boolean skipToNextOpenRoom() {
        // Directions in the order: North, West, South, East
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        String[] directionNames = {"north", "west", "south", "east"};

        for (int i = 0; i < directions.length; i++) {
            int newX = myPlayerPosX + directions[i][0];
            int newY = myPlayerPosY + directions[i][1];

            // Check if the new position is within the maze and the room has not been visited
            if (isValidMove(newX, newY) && !myMazeLayout[newX][newY].visited()) {
                // Move player to the first unvisited adjacent room
                setPlayerPosition(newX, newY);
                return true; // Successfully skipped
            }
        }
        return false; // No adjacent unvisited rooms available
    }

}
