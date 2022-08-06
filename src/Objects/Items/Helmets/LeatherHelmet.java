package Objects.Items.Helmets;

import Mobs.Player;

public class LeatherHelmet extends Helmet {
    int HP = 10;
    int DMG = 0;
    int crit = 2;
    int magic = 10;

    int stock = 0;
  /*  int eqValue;*/

    @Override
    public int getEqValue() {
        return eqValue;
    }

    @Override
    public void setEqValue(int eqValue) {
        this.eqValue = eqValue;
    }

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

    public boolean isLhEquip() {
        return lhEquip;
    }

    public void setLhEquip(boolean lhEquip) {
        this.lhEquip = lhEquip;
    }

    String name = ("Skórzany hełm (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");

    public LeatherHelmet(int stock) {
        this.stock = stock;
    }

    @Override
    public int getHP() {
        return HP;
    }
    int isON = 0;

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
/*   public DrakeHelmet(int HP, int DMG, int crit, int magic) {
        this.HP = HP;
        this.DMG = DMG;
        this.crit = crit;
        this.magic = magic;
    }*/

    boolean equip = false;
    boolean lhEquip = false;

    @Override
    public void eqON(Player player) {

            if (helmEquip < 2) {
                player.setMaxHP(player.getMaxHP() + LeatherHelmet.this.HP);
                player.setHP(player.getHP() + LeatherHelmet.this.HP);
                player.setDMG(player.getDMG() + LeatherHelmet.this.DMG);
                player.setCritChance(player.getCritChance() + LeatherHelmet.this.crit);
                player.setMagic(player.getMagic() + LeatherHelmet.this.magic);
                helmEquip = 2;
                System.out.println("Założyłeś skórzany hełm");
                eqValue = 1;
            }
            else if (lhEquip){
                player.setMaxHP(player.getMaxHP() - LeatherHelmet.this.HP);
                player.setHP(player.getHP() - LeatherHelmet.this.HP);
                player.setDMG(player.getDMG() - LeatherHelmet.this.DMG);
                player.setCritChance(player.getCritChance() - LeatherHelmet.this.crit);
                player.setMagic(player.getMagic() - LeatherHelmet.this.magic);
                lhEquip = false;
                helmEquip = 1;
                System.out.println("Zdjąłeś skórzany hełm");
                eqValue = 0;
            }
            else if (!lhEquip && helmEquip > 1){
                System.out.println("Najpierw zdejmij swój poprzedni hełm");
            }

        }

    @Override
    public void eqOFF(Player player) {
        if (helmEquip > 1) {
            player.setMaxHP(player.getMaxHP() - LeatherHelmet.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - LeatherHelmet.this.DMG);
            player.setCritChance(player.getCritChance() - LeatherHelmet.this.crit);
            player.setMagic(player.getMagic() - LeatherHelmet.this.magic);
            helmEquip = 1;
            eqValue = 0;
            isON = 0;
        }
    }
}
