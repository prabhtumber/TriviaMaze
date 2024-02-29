import java.io.*;
import java.util.Scanner;

/**
 * Controller class for managing the game flow.
 */
public class GameController {

    /** The main game instance. */
    private static Game game;

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
 * Represents the game logic and state.
 */
class Game {

    /** The name of the file used for saving and loading the game state. */
    private static final String SAVE_FILE_NAME = "GameSaveFile.txt";
    /** Scanner object for user input. */
    private static final Scanner scanner = new Scanner(System.in);
    /** Display object for showing information to the user. */
    private static final Display display = new Display();
    /** The game state. */
    private TriviaMaze triviaMaze;

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
        while (isActive) {
            if (!triviaMaze.possibleRoute()) {
                display.displayPlayerLost();
                isActive = false;
            }
            if (triviaMaze.isGameWon()) {
                display.displayPlayerWon();
                isActive = false;
            }
            if (isActive) {
                playTriviaGame();
            }
        }
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
        display.displayMaze(triviaMaze.toString());
        display.displayRoom(triviaMaze.getRoomDisplay());
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

    /**
     * Displays the game menu and handles player input for menu options.
     */
    private void displayGameMenu() {
        boolean isValidInput = false;
        display.displayFileMenu();
        while (!isValidInput) {
            String userInput = scanner.nextLine();
            if (userInput.toLowerCase().matches("save")) {
                saveGame();
                isValidInput = true;
            } else if (userInput.toLowerCase().matches("load")) {
                loadSavedGame();
                isValidInput = true;
            } else if (userInput.toLowerCase().matches("exit")) {
                scanner.close();
                System.exit(0);
            } else {
                display.displayInvalidInput();
            }
        }
    }

    /**
     * Displays the help menu and handles player input for help options.
     */
    private void displayHelpMenu() {
        boolean isValidInput = false;
        display.displayHelpMenu();
        while (!isValidInput) {
            String userInput = scanner.nextLine();
            if (userInput.toLowerCase().matches("instr")) {
                display.displayInstructions();
                isValidInput = true;
            } else if (userInput.toLowerCase().matches("about")) {
                display.displayGameInfo();
                isValidInput = true;
            } else {
                display.displayInvalidInput();
            }
        }
    }

    /**
     * Moves the player in the specified direction.
     * @param direction The direction in which the player wants to move.
     * @return true if the player successfully moved, false otherwise.
     */
    private boolean movePlayer(final String direction) {
        boolean success = false;
        triviaMaze.setCurrentDoor(direction);
        if (triviaMaze.canMove()) {
            success = true;
            if (triviaMaze.checkLocked()) {
                display.displayQuestion(triviaMaze.getDoorQuestion());
                String playerAnswer = scanner.nextLine();
                triviaMaze.checkPlayerAnswer(playerAnswer);
                if (triviaMaze.checkLockedForever()) {
                    display.displayIncorrectAnswer();
                    display.displayAnswer(triviaMaze.getDoorAnswer());
                } else {
                    triviaMaze.movePlayer(direction);
                    display.displayCorrectAnswer();
                }
            } else {
                triviaMaze.movePlayer(direction);
                display.displayRoomVisited();
            }
        } else {
            display.displayWrongDirection();
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
}

/**
 * Represents the display of information to the user.
 */
class Display {
    // Method implementations for displaying various messages and information.
}
