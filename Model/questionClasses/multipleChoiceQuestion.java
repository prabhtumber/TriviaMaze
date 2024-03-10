package Model.questionClasses;

import java.io.Serializable;

public class multipleChoiceQuestion extends Question implements Serializable {
    private static final long serialVersionUID = 1046053044148065321L;

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