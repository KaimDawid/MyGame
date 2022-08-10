package Objects.Items.Necklaces;

import Mobs.Player;
import Objects.Items.Item;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class Necklace extends Item {
    int HP;
    int DMG;
    int crit;
    int magic;

    int stock = 0;
    String shortName;

    String longName = getShortName() + " (" +getHP() +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)";
    int helmEquip;
    int chestEquip;
    int handsEquip;
    int weaponEquip;
    int neckEquip =1;
    int isON = 0;
    int eqValue;

    public Necklace(String shortName, int HP, int DMG, int crit, int magic, int stock) {
        this.HP = HP;
        this.DMG = DMG;
        this.crit = crit;
        this.magic = magic;
        this.stock = stock;
        this.shortName = shortName;
    }



    @Override
    public void eqON(Player player) {
        if (neckEquip < 2) {
            player.setMaxHP(player.getMaxHP() + HP);
            player.setHP(player.getHP() + HP);
            player.setDMG(player.getDMG() + DMG);
            player.setCritChance(player.getCritChance() + crit);
            player.setMagic(player.getMagic() + magic);
            neckEquip = 2;
            System.out.println("Założyłeś: " +getShortName() + " (" +getHP() +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
            isON = 1;
            eqValue = 1;

        }
        else if (neckEquip > 1){
            player.setMaxHP(player.getMaxHP() - HP);
            if (player.getHP() > player.getMaxHP()){
                double difference = (player.getHP() - player.getMaxHP());
                player.setHP(player.getHP() - difference);
            }
            player.setDMG(player.getDMG() - DMG);
            player.setCritChance(player.getCritChance() - crit);
            player.setMagic(player.getMagic() - magic);

            neckEquip = 1;
            System.out.println("Zdjąłeś: "+getShortName() + " (" +getHP() +"HP, " + DMG + "DMG, +" + crit +"% szans na crit, " + magic + " siły zaklęć)");
            longName();
            eqValue = 0;
        }
        else if (eqValue>0){
            System.out.println("Najpierw zdejmij swoją poprzednią zbroję");
        }

    }




    @Override
    public void eqOFF(Player player){
        if (neckEquip > 1) {
            player.setMaxHP(player.getMaxHP() - HP);
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
            player.setDMG(player.getDMG() - DMG);
            player.setCritChance(player.getCritChance() - crit);
            player.setMagic(player.getMagic() - magic);
            neckEquip = 1;
            eqValue = 0;
            isON = 0;
        }
    }

    @Override
    public boolean isEquip() {
        return false;
    }

    @Override
    public void setEquip(boolean equip) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

}
