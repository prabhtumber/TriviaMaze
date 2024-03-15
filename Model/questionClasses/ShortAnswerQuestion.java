package Model.questionClasses;

import java.io.Serializable;

/**
 * Represents a short answer question. This class is used for questions where the answer is expected
 * to be a short text response. It extends the abstract class Question and implements serializable to allow
 * instances of this class to be serialized for storage or transmission.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
public class ShortAnswerQuestion extends Question implements Serializable {
    private static final long serialVersionUID = 569729474472871838L;

    /**
     * Constructs a new ShortAnswerQuestion with the specified question text and answer.
     * @param theQuestion The text of the short answer question.
     * @param theAnswer The text of the answer to the question.
     */
    public ShortAnswerQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }

    /**
     * Retrieves the text of the question.
     * @return A String containing the text of the question.
     */
    @Override
    public String getQuestionText() {
        return getQuestion();
    }

    /**
     * Retrieves the text of the correct answer.
     * @return A String containing the correct answer to the question.
     */
    @Override
    public String getCorrectAnswer() {
        return getAnswer();
    }
}
