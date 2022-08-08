package Objects.Items.Chests;

import Mobs.Player;
import Objects.Items.Item;

public class PlateArmor extends Item {
    int HP = 80;
    int DMG = 5;
    int crit = 0;
    int magic = 10;

    int stock = 0;

    String name = ("Zbroja płytowa [CHEST] (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
    int helmEquip;
    int chestEquip = 1;
    int handsEquip;
    int weaponEquip;
    int neckEquip;
    int isON = 0;

    int eqValue;
    public PlateArmor(int stock) {
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

    boolean paEquip = false;

    @Override
    public void eqON(Player player) {
        if (chestEquip < 2) {
            player.setMaxHP(player.getMaxHP() + PlateArmor.this.HP);
            player.setHP(player.getHP() + PlateArmor.this.HP);
            player.setDMG(player.getDMG() + PlateArmor.this.DMG);
            player.setCritChance(player.getCritChance() + PlateArmor.this.crit);
            player.setMagic(player.getMagic() + PlateArmor.this.magic);
            chestEquip = 2;
            System.out.println("Założyłeś " + name);
            isON = 1;
            eqValue = 1;

        }
        else if (paEquip && chestEquip > 1){
            player.setMaxHP(player.getMaxHP() - PlateArmor.this.HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - PlateArmor.this.DMG);
            player.setCritChance(player.getCritChance() - PlateArmor.this.crit);
            player.setMagic(player.getMagic() - PlateArmor.this.magic);
            paEquip = false;
            chestEquip = 1;
            System.out.println("Zdjąłeś " + name);
            eqValue = 0;
        }
        else if (!paEquip && eqValue>0){
            System.out.println("Najpierw zdejmij swoją poprzednią zbroję");
        }

    }




    @Override
    public void eqOFF(Player player){
        if (chestEquip > 1) {
            player.setMaxHP(player.getMaxHP() - PlateArmor.this.HP);
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
            player.setDMG(player.getDMG() - PlateArmor.this.DMG);
            player.setCritChance(player.getCritChance() - PlateArmor.this.crit);
            player.setMagic(player.getMagic() - PlateArmor.this.magic);
            chestEquip = 1;
            eqValue = 0;
            isON = 0;
        }
    }
    
}
