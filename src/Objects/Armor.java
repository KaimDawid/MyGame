package Objects;

import Mobs.Player;

public class Armor {
    static int stock = 1;
    public static void pickArmor(Player player) {

if (stock > 0) {
    System.out.println("Natknąłeś się na zwłoki rycerza w złotej zbroi, prawdopodobnie próbował uciec" +
            " z labiryntu");
    System.out.println("Bez zastanowienia podnosisz jego zbroję i zakładasz, jemu już się nie przyda");
    player.setHP(player.getHP() + 50);
    player.setMaxHP(player.getMaxHP() + 50);
    System.out.println("Twoje nowe punkty życia to: " + player.getHP() + "/" + player.getMaxHP());
    stock = 0;
}else {}
    }
}
