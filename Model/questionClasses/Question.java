package Model.questionClasses;

import java.io.Serializable;

public abstract class Question implements Serializable {

    private static final long serialVersionUID =1724706615218001071L;
    private final String questionText;
    private final String answerText;

    public Question(final String theQuestion, final String theAnswer) {
        questionText = theQuestion;
        answerText = theAnswer;
    }

    public abstract String getQuestionText();

    public abstract String getCorrectAnswer();

    public String getQuestion() {
        return questionText;
    }

    public String getAnswer() {
        return answerText;
    }
}
