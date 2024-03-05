package Model.questionClasses;

public abstract class Question {

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
