package Logic;

import Mobs.*;
import Objects.Armor;
import Objects.Shop.Shop;
import Objects.Weapon;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    Scanner scanner = new Scanner(System.in);
    Monster[] monsterBase = new Monster[1000];
    double[] field = new double[999];


    public void spawn(int mobsNumber, Monster[] monsterBase){
        Random random = new Random();

        for (int i = 1; i < mobsNumber ; i++) {
            double valueX = random.nextInt(9);
            double valueY = random.nextInt(9);
            //
            // Potwory nie pojawią się na polach 2,5 -- 5,5 i tak dalej, żeby gracz miał trochę swojego miejsca
            //
            double mobType = random.nextInt(100);
            if ((valueX > 5 || valueX < 3 )&& (valueY > 5 || valueY< 3)){
            if (mobType < 26){
            monsterBase[i] = new Goblin(70, 30,valueX,valueY, "goblin", 50, 50, 2);}
             else if (mobType < 51 && mobType > 25){
                monsterBase[i] = new Spider(80, 20, valueX,valueY, "pająk", 30, 1);
            }
          /*       else if (mobType < 61 && mobType > 40){
                monsterBase[i] = new Minotaur(200,60,valueX,valueY, "minotaur", 150, 5);
                }*/
                    else if (mobType < 76 && mobType > 50){
                monsterBase[i] = new Werewolf(150, 40, valueX,valueY,"wilkołak", 100, 100, 4);
                    }
                        else if (mobType > 75){
                monsterBase[i] = new Vampire(160, 50, valueX,valueY,"wampir",120,80, 3);
                        }
                        else {
                System.out.println("ERROR");
            }
            if (field[i-1] != valueX * 100 + valueY){
                field[i] = valueX * 100 + valueY;}
            else {
                System.out.println("ERROR");}}
            else {
                i = i -1;
            }
            }
            //
            // Jakbyś testował spawner to włącz sobie poniższe printy,
            // wyświetlą info o każdym wygenerowanym potworku
            //
          /*  System.out.println(monsterBase[i].getHp());
            System.out.println(monsterBase[i].getDmg());
            System.out.println("Rodzaj potwora: ");
            System.out.println(monsterBase[i].getName());
            System.out.println("Koordy:");
            System.out.println(monsterBase[i].getX());
            System.out.println(monsterBase[i].getY());
            System.out.println();*/
        }

    public static void checker(Player player, Monster monster) {
        if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
            Fight.Turn(player, monster);
        }
    }
    public void Game(){
      /*  Monster[] monsterBase = new Monster[100];*/
        final String SETTINGS = "9";
        final String INFO = "8";
        Player Dawid = new Player(120,120,30,0, 0, 4, 4, 200, 0,
                0, 0);

        //
        // Podstawowe potwory są wyłączone bo generują się automatycznie
        //

       /* Goblin goblin = new Goblin(10, 30,3,2, "goblin", 50, 50, 2);*/
        Minotaur minotaur = new Minotaur(200,60,2,8, "minotaur", 150, 5);
      /*  Spider spider = new Spider(80, 20, 3, 3, "pająk", 30, 1);
        Werewolf werewolf = new Werewolf(150, 40, 0,2,"wilkołak", 100, 100, 4);
        Vampire vampire = new Vampire(160, 50, 4,2,"wampir",120,80, 3);*/
        Shop shop = new Shop(3,4);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zostałeś uwięziony w labiryncie minotaura.");
        System.out.println("Znajdź lepszy ekwipunek zanim stawisz mu czoła.");
        System.out.println("Wybierz w którą stronę checsz iść: ");
        System.out.println("Góra: UP, dół: DOWN, lewo: LEFT, prawo: RIGHT");
        String input;
        String exit = "0";
        spawn(18, monsterBase);


        do {
            System.out.println("Twoje punkty życia to: " + Dawid.getHP() + "/" + Dawid.getMaxHP());
            System.out.println("Twoje koordynaty to: " + Dawid.getX() + ", " + Dawid.getY());
            System.out.println("Wyjdź z gry: 0, Sterowanie: " + SETTINGS);
            System.out.println("Wyświetl informacje: " + INFO);

            input = scanner.nextLine();

            switch (input) {
                case "LEFT":
                    Dawid.setX(Dawid.getX()-1);
                    break;
                case "UP":
                    Dawid.setY(Dawid.getY()+1);
                    break;
                case "RIGHT":
                    Dawid.setX(Dawid.getX()+1);
                    break;
                case "DOWN":
                    Dawid.setY(Dawid.getY()-1);
                    break;
                case "HP":
                    System.out.println(Dawid.getHP());
                    break;
                case "DMG":
                    System.out.println(Dawid.getDMG());
                    break;
                case "XP":
                    System.out.println(Dawid.getXP());
                    //
                    //
                    // Trzeba ustawić możliwość wyświetlenia statystyk na żądanie
                    // zamiast wyświetlać je w każdej pętli bo się tego od zajebania zrobiło
                    // i jest spam w chuj,
                    //
                    // switch "ESC":
                    // sout ( całe statystyki )
                    //
                    break;
                case SETTINGS:
                    System.out.println("UP: góra, DOWN:, dół, LEFT, lewo, RIGHT, prawo,");
                    break;
                case INFO:
                    Test.PlayerInfo(Dawid);
            }
            checker(Dawid, monsterBase[1]);
            checker(Dawid, monsterBase[2]);
            checker(Dawid, monsterBase[3]);
            checker(Dawid, monsterBase[4]);
            checker(Dawid, monsterBase[5]);
            checker(Dawid, monsterBase[6]);
            checker(Dawid, monsterBase[7]);
            checker(Dawid, monsterBase[8]);
            checker(Dawid, monsterBase[9]);
            checker(Dawid, monsterBase[10]);
            checker(Dawid, monsterBase[11]);
            checker(Dawid, monsterBase[12]);
            checker(Dawid, monsterBase[13]);
            checker(Dawid, monsterBase[14]);
            checker(Dawid, monsterBase[15]);
            checker(Dawid, monsterBase[16]);
            checker(Dawid, monsterBase[17]);
            checker(Dawid, minotaur);
            if (Dawid.getX()== shop.getX() && Dawid.getY() == shop.getY()){
                Test.store(Dawid,shop);
            }
            if (Dawid.getX() == 4 && Dawid.getY() == 4) {
                Weapon.goldSword(Dawid);
            }
            else if (Dawid.getY() == 3 && Dawid.getX() == 5)
            {
                Armor.pickArmor(Dawid);}
            else if (Dawid.getY() < 0 || Dawid.getY() > 8 || Dawid.getX() < 0 || Dawid.getX() > 8) {
                System.out.println("Wykroczyłeś poza mapę, wracaj zanim zgubisz się w labiryncie");
            }
            if (Dawid.getHP() > 0)
            {Experience.expCounter(Dawid);
            }
            if (Dawid.getHP() < 1) {
                input = exit;
            }
        }
        while (!input.equals(exit));
        scanner.close();
    }

}
