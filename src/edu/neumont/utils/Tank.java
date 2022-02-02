package edu.neumont.utils;

import edu.neumont.controllers.randomGenerator;

public class Tank extends Zombie {

    static final int MIN_BASE_HP = 45;
    static final int MAX_BASE_HP = 70;

    static final int MIN_SPEED = 4;
    static final int MAX_SPEED = 8;

    static final int MIN_DAMAGE_MODIFIER = 10;
    static final int MAX_DAMAGE_MODIFIER = 20;

    private int damageModifier;

    public Tank() {
        setArms(randomGenerator.getInt(MIN_ARMS, MAX_ARMS));
        setLegs(randomGenerator.getInt(MIN_LEGS, MAX_LEGS));
        setBaseHP(randomGenerator.getInt(MIN_BASE_HP, MAX_BASE_HP));
        setSpeed(randomGenerator.getInt(MIN_SPEED, MAX_SPEED));

        damageModifier = randomGenerator.getInt(MIN_DAMAGE_MODIFIER, MAX_DAMAGE_MODIFIER);
    }

    @Override
    public int attack(int roll) {
        if(roll == 20) {
            return (roll(3, 6) + this.damageModifier) * 3;
        } else if(roll < 10 && roll > 19) {
            return roll(3, 6) + this.damageModifier;
        } else {
            return 0;
        }
    }

    @Override
    public String attackString(int roll) {
        if(roll == 20) {
            return "Critical Hit!";
        } else if(roll >= 10 && roll <= 19) {
            return "Hit!";
        } else {
            return "Miss!";
        }
    }

    @Override
    public void setBaseHP(int baseHP) {
        if(baseHP <  MIN_BASE_HP || baseHP > MAX_BASE_HP) {
            throw new IllegalArgumentException("Invalid Base HP was entered");
        }

        this.baseHP = baseHP;
    }

    @Override
    public void setSpeed(int speed) {
        if(speed <  MIN_SPEED || speed > MAX_SPEED) {
            throw new IllegalArgumentException("Invalid Speed was entered");
        }

        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "damageModifier=" + damageModifier +
                ", arms=" + arms +
                ", legs=" + legs +
                ", baseHP=" + baseHP +
                ", speed=" + speed +
                '}';
    }
}
