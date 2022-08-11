package Mobs;

import Logic.Drop.Miscelanous;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter @Setter
public class Bandit extends Monster{
    int gold;


    public Bandit(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
        this.gold = gold;

    }

    @Override
    public void Drop(){



            Miscelanous.banditsKilled++;
            System.out.println("Udało Ci się zgładzić bandytę, zabiłeś ich już " + Miscelanous.banditsKilled + "/" + Miscelanous.bkRequirement);

        dropNeck();
        dropWeapon();
        dropGloves();
        dropArmor();
        dropHelmet();

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
        if (roll > 80) {
            double critHit = (random.nextInt(20) + monster.getDmg()*1.2);
            player.setHP(player.getHP() - critHit + player.getArmor());
            double critHit2 = (random.nextInt(20) + monster.getDmg()*1.2);
            player.setHP(player.getHP() - critHit + player.getArmor());
            System.out.println("Bandyta dźgnął Cię sztyletem dwukrotnie i zadał cios krytyczny za " + critHit + " i " + critHit2 + " punktów obrażeń!");
        } else if (roll < 81 && roll > missRoll) {
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() -dmgRoll + player.getArmor());
            int dmgRoll2 = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() -dmgRoll + player.getArmor());
            System.out.println("Bandyta dźgnął Cię sztyletem dwukrotnie za " + (dmgRoll - player.getArmor()) + " i " + (dmgRoll2 - player.getArmor())  + " obrażeń");
        } else if (roll < missRoll) {
            System.out.println("Bandyta chybił!");
        }
    }
}
