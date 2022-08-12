package Logic.Spawners;

import Mobs.*;

import java.util.Random;

public class SpawnFloor3 {
    public static void SPAWN(int mobsNumber, Monster[] monsterBase) {
        double checkme[] = new double[1000];
        Random random = new Random();
        int spawnedMonstersFloor2 = 1;

        for (int i = 0; i < mobsNumber; i++) {
            double valueX = random.nextInt(8) + 1;
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
                if (mobType < 21) {
                    monsterBase[i] = new Mutant(400, 70, valueX, valueY, "mutant", 120, 60, 6, 3);
                } else if (mobType < 41 && mobType > 20) {
                    monsterBase[i] = new Imp(240, 50, valueX, valueY, "imp", 80, 20, 5, 3);
                }
                //
                //        Tu ustawiasz szansę na pojawienie się danego typu przeciwnika
                //
                else if (mobType < 61 && mobType > 40) {
                    monsterBase[i] = new Skeleton(300, 50, valueX, valueY, "szkielet", 100, 20, 5, 3);
                } else if (mobType < 81 && mobType > 60) {
                    monsterBase[i] = new Vampire(500, 70, valueX, valueY, "elite wampir", 160, 50, 3,3 );
                }
                else if (mobType > 80){
                    monsterBase[i] = new Mutant(600, 90, valueX, valueY, "elite mutant", 200, 70, 5, 3);
                }
                int emptyslots = mobsNumber;


                //
                // Jakbyś testował spawner to włącz sobie poniższe printy,
                // wyświetlą info o każdym wygenerowanym potworku
                //
                /*    System.out.println(monsterBase[i].getHp());
                    System.out.println(monsterBase[i].getDmg());
                    System.out.println("Rodzaj potwora: ");
                    System.out.println(monsterBase[i].getName());
                    System.out.println("Koordy:");
                    System.out.println(monsterBase[i].getX());
                    System.out.println(monsterBase[i].getY());
                    System.out.println();
                    System.out.println(spawnedMonstersFloor2);*/
            } else {

                i = i - 1;
            }

        }
    }
}
