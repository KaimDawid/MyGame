package Data;

import Logic.Drop.Miscelanous;
import Logic.Inventory;
import Mobs.Monster;
import Mobs.Player;
import Objects.Items.Weapons.Weapon;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter @Setter
public class Quests {

  

    static int questActive1 = 0;

static int questCompletion1 = 0;
    static int questActive2 = 0;

    static int questCompletion2 = 0;



  

    public static void QuestConvo(Player player) throws InterruptedException {
    if (Miscelanous.poisonSacks > Miscelanous.psRequirement){
        questCompletion1 = 1;
    }
    Scanner scanner = new Scanner(System.in);
    if (questActive1 == 0) {
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
        questActive1 = 1;
    }
    else if (questActive1 ==1 && questCompletion1 == 0){
        System.out.println("- Co tutaj robisz, kazałem ci chyba coś przynieść");
        Thread.sleep(1500);
    }
    else if (questActive1 == 1 && questCompletion1 == 1){
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

    public static void Quest2Convo(Player player) throws InterruptedException {
        if (Miscelanous.banditsKilled > Miscelanous.bkRequirement){
            questCompletion2 = 1;
        }
        Scanner scanner = new Scanner(System.in);
        if (questActive2 == 0) {
            System.out.println("W ratuszu natrafiłeś na wodza miasteczka");
            PressButton();
            System.out.println("Jego twarz jest pokryta licznymi bliznami, reszta ciała jest odziana w zużytą zbroję");
            PressButton();
            System.out.println("Słyszałeś że został wodzem po tym jak uratował miasto przed atakiem bandytów");
            PressButton();
            System.out.println("Postanowiłeś zapytać go o pracę");
            PressButton();
            String welcome = """
                          
                  (Wódz spogląda na Ciebie zmęczonymi oczami)
                -  Dobrze że pytasz, na wschód od naszego miasta rozrósł się obóz bandytów.
                   Nie chcemy powtórki z rozrywki, raz już nieźle przez nich oberwaliśmy.
                   Proszę, idź na wschód i wytnij w pień 15 bandytów w ich obozie.
                      """;
            welcome = welcome.indent(10);
            System.out.println(welcome);
            PressButton();
            String welcome2 = """
                    
                   W zamian dam Ci swoją broń, służyła mi przez wiele lat, ale jestem już za stary by jej używać.
                   Jak pomożesz naszemu kowalowi, to będzie on mógł dla Ciebie zatruć ten miecz, a wtedy bez problemu
                   poradzisz sobie nawet z najsilniejszymi potworami.
                   Powodzenia i wróć do nas żywy, proszę.
                """;
            welcome2 = welcome2.indent(10);
            System.out.println(welcome2);
            PressButton();
            questActive2 = 1;
        }
        else if (questActive2 ==1 && questCompletion2 == 0){
            System.out.println("- Pośpiesz się, z każdą chwilą ich obóz się rozrasta");
            Thread.sleep(1500);
        }
        else if (questActive2 == 1 && questCompletion2 == 1){
            System.out.println("Udało Ci się ich zabić?");
            System.out.println("TAK , NIE");

            String input = scanner.nextLine().toUpperCase();
            switch (input){
                case "TAK":
                    System.out.println("Dziękuję ci! Tak jak obiecałem, moja broń należy do Ciebie");
                    Thread.sleep(1000);
                    Monster.number++;
                    Monster.eqNumber[Monster.number] = new Weapon("Obsydianowy miecz dwuręczny", 30, 80, 7, 0, 2, 1, 1);
                    System.out.println("Korzystaj z niej mądrze i zawsze w dobrej sprawie");
                    Thread.sleep(1000);
                    System.out.println("Odwiedź naszego kowala a zatruje on ją dla ciebie. Dzięki ci raz jeszcze, bywaj! ");
                    PressButton();
                    questCompletion2 = 2;
                    break;

                case "NIE":
                    System.out.println("To spierdalaj.");
                    PressButton();
                    break;

            }

        }
        else if (questCompletion2 == 2){
            System.out.println("Dziękuję ci za pomoc, powodzenia w dalszej podróży!");
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
                PressButton();
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



