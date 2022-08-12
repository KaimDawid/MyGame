package Data.Areas;

import Mobs.*;

import java.util.Random;

public class BanditCamp {
    static  int spawnedMonstersFloor2 = 1;
    public static void SPAWN(int mobsNumber, Monster[] banditCampBase) {
    double checkme[] = new double[1000];
    Random random = new Random();


        for (int i = 0; i < mobsNumber; i++) {
        double valueX = random.nextInt(8) + 9;
        double valueY = random.nextInt(8) + 1;


        checkme[i] = (valueX * 100 + valueY);

        double mobType = random.nextInt(100);
        int valid = 0;

        for (int j = 0; j < i; j++) {

            if (checkme[i] == checkme[j]) {
                valid = 1;
                break;
            } else {

            }

        }

        if (valid < 1) {
            spawnedMonstersFloor2++;
            if (mobType < 90) {
                banditCampBase[i] = new Bandit(500, 70, valueX, valueY, "bandyta", 140, 30, 5, 1);
            } else{
                banditCampBase[i] = new BanditChief(700, 110, valueX, valueY, "wódz bandytów", 200, 90, 6, 1);
            }

            int emptyslots = mobsNumber;


            //
            // Jakbyś testował spawner to włącz sobie poniższe printy,
            // wyświetlą info o każdym wygenerowanym potworku
            //
                /*    System.out.println(forestBase[i].getHp());
                    System.out.println(forestBase[i].getDmg());
                    System.out.println("Rodzaj potwora: ");
                    System.out.println(forestBase[i].getName());
                    System.out.println("Koordy:");
                    System.out.println(forestBase[i].getX());
                    System.out.println(forestBase[i].getY());
                    System.out.println();
                    System.out.println(spawnedMonstersFloor2);*/
        } else {

            i = i - 1;
        }

    }
}
}
