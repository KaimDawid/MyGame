package Objects;
import Mobs.*;

public class Weapon {
    public static void goldSword(Player player){
        player.setDMG(player.getDMG() + 30);
        System.out.println("Natrafiłeś na ołtarz ku czci Zeusowi, a przy nim " +
                "magiczny miecz");
        System.out.println("Twoje nowe obrażenia to: " + player.getDMG());
        System.out.println("To wystarczy aby go zgładzić, teraz możesz poszukać " +
                "zbroi, lub jeśli ją masz, stawić czoła minotaurowi");

    }
}
