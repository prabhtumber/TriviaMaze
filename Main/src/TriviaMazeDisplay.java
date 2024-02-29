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
        System.out.println("Each door in the maze has a unique trivia question that you must answer to proceed.");
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
        System.out.println("Remember, each choice could be your step towards victory or a dead end. Choose wisely!");
        System.out.println("Let's begin the adventure! Can you clear the maze and emerge victorious?");

    }

}
