package Objects.Items.Weapons;

import Mobs.Player;

public class BastardSword extends Weapon {
    int helmEquip;
    int chestEquip;
    int handsEquip;
    int weaponEquip = 1;
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

    public boolean isDagEquip() {
        return bsEquip;
    }

    public void setDagEquip(boolean bsEquip) {
        this.bsEquip = bsEquip;
    }

    int HP = 20;
    int DMG = 15;
    int crit = 0;
    int magic = 10;
    int isON = 0;

    int stock = 0;

    String name = ("Miecz Półtoraręczny [WEAPON] (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");


    public BastardSword(int stock) {
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

    @Override
    public int getEqValue() {
        return eqValue;
    }

    @Override
    public void setEqValue(int eqValue) {
        this.eqValue = eqValue;
    }
/*   public DrakeHelmet(int HP, int DMG, int crit, int magic) {
        this.HP = HP;
        this.DMG = DMG;
        this.crit = crit;
        this.magic = magic;
    }*/

    boolean equip = false;
    boolean bsEquip = false;
    @Override
    public void eqON(Player player) {

        if (weaponEquip < 2) {
            player.setMaxHP(player.getMaxHP() + BastardSword.this.HP);
            player.setHP(player.getHP() + BastardSword.this.HP);
            player.setDMG(player.getDMG() + BastardSword.this.DMG);
            player.setCritChance(player.getCritChance() + BastardSword.this.crit);
            player.setMagic(player.getMagic() + BastardSword.this.magic);
            weaponEquip = 2;
            bsEquip = true;
            System.out.println("Założyłeś " + name);
            eqValue = 1;
        }
        else if (bsEquip){
            player.setMaxHP(player.getMaxHP() - BastardSword.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - BastardSword.this.DMG);
            player.setCritChance(player.getCritChance() - BastardSword.this.crit);
            player.setMagic(player.getMagic() - BastardSword.this.magic);
            bsEquip = false;
            weaponEquip = 0;
            System.out.println("Zdjąłeś " + name);
        }
        else if (!bsEquip && weaponEquip > 0){
            System.out.println("Najpierw zdejmij swój poprzednią broń");
        }

    }




    @Override
    public void eqOFF(Player player){
        if (weaponEquip > 1) {
            player.setMaxHP(player.getMaxHP() - BastardSword.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - BastardSword.this.DMG);
            player.setCritChance(player.getCritChance() - BastardSword.this.crit);
            player.setMagic(player.getMagic() - BastardSword.this.magic);
            weaponEquip = 1;
            eqValue = 0;
            isON = 0;
        }
    }
}