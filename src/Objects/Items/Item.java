package Objects.Items;

import Mobs.Player;

public abstract class Item {
    int helmEquip;
    int chestEquip;
    int handsEquip;
    int weaponEquip;
    int neckEquip;

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

    public abstract String getName();

    public abstract void setName(String name);

    public abstract void eqON(Player player);

    public abstract void eqOFF(Player player);


}
