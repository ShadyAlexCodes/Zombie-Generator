package edu.neumont.controllers;

import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

    static String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    static int getInteger(String prompt) {
        int i = 0;

        boolean valid = false;
        while (!valid) {
            String string = getUserInput(prompt);
            try {
                i = Integer.parseInt(string);
                valid = true;
            }
            catch (NumberFormatException ex) {
                System.out.println("You have entered an invalid number.");
            }
        }

        return i;
    }

    public static int getInteger(String prompt, int min, int max) {
        int i = 0;

        boolean valid = false;
        while (!valid) {
            String string = getUserInput(prompt);
            try {
                i = Integer.parseInt(string);
                valid = (i >= min && i <= max);
                if (!valid) {
                    System.out.println("Entered value is not between " + min + " and " + max + ".");
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("You have entered an invalid number.");
            }
        }

        return i;
    }


    static float getFloat(String prompt) {
        float i = 0;

        boolean valid = false;
        while (!valid) {
            String string = getUserInput(prompt);
            try {
                i = Float.parseFloat(string);
                valid = true;
            }
            catch (NumberFormatException ex) {
                System.out.println("You have entered an invalid number.");
            }
        }

        return i;
    }

}
