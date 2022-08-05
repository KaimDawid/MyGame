package Mobs;

import java.util.Random;
import java.util.Scanner;

public class Player {
    public static int ICE = 60;

    public final static int TP = 61;
    public final static int FIREBALL = 62;
 private double HP = 120;
 private double MaxHP = 120;
    int DMG = 20;
   public int XP = 0;

   public double level = 0;

   public int X;
   public int Y;

int gold;
int bombNumber;
int potionNumber;
int armor;
int poison;

int magic;
int classNumber;
int mana;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int chosenSkill1;
    public int chosenSkill2;
    public int chosenSkill3;
    public int chosenSkill4;
    public int chosenSkill5;

    public static int getICE() {
        return ICE;
    }

    public static void setICE(int ICE) {
        Player.ICE = ICE;
    }

    public int getChosenSkill1() {
        return chosenSkill1;
    }

    public void setChosenSkill1(int chosenSkill1) {
        this.chosenSkill1 = chosenSkill1;
    }

    public int getChosenSkill2() {
        return chosenSkill2;
    }

    public void setChosenSkill2(int chosenSkill2) {
        this.chosenSkill2 = chosenSkill2;
    }

    public int getChosenSkill3() {
        return chosenSkill3;
    }

    public void setChosenSkill3(int chosenSkill3) {
        this.chosenSkill3 = chosenSkill3;
    }

    public int getChosenSkill4() {
        return chosenSkill4;
    }

    public void setChosenSkill4(int chosenSkill4) {
        this.chosenSkill4 = chosenSkill4;
    }

    public int getChosenSkill5() {
        return chosenSkill5;
    }

    public void setChosenSkill5(int chosenSkill5) {
        this.chosenSkill5 = chosenSkill5;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    int critChance;

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getPotionNumber() {
        return potionNumber;
    }

    public void setPotionNumber(int potionNumber) {
        this.potionNumber = potionNumber;
    }

    public int getBombNumber() {
        return bombNumber;
    }

    public void setBombNumber(int bombNumber) {
        this.bombNumber = bombNumber;
    }

    public Player(double HP, double maxHP, int DMG, int XP, int level, int x, int y, int gold, int bombNumber, int potionNumber,
                  int armor) {
        this.HP = HP;
        MaxHP = maxHP;
        this.DMG = DMG;
        this.XP = XP;
        this.level = level;
        X = x;
        Y = y;
        this.gold = gold;
        this.bombNumber = bombNumber;
        this.potionNumber = potionNumber;
        this.armor = armor;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public double getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(double maxHP) {
        MaxHP = maxHP;
    }

    public int getDMG() {
        return DMG;
    }

    public void setDMG(int DMG) {
        this.DMG = DMG;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void Freeze(Monster target){
        System.out.println(target.getName() + " został zamrożony na 2 tury");
        target.setFreeze(2);
        mana = mana - 50;
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
    public void Fireball(Monster monster, Player player){
        mana = mana - 20;
        monster.setHp(monster.getHp() - (player.getDMG() * 1.6));
        System.out.println("Rzuciłeś kulą ognia za "+ player.getDMG() * 1.6 + " obrażeń");
    }
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double missRoll = (20 - (player.getLevel() * 3) + (monster.getLevel() * 3));
        double roll = random.nextDouble(100);
        double critRoll = (80 - player.getCritChance());
        if (roll > critRoll){
            monster.setHp(monster.getHp() - (player.getDMG() * 1.2));
            System.out.println("Zadałeś cios krytyczny za "+ player.getDMG()*1.2 + " punktów obrażeń!");
        }
        else if (roll < critRoll && roll > missRoll){
            monster.setHp(monster.getHp() - player.getDMG());
            System.out.println("Zadałeś " + player.getDMG() + " obrażeń");
        }
        else if (roll < missRoll){
            System.out.println("Chybiłeś!");
        }
    }
}
