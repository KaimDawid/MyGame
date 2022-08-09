package Logic;

public enum Numbers {
 ICE(60), TP(61), FIREBALL(62), ADRENALINE (63), IRONSKIN(64), CLEAVE(65);

    private final int description;

    // Konstruktor
    private Numbers(int description) {
        this.description = description;
    }

    public int getDescription() {
        return description;
    }

}
