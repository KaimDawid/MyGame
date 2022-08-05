package Mobs.Classes;

import Mobs.Monster;
import Mobs.Player;

import java.util.Random;
import java.util.Scanner;

public class Mage extends Player {
    public Mage(double HP, double maxHP, int DMG, int XP, int level, int x, int y, int gold, int bombNumber, int potionNumber, int armor, int mana) {
        super(HP, maxHP, DMG, XP, level, x, y, gold, bombNumber, potionNumber, armor);


    }int mana;
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double missRoll = (20 - (player.getLevel() * 3) + (monster.getLevel() * 3));
        double roll = random.nextDouble(100);
        if ( roll > missRoll){
            monster.setHp(monster.getHp() - (player.getDMG() * 0.8));
        }
        else if (roll < missRoll){
            System.out.println("Chybiłeś!");
        }


    }
    public void Fireball(Monster monster, Player player){
        mana = mana - 30;
        monster.setHp(monster.getHp() - (player.getDMG() * 1.6));
        System.out.println("Rzuciłeś kulą ognia za "+ player.getDMG() * 1.6 + " obrażeń");
    }

    public void Teleport(Player player){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz gdzie chcesz się przeteleportować.");
        System.out.println("X :");
        int inputX = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Y: ");
        int inputY = scanner.nextInt();
        scanner.nextLine();
        player.setX(inputX);
        player.setY(inputY);
        System.out.println("Twoje nowe koordynaty to: " + inputX + "," + inputY);

    }
}
