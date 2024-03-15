package Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import Model.questionClasses.*;
import Model.*;
import java.io.Serial;
public class TriviaMazeDatabaseTest {

    private Question MCQquestion;
    private Question shortAnswerQuestion;
    private Question trueFalseQuestion;
    @BeforeEach
    void setUp() {
        // Assuming AbstractQuestionAnswer can be directly instantiated
        // or you have a concrete subclass for testing purposes.
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

        // True/False Question
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
    @Test
    void getQuestion_ShouldReturnAQuestion() {
        Question question = TriviaMazeDatabase.getQuestion();
        assertNotNull(question, "The question should not be null");
    }



    @Test
    void testGetQuestionText() {
        assertEquals("What game is this?", MCQquestion.getQuestionText());
    }

    @Test
    void testGetCorrectAnswer() {
        assertEquals("Trivia Maze", MCQquestion.getCorrectAnswer());
    }
    @Test
    void testShortAnswerQuestion() {
        assertEquals("What game is this?", shortAnswerQuestion.getQuestionText(), "The question text should match.");
        assertEquals("Trivia Maze", shortAnswerQuestion.getCorrectAnswer(), "The correct answer should match.");
    }

    @Test
    void testTrueFalseQuestion() {
        assertEquals("Is Trivia Maze a puzzle game?", trueFalseQuestion.getQuestionText(), "The question text should match.");
        assertEquals("True", trueFalseQuestion.getCorrectAnswer(), "The correct answer should match.");
    }

}
