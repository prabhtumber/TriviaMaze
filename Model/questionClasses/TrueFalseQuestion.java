package Model.questionClasses;

/**
 * Represents a true or false question. This class is used for questions that require a true or false response.
 * It extends the abstract class Question to provide a specific implementation for true/false type questions.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
public class TrueFalseQuestion extends Question {

    /**
     * Constructs a new TrueFalseQuestion with the specified question text and answer.
     * This constructor initializes a true/false question with the given question and answer.
     *
     * @param theQuestion The text of the true or false question.
     * @param theAnswer The correct answer to the question, expected to be either "true" or "false".
     */
    public TrueFalseQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }

    /**
     * Retrieves the text of the question.
     * This method overrides the abstract method in the parent class to provide the specific text for the true/false question.
     *
     * @return A String containing the text of the true/false question.
     */
    @Override
    public String getQuestionText() {
        return getQuestion();
    }

    /**
     * Retrieves the text of the correct answer.
     * This method overrides the abstract method in the parent class to provide the specific answer for the true/false question.
     *
     * @return A String containing the correct answer to the true/false question, which will be either "true" or "false".
     */
    @Override
    public String getCorrectAnswer() {
        return getAnswer();
    }
}
