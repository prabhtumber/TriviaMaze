package View;

public class TriviaMazeDisplay {

        public TriviaMazeDisplay() {

        }

        public void MazeIntro() {
                System.out.print("""

                                █████████████████████████████████████████████████████████████
                                █▄─█▀▀▀█─▄█▄─▄▄─█▄─▄███─▄▄▄─█─▄▄─█▄─▀█▀─▄█▄─▄▄─███─▄─▄─█─▄▄─█
                                ██─█─█─█─███─▄█▀██─██▀█─███▀█─██─██─█▄█─███─▄█▀█████─███─██─█
                                ▀▀▄▄▄▀▄▄▄▀▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀▄▄▄▄▀▄▄▄▀▄▄▄▀▄▄▄▄▄▀▀▀▀▄▄▄▀▀▄▄▄▄▀
                                █████████████████████████████████████████████████████████████
                                █─▄─▄─█▄─▄▄▀█▄─▄█▄─█─▄█▄─▄██▀▄─████▄─▀█▀─▄██▀▄─██░▄▄░▄█▄─▄▄─█
                                ███─████─▄─▄██─███▄▀▄███─███─▀─█████─█▄█─███─▀─███▀▄█▀██─▄█▀█
                                ▀▀▄▄▄▀▀▄▄▀▄▄▀▄▄▄▀▀▀▄▀▀▀▄▄▄▀▄▄▀▄▄▀▀▀▄▄▄▀▄▄▄▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀

                                        """);
                MazeInstruction();

        }

        public void MazeInstruction() {
                System.out.println(
                                "In this game, you will navigate through a maze of rooms, each separated by doors with trivia questions.");
                System.out.println(
                                "Each door in the maze has a unique trivia question that you must answer to proceed.");
                System.out.println(
                                "Answering a question correctly will unlock the door, allowing you to move to the next room.");
                System.out.println(
                                "Be careful! Answering incorrectly will lock the door forever, blocking that path.");
                System.out.println(
                                "Your objective is to successfully navigate through the maze by answering all questions correctly.");
                System.out.println(
                                "If you lock all doors leading to the exit, the game is over, and you will have to start again.");
                System.out.println(
                                "Use commands like 'go north', 'go south', 'go east', and 'go west' to move through the maze.");
                System.out.println("To answer a question, simply type your answer when prompted. Good luck!");
                System.out.println(
                                "Remember, each choice could be your step towards victory or a dead end. Choose wisely!");
                System.out.println("Let's begin the adventure! Can you clear the maze and emerge victorious?");

        }

