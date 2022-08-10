package Mobs;

import Logic.Drop.Drop;
import Logic.GameLogic;
import Objects.Items.Chests.*;
import Objects.Items.Hands.*;
import Objects.Items.Helmets.*;
import Objects.Items.Item;
import Objects.Items.Necklaces.CopperNecklace;
import Objects.Items.Necklaces.Necklace;
import Objects.Items.Necklaces.PearlNecklace;
import Objects.Items.Necklaces.SilverNecklace;
import Objects.Items.Weapons.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.function.Function;

@Getter  @Setter
public abstract class Monster {
    public double hp;
    public int dmg;
    public double x;
    public double y;
    public String name;
    int freeze = 0;







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






    int floor;



    public void Drop(){

        dropNeck();
        dropWeapon();
        dropGloves();
        dropArmor();
        dropHelmet();

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
            if (player.getAdrenalineValue() == 1){
                player.setHP(player.getHP() - (monster.getDmg()*1.3));
            }
            else {
                player.setHP(player.getHP() - monster.getDmg() + player.getArmor());
            }
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

            if (helmetRandomize > 100) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new HeadPiece("Smoczy hełm [HEAD]", 30, 20, 3, 30, 1);
                System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (helmetRandomize > 15 && helmetRandomize < 26) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new HeadPiece("Hełm wysadzany diamentami [HEAD]", 50, 30, 5, 50, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (helmetRandomize > 25 && helmetRandomize < 51) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new HeadPiece("Skórzany hełm [HEAD]", 10, 20, 7, 0, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (helmetRandomize > 50 && helmetRandomize < 81) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new HeadPiece("Płytowy hełm [HEAD]", 50, 10, 0, 10, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (helmetRandomize > 80) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new HeadPiece("Kapelusz nowicjusza [HEAD]", 0, 10, 5, 60, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
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
                Monster.eqNumber[Monster.number] = new ChestArmor("Smocza zbroja [CHEST]", 40, 20, 3, 30, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (armorRandomize > 15 && armorRandomize < 26) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new ChestArmor("Smocza łuskowa [CHEST]", 30, 10, 0, 0, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (armorRandomize > 25 && armorRandomize < 51) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new ChestArmor("Skórzana zbroja [CHEST]", 10, 20, 7, 0, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (armorRandomize > 50 && armorRandomize < 81) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new ChestArmor("Zbroja płytowa [CHEST]", 50, 5, 3, 10, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (armorRandomize > 80) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new ChestArmor("Szata nowicjusza [CHEST]", 10, 10, 3, 50, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
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
                Monster.eqNumber[Monster.number] = new Gloves("Rękawice bazyliszka [GLOVES]", 20, 20, 3, 20, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (glovesRandomize > 15 && glovesRandomize < 26) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Gloves("Rękawice wysadzane diamentami [GLOVES]", 30, 25, 5, 30, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (glovesRandomize > 25 && glovesRandomize < 51) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Gloves("Skórzane rękawice [GLOVES]", 10, 15, 7, 0, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (glovesRandomize > 50 && glovesRandomize < 81) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Gloves("Płytowe rękawice [GLOVES]", 40, 7, 2, 10, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (glovesRandomize > 80) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Gloves("Rękawice nowicjusza [GLOVES]", 10, 5, 3, 40, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
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
                Monster.eqNumber[Monster.number] = new Weapon("Katana [WEAPON]", 0, 40, 7, 10, 1, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (weaponRandomize > 15 && weaponRandomize < 26) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Weapon("Miecz dwuręczny [WEAPON]", 0, 60, 3, 0, 2, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (weaponRandomize > 25 && weaponRandomize < 51) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Weapon("Sztylet [WEAPON]", 0, 20, 10, 0, 1, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (weaponRandomize > 50 && weaponRandomize < 81) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Weapon("Miecz i tarcza [WEAPON]", 40, 30, 3, 10, 2, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (weaponRandomize > 80) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Weapon("Laska nowicjusza [WEAPON]", 0, 5, 0, 80, 2, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
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
                Monster.eqNumber[Monster.number] = new Necklace("Perłowy naszyjnik [NECK]", 5, 5, 3, 40, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (neckRandomize > 25 && neckRandomize < 71) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Necklace("Miedziany naszyjnik [NECK]", 0, 5, 0, 10, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            } else if (neckRandomize > 70) {
                Monster.number++;
                Monster.eqNumber[Monster.number] = new Necklace("Srebrny naszyjnik [NECK]", 15, 5, 0, 30, 1);
                 System.out.println("Znalazłeś " + eqNumber[Monster.number].getShortName() + " (" + eqNumber[Monster.number].getHP() + " HP, "
                        + eqNumber[Monster.number].getDMG() + " DMG, " + eqNumber[Monster.number].getCrit() + "Crit, " + eqNumber[Monster.number].getMagic()
                        + " Mocy zaklęć) !");
            }
        }
    }



}

