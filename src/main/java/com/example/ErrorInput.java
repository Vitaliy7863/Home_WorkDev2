package com.example;

public class ErrorInput {
    public boolean isValidInput(byte input, char[] box) {
        if (input > 0 && input < 10) {
            if (box[input - 1] == 'X' || box[input - 1] == 'O') {
                System.out.println("That one is already in use. Enter another.");
            } else {
                return true;
            }
        } else {
            System.out.println("Invalid input. Enter again.");
        }
        return false;
    }
}
