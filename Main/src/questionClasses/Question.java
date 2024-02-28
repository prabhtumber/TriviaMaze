package questionClasses;

public class Question {

    private final String questionText;
    private final String answerText;

    public Question(final String theQuestion, final String theAnswer) {
        questionText = theQuestion;
        answerText = theAnswer;
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
