package Objects.Items.Weapons;

import Mobs.Player;
import Objects.Items.Item;

public abstract class Weapon extends Item {
    boolean helmEquip = false;
    boolean chestEquip = false;
    boolean handsEquip = false;
    boolean weaponEquip = false;
    boolean neckEquip = false;
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
