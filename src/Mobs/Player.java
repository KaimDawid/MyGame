package Mobs;

import java.util.Random;

public class Player {
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

    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double missRoll = (20 - (player.getLevel() * 3) + (monster.getLevel() * 3));
        double roll = random.nextDouble(100);
        if (roll > 80){
            monster.setHp(monster.getHp() - (player.getDMG() * 1.2));
            System.out.println("Zadałeś cios krytyczny za "+ player.getDMG()*1.2 + " punktów obrażeń!");
        }
        else if (roll < 81 && roll > missRoll){
            monster.setHp(monster.getHp() - player.getDMG());
        }
        else if (roll < missRoll){
            System.out.println("Chybiłeś!");
        }
    }
}
