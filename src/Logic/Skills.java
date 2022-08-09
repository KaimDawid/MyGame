package Logic;

public enum Skills {

    ICE(60), TP(61), FIREBALL(62), ADRENALINE (63), IRONSKIN(64), CLEAVE(65);

    private final int number;

    // Konstruktor
    private Skills(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
