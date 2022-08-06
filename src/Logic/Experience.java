package Logic;

import Mobs.Player;

import java.util.Scanner;

public class Experience {

    public static void expCounter(Player player){
         int firstCap = 40;
         int secondCap = 100;
         int thirdCap = 250;
         int fourthCap = 400;
         int fifthCap = 700;
        Scanner scanner = new Scanner(System.in);
        if (player.getXP()>40 && player.getLevel() == 0){
            player.setMaxHP(player.getMaxHP() +30);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG()+10);
            player.setXP(player.getXP() - 40);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setMana(150);
            player.setMaxMana(150);
            if (player.getClassNumber() == 1){
                System.out.println("Wybierz czar którego chcesz się nauczyć: ");
                System.out.println("1. Lodowy pocisk (zamraża przeciwnika na 2 tury, 20p many)");
                System.out.println("2. Kula ognia (zadaje 120 obrażeń, 50p many)");
                System.out.println("3. Teleportacja (przenieś się na dowolne pole, darmowe)");
                String input = scanner.nextLine();
                switch (input){
                    case "1":
                        player.setChosenSkill1(Player.ICE);
                                break;
                    case "2":
                        player.setChosenSkill1(Player.FIREBALL);
                        break;
                    case "3":
                        player.setChosenSkill1(Player.TP);
                        break;
                }
                System.out.println("Nauczyłeś się nowej umiejętności!");
            }
            player.setLevel(1);

        } else if (player.getXP() > 100 && player.getLevel() == 1) {
            player.setMaxHP(player.getMaxHP() +30);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG()+10);
            player.setXP(player.getXP() - 100);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setMana(180);
            player.setMaxMana(180);
            if (player.getClassNumber() == 1){
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
                String input = scanner.nextLine();
                switch (input){
                    case "1":
                        player.setChosenSkill2(Player.ICE);
                        break;
                    case "2":
                        player.setChosenSkill2(Player.FIREBALL);
                        break;
                    case "3":
                        player.setChosenSkill2(Player.TP);
                        break;
                }
                System.out.println("Nauczyłeś się nowej umiejętności!");
            }
            player.setLevel(2);
        }
        else if (player.getXP() > 250 && player.getLevel() == 2) {
            player.setMaxHP(player.getMaxHP() +40);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG()+10);
            player.setXP(player.getXP() - 250);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setMana(210);
            player.setMaxMana(210);
            if (player.getClassNumber() == 1){
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
                String input = scanner.nextLine();
                switch (input){
                    case "1":
                        player.setChosenSkill3(Player.ICE);
                        break;
                    case "2":
                        player.setChosenSkill3(Player.FIREBALL);
                        break;
                    case "3":
                        player.setChosenSkill3(Player.TP);
                        break;
                }
                System.out.println("Nauczyłeś się nowej umiejętności!");
            }
            player.setLevel(3);
        }
        else if (player.getXP() > 400 && player.getLevel() == 3) {
            player.setMaxHP(player.getMaxHP() +40);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG()+15);
            player.setXP(player.getXP() - 400);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
            player.setMana(250);
            player.setMaxMana(250);
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setLevel(4);
        }
        else if (player.getXP() > 700 && player.getLevel() == 4) {
            player.setMaxHP(player.getMaxHP() +50);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG()+20);
            player.setXP(player.getXP() - 700);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setMana(300);
            player.setMaxMana(300);
            player.setLevel(5);
        }
        if (player.getLevel() == 0 && player.getHP() > 0) {
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + firstCap+ " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
        else if (player.getLevel() == 1 && player.getHP() > 0){
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + secondCap+ " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        } else if (player.getLevel() == 2 && player.getHP() > 0){
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + thirdCap+ " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
        else if (player.getLevel() == 3 && player.getHP() > 0){
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + fourthCap+ " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
        else if (player.getLevel() == 4 && player.getHP() > 0){
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + fifthCap+ " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
        else if (player.getLevel() == 5 && player.getHP() > 0){
            System.out.println("Osiągnąłeś maksymalny poziom doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
    }
}
