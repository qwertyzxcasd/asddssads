package com.company;

import java.util.Random;

public class Main {
    public static int bossHealth = 2500;
    public static int bossDamage = 120;
    public static String bossDefence;
    public static int[] heroesHealth = {650, 450, 350, 500, 450, 400};
    public static int[] heroesDamage = {40, 50, 45, 30, 30, 20};
    public static String[] heroesAttackType = {"Magical", "Thor", "Golem", "Berserk", "Warrior", "TrickyBastard"};
    public static int round_number = 0;

    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            round();
        }

    }

    public static void round() {
        round_number++;
        bossHits();
        heroesHit();
        printStatistics();
        Thor();
        Golem();
        Berserk();
        Magical();
        Warrior();
        TrickyBastard();
    }

    public static void printStatistics() {
        System.out.println(round_number + "  ROUND");
        System.out.println("Boss Health:" + bossHealth + " (" + bossDamage + ")");
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health:" + heroesHealth[i] + " (" + heroesDamage[i] + ")");
        }
    }


    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0 && heroesHealth[3] <= 0 && heroesHealth[3] <= 0) {
            System.out.println("Boss won!");
            return true;
        }
        return false;
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] <= 0) {

            }

            if (heroesHealth[i] - bossDamage < 0) {
                heroesHealth[i] = 0;
            } else {
                heroesHealth[i] = heroesHealth[i] - bossDamage;
            }
        }
    }

    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (bossHealth <= 0 || heroesHealth[i] <= 0) {
                continue;
            }
            if (bossHealth - heroesDamage[i] < 0) {
                bossHealth = 0;
            } else {

                bossHealth = bossHealth - heroesDamage[i];
            }
        }
    }


    public static void Thor() {
        Random random = new Random();
        boolean stan = random.nextBoolean();
        if (stan) {
            bossDamage = 0;
        } else {
            bossDamage = 120;
        }


    }


    public static void Golem() {
        int klkl = bossDamage / 5;
        int gogo = 0;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                gogo++;
                heroesHealth[i] = heroesHealth[i] - klkl;
                heroesHealth[2] = heroesHealth[2] - gogo * klkl;

            }
        }
    }

    public static void Berserk() {
        Random random = new Random();
        int damage = random.nextInt(120);
        heroesHealth[3] = heroesHealth[3] - damage;
        heroesDamage[3] = heroesDamage[3] + damage;
    }

    public static void Magical() {
        int asd = 25;
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesDamage[i] > 0) {

                heroesDamage[i] = heroesDamage[i] + asd;
                heroesDamage[i] = heroesDamage[i] + asd;
            }
        }
    }

    public static void Warrior() {

        Random random = new Random();
        int damage = random.nextInt(2) * 4;

    }

    public static void TrickyBastard() {
        int qqq = 0;
        int sss = 0;
        Random random = new Random();
        boolean die = random.nextBoolean();
        if (die) {
            heroesDamage[5] = 0;
            heroesHealth[5] = + 120;
        } else {
            bossDamage = 120;
        }

    }

}

