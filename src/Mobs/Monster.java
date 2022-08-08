package Mobs;

import Logic.Drop.Drop;
import Logic.GameLogic;
import Objects.Items.Chests.*;
import Objects.Items.Hands.*;
import Objects.Items.Helmets.*;
import Objects.Items.Item;
import Objects.Items.Necklaces.CopperNecklace;
import Objects.Items.Necklaces.PearlNecklace;
import Objects.Items.Necklaces.SilverNecklace;
import Objects.Items.Weapons.*;

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

    int poisonInvulnerability;

    int fireInvulnerability;

    int iceInvulnerability;

    int waterInvulnerability;

    int shockInvulnerability;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public int getPoisonInvulnerability() {
        return poisonInvulnerability;
    }

    public void setPoisonInvulnerability(int poisonInvulnerability) {
        this.poisonInvulnerability = poisonInvulnerability;
    }

    public int getFireInvulnerability() {
        return fireInvulnerability;
    }

    public void setFireInvulnerability(int fireInvulnerability) {
        this.fireInvulnerability = fireInvulnerability;
    }

    public int getIceInvulnerability() {
        return iceInvulnerability;
    }

    public void setIceInvulnerability(int iceInvulnerability) {
        this.iceInvulnerability = iceInvulnerability;
    }

    public int getWaterInvulnerability() {
        return waterInvulnerability;
    }

    public void setWaterInvulnerability(int waterInvulnerability) {
        this.waterInvulnerability = waterInvulnerability;
    }

    public int getShockInvulnerability() {
        return shockInvulnerability;
    }

    public void setShockInvulnerability(int shockInvulnerability) {
        this.shockInvulnerability = shockInvulnerability;
    }

    int floor;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void Drop(){

        Drop.dropNeck();
        Drop.dropWeapon();
        Drop.dropGloves();
        Drop.dropArmor();
        Drop.dropHelmet();

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

    public static void dropHelmet(){
        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 85) {

            int helmetRandomize = random.nextInt(100);

            if (helmetRandomize < 16) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new DrakeHelmet(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "! ");
            } else if (helmetRandomize > 15 && helmetRandomize < 26) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new JewelledCrown(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (helmetRandomize > 25 && helmetRandomize < 51) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new LeatherHelmet(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (helmetRandomize > 50 && helmetRandomize < 81) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new PlateHelmet(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (helmetRandomize > 80) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new MageHat(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            }
        }
    }

    public static void dropArmor(){
        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 85) {
            int armorRandomize = random.nextInt(100);

            if (armorRandomize < 16) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new DrakeArmor(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (armorRandomize > 15 && armorRandomize < 26) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new MailShirt(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (armorRandomize > 25 && armorRandomize < 51) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new LeatherArmor(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (armorRandomize > 50 && armorRandomize < 81) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new PlateArmor(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (armorRandomize > 80) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new ClothRobe(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            }
        }
    }

    public static void dropGloves(){
        Random random = new Random();

        int dropChance = random.nextInt(100);

        if (dropChance > 85) {
            int glovesRandomize = random.nextInt(100);

            if (glovesRandomize < 16) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new BasiliskGloves(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (glovesRandomize > 15 && glovesRandomize < 26) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new JewelledGloves(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (glovesRandomize > 25 && glovesRandomize < 51) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new LeatherGloves(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (glovesRandomize > 50 && glovesRandomize < 81) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new PlateGloves(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (glovesRandomize > 80) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new ClothGloves(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            }
        }
    }

    public static void dropWeapon(){

        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 85) {
            int weaponRandomize = random.nextInt(100);

            if (weaponRandomize < 16) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Katana(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (weaponRandomize > 15 && weaponRandomize < 26) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new BastardSword(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (weaponRandomize > 25 && weaponRandomize < 51) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Dagger(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (weaponRandomize > 50 && weaponRandomize < 81) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new SwordAndShield(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (weaponRandomize > 80) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new NoviceStaff(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            }

        }
    }


    public static void dropNeck() {
        Random random = new Random();
        int dropChance = random.nextInt(100);

        if (dropChance > 85) {
            int neckRandomize = random.nextInt(100);

            if (neckRandomize < 26) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new PearlNecklace(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (neckRandomize > 25 && neckRandomize < 71) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new CopperNecklace(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            } else if (neckRandomize > 70) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new SilverNecklace(1);
                System.out.println("Znalazłeś " + Monster.eqNumber[Monster.number].getName() + "!");
            }
        }
    }



}

