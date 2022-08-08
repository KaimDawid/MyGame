package Logic;

import Logic.Spawners.*;
import Mobs.*;
import Objects.*;
import Objects.Items.Chests.MailShirt;
import Objects.Items.Hands.BasiliskGloves;
import Objects.Items.Helmets.DrakeHelmet;
import Objects.Items.Helmets.LeatherHelmet;
import Objects.Items.Necklaces.PearlNecklace;
import Objects.Items.Weapons.Dagger;
import Objects.Shop.Shop;

import java.util.Random;
import java.util.Scanner;




// TODO: 08.08.2022 - fabuła
//                - NPC
//                - Questy
//                - Weapon enchants
//                - Status invulnerability
//                - dungeons (grota wampirów, piekło)
//                - żywioły ( jeśli rzucisz błyskawice na potwora który otrzymał wodnym pociskiem, dostaje stuna )
//                - system dnia i nocy
//                - więcej sklepów i przedmiotów do kupienia!
//

import static Mobs.Monster.eqNumber;

public class GameLogic {
    static int checkSuccesful = 0;

    int toxic = 0;


    Scanner scanner = new Scanner(System.in);
    public static Monster[] monsterBase = new Monster[50];
    static Monster[] monsterBase2 = new Monster[50];
    static Monster[] monsterBase3 = new Monster[50];

    static Monster[] monsterBase4 = new Monster[50];

    static Monster[] monsterBase5 = new Monster[50];

    static Monster[] monsterBase6 = new Monster[50];

    double[] field = new double[100];
    public static int spawnedMonsters = 1;
    int spawnedMonstersFloor2 = 1;

    double checkme[] = new double[500];

    public void spawn(int mobsNumber, Monster[] monsterBase) {

        Random random = new Random();

        for (int i = 0; i < mobsNumber; i++) {
            double valueX = random.nextInt(8) + 1;
            double valueY = random.nextInt(8) + 1;


            checkme[i] = (valueX * 100 + valueY);
            //
            // Potwory nie pojawią się na polach 2,5 -- 5,5 i tak dalej, żeby gracz miał trochę swojego miejsca
            //
            double mobType = random.nextInt(100);
            int valid = 0;

            for (int j = 0; j < i; j++) {

                if (checkme[i] == checkme[j]) {
                    valid = 1;
                    break;
                } else {

                }

            }
            if ((valueX > 5 || valueX < 3) || (valueY > 5 || valueY < 3)) {
                if (valid < 1) {
                    spawnedMonsters++;
                    if (mobType < 21) {
                        monsterBase[i] = new Goblin(120, 30, valueX, valueY, "goblin", 40, 10, 2, 1);
                    } else if (mobType < 41 && mobType > 20) {
                        monsterBase[i] = new Spider(130, 20, valueX, valueY, "pająk", 20, 1, 1);
                    }
                    //
                    //        Tu ustawiasz szansę na pojawienie się danego typu przeciwnika
                    //
                    else if (mobType < 61 && mobType > 40) {
                        monsterBase[i] = new Werewolf(200, 40, valueX, valueY, "wilkołak", 60, 20, 4, 1);
                    } else if (mobType < 81 && mobType > 60) {
                        monsterBase[i] = new Vampire(210, 50, valueX, valueY, "wampir", 70, 14, 3, 1);
                    } else if (mobType > 80) {
                        monsterBase[i] = new Mutant(250, 60, valueX, valueY, "mutant", 120, 50, 5, 1);
                    }
                    int emptyslots = mobsNumber;


                    //
                    // Jakbyś testował spawner to włącz sobie poniższe printy,
                    // wyświetlą info o każdym wygenerowanym potworku
                    //
                   /* System.out.println(monsterBase[i].getHp());
                    System.out.println(monsterBase[i].getDmg());
                    System.out.println("Rodzaj potwora: ");
                    System.out.println(monsterBase[i].getName());
                    System.out.println("Koordy:");
                    System.out.println(monsterBase[i].getX());
                    System.out.println(monsterBase[i].getY());
                    System.out.println("Piętro: " + monsterBase[i].getFloor());
                    System.out.println();
                    System.out.println(spawnedMonsters);*/

                } else {

                    i = i - 1;
                }
            } else {

                i = i - 1;
            }
        }
    }


