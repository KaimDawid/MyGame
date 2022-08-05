package Objects.Items.Weapons;

import Mobs.Player;
import Objects.Items.Item;

public abstract class Weapon extends Item {
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

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    public abstract boolean isEquip();

    public abstract void setEquip(boolean equip);

    @Override
    public void eqON(Player player) {

    }

    @Override
    public void eqOFF(Player player) {

    }
}
