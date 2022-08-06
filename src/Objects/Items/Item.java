package Objects.Items;

import Mobs.Player;

public abstract class Item {
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

    boolean equip = false;

    public abstract boolean isEquip();

    public abstract void setEquip(boolean equip);

    int HP;
    int DMG;
    int crit;
    int magic;
    String name;
    int eqValue;

    public abstract int getEqValue();

    public abstract void setEqValue(int eqValue);

    public abstract int getHP();

    public abstract void setHP(int HP);

    public abstract int getDMG();

    public abstract void setDMG(int DMG);

    public abstract int getCrit();

    public abstract void setCrit(int crit);

    public abstract int getMagic();

    public abstract void setMagic(int magic);

    public abstract String getName();

    public int getIsON() {
        return isON;
    }

    public void setIsON(int isON) {
        this.isON = isON;
    }

    public abstract void setName(String name);

    public abstract void eqON(Player player);

    public abstract void eqOFF(Player player);


}
