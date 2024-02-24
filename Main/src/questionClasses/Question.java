package questionClasses;

public class Question {

    private final String questionText;
    private final String answerText;

    public Question(final String question, final String answer) {
        questionText = question;
        answerText = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return answerText;
    }

    public String getQuestion() {
        return questionText;
    }

    public String getAnswer() {
        return answerText;
    }
}
