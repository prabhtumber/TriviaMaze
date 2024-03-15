package Model.questionClasses;

import java.io.Serializable;

/**
 * A class representing a multiple-choice question. This class extends the abstract Question class
 * and implements Serializable, allowing instances of this class to be serialized for storage or transmission.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
public class multipleChoiceQuestion extends Question implements Serializable {
    private static final long serialVersionUID = 1046053044148065321L;

    /**
     * Constructs a new MultipleChoiceQuestion instance with the specified question text and answer.
     *
     * @param theQuestion The text of the multiple-choice question.
     * @param theAnswer The correct answer to the multiple-choice question.
     */
    public multipleChoiceQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer); // Passes the question and answer to the superclass constructor.
    }

    /**
     * Retrieves the text of the multiple-choice question.
     *
     * @return The text of the question.
     */
    @Override
    public String getQuestionText() {
        return getQuestion(); // Returns the question text from the superclass.
    }

    /**
     * Retrieves the correct answer to the multiple-choice question.
     *
     * @return The correct answer to the question.
     */
    @Override
    public String getCorrectAnswer() {
        return getAnswer(); // Returns the correct answer from the superclass.
    }
}
