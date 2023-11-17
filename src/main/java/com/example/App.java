package com.example;

public class App {

    public static void main(String[] args) {
        char box[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Logic logic = new Logic();
        boolean boxEmpty = false;

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
            if (!boxEmpty) {
                for (byte i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }

            if (1 == logic.winner(box,'X')) {
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if (2 == logic.winner(box, 'O')) {
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if (3 == logic.winner(box,'X')) {
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }

            logic.input(box);
            logic.random(box);
        }

    }
}