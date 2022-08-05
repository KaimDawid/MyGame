package Mobs;

import Objects.Items.Helmets.DrakeHelmet;
import Objects.Items.Item;
import Objects.Items.Helmets.LeatherHelmet;
import Objects.Items.Weapons.Dagger;

import java.util.Random;

public abstract class Monster {
    public double hp;
    public int dmg;
    public double x;
    public double y;
    public String name;
    public int giveXP;
    double level;
    public static int number = 0;
    public static Item eqNumber[] = new Item[100];
    public void drop(){


        Random random = new Random();
        double drop = random.nextDouble(100);
        if (drop<31){
            eqNumber[number] = new DrakeHelmet(1);
            number++;
            System.out.println("Znalazłeś Smoczy hełm!");
        }
        else if (drop>69){
            eqNumber[number] = new LeatherHelmet(1);
            number++;
            System.out.println("Znalazłeś skórzany hełm!");
        }
        else if (drop>30 && drop< 70){
            eqNumber[number] = new Dagger(1);
            number++;
            System.out.println("Znalazłeś sztylet!");
        }
    }


    public Monster(int hp, int dmg, double x, double y, String name, int giveXP, double level) {
        this.hp = hp;
        this.dmg = dmg;
        this.x = x;
        this.y = y;
        this.name = name;
        this.giveXP = giveXP;
    /*    this.gold = gold;*/
    }



    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGiveXP() {
        return giveXP;
    }

    public void setGiveXP(int giveXP) {
        this.giveXP = giveXP;
    }

abstract public int getGold();
    abstract public void setGold();

    public double getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public abstract void setGold(int gold);
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            System.out.println("Przeciwnik zadał cios krytyczny za "+ monster.getDmg()*1.2 + " punktów obrażeń!");
        }
        else if (roll < 81 && roll > missRoll){
            player.setHP(player.getHP() - monster.getDmg() + player.getArmor());
        }
        else if (roll < missRoll){
            System.out.println("Przeciwnik chybił!");
        }
    }
}

