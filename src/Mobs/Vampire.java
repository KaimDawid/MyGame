package Mobs;

import java.util.Random;

public class Vampire extends Monster {

    int gold;
    double level;


    public Vampire(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
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

    @Override
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            player.setHP(player.getHP() - monster.getDmg());
            monster.setHp(monster.getHp() + (monster.getDmg() * 0.4));
            System.out.println("Wampir uderzył Cię za " + (monster.getDmg() - player.getArmor()) + " obrażeń i uleczył się za "
                    + (monster.getDmg()*0.4) + " obrażeń");
        }
        else if (roll < 81 && roll > missRoll){
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("Wampir uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
        }
        else if (roll < missRoll){
            System.out.println("Wampir chybił!");
        }
    }
}



