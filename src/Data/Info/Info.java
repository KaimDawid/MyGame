package Data.Info;

public enum Info {

    Version("""
            v 0.45
            - Usprawniono i skrócono wszystkie metody\s
            - Zoptymalizowano wydajność gry\s
            - Umożliwiono tworzenie ekwipunku bez konieczności tworzenia nowych klas\s
            - To do :\s
                - NPC\s
                - Questy\s
                - Strefy (Las pająków, dwór wampirów etc)""");

    private final String patchNotes;

    // Konstruktor
    private Info(String patchNotes) {
        this.patchNotes = patchNotes;
    }

    public String printPatchNotes() {
        return patchNotes;
    }

    public void printMe(){
        System.out.println("""
            v 0.48
            - Quest : wódz\s
            - Strefa : obóz bandytów\s
            - To do :\s
                - NPC\s
                - Więcej Questów\s
                - Więcej Stref """);
    }


}
