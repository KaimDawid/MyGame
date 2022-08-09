package Logic.Status;

public enum Skills {
    ICE(60), FIREBALL(62), TP(61), ADRENALINE(63), IRONSKIN(64);


    private int skillno;
    Skills(int skillno) {
     this.skillno = skillno;
    }
    int getSkillno(){
        return skillno;
    }
}
