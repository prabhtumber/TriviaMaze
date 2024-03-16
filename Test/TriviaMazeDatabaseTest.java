package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import Model.questionClasses.*;
import Model.*;
import java.io.Serial;

/**
 * This class contains JUnit tests for the Trivia Maze Database.
 * It includes setup methods for initializing different types of questions
 * such as multiple choice, short answer, and true/false questions.
 * Each test validates different functionalities of the questions stored in the database.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
public class TriviaMazeDatabaseTest {

    private Question MCQquestion; // Multiple choice question instance
    private Question shortAnswerQuestion; // Short answer question instance
    private Question trueFalseQuestion; // True or false question instance

    /**
     * Sets up the test environment before each test.
     * Initializes different types of Question instances.
     */
    @BeforeEach
    void setUp() {
        // Initialize a multiple choice question
        MCQquestion = new Question("What game is this?", "Trivia Maze") {
            @Serial
            private static final long serialVersionUID = 0L;

            @Override
            public String getQuestionText() {
                return getQuestion();
            }

            @Override
            public String getCorrectAnswer() {
                return getAnswer();
            }
        };

        // Initialize a short answer question
        shortAnswerQuestion = new Question("What game is this?", "Trivia Maze") {
            @Serial
            private static final long serialVersionUID = 1L;

            @Override
            public String getQuestionText() {
                return super.getQuestion();
            }

            @Override
            public String getCorrectAnswer() {
                return super.getAnswer();
            }
        };

        // Initialize a true/false question
        trueFalseQuestion = new Question("Is Trivia Maze a puzzle game?", "True") {
            @Serial
            private static final long serialVersionUID = 2L;

            @Override
            public String getQuestionText() {
                return super.getQuestion();
            }

            @Override
            public String getCorrectAnswer() {
                return super.getAnswer();
            }
        };
    }

    /**
     * Tests if the method getQuestion returns a non-null question.
     */
    @Test
    void getQuestion_ShouldReturnAQuestion() {
        Question question = TriviaMazeQuestionFactory.getQuestion();
        assertNotNull(question, "The question should not be null");
    }

    /**
     * Tests if the method getQuestionText returns the correct question text for a multiple choice question.
     */
    @Test
    void testGetQuestionText() {
        assertEquals("What game is this?", MCQquestion.getQuestionText());
    }

    /**
     * Tests if the method getCorrectAnswer returns the correct answer for a multiple choice question.
     */
    @Test
    void testGetCorrectAnswer() {
        assertEquals("Trivia Maze", MCQquestion.getCorrectAnswer());
    }

    /**
     * Tests if the short answer question returns the correct question text and correct answer.
     */
    @Test
    void testShortAnswerQuestion() {
        assertEquals("What game is this?", shortAnswerQuestion.getQuestionText(), "The question text should match.");
        assertEquals("Trivia Maze", shortAnswerQuestion.getCorrectAnswer(), "The correct answer should match.");
    }

    /**
     * Tests if the true/false question returns the correct question text and correct answer.
     */
    @Test
    void testTrueFalseQuestion() {
        assertEquals("Is Trivia Maze a puzzle game?", trueFalseQuestion.getQuestionText(), "The question text should match.");
        assertEquals("True", trueFalseQuestion.getCorrectAnswer(), "The correct answer should match.");
    }
}
