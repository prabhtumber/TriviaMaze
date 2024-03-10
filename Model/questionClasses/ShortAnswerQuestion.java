package Model.questionClasses;

import java.io.Serializable;

public class ShortAnswerQuestion extends Question implements Serializable {
    private static final long serialVersionUID = 569729474472871838L;

    public ShortAnswerQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }

    public String getQuestionText() {
        return getQuestion();
    }

    public String getCorrectAnswer() {
        return getAnswer();
    }
}
