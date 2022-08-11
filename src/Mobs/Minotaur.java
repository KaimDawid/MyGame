package Mobs;

import java.util.Random;

public class Minotaur extends  Monster{

    public Minotaur(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
    }

    @Override
    public int getGold() {
        return 0;
    }

    @Override
    public void setGold() {

    }

    @Override
    public void setGold(int gold) {

    }
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            System.out.println("Minotaur zadał cios krytyczny za "+ monster.getDmg()*1.2 + " punktów obrażeń!");
        }
        else if (roll < 81 && roll > missRoll){
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll+ player.getArmor());
            System.out.println("Minotaur uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
        }
        else if (roll < missRoll){
            System.out.println("Minotaur chybił!");
        }
    }


}
