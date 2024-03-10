package Controller;

import java.awt.*;
import java.io.Serializable;

public final class TriviaMainController implements Serializable {
    private static final long serialVersionUID = 1139818214227838601L;

    public static void main(final String... theArgs) {
        EventQueue.invokeLater(TriviaGameController::new);
    }
}
