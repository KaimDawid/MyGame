package Mobs;

import Logic.Numbers;
import Logic.Size;
import Logic.Skills;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.Scanner;

@Getter @Setter

public class Player {
    public static int ICE = 60;

    public final static int TP = 61;
    public final static int FIREBALL = 62;

    public final static int ADRENALINE = 63;

    public final static int IRONSKIN = 64;

    public final static int CLEAVE = 65;

    private double HP = 120;
    private double MaxHP = 120;
    int DMG = 20;
    public int XP = 0;

    public double level = 0;
    int escapeInvulnerability = 0;

    public int X;
    public int Y;

    int floor = 1;




    int gold;
    int bombNumber;
    int potionNumber;
    int armor;
    int poison;

    int burn;
    int maxMana = 100;

    int ironSkinValue = 0;
    int adrenalineValue = 0;



    int magic = 0;
    int classNumber;
    double mana;

    double manaRegen = 10;



    public int chosenSkill1 = 0;
    public int chosenSkill2 = 0;
    public int chosenSkill3 = 0;
    public int chosenSkill4 = 0;
    public int chosenSkill5 = 0;

    public int chosenSkill6 = 0;

    public int chosenSkill7 = 0;

    public int chosenSkill8 = 0;

    public int chosenSkill9 = 0;



    public int chosenSkill10 = 0;

    int attributePoints;

int weaponCapacity = 1;



    int freeze = 0;


    double critChance;


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


    public void DualWield(Player player){
        player.setWeaponCapacity(2);
    }

    public void Freeze(Monster target) {
        double iceDMG = 25 + (0.25 * magic);
        if (mana > 49) {
            System.out.println(target.getName() + " został zamrożony na 2 tury i otrzymał " + iceDMG + " obrażeń");
            target.setHp(target.getHp() - (DMG * 0.25));
            target.setFreeze(1);
            mana = mana - 50;
        } else {
            System.out.println("Masz za mało many!");
        }
    }

    public void Teleport(Player player) {
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

    public void Fireball(Monster monster, Player player) {
        double fireDMG = 80 + magic;
        if (mana > 19) {
            mana = mana - 30;
            monster.setHp(monster.getHp() - fireDMG);
            System.out.println("Rzuciłeś kulą ognia za " + fireDMG + " obrażeń");
        } else {
            System.out.println("Masz za mało many!");
        }
    }

    public void IronSkin(Player player) {
        String skillName = "Żelazna skóra";
        int ironSkinValue = 30;
        if (player.getIronSkinValue() == 0) {
            System.out.println("Użyłeś czaru " + skillName + " i otrzymałeś " + ironSkinValue + " punktów zbroi na 2 tury");
            player.setArmor(player.getArmor() + ironSkinValue);
            player.setIronSkinValue(1);
        }

    }


    public void Adrenaline(Player player) {

        String skillName = "Adrenalina";

        if (player.getAdrenalineValue() == 0) {
            double adrenalineAttackValue = (player.getDMG() + 60);
            double adrenalineArmorValue = (player.getArmor() - 40);

            player.setDMG((int) adrenalineAttackValue);
            player.setArmor((int) adrenalineArmorValue);

            System.out.println("Użyłeś umiejętności " + skillName + ", zadajesz 50% więcej obrażeń ale sam jesteś bardziej podatny na obrażenia");
            player.setAdrenalineValue(1);
        }

        // 29% w dół

    }

    public void Cleave(Player player, Monster monster, Monster monster2) {

        player.setDMG(player.getDMG() + 20);
        System.out.println("Bierzesz zamach i atakujesz obu wrogów naraz ze zwiększoną siłą");
        System.out.println("Zadajesz obu potworom " + player.getDMG() + " obrażeń");
        player.Attack(monster, player);
        player.Attack(monster2, player);
        player.setDMG(player.getDMG() - 20);


    }


    public void Attack(Monster monster, Player player) {
        Random random = new Random();
        double missRoll = (20 - (player.getLevel() * 3) + (monster.getLevel() * 3));
        double roll = random.nextDouble(100);
        double critRoll = (80 - player.getCritChance());
        if (roll > critRoll) {
            monster.setHp(monster.getHp() - (player.getDMG() * 1.2) + monster.getArmor());
            System.out.println("Zadałeś cios krytyczny za " + player.getDMG() * 1.2 + " punktów obrażeń!");
            if (monster.getArmor() > 0) {
                System.out.println("Potwór zanegował " + monster.getArmor() + " obrażeń");
            }
        } else if (roll < critRoll && roll > missRoll) {
            monster.setHp(monster.getHp() - player.getDMG() + monster.getArmor());
            System.out.println("Zadałeś " + player.getDMG() + " obrażeń");
            if (monster.getArmor() > 0) {
                System.out.println("Potwór zanegował " + monster.getArmor() + " obrażeń");
            }
        } else if (roll < missRoll) {
            System.out.println("Chybiłeś!");
        }
    }



}
