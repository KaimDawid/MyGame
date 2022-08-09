package Mobs;

import java.util.Random;
import java.util.Scanner;

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
            double adrenalineAttackValue = (player.getDMG() * 1.5);
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

    public int getAttributePoints() {
        return attributePoints;
    }

    public void setAttributePoints(int attributePoints) {
        this.attributePoints = attributePoints;
    }

    int escapeInvulnerability = 0;

    public int getEscapeInvulnerability() {
        return escapeInvulnerability;
    }

    public void setEscapeInvulnerability(int escapeInvulnerability) {
        this.escapeInvulnerability = escapeInvulnerability;
    }

    public int getIronSkinValue() {
        return ironSkinValue;
    }

    public void setIronSkinValue(int ironSkinValue) {
        this.ironSkinValue = ironSkinValue;
    }

    public int getAdrenalineValue() {
        return adrenalineValue;
    }

    public void setAdrenalineValue(int adrenalineValue) {
        this.adrenalineValue = adrenalineValue;
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

    public int getFreeze() {
        return freeze;
    }

    public void setFreeze(int freeze) {
        this.freeze = freeze;
    }

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

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
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
    public int getBurn() {
        return burn;
    }

    public void setBurn(int burn) {
        this.burn = burn;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    public double getManaRegen() {
        return manaRegen;
    }

    public void setManaRegen(double manaRegen) {
        this.manaRegen = manaRegen;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public int getWeaponCapacity() {
        return weaponCapacity;
    }

    public void setWeaponCapacity(int weaponCapacity) {
        this.weaponCapacity = weaponCapacity;
    }

}
