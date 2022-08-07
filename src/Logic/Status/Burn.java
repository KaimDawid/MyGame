package Logic.Status;

import Mobs.Player;

public class Burn {

    public static void BURN(Player player){
        int burning = 2;
        player.setBurn(2);
        if (burning > 0) {
            int burningDMG = 40;
            player.setHP(player.getHP()- burningDMG);
            System.out.println("Zostałeś podpalony i otrzymałeś " + burningDMG + "obrażeń od ognia");
            boolean burned = true;
            burning = burning -1;
        }
    }

}
