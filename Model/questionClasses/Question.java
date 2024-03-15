package Model.questionClasses;

import java.io.Serializable;

/**
 * This abstract class represents the general structure of a trivia question.
 * It serves as a base class for various types of trivia questions within the game.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
public abstract class Question implements Serializable {

    private static final long serialVersionUID = 1724706615218001071L;

    // Text of the question
    private final String questionText;

    // Text of the answer
    private final String answerText;

    /**
     * Constructs a new Question with the specified question text and answer text.
     *
     * @param theQuestion The text of the question.
     * @param theAnswer   The text of the answer to the question.
     */
    public Question(final String theQuestion, final String theAnswer) {
        this.questionText = theQuestion;
        this.answerText = theAnswer;
    }

    /**
     * Returns the text of the question.
     * This method is abstract and must be implemented by subclasses.
     *
     * @return The text of the question.
     */
    public abstract String getQuestionText();

    /**
     * Returns the correct answer to the question.
     * This method is abstract and must be implemented by subclasses.
     *
     * @return The correct answer text.
     */
    public abstract String getCorrectAnswer();

    /**
     * Returns the text of the question.
     * This method provides direct access to the question text.
     *
     * @return The text of the question.
     */
    public String getQuestion() {
        return questionText;
    }

    /**
     * Returns the text of the answer.
     * This method provides direct access to the answer text.
     *
     * @return The text of the answer.
     */
    public String getAnswer() {
        return answerText;
    }
}
