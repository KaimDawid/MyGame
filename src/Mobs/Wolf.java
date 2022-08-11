package Mobs;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter @Setter
public class Wolf extends Monster{
    int gold;
    public Wolf(int hp, int dmg, double x, double y, String name, int giveXP,int gold, double level, int floor) {
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

    }
    public void Attack(Monster monster, Player player){
        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            player.setHP(player.getHP() - (monster.getDmg() * 1.2) + player.getArmor());
            System.out.println("Wilk zadał Ci głęboką ranę "+ (monster.getDmg()*1.2 - player.getArmor()) + " punktów obrażeń!");
        }
        else if (roll < 81 && roll > missRoll){
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
            System.out.println("Wilołak ugryzł Cię za " + (dmgRoll - player.getArmor()) + " obrażeń");
        }
        else if (roll < missRoll){
            System.out.println("Wilk chybił!");
        }
    }
}
