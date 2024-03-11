package Controller;

import java.awt.*;
import java.io.Serializable;

/**
 * The TriviaMainController class serves as the entry point for the Trivia Maze Game application.
 * It initializes and runs the main game controller in the Event Dispatch Thread (EDT).
 * This class is marked as final to prevent subclassing, and implements Serializable to allow instances
 * of this class to be serialized.
 */
public final class TriviaMainController implements Serializable {

    private static final long serialVersionUID = 1139818214227838601L;

    /**
     * Main entry point for the application.
     * This method just simply calls the game controller to start the
     * game.
     * @param args Command line arguments, not used in this application.
     */
    public static void main(String[] args) {
        new TriviaGameController();
    }
}
