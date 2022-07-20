package Data.Info;

import Mobs.Player;

public class Infographics {


    public void PlayerInfo(Player player){
        System.out.println("Punkty życia: " + player.getHP() + "/" + player.getMaxHP());
        System.out.println("Punkty obrażeń: " + player.getDMG());
        System.out.println("Poziom: " + player.getLevel());
        System.out.println("Doświadczenie: " + player.getXP());
      if (player.getPotionNumber()>0){
        System.out.println("Eliksiry: " + player.getPotionNumber());}
        System.out.println("Zbroja: " + player.getArmor());
        if (player.getBombNumber()>0){
        System.out.println("Bomby: " + player.getBombNumber());}
        System.out.println("Złoto: " + player.getGold());
    }
}
