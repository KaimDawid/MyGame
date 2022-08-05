package Logic.Status;

import Mobs.Player;

public class Poison {

    public void poisoned(Player player){
        int toxic = 2;
       if (toxic > 0) {
            int poisonDMG = 20;
            player.setHP(player.getHP()- poisonDMG);
            System.out.println("Otrzymałeś " + poisonDMG + "obrażeń od trucizny");
            boolean poisoned = true;
           toxic = toxic -1;
        }
    }
}
