package View;

/**
 * This class is responsible for displaying various elements of the TriviaMaze game.
 * It includes methods for displaying instructions, the maze, questions, and game statuses.
 *
 * @author Virat Singh
 * @author Prabhjeet Singh
 * @version 03/15/2024
 */
public class TriviaMazeDisplay {

        /**
         * Constructor for TriviaMazeDisplay. Initializes a new display instance.
         */
        public TriviaMazeDisplay() {
        }

        /**
         * Prints the game instructions with different color codes for emphasis.
         */
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
                System.out.println(red + "Each door in the maze has a unique trivia question that you must answer to proceed." + reset);
                System.out.println(green + "Answering a question correctly will unlock the door, allowing you to move to the next room." + reset);
                System.out.println(blue + "Be careful! Answering incorrectly will lock the door forever, blocking that path." + reset);
                System.out.println(red + "Your objective is to successfully navigate through the maze by answering all questions correctly." + reset);
                System.out.println(green + "If you lock all doors leading to the exit, the game is over, and you will have to start again." + reset);
                System.out.println(blue + "Use commands like 'go north', 'go south', 'go east', and 'go west' to move through the maze." + reset);
                System.out.println(red + "To answer a question, simply type your answer when prompted. Good luck!" + reset);
                System.out.println(green + "Remember, each choice could be your step towards victory or a dead end. Choose wisely!" + reset);
                System.out.println(blue + "Let's begin the adventure! Can you clear the maze and emerge victorious?" + reset);
        }

        /**
         * Displays the current state of the maze.
         * @param theMaze The current maze layout in String format.
         */
        public void displayMaze(final String theMaze) {
                System.out.println("\t\t\t     MAZE");
                System.out.print("--------------------------------------------");
                System.out.print(theMaze);
                System.out.println("--------------------------------------------");
        }

        /**
         * Displays the current room status.
         * @param theDoor The status of the current door in String format.
         */
        public void displayRoom(final String theDoor) {
                System.out.print(theDoor);
        }

        /**
         * Displays the game type options to the player.
         */
        public void DisplayGameType() {
                System.out.println("""

                                NEW - 𝓝𝓮𝔀 𝓰𝓪𝓶𝓮                 LOAD - 𝑳𝒐𝒂𝒅 𝒈𝒂𝒎𝒆""");
        }

        /**
         * Displays the available navigation and menu options to the player.
         */
        public void displayDirection() {
                System.out.println("Options: |MENU| - |HELP| ");
                System.out.println("Type an option or direction");
                System.out.println();
        }

        /**
         * Displays the game title in a stylized ASCII art format.
         */
        public void displayTitle() {
                System.out.println("""
                         
                         
                         /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$    /$$ /$$$$$$  /$$$$$$        /$$      /$$  /$$$$$$  /$$$$$$$$ /$$$$$$$$
                        |__  $$__/| $$__  $$|_  $$_/| $$   | $$|_  $$_/ /$$__  $$      | $$$    /$$$ /$$__  $$|_____ $$ | $$_____/
                           | $$   | $$  \\ $$  | $$  | $$   | $$  | $$  | $$  \\ $$      | $$$$  /$$$$| $$  \\ $$     /$$/ | $$     \\
                           | $$   | $$$$$$$/  | $$  |  $$ / $$/  | $$  | $$$$$$$$      | $$ $$/$$ $$| $$$$$$$$    /$$/  | $$$$$  \\
                           | $$   | $$__  $$  | $$   \\  $$ $$/   | $$  | $$__  $$      | $$  $$$| $$| $$__  $$   /$$/   | $$__/  \\
                           | $$   | $$  \\ $$  | $$    \\  $$$/    | $$  | $$  | $$      | $$\\  $ | $$| $$  | $$  /$$/    | $$     \\
                           | $$   | $$  | $$ /$$$$$$   \\  $/    /$$$$$$| $$  | $$      | $$ \\/  | $$| $$  | $$ /$$$$$$$$| $$$$$$$$
                           |__/   |__/  |__/|______/    \\_/    |______/|__/  |__/      |__/     |__/|__/  |__/|________/|________/
                                                                                                                                 
                                                                                                                                 
                                                                                                                                 
                        """);
        }

        /**
         * Displays game instructions and room legend to the player.
         */
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

        /**
         * Displays the current trivia question to the player.
         * @param theQuestion The trivia question in String format.
         */
        public void displayQuestion(final String theQuestion) {
                System.out.println(theQuestion);
        }

        /**
         * Displays the correct answer to the current trivia question.
         * @param theAnswer The correct answer in String format.
         */
        public void displayAnswer(final String theAnswer) {
                System.out.println("The right answer was " + theAnswer);
        }

        /**
         * Displays the message indicating that the player has won the game.
         */
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

        /**
         * Displays the message indicating that the player has lost the game.
         */
        public void displayPlayerLost() {
                System.out.println("Sorry, there are no more doors to unlock. You Have Lost...");
                System.out.println();
                System.out.println("""
                         /$$     /$$                        /$$                       /$$   
                        |  $$   /$$/                       | $$                      | $$   
                         \\  $$ /$$//$$$$$$  /$$   /$$      | $$  /$$$$$$   /$$$$$$$ /$$$$$$ 
                          \\  $$$$//$$__  $$| $$  | $$      | $$ /$$__  $$ /$$_____/|_  $$_/ 
                           \\  $$/| $$  \\ $$| $$  | $$      | $$| $$  \\ $$|  $$$$$$   | $$   
                            | $$ | $$  | $$| $$  | $$      | $$| $$  | $$ \\____  $$  | $$ /$$
                            | $$ |  $$$$$$/|  $$$$$$/      | $$|  $$$$$$/ /$$$$$$$/  |  $$$$/
                            |__/  \\______/  \\______/       |__/ \\______/ |_______/    \\___/  """);
        }

        /**
         * Displays the message indicating that the player's answer is correct.
         */
        public void displayCorrect() {
                System.out.println("CORRECT! You may proceed");
        }

        /**
         * Displays the message indicating that the player's answer is incorrect.
         */
        public void displayIncorrect() {
                System.out.println("INCORRECT! TriviaDoor is now locked forever");
        }

        /**
         * Displays the message indicating file operation success.
         */
        public void displayFileSuccess() {
                System.out.println("Success");
        }

        /**
         * Displays the message indicating file operation failure.
         */
        public void displayFileFailed() {
                System.out.println("Failed");
        }

        /**
         * Displays the message indicating incorrect input by the player.
         */
        public void displayWrongIn() {
                System.out.println("Wrong Input Try Again.");
        }

        /**
         * Displays the message indicating that the player has attempted to move in an invalid direction.
         */
        public void displayWrongDirection() {
                System.out.println("Can't go that Direction. Try again.");
        }

        /**
         * Displays the message indicating that the player has returned to a previously visited room.
         */
        public void displayVisited() {
                System.out.println("You already visited this room. Welcome back");
        }

        /**
         * Displays options for the file menu.
         */
        public void displayFileMenu() {
                System.out.println("Type one of the following:");
                System.out.println("\"Save\" to save game");
                System.out.println("\"Load\" to load game");
                System.out.println("\"Exit\" to exit game");
                System.out.println("\"Mute\" to mute the music");
        }

        /**
         * Displays options for the help menu.
         */
        public void displayHelpMenu() {
                System.out.println("Type one of the following:");
                System.out.println("\"About\" for information about the game");
                System.out.println("\"Instruction\" for game Instructions");
        }

        /**
         * Displays the message indicating the player has skipped a room.
         */
        public void displaySkippedRoom() {
                String green = "\u001B[32m";
                String reset = "\u001B[0m";
                System.out.println(green + "Magically transported to the next room!" + reset);
        }

        /**
         * Displays the message indicating there are no adjacent open rooms to skip to.
         */
        public void displayNoOpenRooms() {
                String red = "\u001B[31m";
                String reset = "\u001B[0m";
                System.out.println(red + "No adjacent unopened rooms. Can't skip!" + reset);
        }
}
