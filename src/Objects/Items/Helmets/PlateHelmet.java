package Objects.Items.Helmets;

import Mobs.Player;

public class PlateHelmet extends Helmet {
    int HP = 40;
    int DMG = 5;
    int crit = 0;
    int magic = 10;

    int stock = 0;
    int isON = 0;

    String name = ("Płytowy hełm [HEAD] (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
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
        return phEquip;
    }

    public void setDhEquip(boolean phEquip) {
        this.phEquip = phEquip;
    }

    @Override
    public int getEqValue() {
        return eqValue;
    }

    @Override
    public void setEqValue(int eqValue) {
        this.eqValue = eqValue;
    }

    public PlateHelmet(int stock) {
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

    boolean phEquip = false;

    @Override
    public void eqON(Player player) {
        if (helmEquip < 2) {
            player.setMaxHP(player.getMaxHP() + PlateHelmet.this.HP);
            player.setHP(player.getHP() + PlateHelmet.this.HP);
            player.setDMG(player.getDMG() + PlateHelmet.this.DMG);
            player.setCritChance(player.getCritChance() + PlateHelmet.this.crit);
            player.setMagic(player.getMagic() + PlateHelmet.this.magic);
            helmEquip = 2;
            System.out.println("Założyłeś " + name);
            eqValue = 1;

        }
        else if (phEquip && helmEquip > 1){
            player.setMaxHP(player.getMaxHP() - PlateHelmet.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - PlateHelmet.this.DMG);
            player.setCritChance(player.getCritChance() - PlateHelmet.this.crit);
            player.setMagic(player.getMagic() - PlateHelmet.this.magic);
            phEquip = false;
            helmEquip = 1;
            System.out.println("Zdjąłeś " + name);
            eqValue = 0;
        }
        else if (!phEquip && eqValue>0){
            System.out.println("Najpierw zdejmij swój poprzedni hełm");
        }

    }




    @Override
    public void eqOFF(Player player){
        if (helmEquip > 1) {
            player.setMaxHP(player.getMaxHP() - PlateHelmet.this.HP);
            if (player.getHP() - HP < 1){
                player.setHP(1);
            }
            else {
                player.setHP(player.getHP() - HP);
            }
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - PlateHelmet.this.DMG);
            player.setCritChance(player.getCritChance() - PlateHelmet.this.crit);
            player.setMagic(player.getMagic() - PlateHelmet.this.magic);
            helmEquip = 1;
            eqValue = 0;
            isON = 0;
        }
    }
}
