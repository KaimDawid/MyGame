package Logic;

import Data.Areas.BanditCamp;
import Data.Areas.Forest;
import Data.Info.Info;
import Data.Quests;
import Logic.FightLogic.Fight;
import Logic.Spawners.*;
import Mobs.*;
import Objects.*;
import Objects.Items.Chests.ChestArmor;

import Objects.Items.Item;


import Objects.Items.Weapons.Weapon;
import Objects.Shop.Shop;

import java.util.Date;
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


    int borderX = 16;
    int borderY = 16;
    static int ladderCheckUPSuccessful = 0;
    static int ladderCheckDOWNSuccessful = 0;

    Scanner scanner = new Scanner(System.in);
    public static Monster[] monsterBase = new Monster[50];
    public static Monster[] forestBase = new Monster[50];
    static Monster[] monsterBase2 = new Monster[50];
    static Monster[] monsterBase3 = new Monster[50];

    public static Item[] equipment = new Item[100];

    static Monster[] monsterBase4 = new Monster[50];

    static Monster[] monsterBase5 = new Monster[50];

    static Monster[] monsterBase6 = new Monster[50];

    static Ladder[] ladders = new Ladder[10];

    static Monster[] banditCampBase = new Monster[50];

    static int[] ladX = new int[10];

    static int[] ladY = new int[10];

    static LadderDOWN[] ladderDOWNS = new LadderDOWN[10];

    static LadderUP[] ladderUPS = new LadderUP[10];

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
                        monsterBase[i] = new Goblin(120, 50, valueX, valueY, "goblin", 40, 10, 2, 1);
                    } else if (mobType < 41 && mobType > 20) {
                        monsterBase[i] = new Spider(130, 40, valueX, valueY, "pająk", 20, 1, 1);
                    }
                    //
                    //        Tu ustawiasz szansę na pojawienie się danego typu przeciwnika
                    //
                    else if (mobType < 61 && mobType > 40) {
                        monsterBase[i] = new Werewolf(200, 70, valueX, valueY, "wilkołak", 60, 20, 4, 1);
                    } else if (mobType < 81 && mobType > 60) {
                        monsterBase[i] = new Vampire(210, 70, valueX, valueY, "wampir", 70, 14, 3, 1);
                    } else if (mobType > 80) {
                        monsterBase[i] = new Mutant(250, 80, valueX, valueY, "mutant", 120, 50, 5, 1);
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



    public void Game() throws InterruptedException {
        /*  Monster[] monsterBase = new Monster[100];*/
        final String SETTINGS = "9";
        final String INFO = "8";

        //
        // Podstawowe potwory są wyłączone bo generują się automatycznie
        //

        Player Dawid = new Player(350, 350, 80, 0, 0, 4, 4, 20, 0,
                0, 0);
        Dawid.setFloor(1);
        Dawid.setClassNumber(1);
        Dawid.setMana(100);
        Minotaur minotaur = new Minotaur(600, 60, 2, 8, "minotaur", 400, 8, 2);

        Random random = new Random();

        try {
            createLadder(0);
        }
        catch (ArrayIndexOutOfBoundsException b){

        }
        try {
            createLadder(1);
        }
        catch (NullPointerException a ){

        }
        createLadder(2);
        createLadder(3);
        createLadder(4);
        createLadder(5);



        equipment[1] = new ChestArmor("Płytowa zbroja", 40, 20, 3, 30, 1);

      /*  LadderUP ladderUP1 = new LadderUP(5, 5, 2);*/
        /*Mutant mutant = new Mutant(100, 30, 5, 5, "mutant", 100, 50, 30, 1);*/
        /*Goblin goblin = new Goblin(10,10,4,5,"Goblin", 40, 999, 1, 1);*/
         Spider spider = new Spider(10, 20, 5, 5, "pająk", 30, 1,1);
        Spider spider2 = new Spider(10, 20, 5, 5, "pająk", 30, 1,1);
        Spider spider3 = new Spider(10, 20, 5, 5, "pająk", 30, 1,1);
        Spider spider4 = new Spider(10, 20, 5, 5, "pająk", 30, 1,1);
        equipment[2] = new Weapon("Sztylet", 0, 20, 5, 0, 1, 1, 1);
        eqNumber[30] = new Weapon("Sztylet", 0, 20, 5, 0, 1,1,1);
        eqNumber[31] = new Weapon("Laska nowicjusza", 0, 10, 10, 60, 2, 0, 1);

       /* Werewolf werewolf = new Werewolf(150, 40, 0,2,"wilkołak", 100, 100, 4);
        Vampire vampire = new Vampire(160, 50, 4,2,"wampir",120,80, 3);*/

        Info.Version.printPatchNotes();

        Shop shop = new Shop(3, 4);
        shop.setFloor(1);
        Scanner scanner = new Scanner(System.in);
        String welcome = """
                          
                Dzięki za zagranie w grę :) Twoim zadaniem jest          
                zabicie bossa, najpierw musisz jednak rozwinąć postać
                Poluj na mniejsze potwory, zdobywaj poziomy
                I znajdź drabinę która przeniesie Cię na kolejny poziom lochu
                Jest wiele różnych sposobów na grę, możesz skupić się na magii,
                ataku i ciosach krytycznych, czy wytrwałości.
                Eksperymentuj z różnymi stylami gry i baw się dobrze :)
                
                Wybierz w którą stronę checsz iść: 
                Góra: W, dół: S, lewo: A, prawo: D
                      """;
        welcome = welcome.indent(30);
        System.out.println(welcome);
        String input;




        String exit = "0";
        spawn(27, monsterBase);
        SpawnFloor2.SPAWN(27, monsterBase2);
        SpawnFloor3.SPAWN(27, monsterBase3);
        SpawnFloor4.SPAWN(27,monsterBase4);
        SpawnFloor5.SPAWN(27,monsterBase5);
        SpawnFloor6.SPAWN(27,monsterBase6);
        Forest.SPAWN(27, forestBase);
        BanditCamp.SPAWN(27,banditCampBase);
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
            if (Dawid.getX() > 2 && Dawid.getX() < 6 && Dawid.getY() > 2 && Dawid.getY() < 6){
                System.out.println("Jesteś w mieście, wpisz TOWN aby do niego wejść i porozmawiać z tutejszymi mieszkańcami");
            }
            if (Dawid.getY() > 8 && Dawid.getX() < 9){
                System.out.println("Jesteś teraz w lesie pełnym pająków i wilków");
            }
            if (Dawid.getX() > 8 && Dawid.getY() < 9){
                System.out.println("Jesteś w obozie bandytów");
            }
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
                    if (Dawid.getY() < borderY) {
                        Dawid.setY(Dawid.getY() + 1);
                    } else if (Dawid.getY() >= borderY){
                        System.out.println("Natrafiłeś na ścianę, nie możesz już iść w tą stronę");
                    }
                    else if (Dawid.getY() > 8){
                        System.out.println("Jesteś teraz w lesie pająków");
                    }

                    break;
                case "D":
                    if (Dawid.getX() < borderX) {
                        Dawid.setX(Dawid.getX() + 1);
                    } else if (Dawid.getX() >= borderX) {
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
                case "TOWN":
                    if (Dawid.getX() < 6 && Dawid.getX() > 2 && Dawid.getY() < 6 && Dawid.getY() > 2) {
                        System.out.println("Gdzie chcesz pójść?");
                        System.out.println("Kowal");
                        System.out.println("Ratusz");
                        String input2 = scanner.nextLine().toUpperCase();
                        switch (input2) {
                            case "KOWAL":
                            Quests.QuestConvo(Dawid);
                            break;
                            case "RATUSZ":
                            Quests.Quest2Convo(Dawid);
                            break;
                        }
                    }
                    break;
                case "PATCH":
                    Info.Version.printMe();
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
                            System.out.println((i) + ". " + eqNumber[i].getShortName() + " (" + eqNumber[i].getHP() + " HP, "
                            + eqNumber[i].getDMG() + " DMG, " + eqNumber[i].getCrit() + "Crit, " + eqNumber[i].getMagic()
                            + " Mocy zaklęć) ");
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


                    break;
                case "MAP":
                    System.out.println("Sklep: X:" + shop.getX() + ", Y:" + shop.getY());
                    System.out.println("Drabina piętro 1: X:" + ladderDOWNS[1].getX() + " Y:" + ladderDOWNS[1].getY());
                    System.out.println("Las: X: 1-8, Y: 8-16");
                    break;
                case "ABCDE":
                    Dawid.setHP(10000);
                    Dawid.setDMG(10000);
                    Dawid.setMaxHP(10000);


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
            LadderCheckDOWN(ladderDOWNS[1], Dawid);
            LadderCheckUP(ladderUPS[1], Dawid);
            LadderCheckDOWN(ladderDOWNS[2], Dawid);
            LadderCheckUP(ladderUPS[2], Dawid);
            LadderCheckDOWN(ladderDOWNS[3], Dawid);
            LadderCheckUP(ladderUPS[3], Dawid);
            LadderCheckDOWN(ladderDOWNS[4], Dawid);
            LadderCheckUP(ladderUPS[4], Dawid);
            LadderCheckDOWN(ladderDOWNS[5], Dawid);
            LadderCheckUP(ladderUPS[5], Dawid);
            /*checker(Dawid, mutant);*/
            if (Dawid.getEscapeInvulnerability() < 1) {


                for (int icheck = 1; icheck < spawnedMonsters; icheck++) {
                    checker(Dawid, monsterBase[icheck]);
                    checker(Dawid, monsterBase2[icheck]);
                    checker(Dawid, monsterBase3[icheck]);
                    checker(Dawid, monsterBase4[icheck]);
                    checker(Dawid, monsterBase5[icheck]);
                    checker(Dawid, monsterBase6[icheck]);
                    checker(Dawid,forestBase[icheck]);
                    checker(Dawid,banditCampBase[icheck]);
                    if (checkSuccesful > 0) {
                        checkSuccesful = 0;
                        break;
                    }
                }

                checker(Dawid, minotaur);
                if (Dawid.getX() == shop.getX() && Dawid.getY() == shop.getY() && Dawid.getFloor() == shop.getFloor()) {
                    Test.store(Dawid, shop);
                }

            } else {
                Dawid.setEscapeInvulnerability(0);
            }
            Dawid.setEscapeInvulnerability(0);
           if (Dawid.getY() == 3 && Dawid.getX() == 5) {
                Armor.pickArmor(Dawid);
            }
            if (Dawid.getHP() > 0) {
                Experience.expCounter(Dawid);
            }
            if (Dawid.getHP() < 1) {
                System.out.println("Odrodziłeś się w mieście, niestety utraciłeś całe doświadczenie zdobyte w walce");
                Dawid.setXP(0);
                Dawid.setX(4);
                Dawid.setY(4);
                Dawid.setHP(Dawid.getMaxHP());
                /*input = exit;*/
            }
        }
        while (!input.equals(exit));
        scanner.close();
    }

    public void eqDisplay(Player player) {


    }

    public static void createLadder(int floor) {
        Random random = new Random();
        ladderDOWNS[floor] = new LadderDOWN(1,1,floor);
        ladderUPS[floor] = new LadderUP(1, 1, (floor+1));
        for (int f = 0; f < 1; f++) {


            // to może nie działać


            ladX[floor] = (random.nextInt(8) + 1);
            ladY[floor] = (random.nextInt(8) + 1);


            if ((ladX[floor] > (ladderUPS[floor - 1].getX() + 4) || ladX[floor] < (ladderUPS[floor - 1].getX() - 4)) ||
                    (ladY[floor] > (ladderUPS[floor - 1].getY() + 4) || ladY[floor] < (ladderUPS[floor - 1].getY() - 4))) {


                ladderDOWNS[floor].setX(ladX[floor]);
                ladderDOWNS[floor].setY(ladY[floor]);

                ladderUPS[floor].setX(ladX[floor]);
                ladderUPS[floor].setY(ladY[floor]);
                System.out.println("Koordy drabiny " + floor + " to: ");
                System.out.println("X: " + ladX[floor]);
                System.out.println("Y: " + ladY[floor]);
                System.out.println("floor: " + ladderUPS[floor].getFloor());
            } else {
                f = f - 1;
            }
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
                    ladderCheckUPSuccessful = 1;
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

}