    public static void checker(Player player, Monster monster) throws InterruptedException {
        try {
            if (player.getX() == monster.getX() && player.getY() == monster.getY() && player.getFloor() == monster.getFloor() && monster.getHp() > 0) {
                Fight.Turn(player, monster);
                checkSuccesful = 1;
            }
        } catch (NullPointerException a) {

        }
    }


    public static void LadderCheckUP(LadderUP ladder, Player player) {
        Scanner scanner1 = new Scanner(System.in);
        if (player.getX() == ladder.getX() && player.getY() == ladder.getY() && player.getFloor() == ladder.getFloor()) {
            System.out.println("Znalazłeś drabinę! Możesz teraz zmienić piętro.");
            System.out.println("UP - wejdź piętro wyżej,      0: wyjdź");
            String ladderChoice = scanner1.nextLine().toUpperCase();
            switch (ladderChoice) {

                case "UP":
                    Ladder.ASCEND(player);
                    break;
                case "0":
                    break;

            }

        }
    }


    public static void LadderCheckDOWN(LadderDOWN ladder, Player player) {
        Scanner scanner1 = new Scanner(System.in);
        if (player.getX() == ladder.getX() && player.getY() == ladder.getY() && player.getFloor() == ladder.getFloor()) {
            System.out.println("Znalazłeś drabinę! Możesz teraz zmienić piętro.");
            System.out.println("DOWN - zejdź piętro niżej,      0: wyjdź");
            String ladderChoice = scanner1.nextLine().toUpperCase();
            switch (ladderChoice) {

                case "DOWN":
                    Ladder.DESCEND(player);
                    break;
                case "0":
                    break;

            }

        }
    }

