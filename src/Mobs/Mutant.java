package Mobs;

import java.util.Random;

public class Mutant extends Monster{
    int gold;
    public Mutant(int hp, int dmg, double x, double y, String name, int giveXP, int gold, double level, int floor) {
        super(hp, dmg, x, y, name, giveXP, level, floor);
        this.gold = gold;

    }

    int activeSkill;



    public int getActiveSkill() {
        return activeSkill;
    }

    public void setActiveSkill(int activeSkill) {
        this.activeSkill = activeSkill;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold() {

    }
    int poisonInvulnerability = 1;
    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }


    public void Freeze(Player target){
        double iceDMG = 25;

            System.out.println("Zostałeś zamrożony na 2 tury i otrzymałeś " + iceDMG + " obrażeń!");
            target.setHP(target.getHP() - 25);
            target.setFreeze(1);


    }
    public void Fireball(Monster monster, Player player){
        double fireDMG = 80;

            player.setHP(player.getHP() - fireDMG);
            System.out.println("Mutant skopiował Twój czar i rzucił w Ciebie kulą ognia za " + fireDMG + " obrażeń!");


    }

    void SkillSteal(Monster mutant, Player player){
        if (player.getChosenSkill3() != 0){
            activeSkill = player.getChosenSkill3();
        }
        else {
            if (player.getChosenSkill2() != 0) {
                activeSkill = player.getChosenSkill2();
            }
            else {
                activeSkill = player.getChosenSkill1();
            }
        }
    }

    public void Attack(Monster monster, Player player){

        Random random = new Random();
        double roll = random.nextDouble(100);
        double missRoll = (20 - (monster.getLevel() * 3) + (player.getLevel() * 3));
        if (roll > 80){
            int skillSteal = random.nextInt(30);

            if (skillSteal < 11) {
                activeSkill = player.getChosenSkill1();
            }
            else if (skillSteal > 10 && skillSteal < 21){
                if (player.getChosenSkill2() != 0) {
                    activeSkill = player.getChosenSkill2();
                }
                else {
                    activeSkill = player.getChosenSkill1();
                }
            }
            else if (skillSteal > 20) {
                SkillSteal(monster, player);

            }
            if (activeSkill == Player.ICE){
                Freeze(player);
            }

            else if (activeSkill == Player.FIREBALL){
                Fireball(monster, player);
            }
            else if (activeSkill == Player.TP){
                player.setHP(player.getHP() - (monster.getDmg() * 1.4));
                System.out.println("Mutant ukradł Twoją umiejętność teleportu, przeniósł się za Ciebie i zadał " +
                        (monster.getDmg() * 1.4) + " obrażeń!");
            }
            else {
                System.out.println("Mutant próbował ukraść Twoją umiejętność, ale mu się nie udało");
            }

        }
        else if (roll < 81 && roll > missRoll){
            int dmgRoll = (random.nextInt(20) + monster.getDmg() - 10);
            System.out.println("Mutant uderzył Cię za " + (dmgRoll - player.getArmor()) + " obrażeń!");
            player.setHP(player.getHP() - dmgRoll + player.getArmor());
        }
        else if (roll < missRoll){
            System.out.println("Mutant chybił!");
        }

    }

}
