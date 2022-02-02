package edu.neumont.utils;

import edu.neumont.controllers.randomGenerator;

public abstract class Zombie {

    static final int MIN_ARMS = 0;
    static final int MAX_ARMS = 3;

    static final int MIN_LEGS = 0;
    static final int MAX_LEGS = 3;

    protected int arms;
    protected int legs;
    protected int baseHP;
    protected int speed;


    public int roll(int numberOfDice, int numberOfSides) {

        int value = 0;
        for (int i = 0; i < numberOfDice; i++) {
            value += randomGenerator.getInt(1, numberOfSides + 1);
        }
        return value;
    }

    public abstract int attack(int roll);
    public abstract String attackString(int roll);

    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        if (arms < MIN_ARMS || arms > MAX_ARMS) {
            throw new IllegalArgumentException("Invalid number of arms");
        }

        this.arms = arms;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        if (arms < MIN_LEGS || arms > MAX_ARMS) {
            throw new IllegalArgumentException("Invalid number of arms");
        }


        this.legs = legs;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public abstract void setBaseHP(int baseHP);


    public int getSpeed() {
        return speed;
    }

    public abstract void setSpeed(int speed);

    @Override
    public String toString() {
        return "Zombie{" +
                ", arms=" + arms +
                ", legs=" + legs +
                ", baseHP=" + baseHP +
                ", speed=" + speed +
                '}';
    }
}
