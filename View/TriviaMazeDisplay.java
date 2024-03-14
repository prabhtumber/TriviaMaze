package View;

public class TriviaMazeDisplay {

        public TriviaMazeDisplay() {

        }
        public void MazeInstruction() {
                String reset = "\u001B[0m";
                String red = "\u001B[31m";
                String green = "\u001B[32m";
                String yellow = "\u001B[33m";
                String blue = "\u001B[34m";
                String purple = "\u001B[35m";
                String cyan = "\u001B[36m";
                String white = "\u001B[37m";

                // Print each instruction line with a different color
                System.out.println(white + "In this game, you will navigate through a maze of rooms, each separated by doors with trivia questions." + reset);
                System.out.println(green + "Each door in the maze has a unique trivia question that you must answer to proceed." + reset);
                System.out.println(yellow + "Answering a question correctly will unlock the door, allowing you to move to the next room." + reset);
                System.out.println(red + "Be careful! Answering incorrectly will lock the door forever, blocking that path." + reset);
                System.out.println(blue + "Your objective is to successfully navigate through the maze by answering all questions correctly." + reset);
                System.out.println(purple + "If you lock all doors leading to the exit, the game is over, and you will have to start again." + reset);
                System.out.println(cyan + "Use commands like 'go north', 'go south', 'go east', and 'go west' to move through the maze." + reset);
                System.out.println(yellow + "To answer a question, simply type your answer when prompted. Good luck!" + reset);
                System.out.println(green + "Remember, each choice could be your step towards victory or a dead end. Choose wisely!" + reset);
                System.out.println(blue + "Let's begin the adventure! Can you clear the maze and emerge victorious?" + reset);
        }

