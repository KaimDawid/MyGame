package Objects.Items.Helmets;

import Mobs.Player;

public class MageHat extends Helmet {
    int HP = 15;
    int DMG = 0;
    int crit = 3;
    int magic = 45;

    int stock = 0;
    int isON = 0;

    String name = ("Kapelusz nowicjusza [HEAD] (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
    int helmEquip = 1;
    int chestEquip;
    int handsEquip;
    int weaponEquip;
    int neckEquip;

    @Override
    public int getHelmEquip() {
        return helmEquip;
    }

    @Override
    public void setHelmEquip(int helmEquip) {
        this.helmEquip = helmEquip;
    }

    @Override
    public int getChestEquip() {
        return chestEquip;
    }

    @Override
    public void setChestEquip(int chestEquip) {
        this.chestEquip = chestEquip;
    }

    @Override
    public int getHandsEquip() {
        return handsEquip;
    }

    @Override
    public void setHandsEquip(int handsEquip) {
        this.handsEquip = handsEquip;
    }

    @Override
    public int getWeaponEquip() {
        return weaponEquip;
    }

    @Override
    public void setWeaponEquip(int weaponEquip) {
        this.weaponEquip = weaponEquip;
    }

    @Override
    public int getNeckEquip() {
        return neckEquip;
    }

    @Override
    public void setNeckEquip(int neckEquip) {
        this.neckEquip = neckEquip;
    }

    public boolean isDhEquip() {
        return mhEquip;
    }

    public void setDhEquip(boolean mhEquip) {
        this.mhEquip = mhEquip;
    }

    @Override
    public int getEqValue() {
        return eqValue;
    }

    @Override
    public void setEqValue(int eqValue) {
        this.eqValue = eqValue;
    }

    public MageHat(int stock) {
        this.stock = stock;
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public void setHP(int HP) {
        this.HP = HP;
    }

    @Override
    public int getDMG() {
        return DMG;
    }

    @Override
    public void setDMG(int DMG) {
        this.DMG = DMG;
    }

    @Override
    public int getCrit() {
        return crit;
    }

    @Override
    public void setCrit(int crit) {
        this.crit = crit;
    }

    @Override
    public int getMagic() {
        return magic;
    }

    @Override
    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public boolean isEquip() {
        return equip;
    }

    @Override
    public void setEquip(boolean equip) {
        this.equip = equip;
    }


    boolean equip = false;

    boolean mhEquip = false;

    @Override
    public void eqON(Player player) {
        if (helmEquip < 2) {
            player.setMaxHP(player.getMaxHP() + MageHat.this.HP);
            player.setHP(player.getHP() + MageHat.this.HP);
            player.setDMG(player.getDMG() + MageHat.this.DMG);
            player.setCritChance(player.getCritChance() + MageHat.this.crit);
            player.setMagic(player.getMagic() + MageHat.this.magic);
            helmEquip = 2;
            System.out.println("Założyłeś " + name);
            eqValue = 1;

        }
        else if (mhEquip && helmEquip > 1){
            player.setMaxHP(player.getMaxHP() - MageHat.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - MageHat.this.DMG);
            player.setCritChance(player.getCritChance() - MageHat.this.crit);
            player.setMagic(player.getMagic() - MageHat.this.magic);
            mhEquip = false;
            helmEquip = 1;
            System.out.println("Zdjąłeś " + name);
            eqValue = 0;
        }
        else if (!mhEquip && eqValue>0){
            System.out.println("Najpierw zdejmij swój poprzedni hełm");
        }

    }




    @Override
    public void eqOFF(Player player){
        if (helmEquip > 1) {
            player.setMaxHP(player.getMaxHP() - MageHat.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - MageHat.this.DMG);
            player.setCritChance(player.getCritChance() - MageHat.this.crit);
            player.setMagic(player.getMagic() - MageHat.this.magic);
            helmEquip = 1;
            eqValue = 0;
            isON = 0;
        }
    }
}
