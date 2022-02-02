package edu.neumont.utils;

import edu.neumont.controllers.randomGenerator;

public class Runner extends Zombie {

    static final int MIN_BASE_HP = 45;
    static final int MAX_BASE_HP = 70;

    static final int MIN_SPEED = 4;
    static final int MAX_SPEED = 8;

    public Runner() {
        setArms(randomGenerator.getInt(MIN_ARMS, MAX_ARMS));
        setLegs(randomGenerator.getInt(MIN_LEGS, MAX_LEGS));
        setBaseHP(randomGenerator.getInt(MIN_BASE_HP, MAX_BASE_HP));
        setSpeed(randomGenerator.getInt(MIN_SPEED, MAX_SPEED));
    }

    @Override
    public int attack(int roll) {
        if(roll >= 19) {
            return roll(2, 8) * 2;
        } else if(roll < 18 && roll > 5) {
            return roll(2, 8);
        } else {
            return 0;
        }
    }

    @Override
    public String attackString(int roll) {
        if(roll >= 19) {
            return "Critical Hit!";
        } else if(roll < 18 && roll < 5) {
            return "Hit!";
        } else {
            return "Miss!";
        }
    }

    public int getClimbSpeed() {
        return (int)(speed * (1.0/3.0)); // int * double = double
    }

    @Override
    public void setBaseHP(int baseHP) {
        if(baseHP < MIN_BASE_HP || baseHP > MAX_BASE_HP) {
            throw new IllegalArgumentException("Invalid Base HP was entered");
        }

        this.baseHP = baseHP;
    }

    @Override
    public void setSpeed(int speed) {
        if(speed < MIN_SPEED || speed > MAX_SPEED) {
            throw new IllegalArgumentException("Invalid Speed was entered");
        }

        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Runner{" +
                ", climbSpeed=" + getClimbSpeed() +
                ", arms=" + arms +
                ", legs=" + legs +
                ", baseHP=" + baseHP +
                ", speed=" + speed +
                '}';
    }
}
