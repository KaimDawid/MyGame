package Logic;

import Mobs.*;
import Objects.Armor;
import Objects.Shop.Shop;
import Objects.Weapon;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    Scanner scanner = new Scanner(System.in);
    Monster[] monsterBase = new Monster[1000];
    double[] field = new double[999];
int spawnedMonsters = 1;



    public void spawn(int mobsNumber, Monster[] monsterBase){
        Random random = new Random();

        for (int i = 1; i < mobsNumber ; i++) {
            double valueX = random.nextInt(9);
            double valueY = random.nextInt(9);
            field[i] = (valueX * 100 + valueY);
            //
            // Potwory nie pojawią się na polach 2,5 -- 5,5 i tak dalej, żeby gracz miał trochę swojego miejsca
            //
            double mobType = random.nextInt(100);
       /*     for (int j = 0; j < i - 1; j++) {
                if (field[j] == (valueX*100+valueY)){
                    break;
                     }
                else {

                }
            }*/
            if ((valueX > 5 || valueX < 3 )&& (valueY > 5 || valueY< 3)){
                spawnedMonsters++;
            if (mobType < 26){
            monsterBase[i] = new Goblin(70, 30,valueX,valueY, "goblin", 50, 50, 2);}
             else if (mobType < 51 && mobType > 25){
                monsterBase[i] = new Spider(80, 20, valueX,valueY, "pająk", 30, 1);
            }
             //
             //        Tu ustawiasz szansę na pojawienie się danego typu przeciwnika
             //
                    else if (mobType < 76 && mobType > 50){
                monsterBase[i] = new Werewolf(150, 40, valueX,valueY,"wilkołak", 100, 100, 4);
                    }
                        else if (mobType > 75){
                monsterBase[i] = new Vampire(160, 50, valueX,valueY,"wampir",120,80, 3);
                        }
int emptyslots = mobsNumber;

         /*   if (field[i-1] != (valueX * 100 + valueY)){
                field[i] = (valueX * 100 + valueY);}*/
                //
                // Jakbyś testował spawner to włącz sobie poniższe printy,
                // wyświetlą info o każdym wygenerowanym potworku
                //
                System.out.println(monsterBase[i].getHp());
                System.out.println(monsterBase[i].getDmg());
                System.out.println("Rodzaj potwora: ");
                System.out.println(monsterBase[i].getName());
                System.out.println("Koordy:");
                System.out.println(monsterBase[i].getX());
                System.out.println(monsterBase[i].getY());
                System.out.println();
            }
            else {
                i = i -1;
            }
            }


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

        //
        // Podstawowe potwory są wyłączone bo generują się automatycznie
        //

        Player Dawid = new Player(130,130,30,0, 0, 4, 4, 20, 0,
                0, 0);
        Minotaur minotaur = new Minotaur(200,60,2,8, "minotaur", 150, 5);
      /*  Spider spider = new Spider(80, 20, 3, 3, "pająk", 30, 1);
        Werewolf werewolf = new Werewolf(150, 40, 0,2,"wilkołak", 100, 100, 4);
        Vampire vampire = new Vampire(160, 50, 4,2,"wampir",120,80, 3);*/

        Shop shop = new Shop(3,4);
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

        String exit = "0";
        spawn(24, monsterBase);

        do {

            System.out.printf("Twoje punkty życia to: %.0f/%.0f\n", Dawid.getHP(), Dawid.getMaxHP());
            System.out.println("Twoje koordynaty to: " + Dawid.getX() + ", " + Dawid.getY());
            System.out.println("Wyjdź z gry: 0, Sterowanie: " + SETTINGS);
            System.out.println("Wyświetl informacje: " + INFO);
            input = scanner.nextLine().toUpperCase();


            switch (input) {
                case "A":
                    Dawid.setX(Dawid.getX()-1);
                    break;
                case "W":
                    Dawid.setY(Dawid.getY()+1);
                    break;
                case "D":
                    Dawid.setX(Dawid.getX()+1);
                    break;
                case "S":
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
                    break;
                case SETTINGS:
                    System.out.println("W: góra, S: dół, A: lewo, D: prawo,");
                    break;
                case INFO:
                    Test.PlayerInfo(Dawid);
            }

            for (int i = 1; i < spawnedMonsters; i++) {
                checker(Dawid, monsterBase[i]);
            }
            checker(Dawid, minotaur);
            if (Dawid.getX()== shop.getX() && Dawid.getY() == shop.getY()){
                Test.store(Dawid,shop);
            }
            if (Dawid.getX() == 3 && Dawid.getY() == 3) {
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
