package Logic.Status;

import Mobs.Player;

public class Poison {

    public void poisoned(Player player){
        for (int i = 0; i < 2; i++) {
            int poisonDMG = 20;
            player.setHP(player.getHP()- poisonDMG);
            System.out.println("Otrzymałeś " + poisonDMG);

        }
    }
}