    public void Game() throws InterruptedException {
        /*  Monster[] monsterBase = new Monster[100];*/
        final String SETTINGS = "9";
        final String INFO = "8";

        //
        // Podstawowe potwory są wyłączone bo generują się automatycznie
        //

        Player Dawid = new Player(200, 200, 30, 0, 0, 4, 4, 20, 0,
                0, 0);
        Dawid.setFloor(1);
        Dawid.setClassNumber(1);
        Dawid.setMana(100);
        Minotaur minotaur = new Minotaur(600, 60, 2, 8, "minotaur", 400, 8, 2);

        Random random = new Random();

        LadderDOWN ladderDOWN1 = new LadderDOWN(1, 1, 1);
        LadderUP ladderUP1 = new LadderUP(1, 1, 2);
        for (int k = 0; k < 1; k++) {
            int LadderX;
            int LadderY;
            LadderX = (random.nextInt(8) + 1);
            LadderY = (random.nextInt(8) + 1);


            if ((LadderX > 6 || LadderX < 3) || (LadderY > 6 || LadderY < 3)) {


                ladderDOWN1.setX(LadderX);
                ladderDOWN1.setY(LadderY);

                ladderUP1.setX(LadderX);
                ladderUP1.setY(LadderY);
                System.out.println("Koordy drabiny to: ");
                System.out.println("X: " + LadderX);
                System.out.println("Y: " + LadderY);
                System.out.println("floor: " + ladderUP1.getFloor());
            } else {
                k = k - 1;
            }
        }

        LadderDOWN ladderDOWN2 = new LadderDOWN(1, 1, 2);
        LadderUP ladderUP2 = new LadderUP(1, 1, 3);
        for (int f = 0; f < 1; f++) {
            int LadderX2;
            int LadderY2;
            LadderX2 = (random.nextInt(8) + 1);
            LadderY2 = (random.nextInt(8) + 1);


            if ((LadderX2 > (ladderUP1.getX() + 4) || LadderX2 < (ladderUP1.getX() - 4)) || (LadderY2 > (ladderUP1.getY() + 4) || LadderY2 < (ladderUP1.getY() - 4))) {


                ladderDOWN2.setX(LadderX2);
                ladderDOWN2.setY(LadderY2);

                ladderUP2.setX(LadderX2);
                ladderUP2.setY(LadderY2);
                System.out.println("Koordy drabiny 2 to: ");
                System.out.println("X: " + LadderX2);
                System.out.println("Y: " + LadderY2);
                System.out.println("floor: " + ladderUP2.getFloor());
            } else {
                f = f - 1;
            }
        }
        LadderDOWN ladderDOWN3 = new LadderDOWN(1, 1, 3);
        LadderUP ladderUP3 = new LadderUP(1, 1, 4);
        for (int f3 = 0; f3 < 1; f3++) {
            int LadderX3;
            int LadderY3;
            LadderX3 = (random.nextInt(8) + 1);
            LadderY3 = (random.nextInt(8) + 1);


            if ((LadderX3 > (ladderUP2.getX() + 4) || LadderX3 < (ladderUP2.getX() - 4)) || (LadderY3 > (ladderUP2.getY() + 4) || LadderY3 < (ladderUP2.getY() - 4))) {


                ladderDOWN3.setX(LadderX3);
                ladderDOWN3.setY(LadderY3);

                ladderUP3.setX(LadderX3);
                ladderUP3.setY(LadderY3);
                System.out.println("Koordy drabiny 3 to: ");
                System.out.println("X: " + LadderX3);
                System.out.println("Y: " + LadderY3);
                System.out.println("floor: " + ladderUP3.getFloor());
            } else {
                f3 = f3 - 1;
            }
        }
        LadderDOWN ladderDOWN4 = new LadderDOWN(1, 1, 4);
        LadderUP ladderUP4 = new LadderUP(1, 1, 5);
        for (int f4 = 0; f4 < 1; f4++) {
            int LadderX4;
            int LadderY4;
            LadderX4 = (random.nextInt(8) + 1);
            LadderY4 = (random.nextInt(8) + 1);


            if ((LadderX4 > (ladderUP3.getX() + 4) || LadderX4 < (ladderUP3.getX() - 4)) || (LadderY4 > (ladderUP3.getY() + 4) || LadderY4 < (ladderUP3.getY() - 4))) {


                ladderDOWN4.setX(LadderX4);
                ladderDOWN4.setY(LadderY4);

                ladderUP4.setX(LadderX4);
                ladderUP4.setY(LadderY4);
                System.out.println("Koordy drabiny 4 to: ");
                System.out.println("X: " + LadderX4);
                System.out.println("Y: " + LadderY4);
                System.out.println("floor: " + ladderUP4.getFloor());
            } else {
                f4 = f4 - 1;
            }
        }
        LadderDOWN ladderDOWN5 = new LadderDOWN(1, 1, 5);
        LadderUP ladderUP5 = new LadderUP(1, 1, 6);
        for (int f5 = 0; f5 < 1; f5++) {
            int LadderX5;
            int LadderY5;
            LadderX5 = (random.nextInt(8) + 1);
            LadderY5 = (random.nextInt(8) + 1);


            if ((LadderX5 > (ladderUP4.getX() + 4) || LadderX5 < (ladderUP4.getX() - 4)) || (LadderY5 > (ladderUP4.getY() + 4) || LadderY5 < (ladderUP4.getY() - 4))) {


                ladderDOWN5.setX(LadderX5);
                ladderDOWN5.setY(LadderY5);

                ladderUP5.setX(LadderX5);
                ladderUP5.setY(LadderY5);
                System.out.println("Koordy drabiny 5 to: ");
                System.out.println("X: " + LadderX5);
                System.out.println("Y: " + LadderY5);
                System.out.println("floor: " + ladderUP5.getFloor());
            } else {
                f5 = f5 - 1;
            }
        }




       /* LadderDOWN ladderDOWN1 = new LadderDOWN(5,5,1);

        LadderUP ladderUP1 = new LadderUP(5, 5, 2);*/
        /*Mutant mutant = new Mutant(100, 30, 5, 5, "mutant", 100, 50, 30, 1);*/
        /*Goblin goblin = new Goblin(10,10,4,5,"Goblin", 40, 999, 1, 1);*/
        /* Spider spider = new Spider(80, 20, 3, 3, "pająk", 30, 1);*/
       /* Werewolf werewolf = new Werewolf(150, 40, 0,2,"wilkołak", 100, 100, 4);
        Vampire vampire = new Vampire(160, 50, 4,2,"wampir",120,80, 3);*/

        Shop shop = new Shop(3, 4);
        shop.setFloor(1);
        Scanner scanner = new Scanner(System.in);
        String welcome = """
                          
                          
                Zostałeś uwięziony w labiryncie minotaura.
                Znajdź lepszy ekwipunek zanim stawisz mu czoła.
                Wybierz w którą stronę checsz iść: 
                Góra: W, dół: S, lewo: A, prawo: D
                      """;
        welcome = welcome.indent(30);
        System.out.println(welcome);
        String input;

        DrakeHelmet head1 = new DrakeHelmet(1);


        String exit = "0";
        spawn(27, monsterBase);
        SpawnFloor2.SPAWN(27, monsterBase2);
        SpawnFloor3.SPAWN(27, monsterBase3);
        SpawnFloor4.SPAWN(27,monsterBase4);
        SpawnFloor5.SPAWN(27,monsterBase5);
        SpawnFloor6.SPAWN(27,monsterBase6);
        int helmEQ = 0;
        int weaponEQ = 0;
        int neckEQ = 0;
        int handsEQ = 0;
        int chestEQ = 0;
        Dawid.setEscapeInvulnerability(0);

        do {


            if (Dawid.getEscapeInvulnerability() > 0) {
                System.out.println("Uciekłeś przed walką!");
            }
            System.out.printf("Twoje punkty życia to: %.0f/%.0f\n", Dawid.getHP(), Dawid.getMaxHP());
            System.out.println("Twoje koordynaty to: " + Dawid.getX() + ", " + Dawid.getY() +
                    "             Piętro: " + Dawid.getFloor() + "          Mana: " + Dawid.getMana()
                    + "/" + Dawid.getMaxMana());
            System.out.println("Wyjdź z gry: 0, Sterowanie: " + SETTINGS + ", Ekwipunek: EQ,            Atrybuty : LVLUP");
            if (Dawid.getChosenSkill1() == Player.TP || Dawid.getChosenSkill2() == Player.TP ||
                    Dawid.getChosenSkill3() == Player.TP || Dawid.getChosenSkill4() == Player.TP ||
                    Dawid.getChosenSkill5() == Player.TP) {
                System.out.println("Teleportacja: TP");
            }
            System.out.println("Wyświetl informacje: " + INFO + "                                   Wyjdź z gry: EXIT");
            input = scanner.nextLine().toUpperCase();


            switch (input) {
                case "A":
                    if (Dawid.getX() > 1) {
                        Dawid.setX(Dawid.getX() - 1);
                    } else {
                        System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
                    }
                    break;
                case "W":
                    if (Dawid.getY() < 8) {
                        Dawid.setY(Dawid.getY() + 1);
                    } else {
                        System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
                    }

                    break;
                case "D":
                    if (Dawid.getX() < 8) {
                        Dawid.setX(Dawid.getX() + 1);
                    } else {
                        System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
                    }

                    break;
                case "S":
                    if (Dawid.getY() > 1) {
                        Dawid.setY(Dawid.getY() - 1);
                    } else {
                        System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
                    }

                    break;
                case "HP":
                    System.out.println(Dawid.getHP());
                    break;
                case "DMG":
                    System.out.println(Dawid.getDMG());
                    break;
                case "XP":
                    System.out.println(Dawid.getXP());
                    break;
                case "TP":
                    if (Dawid.getChosenSkill1() == Player.TP || Dawid.getChosenSkill2() == Player.TP ||
                            Dawid.getChosenSkill3() == Player.TP || Dawid.getChosenSkill4() == Player.TP ||
                            Dawid.getChosenSkill5() == Player.TP) {
                        System.out.println("Użyłeś teleportacji!");
                        Dawid.Teleport(Dawid);
                    } else {
                        System.out.println("Nie posiadasz tej umiejętności");
                    }
                    break;


                case "LVLUP":

                    String attributes = "1";
                    do {

                        System.out.println("Masz " + Dawid.getAttributePoints() + " punktów umiejętności");
                        System.out.println("Wybierz którą statystykę chcesz podnieść: ");
                        System.out.println("1. Atak (+1)");
                        System.out.println("2. Moc zaklęć (+5)");
                        System.out.println("3. Punkty życia (+6)");
                        System.out.println("4. Szansa na cios krytyczny (+0,5%)");
                        System.out.println("5. Regeneracja many (+0,5 na turę)");
                        System.out.println("0. Wyjdź");

                        attributes = scanner.nextLine();
                        switch (attributes) {
                            case "1":
                                if (Dawid.getAttributePoints() > 0) {
                                    Dawid.setDMG(Dawid.getDMG() + 1);
                                    Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
                                } else {
                                    System.out.println("Nie masz już punktów umiejętności");
                                }
                                break;
                            case "2":
                                if (Dawid.getAttributePoints() > 0) {
                                    Dawid.setMagic(Dawid.getMagic() + 5);
                                    Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
                                } else {
                                    System.out.println("Nie masz już punktów umiejętności");
                                }
                                break;
                            case "3":
                                if (Dawid.getAttributePoints() > 0) {
                                    Dawid.setMaxHP(Dawid.getMaxHP() + 6);
                                    Dawid.setHP(Dawid.getHP() + 6);
                                    Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
                                } else {
                                    System.out.println("Nie masz już punktów umiejętności");
                                }
                                break;
                            case "4":
                                if (Dawid.getAttributePoints() > 0) {
                                    Dawid.setCritChance(Dawid.getCritChance() + 0.5);
                                    Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
                                } else {
                                    System.out.println("Nie masz już punktów umiejętności");
                                }
                                break;
                            case "5":
                                if (Dawid.getAttributePoints() > 0) {
                                    Dawid.setManaRegen(Dawid.getManaRegen() + 0.5);
                                    Dawid.setAttributePoints(Dawid.getAttributePoints() - 1);
                                } else {
                                    System.out.println("Nie masz już punktów umiejętności");
                                }
                                break;
                            case "0":
                                attributes = "0";
                                break;
                            default:
                                attributes = "0";
                        }


                    }
                    while (attributes != "0");


                    break;


                case "EQ":


                    System.out.println("Twoje przedmioty: ");
                    System.out.println("Naciśnij numer przedmiotu aby go założyć lub zdjąć, wpisz OFF aby zdjąć wszystkie" +
                            " przedmioty lub 0 aby wyjść z ekwipunku");
                    for (int i = 0; i < 50; i++) {
                        try {
                            System.out.println((i + 1) + ". " + eqNumber[i].getName());
                            if (eqNumber[i].getEqValue() > 0) {
                                System.out.println("(Założony)");
                            }
                        } catch (NullPointerException a) {
                        }
                    }
                    Inventory.INVENTORY(Dawid);


                case SETTINGS:
                    System.out.println("W: góra, S: dół, A: lewo, D: prawo,");
                    break;
                case INFO:
                    Test.PlayerInfo(Dawid);
                    break;
                case "EXIT":
                    input = exit;
                    break;
                case "GIVEITEMS":
                    eqNumber[0] = new Dagger(1);
                    eqNumber[1] = new Dagger(1);
                    eqNumber[2] = new DrakeHelmet(1);
                    eqNumber[3] = new DrakeHelmet(1);
                    eqNumber[4] = new MailShirt(1);
                    eqNumber[5] = new PearlNecklace(1);
                    eqNumber[6] = new BasiliskGloves(1);
                    eqNumber[7] = new LeatherHelmet(1);
                    break;
                case "ABCDE":
                    Dawid.setHP(10000);
                    Dawid.setDMG(10000);
                    Dawid.setMaxHP(10000);
                    eqNumber[0] = new Dagger(1);
                    eqNumber[1] = new Dagger(1);
                    eqNumber[2] = new DrakeHelmet(1);
                    eqNumber[3] = new DrakeHelmet(1);
                    eqNumber[4] = new MailShirt(1);
                    eqNumber[5] = new PearlNecklace(1);
                    eqNumber[6] = new BasiliskGloves(1);
                    eqNumber[7] = new LeatherHelmet(1);
                    Dawid.setChosenSkill1(Player.ICE);
                    Dawid.setChosenSkill2(Player.FIREBALL);
                    Dawid.setChosenSkill3(Player.TP);
                    System.out.println("                       ______\n" +
                            "                    .-\"      \"-.\n" +
                            "                   /            \\\n" +
                            "       _          |              |          _\n" +
                            "      ( \\         |,  .-.  .-.  ,|         / )\n" +
                            "       > \"=._     | )(__/  \\__)( |     _.=\" <\n" +
                            "      (_/\"=._\"=._ |/     /\\     \\| _.=\"_.=\"\\_)\n" +
                            "             \"=._ (_     ^^     _)\"_.=\"\n" +
                            "                 \"=\\__|IIIIII|__/=\"\n" +
                            "                _.=\"| \\IIIIII/ |\"=._\n" +
                            "      _     _.=\"_.=\"\\          /\"=._\"=._     _\n" +
                            "     ( \\_.=\"_.=\"     `--------`     \"=._\"=._/ )\n" +
                            "      > _.=\"                            \"=._ <\n" +
                            "     (_/             WPISANO KODY!!!        \\_)");
                    break;

                case "MOREEXP":
                    Dawid.setXP(Dawid.getXP() + 100);
                    System.out.println("Dodałeś 100 expa, teraz masz " + Dawid.getXP());
                    break;
            }
            LadderCheckDOWN(ladderDOWN1, Dawid);
            LadderCheckUP(ladderUP1, Dawid);
            LadderCheckDOWN(ladderDOWN2, Dawid);
            LadderCheckUP(ladderUP2, Dawid);
            LadderCheckDOWN(ladderDOWN3, Dawid);
            LadderCheckUP(ladderUP3, Dawid);
            LadderCheckDOWN(ladderDOWN4, Dawid);
            LadderCheckUP(ladderUP4, Dawid);
            LadderCheckDOWN(ladderDOWN5, Dawid);
            LadderCheckUP(ladderUP5, Dawid);
            /*checker(Dawid, mutant);*/
            if (Dawid.getEscapeInvulnerability() < 1) {

                for (int icheck = 1; icheck < spawnedMonsters; icheck++) {
                    checker(Dawid, monsterBase[icheck]);
                    checker(Dawid, monsterBase2[icheck]);
                    checker(Dawid, monsterBase3[icheck]);
                    checker(Dawid, monsterBase4[icheck]);
                    checker(Dawid, monsterBase5[icheck]);
                    checker(Dawid, monsterBase6[icheck]);
                    if (checkSuccesful > 0) {
                        checkSuccesful = 0;
                        break;
                    }
                }
               /* for (int h = 1; h < (spawnedMonsters * 2); h++) {
                    checker(Dawid, monsterBase2[h]);
                    if (checkSuccesful > 0) {
                        checkSuccesful = 0;
                        break;
                    }
                }*/
                checker(Dawid, minotaur);
                if (Dawid.getX() == shop.getX() && Dawid.getY() == shop.getY() && Dawid.getFloor() == shop.getFloor()) {
                    Test.store(Dawid, shop);
                }

            } else {
                Dawid.setEscapeInvulnerability(0);
            }
            Dawid.setEscapeInvulnerability(0);
            if (Dawid.getX() == 3 && Dawid.getY() == 3) {
                Weapon.goldSword(Dawid);
            } else if (Dawid.getY() == 3 && Dawid.getX() == 5) {
                Armor.pickArmor(Dawid);
            } else if (Dawid.getY() < 0 || Dawid.getY() > 8 || Dawid.getX() < 0 || Dawid.getX() > 8) {
                System.out.println("Wykroczyłeś poza mapę, wracaj zanim zgubisz się w labiryncie");
            }
            if (Dawid.getHP() > 0) {
                Experience.expCounter(Dawid);
            }
            if (Dawid.getHP() < 1) {
                input = exit;
            }
        }
        while (!input.equals(exit));
        scanner.close();
    }

    public void eqDisplay(Player player) {


    }

}
