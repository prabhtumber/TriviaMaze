package questionClasses;

public class TrueFalseQuestion extends Question {

    public TrueFalseQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }

    public String getQuestionText() {
        return getQuestion();
    }

    public String getCorrectAnswer() {
        return getAnswer();
    }
}