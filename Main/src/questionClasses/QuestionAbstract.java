package questionClasses;

import java.io.Serializable;

public abstract class QuestionAbstract {

    private final String questionText;
    private final String answerText;

    public QuestionAbstract(final String theQuestion, final String theAnswer) {
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
