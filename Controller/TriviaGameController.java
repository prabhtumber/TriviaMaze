package Controller;

import Model.TriviaMazeMain;
import View.TriviaMazeDisplay;
import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.*;

/**
 * The controller class for the Trivia Maze game. It controls the flow of the game,
 * manages user input and interactions between the model and the view.
 */
public class TriviaGameController {

    /** File to store the game state */
    private static final File GAME = new File("TriviaGameSaveFile.txt");
    /** Music file path */
    private static final String MUSIC = "music.wav";
    /** Clip for playing music */
    private static Clip musicClip;
    /** Scanner for user input */
    private static final Scanner myIn = new Scanner(System.in);
    /** Instance of TriviaMazeDisplay */
    private static TriviaMazeDisplay myDisplay;
    /** Instance of TriviaMazeMain */
    private static TriviaMazeMain myMaze;

    /**
     * Constructor for TriviaGameController.
     * Initializes the game and starts the game loop.
     */
    protected TriviaGameController() {
        initializeGame();
        triviaMazeLoop();
    }

    /**
     * Initializes the game by creating instances of TriviaMazeMain and TriviaMazeDisplay.
     * Also displays the game title and instructions.
     */
    private static void initializeGame() {
        myMaze = new TriviaMazeMain();
        myDisplay = new TriviaMazeDisplay();
        myDisplay.displayTitle();
        myDisplay.MazeInstruction();
    }

    /**
     * Main game loop controlling the flow of the game.
     * Checks game completion and handles player movements.
     */
    private static void triviaMazeLoop() {
        myDisplay.DisplayGameType();
        start_Game();
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

    /**
     * Plays music in a separate thread.
     * @param filepath The path of the music file to be played.
     */
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

    /**
     * Stops the currently playing music.
     */
    public static void muteMusic() {
        if (musicClip != null && musicClip.isRunning()) {
            musicClip.stop();  // Stop the music
        }
    }

    /**
     * Starts a new game or loads a saved game based on user input.
     */
    private static void start_Game() {
        boolean success = false;
        String userIn;
        while (!success) {
            userIn = myIn.nextLine();
            if (userIn.equalsIgnoreCase("new")) {
                success = true;
                myDisplay.displayInstruction();
                playMusic(MUSIC);
            } else if (userIn.equalsIgnoreCase("load")) {
                if (load_Game()) {
                    success = true;
                    playMusic(MUSIC);
                } else {
                    myDisplay.displayWrongIn();
                }
            }
        }
    }

    /**
     * Loads a saved game from the file.
     * @return True if the game is loaded successfully, false otherwise.
     */
    private static boolean load_Game() {
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
     * Saves the current game state to the file.
     */
    private static void save_Game() {
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
     * Executes the main gameplay logic.
     * Displays the maze, room information, and handles player movements.
     */
    private static void triviaGame() {
        myDisplay.displayMaze(myMaze.toString());
        myDisplay.displayRoom(myMaze.getRoomInfo());
        players_NextMove();
    }

    /**
     * Prompts the player for their next move and handles it accordingly.
     */
    private static void players_NextMove() {
        myDisplay.displayDirection();
        boolean validIn = false;
        String playersMove;
        while (!validIn) {
            playersMove = myIn.nextLine();
            if (playersMove.toLowerCase().matches("north|west|south|east")) {
                if (player_Movement(playersMove)) {
                    validIn = true;
                }
            } else if (playersMove.toLowerCase().matches("menu")) {
                gameMenu();
                validIn = true;
            } else if (playersMove.toLowerCase().matches("help")) {
                gameHelpMenu();
                validIn = true;
            }else if (playersMove.equalsIgnoreCase("gg")) { // Cheat code to skip room
                skipCurrentRoom();
                validIn = true;
            }else {
                myDisplay.displayWrongIn();
            }
        }
    }


    /**
     * Skips the current room by moving the player to an adjacent, unvisited room.
     */
    private static void skipCurrentRoom() {
        // Implement the logic to find an adjacent, unvisited room and move the player there.
        // This is a placeholder for your game logic.
        boolean skipped = myMaze.skipToNextOpenRoom(); // Assume this method finds and moves the player.

        if (skipped) {
            myDisplay.displaySkippedRoom(); // Inform the user that the room has been skipped.
        } else {
            myDisplay.displayNoOpenRooms(); // Inform the user if no open rooms are available to skip to.
        }
    }

    /**
     * Displays the game menu and handles user choices.
     */
    private static void gameMenu() {
        boolean validIn = false;
        myDisplay.displayFileMenu();
        while (!validIn) {
            String playersIn = myIn.nextLine();
            if (playersIn.toLowerCase().matches("save")) {
                save_Game();
                validIn = true;
            } else if (playersIn.toLowerCase().matches("load")) {
                load_Game();
                validIn = true;
            } else if (playersIn.toLowerCase().matches("exit")) {
                myIn.close();
                System.exit(0);
            } else if (playersIn.toLowerCase().matches("mute")) {
                muteMusic();  // Mute the music
                validIn = true;
                //myDisplay.displayFileMenu();
            }else if (playersIn.toLowerCase().matches("unmute")) {
                playMusic(MUSIC);  // Mute the music
                validIn = true;
                //myDisplay.displayFileMenu();
            }

            else {
                myDisplay.displayWrongIn();
            }
        }
    }

    /**
     * Displays the help menu and handles user choices.
     */
    private static void gameHelpMenu() {
        boolean validIn = false;
        myDisplay.displayHelpMenu();
        while (!validIn) {
            String playersIn = myIn.nextLine();
            if (playersIn.toLowerCase().matches("instruction")) {
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
     * Handles player movement within the maze.
     * @param theDirection The direction in which the player wants to move.
     * @return True if the movement is successful, false otherwise.
     */
    private static boolean player_Movement(final String theDirection) {
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