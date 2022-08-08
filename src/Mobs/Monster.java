package Mobs;

import Logic.Drop.Drop;
import Logic.GameLogic;
import Objects.Items.Chests.MailShirt;
import Objects.Items.Hands.BasiliskGloves;
import Objects.Items.Helmets.DrakeHelmet;
import Objects.Items.Item;
import Objects.Items.Helmets.LeatherHelmet;
import Objects.Items.Necklaces.PearlNecklace;
import Objects.Items.Weapons.Dagger;

import java.util.Random;

public abstract class Monster {
    public double hp;
    public int dmg;
    public double x;
    public double y;
    public String name;
    int freeze = 0;

    public int getFreeze() {
        return freeze;
    }

    public void setFreeze(int freeze) {
        this.freeze = freeze;
    }

    public int giveXP;
    double level;
    public static int number = 0;
    public static Item eqNumber[] = new Item[100];
    public static int helmEQ;
    public static int handsEQ;
    public static int chestEQ;
    public static int neckEQ;
    public static int weaponEQ;


    int floor;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void drop(){


        Random random = new Random();
       /* double drop = random.nextDouble(100);
        if (drop<11) {*/
            double dropArmor = random.nextDouble(100);
            if (dropArmor <100) {
                Drop.dropArmor();
            }
            double dropNeck = random.nextDouble(100);
            if (dropNeck <100) {
                Drop.dropNeck();
            }
            double dropWeapon = random.nextDouble(100);
            if (dropWeapon <100) {
                Drop.dropWeapon();
            }
            double dropGloves = random.nextDouble(100);
            if (dropGloves <100) {
                Drop.dropGloves();
            }
            double dropHelmet = random.nextDouble(100);
            if (dropHelmet <100) {
                Drop.dropHelmet();
            }
        /*}*/
    }


    public Monster(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
        this.hp = hp;
        this.dmg = dmg;
        this.x = x;
        this.y = y;
        this.name = name;
        this.giveXP = giveXP;
        this.floor = floor;
    /*    this.gold = gold;*/
    }

    int armor;

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
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

