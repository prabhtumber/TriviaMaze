import java.io.Serializable;

public abstract class QuestionAbstract implements Serializable {

    private final String questionText;
    private final String answerText;

    public QuestionAbstract(final String question, final String answer) {
        questionText = question;
        answerText = answer;
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