        public void displayMaze(final String theMaze) {
                System.out.println("\t\t\t  MAZE");
                System.out.print("\t\t________________");
                System.out.print(theMaze);
                System.out.println("\t\t----------------");
                System.out.println("/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
        }

        public void displayRoom(final String theDoor) {
                System.out.print(theDoor);
        }

        public void DisplayGameType() {
                System.out.println("""

                                NEW - 𝓝𝓮𝔀 𝓰𝓪𝓶𝓮                 LOAD - 𝑳𝒐𝒂𝒅 𝒈𝒂𝒎𝒆""");

        }

        public void displayDirection() {
                System.out.println("Options: |MENU| - |HELP| ");
                System.out.println("Type an option or direction");
                System.out.println();
        }

        public void displayTitle() {
                System.out.println("""


                                █████████████████████████████████████████████████████████████
                                █─▄─▄─█▄─▄▄▀█▄─▄█▄─█─▄█▄─▄██▀▄─████▄─▀█▀─▄██▀▄─██░▄▄░▄█▄─▄▄─█
                                ███─████─▄─▄██─███▄▀▄███─███─▀─█████─█▄█─███─▀─███▀▄█▀██─▄█▀█
                                ▀▀▄▄▄▀▀▄▄▀▄▄▀▄▄▄▀▀▀▄▀▀▀▄▄▄▀▄▄▀▄▄▀▀▀▄▄▄▀▄▄▄▀▄▄▀▄▄▀▄▄▄▄▄▀▄▄▄▄▄▀

                                                                """);

        }

        public void displayInstruction() {
                System.out.println("Instructions: ");
                System.out.println("To move to a different room, you can type:");
                System.out.println("\"North\" to move up");
                System.out.println("\"South\" to move down");
                System.out.println("\"East\" to move right");
                System.out.println("\"West\" to move left");
                System.out.println();
                System.out.println("In the MAZE display:");
                System.out.println("|ST| means the room where you started");
                System.out.println("|RM| means a room");
                System.out.println("|ED| means the end room to win");
                System.out.println();
                System.out.println("In the TriviaRoom display:");
                System.out.println(
                                "|XX| means you can't go through either because it's a wall or door is locked forever");
                System.out.println("|OP| means you can access that door since it was unlocked");
                System.out.println("|LK| means the door is locked but is accessible if Question is answered correctly");
                System.out.println();
                System.out.println("There are three types of questions:");
                System.out.println("Short Answer - You must type the answer");
                System.out.println("Multiple Choice - You must type either A, B, C, or D");
                System.out.println("True or False - You must type either True or False");
                System.out.println();
        }

        public void displayQuestion(final String theQuestion) {
                System.out.println(theQuestion);
        }

        public void displayAnswer(final String theAnswer) {
                System.out.println("The right answer was " + theAnswer);

        }

        public void displayPlayerWon() {
                System.out.println("CONGRATULATIONS! YOU WON!");
                System.out.println();
                System.out.println(
                                """

                                                ██████████████████████████████████████████████
                                                █▄─█─▄█─▄▄─█▄─██─▄███▄─█▀▀▀█─▄█─▄▄─█▄─▀█▄─▄█░█
                                                ██▄─▄██─██─██─██─█████─█─█─█─██─██─██─█▄▀─██▄█
                                                ▀▀▄▄▄▀▀▄▄▄▄▀▀▄▄▄▄▀▀▀▀▀▄▄▄▀▄▄▄▀▀▄▄▄▄▀▄▄▄▀▀▄▄▀▄▀


                                                                                        """);

        }

        public void displayPlayerLost() {
                System.out.println("Sorry, there are no more doors to unlock. You Have Lost...");

                System.out.println();

                System.out.println("""

                                ████████████████████████████████████████████████████
                                █▄─█─▄█─▄▄─█▄─██─▄███▄─▄███─▄▄─█─▄▄▄▄█─▄─▄─█████████
                                ██▄─▄██─██─██─██─█████─██▀█─██─█▄▄▄▄─███─███░░██░░██
                                ▀▀▄▄▄▀▀▄▄▄▄▀▀▄▄▄▄▀▀▀▀▄▄▄▄▄▀▄▄▄▄▀▄▄▄▄▄▀▀▄▄▄▀▀▄▄▀▀▄▄▀▀

                                                """);
        }

        public void displayCorrect() {
                System.out.println("CORRECT! You may proceed");
        }

        public void displayIncorrect() {
                System.out.println("INCORRECT! TriviaDoor is now locked forever");
        }

        public void displayFileSuccess() {
                System.out.println("Success");
        }

        public void displayFileFailed() {
                System.out.println("Failed");
        }

        public void displayWrongIn() {
                System.out.println("Wrong Input Try Again.");
        }

        public void displayWrongDirection() {
                System.out.println("Can't go that Direction. Try again.");
        }

        public void displayVisited() {
                System.out.println("You already visited this room. Welcome back");
        }

        public void displayFileMenu() {
                System.out.println("Type one of the following:");
                System.out.println("\"Save\" to save game");
                System.out.println("\"Load\" to load game");
                System.out.println("\"Exit\" to exit game");
        }

        public void displayHelpMenu() {
                System.out.println("Type one of the following:");
                System.out.println("\"About\" for information about the game");
                System.out.println("\"Instruction\" for game Instructions");
        }

}
