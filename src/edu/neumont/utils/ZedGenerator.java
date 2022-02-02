package edu.neumont.utils;

import edu.neumont.controllers.randomGenerator;

import java.util.ArrayList;

public class ZedGenerator {

    private final ArrayList<Zombie> zombies = new ArrayList<Zombie>();

    public void generate(int number) {
        zombies.clear();

        for(int i = 0; i < number; i++) {
            int random = randomGenerator.getInt(0, 2);
            ZombieType type = ZombieType.values()[random];
            zombies.add(createZombie(type));
        }
    }

    public void display() {
        for (var zombie : zombies) {
            int attackRoll = zombie.roll(1, 20);
            int attackValue = zombie.attack(attackRoll);
            String result = zombie.toString() + zombie.attackString(attackRoll) +  " attack roll = " + attackRoll + " attack value = "  + attackValue;
            System.out.println(result);
        }
    }

    private Zombie createZombie(ZombieType type) {
        Zombie zombieType = null;
        switch (type) {
            case WALKER:
                zombieType = new Walker();
                break;
            case RUNNER:
                zombieType = new Runner();
                break;
            case TANK:
                zombieType = new Tank();
                break;
        }

        return zombieType;
    }

    enum ZombieType {
        WALKER,
        RUNNER,
        TANK
    }

}
