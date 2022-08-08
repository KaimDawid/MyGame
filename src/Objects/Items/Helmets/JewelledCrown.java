package Objects.Items.Helmets;

import Mobs.Player;

public class JewelledCrown extends Helmet{

    int HP = 40;
    int DMG = 10;
    int crit = 5;
    int magic = 30;

    int stock = 0;
    int isON = 0;

    String name = ("Hełm wysadzany klejnotami [HEAD] (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
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
        return jcEquip;
    }

    public void setDhEquip(boolean jcEquip) {
        this.jcEquip = jcEquip;
    }

    @Override
    public int getEqValue() {
        return eqValue;
    }

    @Override
    public void setEqValue(int eqValue) {
        this.eqValue = eqValue;
    }

    public JewelledCrown(int stock) {
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

    boolean jcEquip = false;

    @Override
    public void eqON(Player player) {
        if (helmEquip < 2) {
            player.setMaxHP(player.getMaxHP() + JewelledCrown.this.HP);
            player.setHP(player.getHP() + JewelledCrown.this.HP);
            player.setDMG(player.getDMG() + JewelledCrown.this.DMG);
            player.setCritChance(player.getCritChance() + JewelledCrown.this.crit);
            player.setMagic(player.getMagic() + JewelledCrown.this.magic);
            helmEquip = 2;
            System.out.println("Założyłeś " + name);
            eqValue = 1;

        }
        else if (jcEquip && helmEquip > 1){
            player.setMaxHP(player.getMaxHP() - JewelledCrown.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - JewelledCrown.this.DMG);
            player.setCritChance(player.getCritChance() - JewelledCrown.this.crit);
            player.setMagic(player.getMagic() - JewelledCrown.this.magic);
            jcEquip = false;
            helmEquip = 1;
            System.out.println("Zdjąłeś " + name);
            eqValue = 0;
        }
        else if (!jcEquip && eqValue>0){
            System.out.println("Najpierw zdejmij swój poprzedni hełm");
        }

    }




    @Override
    public void eqOFF(Player player){
        if (helmEquip > 1) {
            player.setMaxHP(player.getMaxHP() - JewelledCrown.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - JewelledCrown.this.DMG);
            player.setCritChance(player.getCritChance() - JewelledCrown.this.crit);
            player.setMagic(player.getMagic() - JewelledCrown.this.magic);
            helmEquip = 1;
            eqValue = 0;
            isON = 0;
        }
    }
    
}
