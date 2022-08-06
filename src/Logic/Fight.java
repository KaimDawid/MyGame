package Logic;

import Mobs.Goblin;
import Mobs.Monster;
import Mobs.Player;
import Mobs.Spider;
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


    public static void Turn(Player player, Monster monster) throws InterruptedException {

         int toxic = 0;
        int escape = 0;

        System.out.println("Napotkałeś na swojej drodze " + monster.getName() +"a" + " walcz!");
        System.out.println("1 - zatakuj");
        System.out.println("RUN - spróbuj uciec");
        if (player.getChosenSkill1() == Player.ICE || player.getChosenSkill2() == Player.ICE || player.getChosenSkill3() == Player.ICE ||
                player.getChosenSkill4() == Player.ICE || player.getChosenSkill5() == Player.ICE ){
            System.out.println("ICE - rzuć lodowy pocisk (zamraża na 2 tury)");
        }
        if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL || player.getChosenSkill3() == Player.FIREBALL ||
                player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() == Player.FIREBALL ){
            System.out.println("FIRE - rzuć kulę ognia (zadaje 120 obrażeń)");
        }
        if (player.getBombNumber()>0){
            System.out.println("2 - rzuć bombę za 80 obrażeń (" + player.getBombNumber() +")");}
        if (player.getPotionNumber()>0){
            System.out.println("3 - użyj eliksiru leczącego (" + player.getPotionNumber() +")");}
        do {

            if (player.getPoison() > 0) {
                int poisonDMG = 20;
                player.setHP(player.getHP()- poisonDMG);
                System.out.println("Otrzymałeś " + poisonDMG + "obrażeń od trucizny");
                boolean poisoned = true;

                player.setPoison(player.getPoison()-1);
            }
            System.out.println("Twoje punkty zdrowia: " + player.getHP() + "/"+ player.getMaxHP() + " Twoje obrażenia :"
                    + player.getDMG() + "            Mana: " + player.getMana());
            Thread.sleep(800);
            System.out.println("Punkty zdrowia przeciwnika: " + monster.getHp() + " Jego obrażenia: " + monster.getDmg());
            Thread.sleep(800);
Spider spider = new Spider(1,1,1,1,"Dupa",1,1);
            Scanner scanner = new Scanner(System.in);
            String input3 = scanner.nextLine().toUpperCase();
            if (spider.getI() > 0){
                int poisonDMG = 20;
                player.setHP(player.getHP()- poisonDMG);
                System.out.println("Otrzymałeś " + poisonDMG + "obrażeń od trucizny");
                spider.setI(spider.getI() - 1);
            }

            switch (input3) {
                case "1":
                    player.Attack(monster, player);
                        Thread.sleep(1000);
                    if (monster.getHp() > 0 && monster.getFreeze() == 0){
                    monster.Attack(monster, player);
                        Thread.sleep(1000);
                    }
                    else if (monster.getFreeze() > 0){
                        System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                        + " tury");
                        monster.setFreeze(monster.getFreeze() - 1);
                    }
                    break;
                case "RUN":
                    System.out.println("Udało Ci się uciec, Twoje koordynaty to: X: " + player.getX() +", Y: " + player.getY());
                  /*  System.out.println("Udało Ci się uciec, ale otrzymałeś " + monster.getDmg() + " obrażeń");
                    if (monster.getHp() > 0 && monster.getFreeze() == 0){
                        monster.Attack(monster, player);
                        Thread.sleep(1000);
                    }
                    else if (monster.getFreeze() > 0){
                        System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                + " tury");
                        monster.setFreeze(monster.getFreeze() - 1);
                    }*/
                    escape = 1;
                    player.setEscapeInvulnerability(1);
                    break;
                case "2":
                    if (player.getBombNumber() > 0){
                        monster.setHp(monster.getHp() - BDMG);
                        if (monster.getHp() > 0 && monster.getFreeze() == 0){
                            monster.Attack(monster, player);
                            Thread.sleep(1000);
                        }
                        else if (monster.getFreeze() > 0){
                            System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                    + " tury");
                            monster.setFreeze(monster.getFreeze() - 1);
                        }
                        System.out.println("Rzuciłeś bombę za 80 obrażeń!");
                    }
                    break;
                case "3":
                    if (player.getPotionNumber()> 0){
                        player.setPotionNumber(player.getPotionNumber() - 1);
                        player.setHP(player.getHP() + 100);
                        double difference = player.getHP() - player.getMaxHP();
                        if (player.getHP() > player.getMaxHP()){
                            player.setHP(player.getHP() - difference);
                        }
                        if (monster.getHp() > 0 && monster.getFreeze() == 0){
                            monster.Attack(monster, player);
                            Thread.sleep(1000);
                        }
                        else if (monster.getFreeze() > 0){
                            System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                    + " tury");
                            monster.setFreeze(monster.getFreeze() - 1);
                        }
                    }
                case "ICE":
                    if (player.getChosenSkill1() == Player.ICE || player.getChosenSkill2() == Player.ICE
                    || player.getChosenSkill3() == Player.ICE || player.getChosenSkill4() == Player.ICE || player.getChosenSkill5() ==
                    Player.ICE) {
                        player.Freeze(monster);
                    }
                    break;
                case "FIRE":
                    if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL
                            || player.getChosenSkill3() == Player.FIREBALL || player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() ==
                            Player.FIREBALL){
                        player.Fireball(monster, player);
                        if (monster.getHp() > 0 && monster.getFreeze() == 0){
                            monster.Attack(monster, player);
                            Thread.sleep(1000);
                        }
                        else if (monster.getFreeze() > 0){
                            System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                    + " tury");
                            monster.setFreeze(monster.getFreeze() - 1);
                        }
                        System.out.println("Zdrowie przeciwnika: " + monster.getHp());
                    }
            }
            if (player.getHP() < 1) {
                System.out.println("Twoje zdrowie spadło do 0");
                System.out.println("poległeś");
            }
            if (monster.getHp() < 1){

                System.out.println("Wygrałeś!");
                monster.setX(100);
                monster.setY(100);
                player.setXP(player.getXP() + monster.getGiveXP());
                monster.drop();

    player.setGold(player.getGold() + monster.getGold());

            }
            if (player.getMana() < player.getMaxMana()) {
                int manaDiff = (player.getMana() - player.getMaxMana());
                player.setMana(player.getMana() + player.getManaRegen());
                if (manaDiff > 0){
                    player.setMana(player.getMana() - manaDiff);
                }
            }
        } while (player.getHP() > 0 && monster.getHp() > 0 && escape == 0);


    }

}
