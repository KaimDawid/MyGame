package Objects.Items.Helmets;

import Mobs.Player;
import Objects.Items.Item;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public abstract class Helmet extends Item {
    boolean equip;
    int helmEquip;
    int chestEquip;
    int handsEquip;
    int weaponEquip;
    int neckEquip;
    int isON = 0;

    String name;
    int HP;
    int DMG;
    int crit;
    int magic;
    int eqValue;




}
