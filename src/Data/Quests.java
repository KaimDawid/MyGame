package Data;

import Logic.Drop.Miscelanous;
import Logic.Inventory;
import Mobs.Monster;
import Mobs.Player;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Quests {



    static int questActive = 0;
    static int questCompletion = 0;

public static void QuestConvo(Player player) throws InterruptedException {
    if (Miscelanous.poisonSacks > 5){
        questCompletion = 1;
    }
    Scanner scanner = new Scanner(System.in);
    if (questActive == 0) {
        System.out.println("Podchodzi do ciebie barczysty mężczyzna o ciemnej skórze i jasnobłękitnych oczach");
        PressButton();
        System.out.println("Pochodzi on z krainy Kaim, rozpoznałeś to po jego specyficznym wyglądzie");
        PressButton();
        System.out.println("Kaeńczycy są znani ze swojej potężnej postury i hipnotyzujących oczu");
        PressButton();
        System.out.println("Są oni jednak bardzo łagodni, nigdy nie wdają się w bitwy i trudzą się jedynie rzemiosłem");
        PressButton();
        String welcome = """
                          
                - Witaj! nie widziałem cię tu wcześniej, a nasze miasteczko jest tak małe że łatwo rozpoznać turystę
                  (śmiech)
                  Jestem tutejszym kowalem, widziałem z daleka twój oręż i domyślam się że nie obawiasz się walki.
                      """;
        welcome = welcome.indent(10);
        System.out.println(welcome);
        PressButton();
        String welcome2 = """
                    
                   Potrzebuję pomocy, w tutejszym szpitalu brakuje jadu do produkcji antidotum na pająki.
                   Jeśli uda Ci się zebrać 6 odwłoków tych paskudztw, wykorzystam trochę trucizny aby
                   wzmocnić twój oręż. Po prostu wróć do mnie gdy będziesz gotowy.
                   Aaa, myślę że się domyślasz, ale przynieś mi coś ostrego, bez sensu żebym smarował trucizną kostur dla maga.
                   Powodzenia!
                """;
        welcome2 = welcome2.indent(10);
        System.out.println(welcome2);
        PressButton();
        questActive = 1;
    }
    else if (questActive ==1 && questCompletion == 0){
        System.out.println("- Co tutaj robisz, kazałem ci chyba coś przynieść");
        Thread.sleep(1500);
    }
    else if (questActive == 1 && questCompletion == 1){
        System.out.println("Masz moje worki z jadem?");
        System.out.println("TAK , NIE");

        String input = scanner.nextLine().toUpperCase();
        switch (input){
            case "TAK":
                System.out.println("Dziękuję ci!, uratowałeś życie wielu osób z naszej wioski.");
                Thread.sleep(1000);
                System.out.println("Codziennie ktoś pada ofiarą zatrucia przez te potworne bestie");
                Thread.sleep(1000);
                System.out.println("Daj mi swoją broń, a zatruję ją żebyś mógł ją użyć przeciwko wrogom");
                Toxify(player);
                if (player.getToxify() == 1){
                    Miscelanous.poisonSacks = Miscelanous.poisonSacks - 6;
                }

                else {
                    System.out.println("Nie mogę zatruć tej bronii, wybacz.");
                }
                break;

            case "NIE":
                System.out.println("To spierdalaj.");
                PressButton();
            break;

        }

    }
}

/* public static void Toxify(Player player){
    if (Monster.weaponEQ != 0){
        player.setToxify(1);
    }
 }*/
    public static void Toxify(Player player){
        try {
            if (Inventory.equippedweapon.getIsSharp() == 1) {
                Inventory.equippedweapon.setIsToxic(1);
                player.setToxify(1);
                System.out.println("Twoja broń jest teraz zatruta!");
            }
        }
        catch (NullPointerException a){

        }

        }

        public static void PressButton(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("(Wciśnij dowolny przycisk żeby kontynuować)");
            String next = scanner.nextLine();

        }

    }



