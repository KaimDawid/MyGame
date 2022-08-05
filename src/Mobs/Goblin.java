package Mobs;


import java.util.Random;

public class Goblin extends Monster {

int gold;


    public Goblin(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level) {
        super(hp, dmg, x, y, name, giveXP, level);
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
            System.out.println("Przeciwnik uderzył Cię za " + monster.getDmg() + " obrażeń");
        }
        else if (roll < missRoll){
            System.out.println("Przeciwnik chybił!");
        }
    }
}


