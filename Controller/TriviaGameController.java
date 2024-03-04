import java.io.*;
import java.util.Scanner;
import TriviaMaze;
import View.TriviaMazeDisplay;

/**
 * Controller class for managing the game flow.
 */
public class GameController {

    /** The main game instance. */
    private static Game game;


    /** The name of the file used for saving and loading the game state. */
    private static final String SAVE_FILE_NAME = "GameSaveFile.txt";
    /** Scanner object for user input. */
    private static final Scanner scanner = new Scanner(System.in);
    /** Display object for showing information to the user. */
    private static final Display display;
    /** The game state. */
    private static TriviaMaze triviaMaze;

    /**
     * Main method to start the game.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }

    /**
     * Constructs a GameController object and initializes the game.
     */
    public GameController() {

        game = new Game();
    }

    /**
     * Starts the game.
     */
    public void start() {
        game.initialize();
        game.run();
    }
}
    /**
     * Initializes the game.
     */
    public void initialize() {
        triviaMaze = new TriviaMaze();
        display.displayTitle();
        display.startIntroduction();
    }

    /**
     * Runs the main game loop.
     */
    public void run() {
        display.displayGameType();
        startGame();
        boolean isActive = true;
         still have to finish this
    }

    /**
     * Handles the startup phase of the game.
     */
    private void startGame() {
        boolean success = false;
        String userInput;
        while (!success) {
            userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("new")) {
                success = true;
                display.displayInstructions();
            } else if (userInput.equalsIgnoreCase("load")) {
                if (loadSavedGame()) {
                    success = true;
                } else {
                    display.displayInvalidInput();
                }
            }
        }
    }

    /**
     * Loads a saved game from file.
     * @return true if loading is successful, false otherwise.
     */
    private boolean loadSavedGame() {
        boolean success = false;
        try {
            FileInputStream fileInputStream = new FileInputStream(SAVE_FILE_NAME);
            if (new File(SAVE_FILE_NAME).length() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                triviaMaze = (TriviaMaze) objectInputStream.readObject();
                display.displayFileLoadSuccess();
                success = true;
            } else {
                display.displayFileLoadFailed();
            }
        } catch (IOException e) {
            System.out.println("No saved file exists.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return success;
    }

    /**
     * Plays the trivia game.
     */
    private void playTriviaGame() {
      // still have to finish this
        handlePlayerInput();
    }

    /**
     * Handles player input during the game.
     */
    private void handlePlayerInput() {
        display.displayDirectionPrompt();
        boolean isValidInput = false;
        String playerInput;
        while (!isValidInput) {
            playerInput = scanner.nextLine();
            if (playerInput.toLowerCase().matches("north|west|south|east")) {
                if (movePlayer(playerInput)) {
                    isValidInput = true;
                }
            } else if (playerInput.toLowerCase().matches("menu")) {
                displayGameMenu();
                isValidInput = true;
            } else if (playerInput.toLowerCase().matches("help")) {
                displayHelpMenu();
                isValidInput = true;
            } else {
                display.displayInvalidInput();
            }
        }
    }
private static void playTriviaGame() {
    displayMaze();
    displayRoom();
    handlePlayersNextMove();
}

private static void displayMaze() {
    myDisplay.showMazeMap(myMaze.toString());
}

private static void displayRoom() {
    myDisplay.showRoomInfo(myMaze.getRoomDisplay());
}
private static boolean loadGame() {
    boolean success = false;

    try {
        FileInputStream fileInputStream = new FileInputStream(GAME_FILE_PATH);

        if (fileInputStream.available() > 0) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            myMaze = (TriviaMaze) objectInputStream.readObject();
            myDisplay.showFileLoadSuccess();
            success = true;
        } else {
            myDisplay.showFileLoadFailure();
        }
    } catch (IOException e) {
        System.out.println("Error: No save file found.");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

    return success;
}

/**
     * Saves the current game state to a file.
     */
    private void saveGame() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(SAVE_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(triviaMaze);
            objectOutputStream.close();
            fileOutputStream.close();
            display.displayFileSaveSuccess();
        } catch (IOException e) {
            display.displayFileSaveFailed();
        }
    }

private static void handlePlayersNextMove() {
    myDisplay.showDirectionPrompt();
    boolean validInput = false;
    String playersMove;

    while (!validInput) {
        playersMove = myIn.nextLine().toLowerCase();

        if (playersMove.matches("north|west|south|east")) {
            if (attemptPlayerMovement(playersMove)) {
                validInput = true;
            }
        } else if (playersMove.equals("menu")) {
            handleGameMenu();
            validInput = true;
        } else if (playersMove.equals("help")) {
            handleGameHelpMenu();
            validInput = true;
        } else {
            myDisplay.showInvalidInputMessage();
        }
    }
}

private static boolean attemptPlayerMovement(String direction) {
    return movePlayer(direction);
}


private static void handleGameMenu() {
    boolean validInput = false;
    myDisplay.showFileMenu();

    while (!validInput) {
        String userInput = myIn.nextLine().toLowerCase();

        if (userInput.equals("save")) {
            saveGame();
            validInput = true;
        } else if (userInput.equals("load")) {
            loadGame();
            validInput = true;
        } else if (userInput.equals("exit")) {
            closeInputScanner();
            exitGame();
        } else {
            myDisplay.showInvalidInputMessage();
        }
    }
}

private static void closeInputScanner() {
    myIn.close();
}

private static void exitGame() {
    System.exit(0);
}

private static void displayGameHelpMenu() {
    boolean validInput = false;
    myDisplay.showHelpMenu();

    while (!validInput) {
        String userInput = myIn.nextLine().toLowerCase();

        if (userInput.equals("instr")) {
            myDisplay.showInstructions();
            validInput = true;
        } else if (userInput.equals("about")) {
            myDisplay.showGameInfo();
            validInput = true;
        } else {
            myDisplay.showInvalidInputMessage();
        }
    }
}


private static boolean movePlayer(final String direction) {
    boolean success = false;

    // Attempt to move the player in the specified direction
    myMaze.setCurrentDoor(direction);

    // Check if the movement is valid
    if (myMaze.canMove()) {
        success = true;

        // If the door is locked, prompt the player with a question
        if (myMaze.isDoorLocked()) {
            myDisplay.displayQuestion(myMaze.getDoorQuestion());
            String playerAnswer = myIn.nextLine();

            // Check if the player's answer unlocks the door
            if (myMaze.checkPlayerAnswer(playerAnswer)) {
                // Unlock the door and move the player
                myMaze.unlockDoor();
                myMaze.movePlayer(direction);
                myDisplay.displayMessage("Correct! You unlocked the door and moved forward.");
            } else {
                // Display an incorrect message and the correct answer
                myDisplay.displayMessage("Incorrect! The correct answer was: " + myMaze.getDoorAnswer());
            }
        } else {
            // Move the player forward since the door is not locked
            myMaze.movePlayer(direction);
            myDisplay.displayMessage("You moved forward.");
        }
    } else {
        // Display a message indicating the direction is invalid
        myDisplay.displayMessage("Invalid direction! Please choose a different direction.");
    }
    return success;
    }
}