        public void displayMaze(final String theMaze) {
                System.out.println("\t\t\t     MAZE");
                System.out.print("--------------------------------------------");
                System.out.print(theMaze);
                System.out.println("--------------------------------------------");
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
                         /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$    /$$ /$$$$$$  /$$$$$$        /$$      /$$  /$$$$$$  /$$$$$$$$ /$$$$$$$$
                        |__  $$__/| $$__  $$|_  $$_/| $$   | $$|_  $$_/ /$$__  $$      | $$$    /$$$ /$$__  $$|_____ $$ | $$_____/
                           | $$   | $$  \\ $$  | $$  | $$   | $$  | $$  | $$  \\ $$      | $$$$  /$$$$| $$  \\ $$     /$$/ | $$     \s
                           | $$   | $$$$$$$/  | $$  |  $$ / $$/  | $$  | $$$$$$$$      | $$ $$/$$ $$| $$$$$$$$    /$$/  | $$$$$  \s
                           | $$   | $$__  $$  | $$   \\  $$ $$/   | $$  | $$__  $$      | $$  $$$| $$| $$__  $$   /$$/   | $$__/  \s
                           | $$   | $$  \\ $$  | $$    \\  $$$/    | $$  | $$  | $$      | $$\\  $ | $$| $$  | $$  /$$/    | $$     \s
                           | $$   | $$  | $$ /$$$$$$   \\  $/    /$$$$$$| $$  | $$      | $$ \\/  | $$| $$  | $$ /$$$$$$$$| $$$$$$$$
                           |__/   |__/  |__/|______/    \\_/    |______/|__/  |__/      |__/     |__/|__/  |__/|________/|________/
                                                                                                                                 \s
                                                                                                                                 \s
                                                                                                                                 \s
                        """);

        }

        public void displayInstruction() {
                String reset = "\u001B[0m";
                String red = "\u001B[31m";
                String green = "\u001B[32m";
                String yellow = "\u001B[33m";
                String blue = "\u001B[34m";
                String purple = "\u001B[35m";
                String cyan = "\u001B[36m";

                // Instructions
                System.out.println(cyan + "Instructions: " + reset);
                System.out.println(yellow + "To move to a different room, you can type:" + reset);
                System.out.println(red + "\"North\"" + reset + " to move up");
                System.out.println(red + "\"South\"" + reset + " to move down");
                System.out.println(red + "\"East\"" + reset + " to move right");
                System.out.println(red + "\"West\"" + reset + " to move left");
                System.out.println();
                System.out.println(purple + "In the MAZE display:" + reset);
                System.out.println(green + "|ST|" + reset + " means the room where you started");
                System.out.println(green + "|RM|" + reset + " means a room");
                System.out.println(green + "|ED|" + reset + " means the end room to win");
                System.out.println();
                System.out.println(blue + "In the TriviaRoom display:" + reset);
                System.out.println(red + "|XX|" + reset + " means you can't go through either because it's a wall or door is locked forever");
                System.out.println(green + "|OP|" + reset + " means you can access that door since it was unlocked");
                System.out.println(yellow + "|LK|" + reset + " means the door is locked but is accessible if Question is answered correctly");
                System.out.println();
                System.out.println(cyan + "There are three types of questions:" + reset);
                System.out.println(purple + "Short Answer" + reset + " - You must type the answer");
                System.out.println(purple + "Multiple Choice" + reset + " - You must type either A, B, C, or D");
                System.out.println(purple + "True or False" + reset + " - You must type either True or False");
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
                System.out.println("\n\n");
                System.out.println("""
                                                .* *.               `o`o`
                                               *. .*              o`o`o`o      ^,^,^
                                                 * \\               `o`o`     ^,^,^,^,^
                                                    \\     ***        |       ^,^,^,^,^
                                                     \\   *****       |        /^,^,^
                                                      \\   ***        |       /
                                          ~@~*~@~      \\   \\         |      /
                                        ~*~@~*~@~*~     \\   \\        |     /
                                        ~*~@smd@~*~      \\   \\       |    /     #$#$#        .`'.;.
                                        ~*~@~*~@~*~       \\   \\      |   /     #$#$#$#   00  .`,.',
                                          ~@~*~@~ \\        \\   \\     |  /      /#$#$#   /|||  `.,'
                                      _____________\\________\\___\\____|_/______/_________|\\/\\___||______ """);


                System.out.println("\n\n");

        }

        public void displayPlayerLost() {
                System.out.println("Sorry, there are no more doors to unlock. You Have Lost...");

                System.out.println();

                System.out.println("""
                         /$$     /$$                        /$$                       /$$   \s
                        |  $$   /$$/                       | $$                      | $$   \s
                         \\  $$ /$$//$$$$$$  /$$   /$$      | $$  /$$$$$$   /$$$$$$$ /$$$$$$ \s
                          \\  $$$$//$$__  $$| $$  | $$      | $$ /$$__  $$ /$$_____/|_  $$_/ \s
                           \\  $$/| $$  \\ $$| $$  | $$      | $$| $$  \\ $$|  $$$$$$   | $$   \s
                            | $$ | $$  | $$| $$  | $$      | $$| $$  | $$ \\____  $$  | $$ /$$
                            | $$ |  $$$$$$/|  $$$$$$/      | $$|  $$$$$$/ /$$$$$$$/  |  $$$$/
                            |__/  \\______/  \\______/       |__/ \\______/ |_______/    \\___/ \s
                                                                                            \s
                                                                                            \s
                                                                                            \s
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
                System.out.println("\"Mute\" to mute the music");
        }

        public void displayHelpMenu() {
                System.out.println("Type one of the following:");
                System.out.println("\"About\" for information about the game");
                System.out.println("\"Instruction\" for game Instructions");
        }

        public void displaySkippedRoom() {
                String green = "\u001B[32m";
                String reset = "\u001B[0m";
                System.out.println(green + "Magically transported to the next room!" + reset);
        }

        public void displayNoOpenRooms() {
                String red = "\u001B[31m";
                String reset = "\u001B[0m";
                System.out.println(red+"No adjacent unopened rooms. Can't skip!"+reset);
        }


}