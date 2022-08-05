package Logic;

import Mobs.Player;

public class Experience {

    public static void expCounter(Player player){
         int firstCap = 40;
         int secondCap = 100;
         int thirdCap = 250;
         int fourthCap = 400;
         int fifthCap = 700;
        if (player.getXP()>40 && player.getLevel() == 0){
            player.setMaxHP(player.getMaxHP() +30);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG()+10);
            player.setXP(player.getXP() - 40);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setLevel(1);

        } else if (player.getXP() > 100 && player.getLevel() == 1) {
            player.setMaxHP(player.getMaxHP() +30);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG()+10);
            player.setXP(player.getXP() - 100);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setLevel(2);
        }
        else if (player.getXP() > 250 && player.getLevel() == 2) {
            player.setMaxHP(player.getMaxHP() +40);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG()+10);
            player.setXP(player.getXP() - 250);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setLevel(3);
        }
        else if (player.getXP() > 400 && player.getLevel() == 3) {
            player.setMaxHP(player.getMaxHP() +40);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG()+15);
            player.setXP(player.getXP() - 400);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setLevel(4);
        }
        else if (player.getXP() > 700 && player.getLevel() == 4) {
            player.setMaxHP(player.getMaxHP() +50);
            player.setHP(player.getMaxHP());
            player.setDMG(player.getDMG()+20);
            player.setXP(player.getXP() - 700);
            System.out.println("Gratulacje! Zdobyłeś kolejny poziom i odnowiłeś swoje punkty życia");
            System.out.printf("Twoje nowe punkty zdrowia: %.0f/%.0f%n", player.getHP(),  player.getMaxHP());
            System.out.println("Twoje nowe obrażenia: " + player.getDMG());
            player.setLevel(5);
        }
        if (player.getLevel() == 0 && player.getHP() > 0) {
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + fourthCap+ " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
        else if (player.getLevel() == 1 && player.getHP() > 0){
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + fourthCap+ " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        } else if (player.getLevel() == 2 && player.getHP() > 0){
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + fourthCap+ " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
        else if (player.getLevel() == 3 && player.getHP() > 0){
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + fourthCap+ " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
        else if (player.getLevel() == 4 && player.getHP() > 0){
            System.out.println("Masz " + player.getLevel() + " poziom doświadczenia, oraz " + player.getXP() +
                    "/" + fourthCap+ " punktów doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
        else if (player.getLevel() == 5 && player.getHP() > 0){
            System.out.println("Osiągnąłeś maksymalny poziom doświadczenia");
            System.out.println("Złoto: " + player.getGold());
        }
    }
}
