package Mobs;

import java.util.Random;

public class Skeleton extends Monster{

    int gold;

    int armor;
    
    int poisonInvulnerability = 1;
    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Skeleton(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
        this.gold = gold;

    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold() {

    }

    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }

    public void Attack(Monster monster, Player player) {
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        int armorUP = 20;
        if (roll > 80) {
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            System.out.println("Przeciwnik zadał cios krytyczny za " + monster.getDmg() * 1.2 + " punktów obrażeń!");
            System.out.println("Szkielet podniósł wartość swojej zbroi o " + armorUP + " punktów.");
        } else if (roll < 81 && roll > missRoll) {
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("Szkielet uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
        } else if (roll < missRoll) {
            System.out.println("Szkielet chybił!");
        }
    }

}
