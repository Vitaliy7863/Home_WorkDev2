package com.example;

public class Output {
    public void logicResult() {
        boolean boxEmpty = true;
        boolean endGame = true;
        char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Logic logic = new Logic();
        StringBuilder gameCells = new StringBuilder();

        System.out.println("Enter box number to select. Enjoy!\n");

        while (endGame) {
            gameCells.append(String.format("\n\n %c | %c | %c \n-----------", box[0], box[1], box[2]));
            gameCells.append(String.format("\n %c | %c | %c \n-----------", box[3], box[4], box[5]));
            gameCells.append(String.format("\n %c | %c | %c \n", box[6], box[7], box[8]));
            System.out.println(gameCells);

            if (boxEmpty) {
                for (int i = 0; i < 9; i++) {
                    box[i] = ' ';
                }
                boxEmpty = false;
            }

            if (1 == logic.winner(box, 'X')) {
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                endGame = false;
            } else if (2 == logic.winner(box, 'O')) {
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                endGame = false;
            } else if (3 == logic.drawTrue(box)) {
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                endGame = false;
            }

            logic.coursePlayer(box);
            logic.courseComputer(box);
        }
    }
}