package Controller;

import Model.TriviaMazeMain;
import View.TriviaMazeDisplay;

import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.*;

public class TriviaGameController {

    /**
     * The file used to save and load the game state.
     */
    private static final File GAME = new File("TriviaGameSaveFile.txt");
    private static final String MUSIC =  "music.wav";
    private static Clip musicClip;

    /**
     * Scanner object to read user input.
     */
    private static final Scanner myIn = new Scanner(System.in);

    /**
     * The display object responsible for showing information to the user.
     */
    private static TriviaMazeDisplay myDisplay;

    /**
     * The TriviaMaze object representing the game state.
     */
    private static TriviaMazeMain myMaze;

    /**
     * Constructs a GameController object and initializes the game.
     */
    protected TriviaGameController() {
        initialization();
        triviaMazeLoop();
    }

    /**
     * Initializes the game by creating a new TriviaMaze and Display.
     */
    private static void initialization() {
        myMaze = new TriviaMazeMain();
        myDisplay = new TriviaMazeDisplay();
        myDisplay.displayTitle();
        myDisplay.MazeInstruction();

    }

    /**
     * The main game loop that continues until the player wins or loses.
     */
    private static void triviaMazeLoop() {
        myDisplay.DisplayGameType();
        startupGame();
        boolean active = true;
        while (active) {
            if (!(myMaze.hasPossiblePath())) {
                myDisplay.displayPlayerLost();
                active = false;
            }
            if (myMaze.isGameCompleted()) {
                myDisplay.displayPlayerWon();
                active =  false;
            }
            if (active) {
                triviaGame();
            }
        }
    }

    public static void playMusic(String filepath) {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                File musicFile = new File(filepath);
                if (!musicFile.exists()) {
                    System.err.println("Music file not found: " + filepath);
                    return;
                }
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
                musicClip = AudioSystem.getClip();
                musicClip.open(audioStream);
                musicClip.start();
                musicClip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                System.err.println("Error occurred while playing the music file.");
                e.printStackTrace();
            }
        }).start();
    }
    public static void muteMusic() {
        if (musicClip != null && musicClip.isRunning()) {
            musicClip.stop();  // Stop the music
        }
    }

    /**
     * Handles the startup phase of the game, where the player chooses to start
     * a new game or load a saved one.
     */
    private static void startupGame() {
        boolean success = false;
        String userIn;
        while (!success) {
            userIn = myIn.nextLine();
            if (userIn.equalsIgnoreCase("new")) {
                success = true;
                myDisplay.displayInstruction();
                playMusic(MUSIC);
            } else if (userIn.equalsIgnoreCase("load")) {
                if (loadGame()) {
                    success = true;
                    playMusic(MUSIC);
                } else {
                    myDisplay.displayWrongIn();
                }
            }
        }
    }

    /**
     * Loads a saved game from the specified file.
     *
     * @return true if the loading is successful, false otherwise.
     */
    private static boolean loadGame() {
        boolean success = false;
        try {
            FileInputStream file = new FileInputStream(GAME);
            if (GAME.length() != 0) {
                ObjectInputStream in = new ObjectInputStream(file);
                myMaze = (TriviaMazeMain) in.readObject();
                myDisplay.displayFileSuccess();
                success = true;
            } else {
                myDisplay.displayFileFailed();
            }
        } catch (IOException e) {
            System.out.println("No Save file exists");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return success;
    }

    /**
     * Saves the current game state to the specified file.
     */
    private static void saveGame() {
        try {
            FileOutputStream file = new FileOutputStream(GAME);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(myMaze);
            out.close();
            file.close();
            myDisplay.displayFileSuccess();
        } catch (IOException e) {
            myDisplay.displayFileFailed();
        }
    }

    /**
     * Displays the current state of the game and handles player
     * input during the game.
     */
    private static void triviaGame() {
        myDisplay.displayMaze(myMaze.toString());
        myDisplay.displayRoom(myMaze.getRoomInfo());
        playersNextMove();
    }

    /**
     * Gets the player's next move and checks if the input is valid.
     */
    private static void playersNextMove() {
        myDisplay.displayDirection();
        boolean validIn = false;
        String playersMove;
        while (!validIn) {
            playersMove = myIn.nextLine();
            if (playersMove.toLowerCase().matches("north|west|south|east")) {
                if (playerMovement(playersMove)) {
                    validIn = true;
                }
            } else if (playersMove.toLowerCase().matches("menu")) {
                gameMenu();
                validIn = true;
            } else if (playersMove.toLowerCase().matches("help")) {
                gameHelpMenu();
                validIn = true;
            } else {myDisplay.displayWrongIn();
            }
        }
    }

    /**
     * Displays the game menu and handles player input for menu options.
     */
    private static void gameMenu() {
        boolean validIn = false;
        myDisplay.displayFileMenu();
        while (!validIn) {
            String playersIn = myIn.nextLine();
            if (playersIn.toLowerCase().matches("save")) {
                saveGame();
                validIn = true;
            } else if (playersIn.toLowerCase().matches("load")) {
                loadGame();
                validIn = true;
            } else if (playersIn.toLowerCase().matches("exit")) {
                myIn.close();
                System.exit(0);
            }else if (playersIn.toLowerCase().matches("mute")) {
                muteMusic();  // Mute the music
                validIn = false; // Stay in the menu
                myDisplay.displayFileMenu(); // Re-display the menu
            } else {
                myDisplay.displayWrongIn();
            }
        }
    }

    /**
     * Displays the help menu and handles player input for help options.
     */
    private static void gameHelpMenu() {
        boolean validIn = false;
        myDisplay.displayHelpMenu();
        while (!validIn) {
            String playersIn = myIn.nextLine();
            if (playersIn.toLowerCase().matches("instr")) {
                myDisplay.displayInstruction();
                validIn = true;
            } else if (playersIn.toLowerCase().matches("about")) {
                myDisplay.MazeInstruction();
                validIn = true;
            } else {
                myDisplay.displayWrongIn();
            }
        }
    }

    /**
     * Moves the player based on the provided direction and handles door interactions.
     *
     * @param theDirection The direction in which the player wants to move.
     * @return true if the player successfully moved, false otherwise.
     */
    private static boolean playerMovement(final String theDirection) {
        boolean success = false;
        myMaze.setCurrentDoor(theDirection);
        if (myMaze.canMove()) {
            success = true;
            if (myMaze.isDoorLocked()) {
                myDisplay.displayQuestion(myMaze.getQuestionForDoor());
                String playersAnswer = myIn.nextLine();
                myMaze.evaluatePlayerAnswer(playersAnswer);
                if (myMaze.isDoorPermanentlyLocked()) {
                    myDisplay.displayIncorrect();
                    myDisplay.displayAnswer(myMaze.getAnswerForDoor());
                } else {
                    myMaze.movePlayer(theDirection);
                    myDisplay.displayCorrect();
                }
            } else {
                myMaze.movePlayer(theDirection);
                myDisplay.displayVisited();
            }
        } else {
            myDisplay.displayWrongDirection();
        }
        return success;
    }
}

