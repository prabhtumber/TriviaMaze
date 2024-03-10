package Controller;

import java.awt.*;
import java.io.Serializable;

/**
 * The TriviaMainController class serves as the entry point for the trivia game application.
 * It initializes the game controller and starts the game by invoking the TriviaGameController class in the Event Dispatch Thread.
 */
public final class TriviaMainController implements Serializable {

    private static final long serialVersionUID = 1139818214227838601L;

    /**
     * The main method serves as the entry point of the application.
     * It starts the game by invoking the TriviaGameController class in the Event Dispatch Thread.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(TriviaGameController::new);
    }
}



