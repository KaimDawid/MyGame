package Logic.Status;

import Mobs.Player;

public class Status {

    public static void BURN(Player player){
        int burning = 2;
        player.setBurn(2);
        if (burning > 0) {
            int burningDMG = 40;
            player.setHP(player.getHP()- burningDMG);
            System.out.println("Otrzymałeś " + burningDMG + "obrażeń od podpalenia");
            boolean burned = true;
            burning = burning -1;
        }
    }
}
