package Logic;

import Mobs.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Experience {

    public static void expCounter(Player player) {
        int firstCap = 40;
        int secondCap = 100;
        int thirdCap = 250;
        int fourthCap = 400;
        int fifthCap = 700;
        Scanner scanner = new Scanner(System.in);
        if (player.getXP() >= 40 && player.getLevel() == 0) {
            player.setMaxHP(player.getMaxHP() + 15);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG() + 5);
            player.setXP(player.getXP() - 40);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(), player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setAttributePoints(player.getAttributePoints() + 5);
            System.out.println("Otrzymałeś też " + player.getAttributePoints() + " punktów umiejętności");
            player.setMana(150);
            player.setMaxMana(150);
            if (player.getClassNumber() == 1) {
                System.out.println("Wybierz czar którego chcesz się nauczyć: ");
                System.out.println("1. Lodowy pocisk (zamraża przeciwnika na 2 tury, 20p many)");
                System.out.println("2. Kula ognia (zadaje 120 obrażeń, 50p many)");
                System.out.println("3. Teleportacja (przenieś się na dowolne pole, darmowe)");
                System.out.println("4. Adrenalina (Zadajesz i przyjmujesz więcej obrażeń)");
                System.out.println("5. Skóra z żelaza (+30 armor w trakcie walki)");
                System.out.println("6. Dual Wielding (Możesz używać dwóch lekkich broni naraz)");
                String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        LearnSkill(player,Player.ICE,1);
                        break;
                    case "2":
                        LearnSkill(player,Player.FIREBALL,1);
                        break;
                    case "3":
                        LearnSkill(player,Player.TP,1);
                        break;
                    case "4":
                        LearnSkill(player,Player.ADRENALINE,1);
                        break;
                    case "5":
                        LearnSkill(player,Player.IRONSKIN,1);
                        break;
                    case "6":
                        player.DualWield(player);
                        break;
                    case "7":
                        LearnSkill(player,Player.CLEAVE, 1);
                        break;
                }
                System.out.println("Nauczyłeś się nowej umiejętności!");
            }
            player.setLevel(1);

        } else if (player.getXP() >= 100 && player.getLevel() == 1) {
            player.setMaxHP(player.getMaxHP() + 25);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG() + 7);
            player.setXP(player.getXP() - 100);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(), player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setAttributePoints(player.getAttributePoints() + 5);
            System.out.println("Otrzymałeś też " + player.getAttributePoints() + " punktów umiejętności");
            player.setMana(180);
            player.setMaxMana(180);
            if (player.getClassNumber() == 1) {
                System.out.println("Wybierz czar którego chcesz się nauczyć: ");
                if (player.getChosenSkill1() != Player.ICE) {
                    System.out.println("1. Lodowy pocisk (zamraża przeciwnika na 2 tury, 20p many)");
                }
                if (player.getChosenSkill1() != Player.FIREBALL) {
                    System.out.println("2. Kula ognia (zadaje 120 obrażeń, 50p many)");
                }
                if (player.getChosenSkill1() != Player.TP) {
                    System.out.println("3. Teleportacja (przenieś się na dowolne pole, darmowe)");
                }
                if (player.getChosenSkill1() != Player.ADRENALINE){
                    System.out.println("4. Adrenalina (Zadajesz i przyjmujesz więcej obrażeń)");
                }
                if (player.getChosenSkill1() != Player.IRONSKIN){
                    System.out.println("5. Skóra z żelaza (+30 armor w trakcie walki)");
                }
                if (player.getWeaponCapacity() < 2){
                    System.out.println("6. Dual Wielding (Możesz używać dwóch lekkich broni naraz)");
                }


                String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        LearnSkill(player,Player.ICE,2);
                        break;
                    case "2":
                        LearnSkill(player,Player.FIREBALL,2);
                        break;
                    case "3":
                        LearnSkill(player,Player.TP,2);
                        break;
                    case "4":
                        LearnSkill(player,Player.ADRENALINE,2);
                        break;
                    case "5":
                        LearnSkill(player,Player.IRONSKIN,2);
                        break;
                    case "6":
                        player.DualWield(player);
                        break;
                    case "7":
                        LearnSkill(player,Player.CLEAVE, 2);
                        break;
                }

                System.out.println("Nauczyłeś się nowej umiejętności!");
            }
            player.setLevel(2);
        } else if (player.getXP() >= 250 && player.getLevel() == 2) {
            player.setMaxHP(player.getMaxHP() + 30);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG() + 10);
            player.setXP(player.getXP() - 250);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(), player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setAttributePoints(player.getAttributePoints() + 5);
            System.out.println("Otrzymałeś też " + player.getAttributePoints() + " punktów umiejętności");
            player.setMana(210);
            player.setMaxMana(210);
            if (player.getClassNumber() == 1) {
                System.out.println("Wybierz czar którego chcesz się nauczyć: ");
                if (player.getChosenSkill1() != Player.ICE && player.getChosenSkill2() != Player.ICE) {
                    System.out.println("1. Lodowy pocisk (zamraża przeciwnika na 2 tury, 20p many)");
                }
                if (player.getChosenSkill1() != Player.FIREBALL && player.getChosenSkill2() != Player.FIREBALL) {
                    System.out.println("2. Kula ognia (zadaje 120 obrażeń, 50p many)");
                }
                if (player.getChosenSkill1() != Player.TP && player.getChosenSkill2() != Player.TP) {
                    System.out.println("3. Teleportacja (przenieś się na dowolne pole, darmowe)");
                }
                if (player.getChosenSkill1() != Player.ADRENALINE && player.getChosenSkill2() != Player.ADRENALINE){
                    System.out.println("4. Adrenalina (Zadajesz i przyjmujesz więcej obrażeń)");
                }
                if (player.getChosenSkill1() != Player.IRONSKIN && player.getChosenSkill2() != Player.IRONSKIN){
                    System.out.println("5. Skóra z żelaza (+30 armor w trakcie walki)");
                }
                if (player.getWeaponCapacity() < 2){
                    System.out.println("6. Dual Wielding (Możesz używać dwóch lekkich broni naraz)");
                }
                String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        LearnSkill(player,Player.ICE,3);
                        break;
                    case "2":
                        LearnSkill(player,Player.FIREBALL,3);
                        break;
                    case "3":
                        LearnSkill(player,Player.TP,3);
                        break;
                    case "4":
                        LearnSkill(player,Player.ADRENALINE,3);
                        break;
                    case "5":
                        LearnSkill(player,Player.IRONSKIN,3);
                        break;
                    case "6":
                        player.DualWield(player);
                        break;
                    case "7":
                        LearnSkill(player,Player.CLEAVE, 3);
                        break;
                }
                System.out.println("Nauczyłeś się nowej umiejętności!");
            }
            player.setLevel(3);
        } else if (player.getXP() >= 400 && player.getLevel() == 3) {
            player.setMaxHP(player.getMaxHP() + 40);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG() + 10);
            player.setXP(player.getXP() - 400);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(), player.getMaxHP());
            player.setMana(250);
            player.setMaxMana(250);
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setAttributePoints(player.getAttributePoints() + 5);
            System.out.println("Otrzymałeś też " + player.getAttributePoints() + " punktów umiejętności");
            if (player.getClassNumber() == 1) {
                System.out.println("Wybierz czar którego chcesz się nauczyć: ");
                if (player.getChosenSkill1() != Player.ICE && player.getChosenSkill2() != Player.ICE && player.getChosenSkill3() != Player.ICE &&
                        player.getChosenSkill4() != Player.ICE) {
                    System.out.println("1. Lodowy pocisk (zamraża przeciwnika na 2 tury, 20p many)");
                }
                if (player.getChosenSkill1() != Player.FIREBALL && player.getChosenSkill2() != Player.FIREBALL && player.getChosenSkill3() != Player.FIREBALL &&
                        player.getChosenSkill4() != Player.FIREBALL) {
                    System.out.println("2. Kula ognia (zadaje 120 obrażeń, 50p many)");
                }
                if (player.getChosenSkill1() != Player.TP && player.getChosenSkill2() != Player.TP && player.getChosenSkill3() != Player.TP &&
                        player.getChosenSkill4() != Player.TP) {
                    System.out.println("3. Teleportacja (przenieś się na dowolne pole, darmowe)");
                }
                if (player.getChosenSkill1() != Player.ADRENALINE && player.getChosenSkill2() != Player.ADRENALINE && player.getChosenSkill3() != Player.ADRENALINE &&
                        player.getChosenSkill4() != Player.ADRENALINE){
                    System.out.println("4. Adrenalina (Zadajesz i przyjmujesz więcej obrażeń)");
                }
                if (player.getChosenSkill1() != Player.IRONSKIN && player.getChosenSkill2() != Player.IRONSKIN && player.getChosenSkill3() != Player.IRONSKIN &&
                        player.getChosenSkill4() != Player.IRONSKIN){
                    System.out.println("5. Skóra z żelaza (+30 armor w trakcie walki)");
                }
                if (player.getWeaponCapacity() < 2){
                    System.out.println("6. Dual Wielding (Możesz używać dwóch lekkich broni naraz)");
                }
                String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        LearnSkill(player,Player.ICE,4);
                        break;
                    case "2":
                        LearnSkill(player,Player.FIREBALL,4);
                        break;
                    case "3":
                        LearnSkill(player,Player.TP,4);
                        break;
                    case "4":
                        LearnSkill(player,Player.ADRENALINE,4);
                        break;
                    case "5":
                        LearnSkill(player,Player.IRONSKIN,4);
                        break;
                    case "6":
                        player.DualWield(player);
                        break;
                    case "7":
                        LearnSkill(player,Player.CLEAVE, 4);
                        break;
                }
                System.out.println("Nauczyłeś się nowej umiejętności!");
            }
            player.setLevel(4);
        } else if (player.getXP() >= 700 && player.getLevel() == 4) {
            player.setMaxHP(player.getMaxHP() + 40);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG() + 15);
            player.setXP(player.getXP() - 700);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(), player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setAttributePoints(player.getAttributePoints() + 5);
            System.out.println("Otrzymałeś też " + player.getAttributePoints() + " punktów umiejętności");
            if (player.getClassNumber() == 1) {
                System.out.println("Wybierz czar którego chcesz się nauczyć: ");
                if (player.getChosenSkill1() != Player.ICE && player.getChosenSkill2() != Player.ICE && player.getChosenSkill3() != Player.ICE &&
                        player.getChosenSkill4() != Player.ICE) {
                    System.out.println("1. Lodowy pocisk (zamraża przeciwnika na 2 tury, 20p many)");
                }
                if (player.getChosenSkill1() != Player.FIREBALL && player.getChosenSkill2() != Player.FIREBALL && player.getChosenSkill3() != Player.FIREBALL &&
                        player.getChosenSkill4() != Player.FIREBALL) {
                    System.out.println("2. Kula ognia (zadaje 120 obrażeń, 50p many)");
                }
                if (player.getChosenSkill1() != Player.TP && player.getChosenSkill2() != Player.TP && player.getChosenSkill3() != Player.TP &&
                        player.getChosenSkill4() != Player.TP) {
                    System.out.println("3. Teleportacja (przenieś się na dowolne pole, darmowe)");
                }
                if (player.getChosenSkill1() != Player.ADRENALINE && player.getChosenSkill2() != Player.ADRENALINE && player.getChosenSkill3() != Player.ADRENALINE &&
                        player.getChosenSkill4() != Player.ADRENALINE){
                    System.out.println("4. Adrenalina (Zadajesz i przyjmujesz więcej obrażeń)");
                }
                if (player.getChosenSkill1() != Player.IRONSKIN && player.getChosenSkill2() != Player.IRONSKIN && player.getChosenSkill3() != Player.IRONSKIN &&
                player.getChosenSkill4() != Player.IRONSKIN){
                    System.out.println("5. Skóra z żelaza (+30 armor w trakcie walki)");
                }
                if (player.getWeaponCapacity() < 2){
                    System.out.println("6. Dual Wielding (Możesz używać dwóch lekkich broni naraz)");
                }
                String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        LearnSkill(player,Player.ICE,5);
                        break;
                    case "2":
                        LearnSkill(player,Player.FIREBALL,5);
                        break;
                    case "3":
                        LearnSkill(player,Player.TP,5);
                        break;
                    case "4":
                        LearnSkill(player,Player.ADRENALINE,5);
                        break;
                    case "5":
                        LearnSkill(player,Player.IRONSKIN,5);
                        break;
                    case "6":
                        player.DualWield(player);
                        break;
                    case "7":
                        LearnSkill(player,Player.CLEAVE, 5);
                        break;
                }
                System.out.println("Nauczyłeś się nowej umiejętności!");
            }
            player.setMana(300);
            player.setMaxMana(300);
            player.setLevel(5);
        }
        if (player.getLevel() == 0 && player.getHP() > 0) {
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + firstCap + " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        } else if (player.getLevel() == 1 && player.getHP() > 0) {
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + secondCap + " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        } else if (player.getLevel() == 2 && player.getHP() > 0) {
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + thirdCap + " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        } else if (player.getLevel() == 3 && player.getHP() > 0) {
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + fourthCap + " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        } else if (player.getLevel() == 4 && player.getHP() > 0) {
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + fifthCap + " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        } else if (player.getLevel() == 5 && player.getHP() > 0) {
            System.out.println("Osiągnąłeś maksymalny poziom doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
    }

    public static void LearnSkill(Player player, int skillNumber, int skillSlot){
        if (player.getChosenSkill1() != skillNumber && player.getChosenSkill2() != skillNumber && player.getChosenSkill3() != skillNumber &&
                player.getChosenSkill4() != skillNumber &&  player.getChosenSkill5() != skillNumber) {
            if (skillSlot == 1) {
                player.setChosenSkill1(skillNumber);
            } else if (skillSlot == 2) {
                player.setChosenSkill2(skillNumber);
            } else if (skillSlot == 3) {
                player.setChosenSkill3(skillNumber);
            } else if (skillSlot == 4) {
                player.setChosenSkill4(skillNumber);
            } else if (skillSlot == 5) {
                player.setChosenSkill5(skillNumber);
            }
        } else {
            System.out.println("Umiesz już ten czar");
            }


        }
    }


