package Logic;

import Logic.Drop.Drop;
import Mobs.Goblin;
import Mobs.Monster;
import Mobs.Player;
import Mobs.Spider;
import Objects.Shop.Bomb;

import java.util.Random;
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
    public static int joined = 1;
    public static int doubleStrike = 0;

    public static int ironSkinDuration;

    public static int adrenalineDuration;

    void isFrozen(Player player) {
        if (player.getFreeze() > 0) {
            System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
        }
    }

    public static void groupFight(Monster[] monsterTable, Player player) {


        //
        //
        //   Jakby Ci coś nie działało to linijka 324 !!!
        //
        //
        //

        Random random = new Random();
        if (doubleStrike == 0) {
            joined = 1;
            do {

                if ((GameLogic.monsterBase[joined].getX() - player.getX() == 1 || player.getX() - GameLogic.monsterBase[joined].getX() == 1) &&
                        (GameLogic.monsterBase[joined].getY() - player.getY() == 1 || player.getY() - GameLogic.monsterBase[joined].getY() == 1)
                ) {

                    int chance = random.nextInt(100);
                    if (chance > 92) {
                        System.out.println(GameLogic.monsterBase[joined].getName() + " dołączył do walki!");
                        doubleStrike = 1;
                        joined--;
                    }
                }
                joined++;
            } while (joined < 20 && doubleStrike == 0);
        }

    }

    public static void Turn(Player player, Monster monster) throws InterruptedException {

        int toxic = 0;
        int escape = 0;
        int burnDMG = 40;

        System.out.println("Napotkałeś na swojej drodze " + monster.getName() + "a" + " walcz!");
        /* int doubleStrike = 0;*/


        System.out.println("1 - zatakuj");
        System.out.println("RUN - spróbuj uciec");
        if (player.getChosenSkill1() == Player.ICE || player.getChosenSkill2() == Player.ICE || player.getChosenSkill3() == Player.ICE ||
                player.getChosenSkill4() == Player.ICE || player.getChosenSkill5() == Player.ICE) {
            System.out.println("ICE - rzuć lodowy pocisk (zamraża na 2 tury)");
        }
        if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL || player.getChosenSkill3() == Player.FIREBALL ||
                player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() == Player.FIREBALL) {
            System.out.println("FIRE - rzuć kulę ognia (zadaje 120 obrażeń)");
        }
        if (player.getChosenSkill1() == Player.ADRENALINE || player.getChosenSkill2() == Player.ADRENALINE || player.getChosenSkill3() == Player.ADRENALINE ||
                player.getChosenSkill4() == Player.ADRENALINE || player.getChosenSkill5() == Player.ADRENALINE) {
            System.out.println("ADRENALINE: Zadajesz więcej obrażeń, ale też otrzymujesz więcej");
        }
        if (player.getChosenSkill1() == Player.IRONSKIN || player.getChosenSkill2() == Player.IRONSKIN || player.getChosenSkill3() == Player.IRONSKIN ||
                player.getChosenSkill4() == Player.IRONSKIN || player.getChosenSkill5() == Player.IRONSKIN) {
            System.out.println("IRONSKIN: + 30 armor na 2 tury");
        }
        if (player.getBombNumber() > 0) {
            System.out.println("2 - rzuć bombę za 80 obrażeń (" + player.getBombNumber() + ")");
        }
        if (player.getPotionNumber() > 0) {
            System.out.println("3 - użyj eliksiru leczącego (" + player.getPotionNumber() + ")");
        }


        do {


            if (player.getPoison() > 0) {
                int poisonDMG = 20;
                player.setHP(player.getHP() - poisonDMG);
                System.out.println("Otrzymałeś " + poisonDMG + " obrażeń od trucizny");

                player.setPoison(player.getPoison() - 1);
            }
            System.out.println("Twoje punkty zdrowia: " + player.getHP() + "/" + player.getMaxHP() + " Twoje obrażenia :"
                    + player.getDMG() + "            Mana: " + player.getMana());

            if (monster.getHp() > 0) {
                System.out.println("Punkty zdrowia przeciwnika: " + monster.getHp() + " Jego obrażenia: " + monster.getDmg());
            } else if (monster.getHp() < 1) {
                System.out.println(monster.getName() + " jest martwy");
            }
            if (doubleStrike == 1 && GameLogic.monsterBase[joined].getHp() > 0) {
                System.out.println("Punkty zdrowia drugiego przeciwnika (" + GameLogic.monsterBase[joined].getName() + ") : " + GameLogic.monsterBase[joined].getHp());
            } else if (doubleStrike == 1 && GameLogic.monsterBase[joined].getHp() < 1) {
                System.out.println(GameLogic.monsterBase[joined].getName() + " jest martwy");
            }
            if (doubleStrike == 1) {
                System.out.println("Uważaj na siebie, walczysz z dwoma przeciwnikami! " + monster.getName() + " i "
                        + GameLogic.monsterBase[joined].getName());
            }
            groupFight(GameLogic.monsterBase, player);

            Scanner scanner = new Scanner(System.in);
            String input3 = scanner.nextLine().toUpperCase();


            switch (input3) {

                case "ADRENALINE":
                    if (player.getAdrenalineValue() == 0) {
                        player.Adrenaline(player);
                        player.setAdrenalineValue(1);
                        adrenalineDuration = 2;
                    } else {
                        player.Attack(monster, player);
                    }
                    if (doubleStrike == 1 && GameLogic.monsterBase[joined].getFreeze() == 0) {
                        GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
                    }
                    Thread.sleep(500);
                    if (monster.getHp() > 0 && monster.getFreeze() == 0) {
                        monster.Attack(monster, player);
                        Thread.sleep(500);
                    } else if (monster.getFreeze() > 0) {
                        System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                + " tury");
                        monster.setFreeze(monster.getFreeze() - 1);
                    }
                    if (player.getBurn() > 0) {
                        System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
                        player.setHP(player.getHP() - burnDMG);
                    }
                    adrenalineDuration--;
                    break;

                case "IRONSKIN":
                    if (player.getIronSkinValue() == 0) {
                        player.IronSkin(player);
                        player.setIronSkinValue(1);
                        ironSkinDuration = 2;
                    } else {
                        player.Attack(monster, player);
                    }
                    if (doubleStrike == 1 && GameLogic.monsterBase[joined].getFreeze() == 0) {
                        GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
                    }
                    Thread.sleep(500);
                    if (monster.getHp() > 0 && monster.getFreeze() == 0) {
                        monster.Attack(monster, player);
                        Thread.sleep(500);
                    } else if (monster.getFreeze() > 0) {
                        System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                + " tury");
                        monster.setFreeze(monster.getFreeze() - 1);
                    }
                    if (player.getBurn() > 0) {
                        System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
                        player.setHP(player.getHP() - burnDMG);
                    }
                    ironSkinDuration--;
                    break;

                case "1":
                    /* groupFight(GameLogic.monsterBase, player);*/
                    if (doubleStrike == 0) {
                        if (player.getFreeze() < 1) {
                            player.Attack(monster, player);
                        } else if (player.getFreeze() > 0) {
                            System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                            player.setFreeze(player.getFreeze() - 1);
                        }
                        if (doubleStrike == 1 && GameLogic.monsterBase[joined].getFreeze() == 0) {
                            GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
                        }
                        Thread.sleep(500);
                        if (monster.getHp() > 0 && monster.getFreeze() == 0) {
                            monster.Attack(monster, player);
                            Thread.sleep(500);
                        } else if (monster.getFreeze() > 0) {
                            System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                    + " tury");
                            monster.setFreeze(monster.getFreeze() - 1);
                        }
                        if (player.getBurn() > 0) {
                            System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
                            player.setHP(player.getHP() - burnDMG);
                        }
                    } else if (doubleStrike == 1) {
                        System.out.println("Kogo chcesz zaatakować?");
                        if (monster.getHp() > 0) {
                            System.out.println("A. " + monster.getName() + " (" + monster.getHp() + ") HP");
                        } else {
                            System.out.println("A. " + monster.getName() + " (Martwy)");
                        }
                        if (GameLogic.monsterBase[joined].getHp() > 0) {
                            System.out.println("B. " + GameLogic.monsterBase[joined].getName() + " (" + GameLogic.monsterBase[joined].getHp() + ") HP");
                        } else if (GameLogic.monsterBase[joined].getHp() < 1) {
                            System.out.println("B. " + GameLogic.monsterBase[joined].getName() + " (Martwy)");
                        }

                        String choice = scanner.nextLine().toUpperCase();

                        switch (choice) {

                            case "A":

                                if (player.getFreeze() < 1) {
                                    player.Attack(monster, player);
                                } else if (player.getFreeze() > 0) {
                                    System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                                    player.setFreeze(player.getFreeze() - 1);
                                }
                                if (GameLogic.monsterBase[joined].getHp() > 0) {
                                    GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
                                }
                                Thread.sleep(500);
                                if (monster.getHp() > 0 && monster.getFreeze() == 0) {
                                    monster.Attack(monster, player);
                                    Thread.sleep(500);
                                } else if (monster.getFreeze() > 0) {
                                    System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                            + " tury");
                                    monster.setFreeze(monster.getFreeze() - 1);
                                }
                                if (player.getBurn() > 0) {
                                    System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
                                    player.setHP(player.getHP() - burnDMG);
                                }

                                break;

                            case "B":

                                if (player.getFreeze() < 1) {
                                    player.Attack(GameLogic.monsterBase[joined], player);
                                } else if (player.getFreeze() > 0) {
                                    System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                                    player.setFreeze(player.getFreeze() - 1);
                                }
                                if (GameLogic.monsterBase[joined].getHp() > 0) {
                                    GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
                                }
                                Thread.sleep(500);
                                if (monster.getHp() > 0 && monster.getFreeze() == 0) {
                                    monster.Attack(monster, player);
                                    Thread.sleep(500);
                                } else if (monster.getFreeze() > 0) {
                                    System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                            + " tury");
                                    monster.setFreeze(monster.getFreeze() - 1);
                                }
                                if (player.getBurn() > 0) {
                                    System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
                                    player.setHP(player.getHP() - burnDMG);
                                }

                                break;

                        }

                    }
                    break;
                case "RUN":
                    if (player.getBurn() > 0) {
                        System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
                        player.setHP(player.getHP() - burnDMG);
                    }
                    System.out.println("Udało Ci się uciec, Twoje koordynaty to: X: " + player.getX() + ", Y: " + player.getY());
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
                    doubleStrike = 0;
                    break;
                case "2":
                    if (player.getBombNumber() > 0) {
                        monster.setHp(monster.getHp() - BDMG);
                        if (monster.getHp() > 0 && monster.getFreeze() == 0) {
                            monster.Attack(monster, player);
                            Thread.sleep(500);
                        } else if (monster.getFreeze() > 0) {
                            System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                    + " tury");
                            monster.setFreeze(monster.getFreeze() - 1);
                        }
                        System.out.println("Rzuciłeś bombę za 80 obrażeń!");
                        if (player.getBurn() > 0) {
                            System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
                            player.setHP(player.getHP() - burnDMG);
                        }
                        if (doubleStrike == 1) {
                            GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
                        }
                    }
                    break;
                case "3":
                    if (player.getPotionNumber() > 0) {
                        player.setPotionNumber(player.getPotionNumber() - 1);
                        player.setHP(player.getHP() + 100);
                        double difference = player.getHP() - player.getMaxHP();
                        if (player.getHP() > player.getMaxHP()) {
                            player.setHP(player.getHP() - difference);
                        }
                        if (monster.getHp() > 0 && monster.getFreeze() == 0) {
                            monster.Attack(monster, player);
                            Thread.sleep(500);
                        } else if (monster.getFreeze() > 0) {
                            System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                    + " tury");
                            monster.setFreeze(monster.getFreeze() - 1);
                        }
                        if (player.getBurn() > 0) {
                            System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
                            player.setHP(player.getHP() - burnDMG);
                        }
                        if (doubleStrike == 1) {
                            GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
                        }
                    }
                    break;
                case "ICE":
                    if (player.getChosenSkill1() == Player.ICE || player.getChosenSkill2() == Player.ICE
                            || player.getChosenSkill3() == Player.ICE || player.getChosenSkill4() == Player.ICE || player.getChosenSkill5() ==
                            Player.ICE) {
                        if (doubleStrike == 1) {
                            System.out.println("Kogo chcesz zamrozić?");
                            System.out.println("A. " + monster.getName());
                            System.out.println("B. " + GameLogic.monsterBase[joined].getName());

                            String choice = scanner.nextLine().toUpperCase();
                            switch (choice) {
                                case "A":
                                    player.Freeze(monster);
                                    break;
                                case "B":
                                    player.Freeze(GameLogic.monsterBase[joined]);
                                    break;
                            }
                        } else {
                            player.Freeze(monster);
                        }

                    }
                    if (player.getBurn() > 0) {
                        System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
                        player.setHP(player.getHP() - burnDMG);
                    }
                    if (doubleStrike == 1 && GameLogic.monsterBase[joined].getFreeze() == 0) {
                        GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
                    }
                    if (monster.getFreeze() == 0) {
                        monster.Attack(monster, player);
                    }
                    break;
                case "FIRE":
                    if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL
                            || player.getChosenSkill3() == Player.FIREBALL || player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() ==
                            Player.FIREBALL) {
                        player.Fireball(monster, player);
                        if (monster.getHp() > 0 && monster.getFreeze() == 0) {
                            monster.Attack(monster, player);
                            Thread.sleep(500);
                        } else if (monster.getFreeze() > 0) {
                            System.out.println("Przeciwnik jest zamrożony, nie może się ruszać przez " + monster.getFreeze()
                                    + " tury");
                            monster.setFreeze(monster.getFreeze() - 1);
                        }
                        System.out.println("Zdrowie przeciwnika: " + monster.getHp());
                        if (player.getBurn() > 0) {
                            System.out.println("Otrzymałeś " + burnDMG + " obrażeń od ognia!");
                            player.setHP(player.getHP() - burnDMG);
                        }
                        if (doubleStrike == 1) {
                            GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
                        }
                    }
                    break;


            }
            if (doubleStrike == 1) {
                if (monster.getHp() <= 0 && GameLogic.monsterBase[joined].getHp() <= 0) {
                    System.out.println("Pokonałeś obu wrogów!");
                    GameLogic.monsterBase[joined].setX(100);
                    GameLogic.monsterBase[joined].setY(100);
                    monster.setX(100);
                    monster.setY(100);
                    player.setXP(player.getXP() + monster.getGiveXP() + GameLogic.monsterBase[joined].getGiveXP());
                    GameLogic.monsterBase[joined].Drop();
                    monster.Drop();
                    player.setGold(player.getGold() + monster.getGold() + GameLogic.monsterBase[joined].getGold());
                    joined = 1;
                    doubleStrike = 0;
                    PlayerStatusWearOff(player);
                    escape = 1;

                }
            } else if (doubleStrike == 0) {
                if (monster.getHp() <= 0) {
                    System.out.println("Wygrałeś!");
                    monster.setX(100);
                    monster.setY(100);
                    player.setXP(player.getXP() + monster.getGiveXP());
                    Random random = new Random();
                  /*  int dropchance = random.nextInt(100);
                    if (dropchance < 101){*/

                        /*Drop.dropHelmet();
                        Drop.dropArmor();
                        Drop.dropGloves();
                        Drop.dropWeapon();
                        Drop.dropNeck();*/
                    /*}*/
                    monster.Drop();
                    joined = 1;
                    doubleStrike = 0;
                    player.setGold(player.getGold() + monster.getGold());
                    PlayerStatusWearOff(player);
                    escape = 1;

                }
            }

            if (player.getHP() < 1) {
                System.out.println("Twoje zdrowie spadło do 0");
                System.out.println("poległeś");
            }

            /*if (monster.getHp() < 1){

                System.out.println("Wygrałeś!");
                monster.setX(100);
                monster.setY(100);
                player.setXP(player.getXP() + monster.getGiveXP());
                monster.drop();
                joined = 1;
                doubleStrike = 0;

    player.setGold(player.getGold() + monster.getGold());

            }*/
            if (player.getMana() < player.getMaxMana()) {

                player.setMana(player.getMana() + player.getManaRegen());
                double manaDiff = (player.getMana() - player.getMaxMana());
                if (manaDiff > 0) {
                    player.setMana(player.getMana() - manaDiff);
                }
            }


        } while (player.getHP() > 0 && escape == 0);


    }

    public static void PlayerStatusWearOff(Player player) {

        if (player.getAdrenalineValue() == 1) {
            player.setDMG((int) (player.getDMG() * 0.71));
            player.setArmor(player.getArmor() + 40);
            player.setAdrenalineValue(0);
        }

        if (player.getIronSkinValue() == 1) {

            player.setArmor(player.getArmor() - 30);
            player.setIronSkinValue(0);
        }

        player.setFreeze(0);
        player.setPoison(0);


    }

}
