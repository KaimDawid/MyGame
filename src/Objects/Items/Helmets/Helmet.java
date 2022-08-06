package Objects.Items.Helmets;

import Mobs.Player;
import Objects.Items.Item;

public abstract class Helmet extends Item {
    boolean equip;
    int helmEquip;
    int chestEquip;
    int handsEquip;
    int weaponEquip;
    int neckEquip;
    int isON = 0;

    public abstract int getHelmEquip();

    public abstract void setHelmEquip(int helmEquip);

    public abstract int getChestEquip();

    public abstract void setChestEquip(int chestEquip);

    public abstract int getHandsEquip();

    public abstract void setHandsEquip(int handsEquip);

    public abstract int getWeaponEquip();

    public abstract void setWeaponEquip(int weaponEquip);

    public abstract int getNeckEquip();

    public abstract void setNeckEquip(int neckEquip);
    int HP;
    int DMG;
    int crit;
    int magic;
    int eqValue;

    public abstract int getEqValue();

    public abstract void setEqValue(int eqValue);
    public abstract String getName();

    public abstract void setName(String name);

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDMG() {
        return DMG;
    }

    public void setDMG(int DMG) {
        this.DMG = DMG;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public abstract boolean isEquip();

    public abstract void setEquip(boolean equip);

    public abstract void eqON(Player player);

    public abstract void eqOFF(Player player);


}
