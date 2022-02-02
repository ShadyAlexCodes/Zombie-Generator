package edu.neumont.controllers;

import java.util.Random;

public class randomGenerator {

    static Random random = new Random();


    public static int getInt(int min, int max) {
        return random.nextInt(min, max + 1);
    }

    public static double getDouble(double min, double max) {
        return random.nextDouble(min, max);
    }

}
