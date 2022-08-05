package Objects.Shop;

import Mobs.Player;

import java.util.Scanner;

public class Shop {
    int X;
    int Y;

    public Shop(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public static void purchase(Player player) {
        Scanner scanner = new Scanner(System.in);

        int bombPrice = 25;
        int potionPrice = 40;
int armorPrice = 50;
int redRingPrice = 30;
int greenRingPrice = 30;
String input = "100";
int bombStock = 3;
int potionStock = 2;
int armorStock = 1;
int redRingStock = 1;
int greenRingStock = 1;
        System.out.println("Witaj w sklepie, wybierz towar który chcesz kupić");
        System.out.println("1. Bomba: " + bombPrice + " sztuk złota (80 obrażeń w walce)");
        System.out.println("2. Eliksir zdrowia: " + potionPrice + " sztuk złota (+ 100 punktów życia w walce)");
        System.out.println("3. Podkowa: " + armorPrice + " sztuk złota (negacja 15 punktów obrażeń");
        System.out.println("4. Czerwony pierścień (+15 obrażeń): " + redRingPrice + " sztuk złota");
        System.out.println("5. Zielony pierścień (+20 życia): " + greenRingPrice + " sztuk złota");
do {
    System.out.println("Dostępne towary: wpisz 9");
    System.out.println("Wyjdź: wpisz 0");
    input = scanner.nextLine().toUpperCase();
    switch (input) {
        case "1":
            if (bombStock > 0) {
                if (player.getGold() > bombPrice) {
                    player.setGold(player.getGold() - bombPrice);
                    player.setBombNumber(player.getBombNumber() + 1);
                    bombStock = (bombStock - 1);
                    System.out.println("Zakupiłeś bombę, masz ich teraz: " + player.getBombNumber());
                } else {
                    System.out.println("Nie masz wystarczająco pieniędzy.");
                }
            }
            else {
                System.out.println("Towar się skończył, wybierz sobie coś innego");}
            break;
        case "2":
            if (potionStock > 0) {
                if (player.getGold() > potionPrice) {
                    player.setGold(player.getGold() - potionPrice);
                    player.setPotionNumber(player.getPotionNumber() + 1);
                    potionStock = (potionStock - 1);
                    System.out.println("Zakupiłeś eliksir zdrowia, masz ich teraz: " + player.getPotionNumber());
                } else {
                    System.out.println("Nie masz wystarczająco pieniędzy");
                }
            }    else {
                System.out.println("Towar się skończył, wybierz sobie coś innego");}
            break;
        case "3":
            if (armorStock > 0) {
                if (player.getGold() > armorPrice) {
                    player.setGold(player.getGold() - armorPrice);
                    player.setArmor(player.getArmor() + 15);
                    armorStock = (armorStock - 1);
                    System.out.println("Zakupiłeś podkowę, negujesz od teraz: " + player.getArmor() + " obrażeń");
                } else {
                    System.out.println("Nie masz wystarczająco pieniędzy");
                }
            }    else {
                System.out.println("Towar się skończył, wybierz sobie coś innego");}
            break;
        case "4":
            if (redRingStock > 0) {
                if (player.getGold() > redRingPrice) {
                    player.setGold(player.getGold() - redRingPrice);
                    player.setDMG(player.getDMG() + 15);
                    redRingStock = (redRingStock - 1);
                    System.out.println("Zakupiłeś czerwony pierścień, dostajesz + 15 do obrażeń ");
                } else {
                    System.out.println("Nie masz wystarczająco pieniędzy");
                }
            }    else {
                System.out.println("Towar się skończył, wybierz sobie coś innego");}
            break;
        case "5":
            if (greenRingStock > 0) {
                if (player.getGold() > greenRingPrice) {
                    player.setGold(player.getGold() - greenRingPrice);
                    player.setHP(player.getHP() + 20);
                    player.setMaxHP(player.getHP() + 20);
                    greenRingStock = (greenRingStock - 1);
                    System.out.println("Zakupiłeś zielony pierścień, dostajesz + 20 do zdrowia ");
                } else {
                    System.out.println("Nie masz wystarczająco pieniędzy");
                }
            }    else {
                System.out.println("Towar się skończył, wybierz sobie coś innego");}
            break;
        case "9":
            System.out.println("1. Bomba: " + bombPrice + " sztuk złota (80 obrażeń w walce)");
            System.out.println("2. Eliksir zdrowia: " + potionPrice + " sztuk złota (+ 100 punktów życia w walce)");
            System.out.println("3. Zbroja: " + armorPrice + " sztuk złota (negacja 15 punktów obrażeń");
            System.out.println("4. Czerwony pierścień (+15 obrażeń): " + redRingPrice + " sztuk złota");
            System.out.println("5. Zielony pierścień (+20 życia): " + greenRingPrice + " sztuk złota");
            break;
        default:
            input = "0";
    }
} while (!input.equals("0"));
    }
}
