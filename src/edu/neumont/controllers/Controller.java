package edu.neumont.controllers;

import edu.neumont.utils.ZedGenerator;

public class Controller {

    private ZedGenerator zedGenerator = new ZedGenerator();

    public void run() {

        boolean quit = false;

        while (!quit) {
            System.out.println("-----------------------------");
            System.out.println(" ");
            System.out.println("(1) Generate 1 Zombie");
            System.out.println("(2) Generate some of Zombies");
            System.out.println("(3) Generate random # zombies");
            System.out.println("(4) Quit");
            System.out.println(" ");
            System.out.println("-----------------------------");

            int selection = Console.getInteger("Please select an option: ", 1, 4);

            switch (selection) {
                case 1:
                    zedGenerator.generate(1);
                    break;
                case 2:
                    int number = Console.getInteger("Enter a number of zombies: ", 1, 100);
                    zedGenerator.generate(number);
                    break;
                case 3:
                    zedGenerator.generate(randomGenerator.getInt(1, 10));
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("ERROR!");
                    break;
            }
            zedGenerator.display();
        }
    }


}
