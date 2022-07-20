package Logic;

import Mobs.Goblin;
import Mobs.Monster;
import Mobs.Player;
import Objects.Shop.Bomb;
import java.util.Scanner;

//
// Ta klasa przechowuje pętlę walki ATTACK / RUN do momentu aż jeden z celów osiągnie 0 pkt życia
// lub użytkownik wpisze komendę "RUN".
// W przyszłości dodać:
//                     - system obrony (HP = (HP - (DMG - DEF)))
//                     - szansę na trafienie zależną od poziomu przeciwnika
//                     - random.nextInt(100)
//                      int chance = 90 - (MobLVL*10) + (PlayerLevel*7)
//                      if (random.nextInt(100) > chance) { miss }
public class Fight {
    static final int BDMG = 80;


    public static void Turn(Player player, Monster monster){
        int escape = 0;

        System.out.println("Napotkałeś na swojej drodze " + monster.getName() +"a" + " walcz!");
        do {
            System.out.println("Twoje punkty zdrowia: " + player.getHP() + "/"+ player.getMaxHP() + " Twoje obrażenia :"
                    + player.getDMG());
            System.out.println("Punkty zdrowia przeciwnika: " + monster.getHp() + " Jego obrażenia: " + monster.getDmg());
            System.out.println("ATTACK - zatakuj");
            System.out.println("RUN - spróbuj uciec");
            System.out.println("THROW - rzuć bombę za 80 obrażeń");
            System.out.println("HEAL - użyj eliksiru leczącego");
            Scanner scanner = new Scanner(System.in);
            String input3 = scanner.nextLine();
            switch (input3) {
                case "ATTACK":
                    player.Attack(monster, player);
                    monster.Attack(monster, player);
                    break;
                case "RUN":
                    System.out.println("Udało Ci się uciec, ale otrzymałeś " + monster.getDmg() + " obrażeń");
                    player.setX(player.getX() - 1);
                    escape = 1;
                    break;
                case "THROW":
                    if (player.getBombNumber() > 0){
                        monster.setHp(monster.getHp() - BDMG);
                        monster.Attack(monster, player);
                    }
                case "HEAL":
                    if (player.getPotionNumber()> 0){
                        player.setPotionNumber(player.getPotionNumber() - 1);
                        player.setHP(player.getHP() + 100);
                        monster.Attack(monster, player);
                    }
            }
            if (player.getHP() < 1) {
                System.out.println("Otrzymałeś " + monster.getDmg() + " obrażeń i Twoje zdrowie spadło do 0");
                System.out.println("poległeś");
            }
            if (monster.getHp() < 1){

                System.out.println("Wygrałeś!");
                monster.setX(100);
                monster.setY(100);
                player.setXP(player.getXP() + monster.getGiveXP());

    player.setGold(player.getGold() + monster.getGold());

            }
        } while (player.getHP() > 0 && monster.getHp() > 0 && escape == 0);


    }

}
