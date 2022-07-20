package Mobs;

import java.util.Random;

public class Vampire extends Monster {

    int gold;
    double level;


    public Vampire(int hp, int dmg, int x, int y, String name, int giveXP, int gold, double level) {
        super(hp, dmg, x, y, name, giveXP, level);
        this.gold = gold;

    }

    @Override
    public int getGold() {
        return gold;
    }
    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }
    @Override
    public void setGold() {

    }

    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }

    public void attack(Monster monster, Player player){
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            player.setHP(player.getHP() - monster.getDmg());
            monster.setHp(monster.getHp() + (monster.getDmg() * 0.4));
            System.out.println("Wampir uleczył się za " + (monster.getDmg()*0.4) + " obrażeń");
        }
        else if (roll < 81 && roll > missRoll){
            player.setHP(player.getHP() - monster.getDmg());
        }
        else if (roll < missRoll){
            System.out.println("Przeciwnik chybił!");
        }
    }
}



