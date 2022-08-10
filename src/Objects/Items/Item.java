package Objects.Items;

import Mobs.Player;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Item {
    int isSharp;
    int isToxic;
    int helmEquip;
    int chestEquip;
    int handsEquip;
    int weaponEquip;
    int neckEquip;
    int isON = 0;

    /*public static void NewItem(String shortName, double hp, double DMG, double crit, int mana, int magic, Player player ){
        public static void eqON(Player player) {
            if (chestEquip < 2) {
                player.setMaxHP(player.getMaxHP() + this.HP);
                player.setHP(player.getHP() + this.HP);
                player.setDMG(player.getDMG() + this.DMG);
                player.setCritChance(player.getCritChance() + this.crit);
                player.setMagic(player.getMagic() + this.magic);
                chestEquip = 2;
                System.out.println("Założyłeś " + shortName);
                isON = 1;
                eqValue = 1;

            }
            else if (chestEquip > 1){
                player.setMaxHP(player.getMaxHP() - this.HP);
                if (player.getHP() > player.getMaxHP()){
                    double difference = (player.getHP() - player.getMaxHP());
                    player.setHP(player.getHP() - difference);
                }
                player.setDMG(player.getDMG() - this.DMG);
                player.setCritChance(player.getCritChance() - this.crit);
                player.setMagic(player.getMagic() - this.magic);
                msEquip = false;
                chestEquip = 1;
                System.out.println("Zdjąłeś " + shortName);
                eqValue = 0;
            }
            else if (eqValue>0){
                System.out.println("Najpierw zdejmij swoją poprzednią zbroję");
            }

        }
    }*/

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
    String shortName;
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

    public abstract String getName();

    public int getIsON() {
        return isON;
    }

    public void setIsON(int isON) {
        this.isON = isON;
    }

    public abstract void setName(String name);

    public abstract void eqON(Player player);

    public abstract void eqOFF(Player player);

    public String longName(){
        return shortName + " (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)";
        /*System.out.println(shortName + " (" +HP +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");*/
    }
}
