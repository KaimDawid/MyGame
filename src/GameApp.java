import Data.Info.Infographics;
import Logic.Experience;
import Logic.Fight;
import Logic.Test;
import Mobs.*;
import Objects.Armor;
import Objects.Shop.Shop;
import Objects.Weapon;
import java.util.Scanner;

public class GameApp {
    public static final String SETTINGS = "9";
    public static final String INFO = "8";
    public static void main(String[] args) {

        Player Dawid = new Player(120,120,30,0, 0, 2, 2, 200, 0,
                0, 0);

       Goblin goblin = new Goblin(10, 30,3,2, "goblin", 50, 50, 2);
        Minotaur minotaur = new Minotaur(200,60,2,6, "minotaur", 150, 5);
        Spider spider = new Spider(80, 20, 3, 3, "pająk", 30, 1);
        Werewolf werewolf = new Werewolf(150, 40, 0,2,"wilkołak", 100, 100, 4);
        Vampire vampire = new Vampire(160, 50, 4,2,"wampir",120,80, 3);
        Shop shop = new Shop(0,0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zostałeś uwięziony w labiryncie minotaura.");
        System.out.println("Znajdź lepszy ekwipunek zanim stawisz mu czoła.");
        System.out.println("Wybierz w którą stronę checsz iść: ");
        System.out.println("Góra: UP, dół: DOWN, lewo: LEFT, prawo: RIGHT");
        String input;
        String exit = "0";
        System.out.println("Złoto goblina: "+goblin.getGold());
        System.out.println("Twoje złoto: " + Dawid.getGold());
        System.out.println("Doświadczenie: " + goblin.getGiveXP());

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
            Test.checker(Dawid, spider);
            Test.checker(Dawid, werewolf);
            Test.checker(Dawid, goblin);
            Test.checker(Dawid, minotaur);
            if (Dawid.getX()== shop.getX() && Dawid.getY() == shop.getY()){
              Test.store(Dawid,shop);
            }
            if (Dawid.getX() == 1 && Dawid.getY() == 1) {
                Weapon.goldSword(Dawid);
            }
            else if (Dawid.getY() == 1 && Dawid.getX() == 3)
            {Armor.pickArmor(Dawid);}
            else if (Dawid.getY() < 0 || Dawid.getY() > 5 || Dawid.getX() < 0 || Dawid.getX() > 5) {
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

