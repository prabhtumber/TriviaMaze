import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;
import questionClasses.*;
import java.util.Random;

public class TriviaMazeDatabase {

    public static Question getQuestion() {
        Random random = new Random();

        return switch (random.nextInt(3)) {
            case 0 -> getShortAnswerQuestion();
            case 1 -> getMCQQuestion();
            case 2 -> getTrueFalseQuestion();
            default -> null;
        };
    }

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
                Statement stmt = conn.createStatement();) {

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
                Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String question = rs.getString("QUESTION");
                String answer = rs.getString("ANSWER");

                return new multipleChoiceQuestion(question, answer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

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
                Statement stmt = conn.createStatement();) {

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
