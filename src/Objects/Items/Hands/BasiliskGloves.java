package Objects.Items.Hands;

import Mobs.Player;
import Objects.Items.Chests.MailShirt;
import Objects.Items.Item;

public class BasiliskGloves extends Item {
    int HP = 10;
    int DMG = 10;
    int crit = 0;
    int magic = 60;

    int stock = 0;

    String name = ("Rękawice Bazyliszka [HANDS] (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
    int helmEquip;
    int chestEquip;
    int isON = 0;
    int handsEquip = 1;
    int weaponEquip;
    int neckEquip;

    int eqValue;
    public BasiliskGloves(int stock) {
        this.stock = stock;
    }

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


    @Override
    public int getEqValue() {
        return eqValue;
    }

    @Override
    public void setEqValue(int eqValue) {
        this.eqValue = eqValue;
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
/*   public DrakeHelmet(int HP, int DMG, int crit, int magic) {
        this.HP = HP;
        this.DMG = DMG;
        this.crit = crit;
        this.magic = magic;
    }*/

    boolean equip = false;

    boolean msEquip = false;

    @Override
    public void eqON(Player player) {
        if (handsEquip < 2) {
            player.setMaxHP(player.getMaxHP() + BasiliskGloves.this.HP);
            player.setHP(player.getHP() + BasiliskGloves.this.HP);
            player.setDMG(player.getDMG() + BasiliskGloves.this.DMG);
            player.setCritChance(player.getCritChance() + BasiliskGloves.this.crit);
            player.setMagic(player.getMagic() + BasiliskGloves.this.magic);
            handsEquip = 2;
            System.out.println("Założyłeś " + name);
            eqValue = 1;

        }
        else if (msEquip && handsEquip > 1){
            player.setMaxHP(player.getMaxHP() - BasiliskGloves.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - BasiliskGloves.this.DMG);
            player.setCritChance(player.getCritChance() - BasiliskGloves.this.crit);
            player.setMagic(player.getMagic() - BasiliskGloves.this.magic);
            msEquip = false;
            handsEquip = 1;
            System.out.println("Zdjąłeś " + name);
            eqValue = 0;
        }
        else if (!msEquip && eqValue>0){
            System.out.println("Najpierw zdejmij swoją poprzednią zbroję");
        }

    }




    @Override
    public void eqOFF(Player player){
        if (handsEquip > 1) {
            player.setMaxHP(player.getMaxHP() - BasiliskGloves.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - BasiliskGloves.this.DMG);
            player.setCritChance(player.getCritChance() - BasiliskGloves.this.crit);
            player.setMagic(player.getMagic() - BasiliskGloves.this.magic);
            handsEquip = 1;
            eqValue = 0;
            isON = 0;
        }
    }
}
