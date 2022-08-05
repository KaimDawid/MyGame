package Mobs;


import Logic.Fight;
import Logic.Status.Poison;

import java.util.Random;

public class Spider extends Monster {

    public Spider(int hp, int dmg, double x, double y, String name, int giveXP, double level) {
        super(hp, dmg, x, y, name, giveXP, level);

    }

    @Override
    public int getGold() {
        return 0;
    }

    @Override
    public void setGold() {

    }

    public boolean isSpidey() {
        return spidey;
    }

    public void setSpidey(boolean spidey) {
        this.spidey = spidey;
    }
    int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    boolean spidey = true;

    @Override
    public void setGold(int gold) {

    }
   /* public void Attack(Monster monster, Player player){
        Fight fight = new Fight();
        Random random = new Random();
        Poison poison = new Poison();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            setI(2);
            spidey = true;
            poison.poisoned(player);
            player.setHP(player.getHP() - (monster.getDmg()) + player.getArmor());
            System.out.println("Przeciwnik zatruł Cię na 2 tury za "+ 20 + " punktów obrażeń!");

        }
        else if (roll < 81 && roll > missRoll){
            player.setHP(player.getHP() - monster.getDmg() + player.getArmor());
            System.out.println("Przeciwnik uderzył Cię za " + monster.getDmg() + " obrażeń");
        }
        else if (roll < missRoll){
            System.out.println("Przeciwnik chybił!");
        }s
    }*/
   public void Attack(Monster monster, Player player){
       Random random = new Random();
       double roll = random.nextDouble(100);
       double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
       if (roll > 80){
           player.setPoison(2);
           player.setHP(player.getHP() - monster.getDmg() + player.getArmor());
           System.out.println("Przeciwnik Cię zatruł za 20 obrażeń i zadał " + monster.getDmg() + " obrażeń!");
       }
       else if (roll < 81 && roll > missRoll){
           System.out.println("Otrzymałeś " + monster.getDmg() + " obrażeń");
           player.setHP(player.getHP() - monster.getDmg() + player.getArmor());
       }
       else if (roll < missRoll){
           System.out.println("Przeciwnik chybił!");
       }
   }


}

