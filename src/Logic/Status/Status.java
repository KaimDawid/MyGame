package Logic.Status;

import Mobs.Monster;
import Mobs.Player;

public class Status {

    public static void BURN(Player player){

        player.setBurn(2);
            int burningDMG = 40;
            player.setHP(player.getHP()- burningDMG);
            System.out.println("Zostałeś podpalony i otrzymałeś " + burningDMG + "obrażeń od podpalenia");

    }
    public static void POISON(Player player, Monster monster){

            int poisonDMG = 20;
            player.setPoison(2);
            player.setHP(player.getHP()- poisonDMG);
            /*player.setHP(player.getHP() - monster.getDmg() + player.getArmor());*/
            System.out.println("Przeciwnik Cię zatruł za 20 obrażeń!");


    }
}
