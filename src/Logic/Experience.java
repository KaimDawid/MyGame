package Logic;

import Mobs.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Experience {

    public static String lvlupInput;

    public static String iceDescription = "1. Lodowy pocisk (zamraża przeciwnika na 2 tury, 20p many)";

    public static String fireDescription = "2. Kula ognia (zadaje 120 obrażeń, 50p many)";
    public static String tpDescription = "3. Teleportacja (przenieś się na dowolne pole, darmowe)";
    public static String adrenalineDescription = "4. Adrenalina (Zadajesz i przyjmujesz więcej obrażeń)";
    public static String ironskinDescription = "5. Skóra z żelaza (+30 armor w trakcie walki)";
    public static String dualWieldDescripion = "6. Dual Wielding (Możesz używać dwóch lekkich broni naraz)";
    public static String cleaveDescription = "7. Cleave (Atakujesz 2 potwory naraz ze zwiększoną siłą)";
    public static String healDescription = "8. Heal (Leczysz się za koszt many)";


    public static void expCounter(Player player) {


       int firstCap = 40;
        int secondCap = 100;
        int thirdCap = 250;
        int fourthCap = 400;
        int fifthCap = 700;
        int sixthCap = 1100;
        int seventhCap = 1700;
        int eigthCap = 2500;
        int ninethCap = 3500;
        int tenthCap = 5000;


        Scanner scanner = new Scanner(System.in);
        if (player.getXP() >= firstCap && player.getLevel() == 0) {
            addPointsAndPrint(player, firstCap, 15, 5, 50);
            if (player.getClassNumber() == 1) {

                LevelUp(player, 1,1);

            }

        } else if (player.getXP() >= secondCap && player.getLevel() == 1) {
            addPointsAndPrint(player, secondCap, 15, 5, 50);
            if (player.getClassNumber() == 1) {

                LevelUp(player, 2,2);

            }

        } else if (player.getXP() >= thirdCap && player.getLevel() == 2) {

            addPointsAndPrint(player, thirdCap, 20, 5, 50);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 3,3);

            }

        } else if (player.getXP() >= fourthCap && player.getLevel() == 3) {
            addPointsAndPrint(player, fourthCap, 25, 5, 50);
            if (player.getClassNumber() == 1) {

                LevelUp(player, 4,4);
            }


        } else if (player.getXP() >= fifthCap && player.getLevel() == 4) {

            addPointsAndPrint(player, fifthCap, 30, 5, 50);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 5, 5);
            }

        } else if (player.getXP() >= sixthCap && player.getLevel() == 5) {

            addPointsAndPrint(player, sixthCap, 30, 10, 50);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 6,6 );
            }


        } else if (player.getXP() >= seventhCap && player.getLevel() == 6) {

            addPointsAndPrint(player, seventhCap, 15, 5, 50);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 7, 7);
            }

        } else if (player.getXP() >= eigthCap && player.getLevel() == 7) {
            addPointsAndPrint(player, eigthCap, 15, 5, 50);
            if (player.getClassNumber() == 1) {

                LevelUp(player, 8, 8);
            }

        } else if (player.getXP() >= ninethCap && player.getLevel() == 8) {

            addPointsAndPrint(player, ninethCap, 15, 5, 50);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 9, 9);
            }


        } else if (player.getXP() >= tenthCap && player.getLevel() == 9) {

            addPointsAndPrint(player, tenthCap, 15, 5, 50);

            if (player.getClassNumber() == 1) {

                LevelUp(player, 10, 10);
            }

        }
        if (player.getLevel() == 0 && player.getHP() > 0) {
            ExpDisplay(player, firstCap);

        } else if (player.getLevel() == 1 && player.getHP() > 0) {
            ExpDisplay(player, secondCap);

        } else if (player.getLevel() == 2 && player.getHP() > 0) {
            ExpDisplay(player, thirdCap);

        } else if (player.getLevel() == 3 && player.getHP() > 0) {
            ExpDisplay(player, fourthCap);

        } else if (player.getLevel() == 4 && player.getHP() > 0) {
            ExpDisplay(player, fifthCap);

        } else if (player.getLevel() == 5 && player.getHP() > 0) {
            ExpDisplay(player, sixthCap);

        } else if (player.getLevel() == 6 && player.getHP() > 0) {
            ExpDisplay(player, seventhCap);

        } else if (player.getLevel() == 7 && player.getHP() > 0) {
            ExpDisplay(player, eigthCap);

        } else if (player.getLevel() == 8 && player.getHP() > 0) {
            ExpDisplay(player, ninethCap);

        } else if (player.getLevel() == 9 && player.getHP() > 0) {
            ExpDisplay(player, tenthCap);

        } else if (player.getLevel() == 10 && player.getHP() > 0) {
            System.out.println("Osiągnąłeś maksymalny poziom doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
    }

    public static void LearnSkill(Player player, int skillNumber, int skillSlot) {
        String input;
        if (player.getChosenSkill1() != skillNumber && player.getChosenSkill2() != skillNumber && player.getChosenSkill3() != skillNumber &&
                player.getChosenSkill4() != skillNumber && player.getChosenSkill5() != skillNumber && player.getChosenSkill6() != skillNumber
                && player.getChosenSkill7() != skillNumber && player.getChosenSkill8() != skillNumber && player.getChosenSkill9() != skillNumber
                && player.getChosenSkill10() != skillNumber) {
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
            } else if (skillSlot == 6) {
                player.setChosenSkill6(skillNumber);
            } else if (skillSlot == 7) {
                player.setChosenSkill7(skillNumber);
            } else if (skillSlot == 8) {
                player.setChosenSkill8(skillNumber);
            } else if (skillSlot == 9) {
                player.setChosenSkill9(skillNumber);
            } else if (skillSlot == 10) {
                player.setChosenSkill10(skillNumber);
            }
            lvlupInput = "0";
        } else {
            System.out.println("Umiesz już ten czar");
        }


    }

    public static void LevelUp(Player player, int skillSlot, int nextLevel) {

        do {
            Scanner scanner = new Scanner(System.in);
            PrintSkill(Player.ICE, player, iceDescription);
            PrintSkill(Player.FIREBALL, player, fireDescription);
            PrintSkill(Player.TP, player, tpDescription);
            PrintSkill(Player.ADRENALINE, player, adrenalineDescription);
            PrintSkill(Player.IRONSKIN, player, ironskinDescription);
            PrintSkill(Player.HEAL, player, healDescription);
            if (player.getWeaponCapacity() < 2){
                System.out.println("6. Dual Wielding (Możesz używać dwóch lekkich broni naraz)");
            }
            PrintSkill(Player.CLEAVE, player, cleaveDescription);
            PrintSkill(Player.HEAL, player, healDescription);

        /*    System.out.println("Wybierz czar którego chcesz się nauczyć: ");
            System.out.println("1. Lodowy pocisk (zamraża przeciwnika na 2 tury, 20p many)");
            System.out.println("2. Kula ognia (zadaje 120 obrażeń, 50p many)");
            System.out.println("3. Teleportacja (przenieś się na dowolne pole, darmowe)");
            System.out.println("4. Adrenalina (Zadajesz i przyjmujesz więcej obrażeń)");
            System.out.println("5. Skóra z żelaza (+30 armor w trakcie walki)");

            System.out.println("7. Cleave (Atakujesz 2 potwory naraz ze zwiększoną siłą) NIE DODANY");*/
            lvlupInput = scanner.nextLine();
            switch (lvlupInput) {
                case "1":
                    LearnSkill(player, Player.ICE, skillSlot);
                    break;
                case "2":
                    LearnSkill(player, Player.FIREBALL, skillSlot);
                    break;
                case "3":
                    LearnSkill(player, Player.TP, skillSlot);
                    break;
                case "4":
                    LearnSkill(player, Player.ADRENALINE, skillSlot);
                    break;
                case "5":
                    LearnSkill(player, Player.IRONSKIN, skillSlot);
                    break;
                case "6":
                    player.DualWield(player);
                    lvlupInput = "0";
                    break;
                case "7":
                    LearnSkill(player, Player.CLEAVE, skillSlot);
                    break;
                case "8":
                    LearnSkill(player, Player.HEAL, skillSlot);
            }
        } while (!lvlupInput.equals("0"));
        System.out.println("Nauczyłeś się nowej umiejętności!");
        player.setLevel(nextLevel);

    }

    public static void addPointsAndPrint(Player player, int cap, int hpUP, int dmgUP, int manaUP) {
        player.setMaxHP(player.getMaxHP() + hpUP);
        player.setHP(player.getMaxHP());
        player.setDMG(player.getDMG() + dmgUP);
        player.setXP(player.getXP() - cap);
        System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
        System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(), player.getMaxHP());
        System.out.println("Twoje nowe obrażenia: " + player.getDMG());
        player.setAttributePoints(player.getAttributePoints() + 5);
        System.out.println("Otrzymałeś też " + player.getAttributePoints() + " punktów umiejętności");

        player.setMaxMana(player.getMaxMana() + manaUP);
        player.setMana(player.getMaxMana());
    }

    public static void ExpDisplay(Player player, int cap){
        System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                "/" + cap + " punktów doświadczenia");
        System.out.println("Złoto: " + player.getGold());
    }

    public static void PrintSkill(int skillNumber, Player player, String description){
        if (player.getChosenSkill1() != skillNumber && player.getChosenSkill2() != skillNumber && player.getChosenSkill3() != skillNumber &&
                player.getChosenSkill4() != skillNumber && player.getChosenSkill5() != skillNumber && player.getChosenSkill6() != skillNumber
                && player.getChosenSkill7() != skillNumber && player.getChosenSkill8() != skillNumber && player.getChosenSkill9() != skillNumber
                && player.getChosenSkill10() != skillNumber){
            System.out.println(description);
        }
    }

}


