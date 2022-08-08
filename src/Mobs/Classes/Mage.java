package Mobs.Classes;

import Mobs.Monster;
import Mobs.Player;

import java.util.Random;
import java.util.Scanner;

public class Mage extends Player {
    public Mage(double HP, double maxHP, int DMG, int XP, int level, int x, int y, int gold, int bombNumber, int potionNumber, int armor, int mana) {
        super(HP, maxHP, DMG, XP, level, x, y, gold, bombNumber, potionNumber, armor);


    }

    double mana;
    int classNumber = 1;
    public int chosenSkill1;
    public int chosenSkill2;
    public int chosenSkill3;
    public int chosenSkill4;
    public int chosenSkill5;

    @Override
    public int getChosenSkill1() {
        return chosenSkill1;
    }

    @Override
    public void setChosenSkill1(int chosenSkill1) {
        this.chosenSkill1 = chosenSkill1;
    }

    @Override
    public int getChosenSkill2() {
        return chosenSkill2;
    }

    @Override
    public void setChosenSkill2(int chosenSkill2) {
        this.chosenSkill2 = chosenSkill2;
    }

    @Override
    public int getChosenSkill3() {
        return chosenSkill3;
    }

    @Override
    public void setChosenSkill3(int chosenSkill3) {
        this.chosenSkill3 = chosenSkill3;
    }

    @Override
    public int getChosenSkill4() {
        return chosenSkill4;
    }

    @Override
    public void setChosenSkill4(int chosenSkill4) {
        this.chosenSkill4 = chosenSkill4;
    }

    @Override
    public int getChosenSkill5() {
        return chosenSkill5;
    }

    @Override
    public void setChosenSkill5(int chosenSkill5) {
        this.chosenSkill5 = chosenSkill5;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    @Override
    public int getClassNumber() {
        return classNumber;
    }

    @Override
    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

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
    @Override
    public void Fireball(Monster monster, Player player){
        mana = mana - 30;
        monster.setHp(monster.getHp() - (player.getDMG() * 1.6));
        System.out.println("Rzuciłeś kulą ognia za "+ player.getDMG() * 1.6 + " obrażeń");
    }

    @Override
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
@Override
    public void Freeze(Monster target){
        System.out.println(target.getName() + " został zamrożony na 2 tury");
        target.setFreeze(2);
    }
}
