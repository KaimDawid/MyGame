package Logic;

import Mobs.Goblin;
import Mobs.Monster;
import Mobs.Player;
import Objects.Shop.Shop;

import java.util.Random;
import java.util.Scanner;

public class Test {

    //
    // Klasa zawiera wszystkie metody odpowiedzialne za wydarzenia.
    // Wydarzenia są przeważnie triggerowane przez ustawienie pozycji gracza
    // na pozycji obiektu (Potwora, sklepu)
    //

    Scanner scanner = new Scanner(System.in);
    public static void checker(Player player, Monster monster) {
        if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
            Fight.Turn(player, monster);
        }
    }

    public static void store(Player player, Shop shop){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Przy drodze znajduje się sklep, czy chcesz do niego wejść? ");
        System.out.println("Y - tak");
        System.out.println("Dowolny przycisk - pomiń sklep");
        String input2 = scanner.nextLine();
        switch (input2) {
            case "Y":
                shop.purchase(player);
                input2 = "0";
            default:
                System.out.println("Powodzenia w dalszej podróży!");
        }
    }
    public static void PlayerInfo(Player player){

        System.out.println();
        System.out.println("Statystyki: ");
        System.out.println();
        System.out.printf("Punkty życia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
        System.out.println("Punkty obrażeń: " + player.getDMG());
        System.out.printf("Poziom: %.0f%n", player.getLevel());
        /*System.out.println("Poziom: " + player.getLevel());*/
        System.out.println("Doświadczenie: " + player.getXP());
        if (player.getPotionNumber()>0){
            System.out.println("Eliksiry: " + player.getPotionNumber());}
        System.out.println("Zbroja: " + player.getArmor());
        if (player.getBombNumber()>0){
            System.out.println("Bomby: " + player.getBombNumber());}
        System.out.println("Złoto: " + player.getGold());
    }

}
