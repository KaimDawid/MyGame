package Logic;

import Mobs.*;
import Objects.Armor;
import Objects.Items.Chests.MailShirt;
import Objects.Items.Hands.BasiliskGloves;
import Objects.Items.Helmets.DrakeHelmet;
import Objects.Items.Helmets.LeatherHelmet;
import Objects.Items.Necklaces.PearlNecklace;
import Objects.Shop.Shop;
import Objects.Weapon;

import java.util.Random;
import java.util.Scanner;

import static Mobs.Monster.eqNumber;

public class GameLogic {
    static int checkSuccesful = 0;

    int toxic = 0;


    Scanner scanner = new Scanner(System.in);
    Monster[] monsterBase = new Monster[1000];
    double[] field = new double[999];
    int spawnedMonsters = 1;


    double checkme[] = new double[1000];

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
                    if (mobType < 26) {
                        monsterBase[i] = new Goblin(70, 30, valueX, valueY, "goblin", 50, 50, 2);
                    } else if (mobType < 51 && mobType > 25) {
                        monsterBase[i] = new Spider(80, 20, valueX, valueY, "pająk", 30, 1);
                    }
                    //
                    //        Tu ustawiasz szansę na pojawienie się danego typu przeciwnika
                    //
                    else if (mobType < 76 && mobType > 50) {
                        monsterBase[i] = new Werewolf(150, 40, valueX, valueY, "wilkołak", 100, 100, 4);
                    } else if (mobType > 75) {
                        monsterBase[i] = new Vampire(160, 50, valueX, valueY, "wampir", 120, 80, 3);
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
            if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
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

        Player Dawid = new Player(130, 130, 30, 0, 0, 4, 4, 20, 0,
                0, 0);
        Dawid.setClassNumber(1);
        Dawid.setMana(50);
        Minotaur minotaur = new Minotaur(600, 60, 2, 8, "minotaur", 400, 8);
        /* Spider spider = new Spider(80, 20, 3, 3, "pająk", 30, 1);*/
       /* Werewolf werewolf = new Werewolf(150, 40, 0,2,"wilkołak", 100, 100, 4);
        Vampire vampire = new Vampire(160, 50, 4,2,"wampir",120,80, 3);*/

        Shop shop = new Shop(3, 4);
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
            System.out.println("Twoje koordynaty to: " + Dawid.getX() + ", " + Dawid.getY());
            System.out.println("Wyjdź z gry: 0, Sterowanie: " + SETTINGS + ", Ekwipunek: EQ");
            if (Dawid.getChosenSkill1() == Player.TP || Dawid.getChosenSkill2() == Player.TP ||
                    Dawid.getChosenSkill3() == Player.TP || Dawid.getChosenSkill4() == Player.TP ||
                    Dawid.getChosenSkill5() == Player.TP) {
                System.out.println("Teleportacja: TP");
            }
            System.out.println("Wyświetl informacje: " + INFO);
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

                    String input2 = scanner.nextLine().toUpperCase();
                    switch (input2) {
                        case "1":
                            try {
                                if (eqNumber[0].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[0].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[0].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[0].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[0].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[0].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[0].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[0].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[0].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[0].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[0].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[0].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[0].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[0].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[0].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[0].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[0].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[0].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[0].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[0].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;
                        case "2":
                            try {
                                if (eqNumber[1].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[1].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[1].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[1].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[1].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[1].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[1].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[1].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[1].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[1].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[1].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[1].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[1].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[1].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[1].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[1].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[1].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[1].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[1].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[1].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;
                        case "3":
                            try {
                                if (eqNumber[2].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[2].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[2].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[2].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[2].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[2].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[2].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[2].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[2].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[2].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[2].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[2].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[2].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[2].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[2].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[2].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[2].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[2].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[2].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[2].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;
                        case "4":
                            try {
                                if (eqNumber[3].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[3].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[3].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[3].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[3].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[3].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[3].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[3].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[3].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[3].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[3].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[3].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[3].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[3].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[3].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[3].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[3].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[3].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[3].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[3].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;
                        case "5":
                            try {
                                if (eqNumber[4].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[4].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[4].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[4].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[4].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[4].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[4].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[4].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[4].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[4].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[4].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[4].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[4].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[4].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[4].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[4].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[4].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[4].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[4].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[4].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;
                        case "6":
                            try {
                                if (eqNumber[5].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[5].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[5].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[5].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[5].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[5].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[5].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[5].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[5].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[5].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[5].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[5].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[5].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[5].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[5].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[5].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[5].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[5].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[5].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[5].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;
                        case "7":
                            try {
                                if (eqNumber[6].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[6].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[6].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[6].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[6].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[6].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[6].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[6].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[6].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[6].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[6].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[6].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[6].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[6].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[6].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[6].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[6].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[6].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[6].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[6].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;
                        case "8":
                            try {
                                if (eqNumber[7].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[7].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[7].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[7].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[7].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[7].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[7].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[7].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[7].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[7].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[7].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[7].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[7].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[7].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[7].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[7].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[7].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[7].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[7].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[7].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;
                        case "9":
                            try {
                                if (eqNumber[8].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[8].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[8].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[8].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[8].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[8].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[8].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[8].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[8].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[8].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[8].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[8].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[8].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[8].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[8].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[8].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[8].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[8].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[8].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[8].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;
                        case "10":

                            try {
                                if (eqNumber[9].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[9].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[9].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[9].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[9].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[9].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[9].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[9].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[9].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[9].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[9].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[9].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[9].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[9].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[9].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[9].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[9].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[9].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[9].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[9].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;
                        case "11":
                            try {
                                if (eqNumber[10].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[10].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[10].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[10].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[10].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[10].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[10].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[10].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[10].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[10].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[10].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[10].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[10].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[10].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[10].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[10].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[10].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[10].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[10].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[10].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;

                        case "12":
                            try {
                                if (eqNumber[11].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[11].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[11].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[11].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[11].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[11].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[11].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[11].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[11].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[11].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[11].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[11].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[11].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[11].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[11].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[11].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[11].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[11].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[11].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[11].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;

                        case "13":
                            try {
                                if (eqNumber[12].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[12].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[12].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[12].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[12].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[12].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[12].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[12].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[12].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[12].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[12].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[12].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[12].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[12].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[12].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[12].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[12].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[12].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[12].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[12].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;

                        case "14":
                            try {
                                if (eqNumber[13].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[13].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[13].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[13].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[13].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[13].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[13].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[13].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[13].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[13].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[13].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[13].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[13].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[13].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[13].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[13].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[13].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[13].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[13].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[13].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;

                        case "15":
                            try {
                                if (eqNumber[14].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[14].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[14].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[14].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[14].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[14].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[14].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[14].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[14].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[14].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[14].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[14].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[14].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[14].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[14].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[14].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[14].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[14].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[14].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[14].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;

                        case "16":
                            try {
                                if (eqNumber[15].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[15].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[15].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[15].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[15].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[15].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[15].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[15].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[15].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[15].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[15].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[15].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[15].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[15].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[15].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[15].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[15].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[15].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[15].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[15].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;

                        case "17":
                            try {
                                if (eqNumber[16].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[16].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[16].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[16].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[16].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[16].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[16].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[16].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[16].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[16].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[16].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[16].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[16].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[16].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[16].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[16].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[16].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[16].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[16].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[16].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;

                        case "18":
                            try {
                                if (eqNumber[17].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[17].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[17].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[17].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[17].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[17].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[17].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[17].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[17].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[17].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[17].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[17].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[17].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[17].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[17].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[17].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[17].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[17].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[17].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[17].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;

                        case "19":
                            try {
                                if (eqNumber[18].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[18].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[18].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[18].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[18].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[18].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[18].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[18].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[18].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[18].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[18].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[18].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[18].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[18].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[18].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[18].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[18].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[18].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[18].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[18].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;

                        case "20":
                            try {
                                if (eqNumber[19].getHelmEquip() > 0 && helmEQ < 1) {
                                    eqNumber[19].eqON(Dawid);
                                    helmEQ = 1;
                                } else if (eqNumber[19].getWeaponEquip() > 0 && weaponEQ < 1) {
                                    eqNumber[19].eqON(Dawid);
                                    weaponEQ = 1;
                                } else if (eqNumber[19].getNeckEquip() > 0 && neckEQ < 1) {
                                    eqNumber[19].eqON(Dawid);
                                    neckEQ = 1;
                                } else if (eqNumber[19].getChestEquip() > 0 && chestEQ < 1) {
                                    eqNumber[19].eqON(Dawid);
                                    chestEQ = 1;
                                } else if (eqNumber[19].getHandsEquip() > 0 && handsEQ < 1) {
                                    eqNumber[19].eqON(Dawid);
                                    handsEQ = 1;
                                } else if (eqNumber[19].getHelmEquip() > 0 && helmEQ > 0) {
                                    eqNumber[19].eqOFF(Dawid);
                                    helmEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[19].getWeaponEquip() > 0 && weaponEQ > 0) {
                                    eqNumber[19].eqOFF(Dawid);
                                    weaponEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[19].getNeckEquip() > 0 && neckEQ > 0) {
                                    eqNumber[19].eqOFF(Dawid);
                                    neckEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[19].getChestEquip() > 0 && chestEQ > 0) {
                                    eqNumber[19].eqOFF(Dawid);
                                    chestEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else if (eqNumber[19].getHandsEquip() > 0 && handsEQ > 0) {
                                    eqNumber[19].eqOFF(Dawid);
                                    handsEQ = 0;
                                    System.out.println("Zdjąłeś przedmiot");
                                } else {
                                    System.out.println("Najpierw zdejmij ekwipunek!");
                                }
                            } catch (NullPointerException a) {
                                System.out.println("Nie masz tego przedmiotu");
                            }
                            break;

                        case "0":
                            break;
                        case "OFF":
                            for (int i = 0; i < 50; i++) {
                                try {
                                    eqNumber[i].eqOFF(Dawid);
                                } catch (NullPointerException a) {

                                }
                            }
                            helmEQ = 0;
                            weaponEQ = 0;
                            neckEQ = 0;
                            chestEQ = 0;
                            handsEQ = 0;
                            System.out.println("Zdjąłeś wszystkie przedmioty");
                            Thread.sleep(500);
                        default:
                            break;
                    }

                case SETTINGS:
                    System.out.println("W: góra, S: dół, A: lewo, D: prawo,");
                    break;
                case INFO:
                    Test.PlayerInfo(Dawid);
                    break;
                case "ABCDE":
                    Dawid.setHP(10000);
                    Dawid.setDMG(10000);
                    Dawid.setMaxHP(10000);
                    eqNumber[0] = new DrakeHelmet(1);
                    eqNumber[1] = new DrakeHelmet(1);
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
            }

            if (Dawid.getEscapeInvulnerability() < 1) {
                for (int i = 1; i < spawnedMonsters; i++) {
                    checker(Dawid, monsterBase[i]);
                    if (checkSuccesful > 0) {
                        checkSuccesful = 0;
                        break;
                    }
                }
                checker(Dawid, minotaur);
                if (Dawid.getX() == shop.getX() && Dawid.getY() == shop.getY()) {
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
