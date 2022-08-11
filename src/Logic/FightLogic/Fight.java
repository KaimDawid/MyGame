package Logic.FightLogic;

import Logic.Drop.Drop;
import Logic.FightLogic.FightLogic;
import Logic.GameLogic;
import Mobs.Goblin;
import Mobs.Monster;
import Mobs.Player;
import Mobs.Spider;
import Objects.Shop.Bomb;

import java.util.Random;
import java.util.Scanner;


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





        Random random = new Random();
        if (doubleStrike == 0) {
            joined = 1;
            do {

                if ((GameLogic.monsterBase[joined].getX() - player.getX() == 1 || player.getX() - GameLogic.monsterBase[joined].getX() == 1) &&
                        (GameLogic.monsterBase[joined].getY() - player.getY() == 1 || player.getY() - GameLogic.monsterBase[joined].getY() == 1)
                ) {

                    int chance = random.nextInt(100);
                    if (chance > 91) {
                        System.out.println(GameLogic.monsterBase[joined].getName() + " dołączył do walki!");
                        doubleStrike = 1;
                        joined--;
                    }
                }
                joined++;
            } while (joined < 2 && doubleStrike == 0);
        }

    }
    public static int escape = 0;
    public static void Turn(Player player, Monster monster) throws InterruptedException {

        escape = 0;

        int toxic = 0;

        int burnDMG = 40;

        System.out.println("Napotkałeś na swojej drodze " + monster.getName() + "a" + " walcz!");
        /* int doubleStrike = 0;*/


        System.out.println("1 - zatakuj");
        System.out.println("RUN - spróbuj uciec");
        if (player.getChosenSkill1() == Player.ICE || player.getChosenSkill2() == Player.ICE || player.getChosenSkill3() == Player.ICE ||
                player.getChosenSkill4() == Player.ICE || player.getChosenSkill5() == Player.ICE || player.getChosenSkill6() == Player.ICE ||
                player.getChosenSkill7() == Player.ICE || player.getChosenSkill8() == Player.ICE ||
                player.getChosenSkill9() == Player.ICE || player.getChosenSkill10() == Player.ICE) {
            System.out.println("ICE - rzuć lodowy pocisk (zamraża na 2 tury)");
        }
        if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL || player.getChosenSkill3() == Player.FIREBALL ||
                player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() == Player.FIREBALL || player.getChosenSkill6() == Player.FIREBALL ||
                player.getChosenSkill7() == Player.FIREBALL || player.getChosenSkill8() == Player.FIREBALL ||
                player.getChosenSkill9() == Player.FIREBALL || player.getChosenSkill10() == Player.FIREBALL) {
            System.out.println("FIRE - rzuć kulę ognia (zadaje 120 obrażeń)");
        }
        if (player.getChosenSkill1() == Player.ADRENALINE || player.getChosenSkill2() == Player.ADRENALINE || player.getChosenSkill3() == Player.ADRENALINE ||
                player.getChosenSkill4() == Player.ADRENALINE || player.getChosenSkill5() == Player.ADRENALINE || player.getChosenSkill6() == Player.ADRENALINE || player.getChosenSkill7() == Player.ADRENALINE
                || player.getChosenSkill10() == Player.ADRENALINE || player.getChosenSkill8() == Player.ADRENALINE || player.getChosenSkill9() == Player.ADRENALINE) {
            System.out.println("ADRENALINE: Zadajesz więcej obrażeń, ale też otrzymujesz więcej.");
        }
        if (player.getChosenSkill1() == Player.IRONSKIN || player.getChosenSkill2() == Player.IRONSKIN || player.getChosenSkill3() == Player.IRONSKIN ||
                player.getChosenSkill4() == Player.IRONSKIN || player.getChosenSkill5() == Player.IRONSKIN || player.getChosenSkill6() == Player.IRONSKIN ||
                player.getChosenSkill7() == Player.IRONSKIN || player.getChosenSkill8() == Player.IRONSKIN ||
                player.getChosenSkill9() == Player.IRONSKIN || player.getChosenSkill10() == Player.IRONSKIN) {
            System.out.println("IRONSKIN: + 30 armor.");
        }
        if (player.getBombNumber() > 0) {
            System.out.println("2 - rzuć bombę za 80 obrażeń (" + player.getBombNumber() + ")");
        }
        if (player.getPotionNumber() > 0) {
            System.out.println("3 - użyj eliksiru leczącego (" + player.getPotionNumber() + ")");
        }
        if (player.getChosenSkill1() == Player.CLEAVE || player.getChosenSkill2() == Player.CLEAVE || player.getChosenSkill3() == Player.CLEAVE ||
                player.getChosenSkill4() == Player.CLEAVE || player.getChosenSkill5() == Player.CLEAVE || player.getChosenSkill6() == Player.CLEAVE ||
                player.getChosenSkill7() == Player.CLEAVE || player.getChosenSkill8() == Player.CLEAVE || player.getChosenSkill9() == Player.CLEAVE ||
                player.getChosenSkill10() == Player.CLEAVE)
        {
            System.out.println("CLEAVE: Zaatakuj obu wrogów ze zwiększoną siłą.");
        }

        do {

            /*if (player.getIronSkinValue() > 0) {
                player.setIronSkinValue(player.getIronSkinValue() - 1);
                if (player.getIronSkinValue() == 0){
                    player.setArmor(player.getArmor() - 30);
                    System.out.println("Ironskin przestał działać.");
                }
            }
            if (player.getAdrenalineValue() > 0) {
                player.setAdrenalineValue(player.getAdrenalineValue() - 1);
                if (player.getAdrenalineValue() == 0){
                    player.setDMG((int) (player.getDMG() * 0.71));
                    player.setArmor(player.getArmor() + 40);
                    System.out.println("Adrenalina przestała działać.");
                }
            }*/
            FightLogic.StatusConclude(player,monster);

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
                    if (player.getAdrenalineValue() == 0 && player.getChosenSkill1() == Player.ADRENALINE || player.getChosenSkill2() == Player.ADRENALINE
                            || player.getChosenSkill3() == Player.ADRENALINE || player.getChosenSkill4() == Player.ADRENALINE || player.getChosenSkill5() ==
                            Player.ADRENALINE || player.getChosenSkill6() == Player.ADRENALINE || player.getChosenSkill7() == Player.ADRENALINE
                            || player.getChosenSkill8() == Player.ADRENALINE || player.getChosenSkill9() == Player.ADRENALINE || player.getChosenSkill10() == Player.ADRENALINE) {
                        player.Adrenaline(player);
                        player.setAdrenalineValue(1);
                        adrenalineDuration = 3;
                    } else {
                        player.Attack(monster, player);
                    }
                   EnemyAttack(player, monster);

                    break;

                case "IRONSKIN":
                    if (player.getIronSkinValue() == 0) {
                        player.IronSkin(player);
                        player.setIronSkinValue(1);
                        ironSkinDuration = 3;
                    } else {
                        player.Attack(monster, player);
                    }
                  EnemyAttack(player, monster);
                    break;

                case "1":

                    if (doubleStrike == 0) {
                        if (player.getFreeze() < 1) {
                            player.Attack(monster, player);
                        } else if (player.getFreeze() > 0) {
                            System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                            player.setFreeze(player.getFreeze() - 1);
                        }
                       EnemyAttack(player, monster);
                    } else if (doubleStrike == 1) {
                        FightLogic.WhoDoYouWantToAttack(monster, joined);

                        String choice = scanner.nextLine().toUpperCase();

                        switch (choice) {

                            case "A":

                                if (player.getFreeze() < 1) {
                                    player.Attack(monster, player);
                                } else if (player.getFreeze() > 0) {
                                    System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                                    player.setFreeze(player.getFreeze() - 1);
                                }
                                EnemyAttack(player, monster);
                                break;

                            case "B":

                                if (player.getFreeze() < 1) {
                                    player.Attack(GameLogic.monsterBase[joined], player);
                                } else if (player.getFreeze() > 0) {
                                    System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                                    player.setFreeze(player.getFreeze() - 1);
                                }
                                EnemyAttack(player, monster);
                                break;

                        }

                    }
                    break;
                case "RUN":
                    System.out.println("Udało Ci się uciec, Twoje koordynaty to: X: " + player.getX() + ", Y: " + player.getY());

                    escape = 1;
                    player.setEscapeInvulnerability(1);
                    doubleStrike = 0;
                    break;
                case "2":
                    if (player.getBombNumber() > 0) {
                        if (doubleStrike == 0) {
                            monster.setHp(monster.getHp() - BDMG);
                            System.out.println("Rzuciłeś bombę za 80 obrażeń!");
                        }
                        else if (doubleStrike > 0){
                            FightLogic.WhoDoYouWantToAttack(monster,joined);

                            String choice = scanner.nextLine();
                            switch (choice){
                                case "A":

                                    if (player.getFreeze() < 1) {
                                        monster.setHp(monster.getHp() - BDMG);
                                    } else if (player.getFreeze() > 0) {
                                        System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                                        player.setFreeze(player.getFreeze() - 1);
                                    }
                                    EnemyAttack(player, monster);


                                    break;

                                case "B":

                                    if (player.getFreeze() < 1) {
                                        GameLogic.monsterBase[joined].setHp(GameLogic.monsterBase[joined].getHp() - BDMG);
                                    } else if (player.getFreeze() > 0) {
                                        System.out.println("Zostałeś zamrożony, nie możesz się ruszać przez " + player.getFreeze() + " tury");
                                        player.setFreeze(player.getFreeze() - 1);
                                    }
                                    EnemyAttack(player, monster);

                                    break;
                            }
                        }
                        EnemyAttack(player, monster);
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
                        EnemyAttack(player, monster);

                    }
                    break;
                case "ICE":
                    if (player.getChosenSkill1() == Player.ICE || player.getChosenSkill2() == Player.ICE
                            || player.getChosenSkill3() == Player.ICE || player.getChosenSkill4() == Player.ICE || player.getChosenSkill5() ==
                            Player.ICE ||player.getChosenSkill6() == Player.ICE || player.getChosenSkill7() == Player.ICE
                            || player.getChosenSkill8() == Player.ICE || player.getChosenSkill9() == Player.ICE || player.getChosenSkill10() ==
                            Player.ICE) {
                        if (doubleStrike == 1) {
                            FightLogic.WhoDoYouWantToAttack(monster, joined);

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
                    EnemyAttack(player, monster);

                    break;
                case "FIRE":
                    if (player.getChosenSkill1() == Player.FIREBALL || player.getChosenSkill2() == Player.FIREBALL
                            || player.getChosenSkill3() == Player.FIREBALL || player.getChosenSkill4() == Player.FIREBALL || player.getChosenSkill5() ==
                            Player.FIREBALL  || player.getChosenSkill6() == Player.FIREBALL || player.getChosenSkill7() == Player.FIREBALL
                            || player.getChosenSkill8() == Player.FIREBALL || player.getChosenSkill9() == Player.FIREBALL || player.getChosenSkill10() == Player.FIREBALL) {
                        if (doubleStrike == 1) {
                            FightLogic.WhoDoYouWantToAttack(monster, joined);

                            String choice = scanner.nextLine().toUpperCase();
                            switch (choice) {
                                case "A":
                                    player.Fireball(monster, player);
                                    break;
                                case "B":
                                    player.Fireball(GameLogic.monsterBase[joined], player);
                                    break;
                            }
                        } else {
                            player.Fireball(monster, player);
                        }
                        EnemyAttack(player, monster);
                        System.out.println("Zdrowie przeciwnika: " + monster.getHp());

                    }
                    break;

                case "CLEAVE":
                    if (doubleStrike == 1) {
                        player.Cleave(player, monster, GameLogic.monsterBase[joined]);
                    }
                    else {
                        player.Attack(monster, player);
                    }
                    EnemyAttack(player,monster);
                   break;
                case "HEAL":
                    player.Heal(player);
                    EnemyAttack(player, monster);

            }

            FightLogic.ConcludeBattle(player, monster, joined );
            FightLogic.RestoreMana(player);



        } while (player.getHP() > 0 && escape == 0);


    }

    static void EnemyAttack(Player player, Monster monster1) throws InterruptedException {
        if (doubleStrike == 1 && GameLogic.monsterBase[joined].getFreeze() == 0 && GameLogic.monsterBase[joined].getHp() > 0) {
            GameLogic.monsterBase[joined].Attack(GameLogic.monsterBase[joined], player);
        }
        else if (GameLogic.monsterBase[joined].getFreeze() > 0){
            System.out.println(GameLogic.monsterBase[joined].getName() + " jest zamrożony, nie może się ruszać przez " +
                    GameLogic.monsterBase[joined].getFreeze() + " tury.");
            GameLogic.monsterBase[joined].setFreeze(GameLogic.monsterBase[joined].getFreeze() - 1);
        }
        Thread.sleep(500);
        if (monster1.getHp() > 0 && monster1.getFreeze() == 0) {
            monster1.Attack(monster1, player);
            Thread.sleep(500);
        } else if (monster1.getFreeze() > 0) {
            System.out.println(monster1.getName() + " jest zamrożony, nie może się ruszać przez " + monster1.getFreeze()
                    + " tury");
        }
    }

    public static void PlayerStatusWearOff(Player player) {

        if (player.getAdrenalineValue() > 0) {
            player.setDMG( (player.getDMG() - 60));
            player.setArmor(player.getArmor() + 40);
            player.setAdrenalineValue(0);
        }

        if (player.getIronSkinValue() > 0) {

            player.setArmor(player.getArmor() - 30);
            player.setIronSkinValue(0);
        }

        player.setFreeze(0);
        player.setPoison(0);

    }



}
