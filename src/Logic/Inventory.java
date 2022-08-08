package Logic;

import Mobs.Monster;
import Mobs.Player;

import java.util.Scanner;

import static Mobs.Monster.eqNumber;

public class Inventory {

static Scanner scanner = new Scanner(System.in);

    public static void INVENTORY(Player Dawid) throws InterruptedException {
        String input2 = scanner.nextLine().toUpperCase();
        switch (input2) {
            case "1":

                try {
                    if (eqNumber[0].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[0].getIsON() < 1) {
                        eqNumber[0].eqON(Dawid);
                        eqNumber[0].setIsON(1);
                        Monster.helmEQ = 1;
                    } else if (eqNumber[0].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[0].getIsON() < 1) {
                        eqNumber[0].eqON(Dawid);
                        eqNumber[0].setIsON(1);
                        Monster.weaponEQ++;
                    } else if (eqNumber[0].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[0].getIsON() < 1) {
                        eqNumber[0].eqON(Dawid);
                        eqNumber[0].setIsON(1);
                        Monster.neckEQ = 1;
                    } else if (eqNumber[0].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[0].getIsON() < 1) {
                        eqNumber[0].eqON(Dawid);
                        eqNumber[0].setIsON(1);
                        Monster.chestEQ = 1;
                    } else if (eqNumber[0].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[0].getIsON() < 1) {
                        eqNumber[0].eqON(Dawid);
                        eqNumber[0].setIsON(1);
                        Monster.handsEQ = 1;
                    } else if (eqNumber[0].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[0].getIsON() > 0) {
                        eqNumber[0].eqOFF(Dawid);
                        eqNumber[0].setIsON(0);
                        Monster.helmEQ = 0;
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[0].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[0].getIsON() > 0) {
                        eqNumber[0].eqOFF(Dawid);
                        eqNumber[0].setIsON(0);
                        Monster.weaponEQ--;
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[0].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[0].getIsON() > 0) {
                        eqNumber[0].eqOFF(Dawid);
                        eqNumber[0].setIsON(0);
                        Monster.neckEQ = 0;
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[0].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[0].getIsON() > 0) {
                        eqNumber[0].eqOFF(Dawid);
                        eqNumber[0].setIsON(0);
                        Monster.chestEQ = 0;
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[0].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[0].getIsON() > 0) {
                        eqNumber[0].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[0].setIsON(0);
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
                    if (eqNumber[1].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[1].getIsON() < 1) {
                        eqNumber[1].eqON(Dawid);
                        eqNumber[1].setIsON(1);
                        Monster.helmEQ = 1;
                    } else if (eqNumber[1].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[1].getIsON() < 1) {
                        eqNumber[1].eqON(Dawid);
                        eqNumber[1].setIsON(1);
                        Monster.weaponEQ++;
                    } else if (eqNumber[1].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[1].getIsON() < 1) {
                        eqNumber[1].eqON(Dawid);
                        eqNumber[1].setIsON(1);
                        Monster.neckEQ = 1;
                    } else if (eqNumber[1].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[1].getIsON() < 1) {
                        eqNumber[1].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[1].setIsON(1);
                    } else if (eqNumber[1].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[1].getIsON() < 1) {
                        eqNumber[1].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[1].setIsON(1);
                    } else if (eqNumber[1].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[1].getIsON() > 0) {
                        eqNumber[1].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[1].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[1].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[1].getIsON() > 0) {
                        eqNumber[1].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[1].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[1].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[1].getIsON() > 0) {
                        eqNumber[1].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[1].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[1].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[1].getIsON() > 0) {
                        eqNumber[1].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[1].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[1].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[1].getIsON() > 0) {
                        eqNumber[1].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[1].setIsON(0);
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
                    if (eqNumber[2].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[2].getIsON() < 1) {
                        eqNumber[2].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[2].setIsON(1);
                    } else if (eqNumber[2].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[2].getIsON() < 1) {
                        eqNumber[2].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[2].setIsON(1);
                    } else if (eqNumber[2].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[2].getIsON() < 1) {
                        eqNumber[2].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[2].setIsON(1);
                    } else if (eqNumber[2].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[2].getIsON() < 1) {
                        eqNumber[2].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[2].setIsON(1);
                    } else if (eqNumber[2].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[2].getIsON() < 1) {
                        eqNumber[2].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[2].setIsON(1);
                    } else if (eqNumber[2].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[2].getIsON() > 0) {
                        eqNumber[2].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[2].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[2].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[2].getIsON() > 0) {
                        eqNumber[2].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[2].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[2].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[2].getIsON() > 0) {
                        eqNumber[2].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[2].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[2].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[2].getIsON() > 0) {
                        eqNumber[2].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[2].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[2].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[2].getIsON() > 0) {
                        eqNumber[2].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[2].setIsON(0);
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
                    if (eqNumber[3].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[3].getIsON() < 1) {
                        eqNumber[3].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[3].setIsON(1);
                    } else if (eqNumber[3].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[3].getIsON() < 1) {
                        eqNumber[3].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[3].setIsON(1);
                    } else if (eqNumber[3].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[3].getIsON() < 1) {
                        eqNumber[3].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[3].setIsON(1);
                    } else if (eqNumber[3].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[3].getIsON() < 1) {
                        eqNumber[3].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[3].setIsON(1);
                    } else if (eqNumber[3].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[3].getIsON() < 1) {
                        eqNumber[3].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[3].setIsON(1);
                    } else if (eqNumber[3].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[3].getIsON() > 0) {
                        eqNumber[3].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[3].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[3].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[3].getIsON() > 0) {
                        eqNumber[3].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[3].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[3].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[3].getIsON() > 0) {
                        eqNumber[3].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[3].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[3].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[3].getIsON() > 0) {
                        eqNumber[3].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[3].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[3].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[3].getIsON() > 0) {
                        eqNumber[3].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[3].setIsON(0);
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
                    if (eqNumber[4].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[4].getIsON() < 1) {
                        eqNumber[4].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[4].setIsON(1);
                    } else if (eqNumber[4].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[4].getIsON() < 1) {
                        eqNumber[4].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[4].setIsON(1);
                    } else if (eqNumber[4].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[4].getIsON() < 1) {
                        eqNumber[4].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[4].setIsON(1);
                    } else if (eqNumber[4].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[4].getIsON() < 1) {
                        eqNumber[4].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[4].setIsON(1);
                    } else if (eqNumber[4].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[4].getIsON() < 1) {
                        eqNumber[4].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[4].setIsON(1);
                    } else if (eqNumber[4].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[4].getIsON() > 0) {
                        eqNumber[4].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[4].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[4].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[4].getIsON() > 0) {
                        eqNumber[4].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[4].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[4].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[4].getIsON() > 0) {
                        eqNumber[4].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[4].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[4].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[4].getIsON() > 0) {
                        eqNumber[4].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[4].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[4].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[4].getIsON() > 0) {
                        eqNumber[4].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[4].setIsON(0);
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
                    if (eqNumber[5].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[5].getIsON() < 1) {
                        eqNumber[5].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[5].setIsON(1);
                    } else if (eqNumber[5].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[5].getIsON() < 1) {
                        eqNumber[5].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[5].setIsON(1);
                    } else if (eqNumber[5].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[5].getIsON() < 1) {
                        eqNumber[5].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[5].setIsON(1);
                    } else if (eqNumber[5].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[5].getIsON() < 1) {
                        eqNumber[5].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[5].setIsON(1);
                    } else if (eqNumber[5].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[5].getIsON() < 1) {
                        eqNumber[5].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[5].setIsON(1);
                    } else if (eqNumber[5].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[5].getIsON() > 0) {
                        eqNumber[5].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[5].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[5].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[5].getIsON() > 0) {
                        eqNumber[5].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[5].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[5].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[5].getIsON() > 0) {
                        eqNumber[5].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[5].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[5].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[5].getIsON() > 0) {
                        eqNumber[5].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[5].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[5].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[5].getIsON() > 0) {
                        eqNumber[5].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[5].setIsON(0);
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
                    if (eqNumber[6].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[6].getIsON() < 1) {
                        eqNumber[6].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[6].setIsON(1);
                    } else if (eqNumber[6].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[6].getIsON() < 1) {
                        eqNumber[6].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[6].setIsON(1);
                    } else if (eqNumber[6].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[6].getIsON() < 1) {
                        eqNumber[6].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[6].setIsON(1);
                    } else if (eqNumber[6].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[6].getIsON() < 1) {
                        eqNumber[6].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[6].setIsON(1);
                    } else if (eqNumber[6].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[6].getIsON() < 1) {
                        eqNumber[6].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[6].setIsON(1);
                    } else if (eqNumber[6].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[6].getIsON() > 0) {
                        eqNumber[6].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[6].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[6].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[6].getIsON() > 0) {
                        eqNumber[6].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[6].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[6].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[6].getIsON() > 0) {
                        eqNumber[6].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[6].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[6].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[6].getIsON() > 0) {
                        eqNumber[6].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[6].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[6].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[6].getIsON() > 0) {
                        eqNumber[6].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[6].setIsON(0);
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
                    if (eqNumber[7].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[7].getIsON() < 1) {
                        eqNumber[7].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[7].setIsON(1);
                    } else if (eqNumber[7].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[7].getIsON() < 1) {
                        eqNumber[7].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[7].setIsON(1);
                    } else if (eqNumber[7].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[7].getIsON() < 1) {
                        eqNumber[7].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[7].setIsON(1);
                    } else if (eqNumber[7].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[7].getIsON() < 1) {
                        eqNumber[7].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[7].setIsON(1);
                    } else if (eqNumber[7].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[7].getIsON() < 1) {
                        eqNumber[7].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[7].setIsON(1);
                    } else if (eqNumber[7].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[7].getIsON() > 0) {
                        eqNumber[7].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[7].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[7].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[7].getIsON() > 0) {
                        eqNumber[7].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[7].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[7].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[7].getIsON() > 0) {
                        eqNumber[7].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[7].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[7].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[7].getIsON() > 0) {
                        eqNumber[7].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[7].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[7].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[7].getIsON() > 0) {
                        eqNumber[7].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[7].setIsON(0);
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
                    if (eqNumber[8].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[8].getIsON() < 1) {
                        eqNumber[8].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[8].setIsON(1);
                    } else if (eqNumber[8].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[8].getIsON() < 1) {
                        eqNumber[8].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[8].setIsON(1);
                    } else if (eqNumber[8].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[8].getIsON() < 1) {
                        eqNumber[8].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[8].setIsON(1);
                    } else if (eqNumber[8].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[8].getIsON() < 1) {
                        eqNumber[8].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[8].setIsON(1);
                    } else if (eqNumber[8].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[8].getIsON() < 1) {
                        eqNumber[8].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[8].setIsON(1);
                    } else if (eqNumber[8].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[8].getIsON() > 0) {
                        eqNumber[8].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[8].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[8].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[8].getIsON() > 0) {
                        eqNumber[8].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[8].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[8].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[8].getIsON() > 0) {
                        eqNumber[8].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[8].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[8].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[8].getIsON() > 0) {
                        eqNumber[8].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[8].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[8].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[8].getIsON() > 0) {
                        eqNumber[8].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[8].setIsON(0);
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
                    if (eqNumber[9].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[9].getIsON() < 1) {
                        eqNumber[9].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[9].setIsON(1);
                    } else if (eqNumber[9].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[9].getIsON() < 1) {
                        eqNumber[9].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[9].setIsON(1);
                    } else if (eqNumber[9].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[9].getIsON() < 1) {
                        eqNumber[9].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[9].setIsON(1);
                    } else if (eqNumber[9].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[9].getIsON() < 1) {
                        eqNumber[9].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[9].setIsON(1);
                    } else if (eqNumber[9].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[9].getIsON() < 1) {
                        eqNumber[9].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[9].setIsON(1);
                    } else if (eqNumber[9].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[9].getIsON() > 0) {
                        eqNumber[9].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[9].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[9].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[9].getIsON() > 0) {
                        eqNumber[9].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[9].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[9].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[9].getIsON() > 0) {
                        eqNumber[9].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[9].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[9].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[9].getIsON() > 0) {
                        eqNumber[9].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[9].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[9].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[9].getIsON() > 0) {
                        eqNumber[9].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[9].setIsON(0);
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
                    if (eqNumber[10].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[10].getIsON() < 1) {
                        eqNumber[10].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[10].setIsON(1);
                    } else if (eqNumber[10].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[10].getIsON() < 1) {
                        eqNumber[10].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[10].setIsON(1);
                    } else if (eqNumber[10].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[10].getIsON() < 1) {
                        eqNumber[10].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[10].setIsON(1);
                    } else if (eqNumber[10].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[10].getIsON() < 1) {
                        eqNumber[10].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[10].setIsON(1);
                    } else if (eqNumber[10].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[10].getIsON() < 1) {
                        eqNumber[10].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[10].setIsON(1);
                    } else if (eqNumber[10].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[10].getIsON() > 0) {
                        eqNumber[10].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[10].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[10].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[10].getIsON() > 0) {
                        eqNumber[10].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[10].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[10].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[10].getIsON() > 0) {
                        eqNumber[10].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[10].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[10].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[10].getIsON() > 0) {
                        eqNumber[10].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[10].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[10].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[10].getIsON() > 0) {
                        eqNumber[10].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[10].setIsON(0);
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
                    if (eqNumber[11].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[11].getIsON() < 1) {
                        eqNumber[11].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[11].setIsON(1);
                    } else if (eqNumber[11].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[11].getIsON() < 1) {
                        eqNumber[11].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[11].setIsON(1);
                    } else if (eqNumber[11].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[11].getIsON() < 1) {
                        eqNumber[11].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[11].setIsON(1);
                    } else if (eqNumber[11].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[11].getIsON() < 1) {
                        eqNumber[11].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[11].setIsON(1);
                    } else if (eqNumber[11].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[11].getIsON() < 1) {
                        eqNumber[11].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[11].setIsON(1);
                    } else if (eqNumber[11].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[11].getIsON() > 0) {
                        eqNumber[11].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[11].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[11].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[11].getIsON() > 0) {
                        eqNumber[11].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[11].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[11].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[11].getIsON() > 0) {
                        eqNumber[11].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[11].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[11].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[11].getIsON() > 0) {
                        eqNumber[11].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[11].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[11].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[11].getIsON() > 0) {
                        eqNumber[11].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[11].setIsON(0);
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
                    if (eqNumber[12].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[12].getIsON() < 1) {
                        eqNumber[12].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[12].setIsON(1);
                    } else if (eqNumber[12].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[12].getIsON() < 1) {
                        eqNumber[12].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[12].setIsON(1);
                    } else if (eqNumber[12].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[12].getIsON() < 1) {
                        eqNumber[12].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[12].setIsON(1);
                    } else if (eqNumber[12].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[12].getIsON() < 1) {
                        eqNumber[12].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[12].setIsON(1);
                    } else if (eqNumber[12].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[12].getIsON() < 1) {
                        eqNumber[12].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[12].setIsON(1);
                    } else if (eqNumber[12].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[12].getIsON() > 0) {
                        eqNumber[12].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[12].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[12].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[12].getIsON() > 0) {
                        eqNumber[12].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[12].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[12].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[12].getIsON() > 0) {
                        eqNumber[12].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[12].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[12].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[12].getIsON() > 0) {
                        eqNumber[12].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[12].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[12].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[12].getIsON() > 0) {
                        eqNumber[12].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[12].setIsON(0);
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
                    if (eqNumber[13].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[13].getIsON() < 1) {
                        eqNumber[13].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[13].setIsON(1);
                    } else if (eqNumber[13].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[13].getIsON() < 1) {
                        eqNumber[13].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[13].setIsON(1);
                    } else if (eqNumber[13].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[13].getIsON() < 1) {
                        eqNumber[13].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[13].setIsON(1);
                    } else if (eqNumber[13].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[13].getIsON() < 1) {
                        eqNumber[13].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[13].setIsON(1);
                    } else if (eqNumber[13].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[13].getIsON() < 1) {
                        eqNumber[13].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[13].setIsON(1);
                    } else if (eqNumber[13].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[13].getIsON() > 0) {
                        eqNumber[13].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[13].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[13].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[13].getIsON() > 0) {
                        eqNumber[13].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[13].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[13].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[13].getIsON() > 0) {
                        eqNumber[13].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[13].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[13].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[13].getIsON() > 0) {
                        eqNumber[13].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[13].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[13].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[13].getIsON() > 0) {
                        eqNumber[13].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[13].setIsON(0);
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
                    if (eqNumber[14].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[14].getIsON() < 1) {
                        eqNumber[14].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[14].setIsON(1);
                    } else if (eqNumber[14].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[14].getIsON() < 1) {
                        eqNumber[14].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[14].setIsON(1);
                    } else if (eqNumber[14].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[14].getIsON() < 1) {
                        eqNumber[14].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[14].setIsON(1);
                    } else if (eqNumber[14].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[14].getIsON() < 1) {
                        eqNumber[14].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[14].setIsON(1);
                    } else if (eqNumber[14].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[14].getIsON() < 1) {
                        eqNumber[14].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[14].setIsON(1);
                    } else if (eqNumber[14].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[14].getIsON() > 0) {
                        eqNumber[14].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[14].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[14].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[14].getIsON() > 0) {
                        eqNumber[14].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[14].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[14].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[14].getIsON() > 0) {
                        eqNumber[14].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[14].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[14].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[14].getIsON() > 0) {
                        eqNumber[14].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[14].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[14].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[14].getIsON() > 0) {
                        eqNumber[14].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[14].setIsON(0);
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
                    if (eqNumber[15].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[15].getIsON() < 1) {
                        eqNumber[15].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[15].setIsON(1);
                    } else if (eqNumber[15].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[15].getIsON() < 1) {
                        eqNumber[15].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[15].setIsON(1);
                    } else if (eqNumber[15].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[15].getIsON() < 1) {
                        eqNumber[15].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[15].setIsON(1);
                    } else if (eqNumber[15].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[15].getIsON() < 1) {
                        eqNumber[15].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[15].setIsON(1);
                    } else if (eqNumber[15].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[15].getIsON() < 1) {
                        eqNumber[15].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[15].setIsON(1);
                    } else if (eqNumber[15].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[15].getIsON() > 0) {
                        eqNumber[15].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[15].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[15].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[15].getIsON() > 0) {
                        eqNumber[15].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[15].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[15].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[15].getIsON() > 0) {
                        eqNumber[15].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[15].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[15].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[15].getIsON() > 0) {
                        eqNumber[15].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[15].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[15].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[15].getIsON() > 0) {
                        eqNumber[15].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[15].setIsON(0);
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
                    if (eqNumber[16].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[16].getIsON() < 1) {
                        eqNumber[16].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[16].setIsON(1);
                    } else if (eqNumber[16].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[16].getIsON() < 1) {
                        eqNumber[16].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[16].setIsON(1);
                    } else if (eqNumber[16].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[16].getIsON() < 1) {
                        eqNumber[16].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[16].setIsON(1);
                    } else if (eqNumber[16].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[16].getIsON() < 1) {
                        eqNumber[16].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[16].setIsON(1);
                    } else if (eqNumber[16].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[16].getIsON() < 1) {
                        eqNumber[16].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[16].setIsON(1);
                    } else if (eqNumber[16].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[16].getIsON() > 0) {
                        eqNumber[16].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[16].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[16].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[16].getIsON() > 0) {
                        eqNumber[16].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[16].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[16].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[16].getIsON() > 0) {
                        eqNumber[16].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[16].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[16].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[16].getIsON() > 0) {
                        eqNumber[16].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[16].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[16].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[16].getIsON() > 0) {
                        eqNumber[16].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[16].setIsON(0);
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
                    if (eqNumber[17].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[17].getIsON() < 1) {
                        eqNumber[17].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[17].setIsON(1);
                    } else if (eqNumber[17].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[17].getIsON() < 1) {
                        eqNumber[17].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[17].setIsON(1);
                    } else if (eqNumber[17].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[17].getIsON() < 1) {
                        eqNumber[17].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[17].setIsON(1);
                    } else if (eqNumber[17].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[17].getIsON() < 1) {
                        eqNumber[17].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[17].setIsON(1);
                    } else if (eqNumber[17].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[17].getIsON() < 1) {
                        eqNumber[17].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[17].setIsON(1);
                    } else if (eqNumber[17].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[17].getIsON() > 0) {
                        eqNumber[17].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[17].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[17].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[17].getIsON() > 0) {
                        eqNumber[17].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[17].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[17].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[17].getIsON() > 0) {
                        eqNumber[17].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[17].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[17].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[17].getIsON() > 0) {
                        eqNumber[17].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[17].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[17].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[17].getIsON() > 0) {
                        eqNumber[17].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[17].setIsON(0);
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
                    if (eqNumber[18].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[18].getIsON() < 1) {
                        eqNumber[18].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[18].setIsON(1);
                    } else if (eqNumber[18].getWeaponEquip() > 0 && Monster.weaponEQ < Dawid.getWeaponCapacity() && eqNumber[18].getIsON() < 1) {
                        eqNumber[18].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[18].setIsON(1);
                    } else if (eqNumber[18].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[18].getIsON() < 1) {
                        eqNumber[18].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[18].setIsON(1);
                    } else if (eqNumber[18].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[18].getIsON() < 1) {
                        eqNumber[18].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[18].setIsON(1);
                    } else if (eqNumber[18].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[18].getIsON() < 1) {
                        eqNumber[18].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[18].setIsON(1);
                    } else if (eqNumber[18].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[18].getIsON() > 0) {
                        eqNumber[18].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[18].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[18].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[18].getIsON() > 0) {
                        eqNumber[18].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[18].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[18].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[18].getIsON() > 0) {
                        eqNumber[18].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[18].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[18].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[18].getIsON() > 0) {
                        eqNumber[18].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[18].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[18].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[18].getIsON() > 0) {
                        eqNumber[18].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[18].setIsON(0);
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
                    if (eqNumber[19].getHelmEquip() > 0 && Monster.helmEQ < 1 && eqNumber[19].getIsON() < 1) {
                        eqNumber[19].eqON(Dawid);
                        Monster.helmEQ = 1;
                        eqNumber[19].setIsON(1);
                    } else if (eqNumber[19].getWeaponEquip() > 0 && eqNumber[19].getIsON() < 1 && Monster.weaponEQ < Dawid.getWeaponCapacity()) {
                        eqNumber[19].eqON(Dawid);
                        Monster.weaponEQ++;
                        eqNumber[19].setIsON(1);
                    } else if (eqNumber[19].getNeckEquip() > 0 && Monster.neckEQ < 1 && eqNumber[19].getIsON() < 1) {
                        eqNumber[19].eqON(Dawid);
                        Monster.neckEQ = 1;
                        eqNumber[19].setIsON(1);
                    } else if (eqNumber[19].getChestEquip() > 0 && Monster.chestEQ < 1 && eqNumber[19].getIsON() < 1) {
                        eqNumber[19].eqON(Dawid);
                        Monster.chestEQ = 1;
                        eqNumber[19].setIsON(1);
                    } else if (eqNumber[19].getHandsEquip() > 0 && Monster.handsEQ < 1 && eqNumber[19].getIsON() < 1) {
                        eqNumber[19].eqON(Dawid);
                        Monster.handsEQ = 1;
                        eqNumber[19].setIsON(1);
                    } else if (eqNumber[19].getHelmEquip() > 0 && Monster.helmEQ > 0 && eqNumber[19].getIsON() > 0) {
                        eqNumber[19].eqOFF(Dawid);
                        Monster.helmEQ = 0;
                        eqNumber[19].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[19].getWeaponEquip() > 0 && Monster.weaponEQ > 0 && eqNumber[19].getIsON() > 0) {
                        eqNumber[19].eqOFF(Dawid);
                        Monster.weaponEQ--;
                        eqNumber[19].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[19].getNeckEquip() > 0 && Monster.neckEQ > 0 && eqNumber[19].getIsON() > 0) {
                        eqNumber[19].eqOFF(Dawid);
                        Monster.neckEQ = 0;
                        eqNumber[19].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[19].getChestEquip() > 0 && Monster.chestEQ > 0 && eqNumber[19].getIsON() > 0) {
                        eqNumber[19].eqOFF(Dawid);
                        Monster.chestEQ = 0;
                        eqNumber[19].setIsON(0);
                        System.out.println("Zdjąłeś przedmiot");
                    } else if (eqNumber[19].getHandsEquip() > 0 && Monster.handsEQ > 0 && eqNumber[19].getIsON() > 0) {
                        eqNumber[19].eqOFF(Dawid);
                        Monster.handsEQ = 0;
                        eqNumber[19].setIsON(0);
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
                Monster.helmEQ = 0;
                Monster.weaponEQ--;
                Monster.neckEQ = 0;
                Monster.chestEQ = 0;
                Monster.handsEQ = 0;
                System.out.println("Zdjąłeś wszystkie przedmioty");
                Thread.sleep(500);
            default:
                break;
        }
    }
}
