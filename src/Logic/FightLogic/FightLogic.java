package Logic.FightLogic;

import Logic.GameLogic;
import Mobs.Monster;
import Mobs.Player;

import java.util.Random;

import static Logic.FightLogic.Fight.PlayerStatusWearOff;

public class FightLogic {

    public static void ConcludeBattle(Player player, int doubleStrike, Monster monster1, int joined){
        if (doubleStrike == 1) {
            if (monster1.getHp() <= 0 && GameLogic.monsterBase[joined].getHp() <= 0) {
                System.out.println("Pokonałeś obu wrogów!");
                GameLogic.monsterBase[joined].setX(100);
                GameLogic.monsterBase[joined].setY(100);
                monster1.setX(100);
                monster1.setY(100);
                player.setXP(player.getXP() + monster1.getGiveXP() + GameLogic.monsterBase[joined].getGiveXP());
                GameLogic.monsterBase[joined].Drop();
                monster1.Drop();
                player.setGold(player.getGold() + monster1.getGold() + GameLogic.monsterBase[joined].getGold());
                joined = 1;
                doubleStrike = 0;
                PlayerStatusWearOff(player);
                Fight.escape = 1;

            }
        } else if (doubleStrike == 0) {
            if (monster1.getHp() <= 0) {
                System.out.println("Wygrałeś!");
                monster1.setX(100);
                monster1.setY(100);
                player.setXP(player.getXP() + monster1.getGiveXP());
                Random random = new Random();

                monster1.Drop();
                joined = 1;
                doubleStrike = 0;
                player.setGold(player.getGold() + monster1.getGold());
                PlayerStatusWearOff(player);
                Fight.escape = 1;

            }
        }

        if (player.getHP() < 1) {
            System.out.println("Twoje zdrowie spadło do 0");
            System.out.println("poległeś");
        }

    }
    public static void StatusConclude(Player player, Monster monster){
        int burnDMG = 40;
        if (player.getBurn() > 0) {
            System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
            player.setHP(player.getHP() - burnDMG);
            player.setBurn(player.getBurn() - 1);
        }
        if (player.getPoison() > 0) {
            int poisonDMG = 20;
            player.setHP(player.getHP() - poisonDMG);
            System.out.println("Otrzymałeś " + poisonDMG + " obrażeń od trucizny");
            player.setPoison(player.getPoison() - 1);
        }


        if (Fight.adrenalineDuration > 0){
            Fight.adrenalineDuration--;
        }
        if (Fight.ironSkinDuration > 0){
            Fight.ironSkinDuration--;
        }

    }

    public static void RestoreMana(Player player){
        if (player.getMana() < player.getMaxMana()) {

            player.setMana(player.getMana() + player.getManaRegen());
            double manaDiff = (player.getMana() - player.getMaxMana());
            if (manaDiff > 0) {
                player.setMana(player.getMana() - manaDiff);
            }
        }
    }

    public static void WhoDoYouWantToAttack(Monster monster, int joined){
        System.out.println("Kogo chcesz wybrać jako swój cel?");
        if (monster.getHp() > 0) {
            System.out.println("A. " + monster.getName() + " (" + monster.getHp() + ") HP");
        } else {
            System.out.println("A. " + monster.getName() + " (Martwy)");
        }
        if (GameLogic.monsterBase[joined].getHp() > 0) {
            System.out.println("B. " + GameLogic.monsterBase[joined].getName() + " (" + GameLogic.monsterBase[joined].getHp() + ") HP");
        } else if (GameLogic.monsterBase[joined].getHp() < 1) {
            System.out.println("B. " + GameLogic.monsterBase[joined].getName() + " (Martwy)");
        }
    }

}
