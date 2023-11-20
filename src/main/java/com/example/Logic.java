package com.example;

import java.util.Scanner;

public class Logic {
    private int amountMove = 0;

    public byte winner(char[] box, char value) {
        byte winPlayer = 1;
        byte winComputer = 2;
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

        return result;
    }

    public byte drawTrue(char[] box) {
        byte draw = 3;
        boolean isDraw = true;
        byte result = 0;
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

    public void coursePlayer(char[] box) {
        byte inputNumber;
        ErrorInput errorsInput = new ErrorInput();
        Scanner scan = new Scanner(System.in);
        while (true) {
            inputNumber = scan.nextByte();
            if (errorsInput.isValidInput(inputNumber, box)) {
                box[inputNumber - 1] = 'X';
                amountMove++;
                break;
            }
        }
    }

    public void courseComputer(char[] box) {
        byte rand;
        boolean work = true;
        while (work) {
            if (amountMove == box.length) {
                work = false;
            }
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                amountMove++;
                work = false;
            }
        }
    }
}

