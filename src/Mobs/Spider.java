package Mobs;


import Logic.Drop.Miscelanous;
import Logic.Status.Status;

import java.util.Random;

public class Spider extends Monster {

    public Spider(int hp, int dmg, double x, double y, String name, int giveXP, double level, int floor) {
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
    public void Drop(){
    Random random = new Random();
    int sackChance = random.nextInt(100);
    if (sackChance > 10){
        int sackNumber = (random.nextInt(2)+ 1);
        Miscelanous.poisonSacks = Miscelanous.poisonSacks + sackNumber;
        System.out.println("Znalazłeś " + sackNumber + " worków z jadem, masz ich już " + Miscelanous.poisonSacks + "/6");
    }
    dropNeck();
        dropWeapon();
        dropGloves();
        dropArmor();
        dropHelmet();

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
           Status.POISON(player, monster);
       }
       else if (roll < 81 && roll > missRoll){
           int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
           System.out.println("Pająk ukąsił Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
           player.setHP(player.getHP() -dmgRoll + player.getArmor());
       }
       else if (roll < missRoll){
           System.out.println("Pająk chybił!");
       }
   }


}

