package Model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Model.questionClasses.*;
import org.sqlite.SQLiteDataSource;
import java.util.Random;

/**
 * Class handling the database interactions for retrieving Trivia Maze questions.
 * It is responsible for fetching different types of questions (Short Answer, Multiple Choice, True/False)
 * from the SQLite database and constructing question objects from them.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
public class TriviaMazeDatabase implements Serializable {
    private static final long serialVersionUID = 1887880497416979668L;

    /**
     * Fetches a random question from the database.
     * The type of question (Short Answer, Multiple Choice, True/False) is also selected randomly.
     * @return A Question object representing the randomly selected question, or null if there's an issue.
     */
    public static Question getQuestion() {
        Random random = new Random();

        return switch (random.nextInt(3)) {
            case 0 -> getShortAnswerQuestion();
            case 1 -> getMCQQuestion();
            case 2 -> getTrueFalseQuestion();
            default -> null;
        };
    }

    /**
     * Retrieves a random Short Answer question from the database.
     * @return A ShortAnswerQuestion object, or null if an error occurs during database access.
     */
    private static Question getShortAnswerQuestion() {
        SQLiteDataSource ds = null;

        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:TriviaMazeQuestionDatabase.db");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        String query = "SELECT * FROM shortAnswerTable ORDER BY RANDOM() Limit 1";
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String question = rs.getString("QUESTION");
                String answer = rs.getString("ANSWER");

                return new ShortAnswerQuestion(question, answer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    /**
     * Retrieves a random Multiple Choice Question (MCQ) from the database.
     * @return A MultipleChoiceQuestion object, or null if an error occurs during database access.
     */
    private static Question getMCQQuestion() {
        SQLiteDataSource ds = null;

        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:TriviaMazeQuestionDatabase.db");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        String query = "SELECT * FROM MCQTable ORDER BY RANDOM() Limit 1";
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String question = rs.getString("QUESTION");
                String answer = rs.getString("ANSWER");

                // Note: Correct the class name if necessary, for instance, if it should be MultipleChoiceQuestion instead of multipleChoiceQuestion.
                return new multipleChoiceQuestion(question, answer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    /**
     * Retrieves a random True or False question from the database.
     * @return A TrueFalseQuestion object, or null if an error occurs during database access.
     */
    private static Question getTrueFalseQuestion() {
        SQLiteDataSource ds = null;

        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:TriviaMazeQuestionDatabase.db");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        String query = "SELECT * FROM trueFalseTable ORDER BY RANDOM() Limit 1";
        try (Connection conn = ds.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String question = rs.getString("QUESTION");
                String answer = rs.getString("ANSWER");

                return new TrueFalseQuestion(question, answer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
