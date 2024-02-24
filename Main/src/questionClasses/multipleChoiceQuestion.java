package questionClasses;

public class multipleChoiceQuestion extends QuestionAbstract {

    public multipleChoiceQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }

    @Override
    public String getQuestionText() {
        return getQuestion();
    }

    @Override
    public String getCorrectAnswer() {
        return getAnswer();
    }
}