package Mobs.Classes;

import Mobs.Player;

public class Mercenary extends Player {
    public Mercenary(double HP, double maxHP, int DMG, int XP, int level, int x, int y, int gold, int bombNumber, int potionNumber, int armor) {
        super(HP, maxHP, DMG, XP, level, x, y, gold, bombNumber, potionNumber, armor);
    }
    int classNumber = 3;

    @Override
    public int getClassNumber() {
        return classNumber;
    }

    @Override
    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }
}
