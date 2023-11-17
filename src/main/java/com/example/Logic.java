package com.example;

import java.util.Scanner;

public class Logic {

    public byte winner(char[] box, char value) {
        byte winPlayer = 1;
        byte winComputer = 2;
        byte draw = 3;
        byte result = 0;

        for (int stringNumber = 0; stringNumber < 9; stringNumber += 3) {
            if (box[stringNumber] == value && box[stringNumber + 1] == value && box[stringNumber + 2] == value) {
                result = (value == 'X') ? winPlayer : winComputer;
                break;
            }
        }

        for (int columnNumber = 0; columnNumber < 3; columnNumber++) {
            if (box[columnNumber] == value && box[columnNumber + 3] == value && box[columnNumber + 6] == value) {
                result = (value == 'X') ? winPlayer : winComputer;
                break;
            }
        }

        if ((box[0] == value && box[4] == value && box[8] == value) || (box[2] == value && box[4] == value && box[6] == value)) {
            result = (value == 'X') ? winPlayer : winComputer;
        }

        boolean isDraw = true;
        for (char cell : box) {
            if (cell != 'X' && cell != 'O') {
                isDraw = false;
                break;
            }
        }
        if (isDraw) {
            result = draw;
        }

        return result;
    }

    public void input(char[] box) {
        Scanner scan = new Scanner(System.in);
        byte inputNumber;
        while (true) {
            inputNumber = scan.nextByte();
            if (inputNumber > 0 && inputNumber < 10) {
                if (box[inputNumber - 1] == 'X' || box[inputNumber - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[inputNumber - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    public void random(char[] box) {
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }
}
