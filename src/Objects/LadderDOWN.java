package Objects;

import Mobs.Player;

public class LadderDOWN{
    int X;
    int Y;

    public LadderDOWN(int x, int y, int floor) {
        X = x;
        Y = y;
        Floor = floor;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getFloor() {
        return Floor;
    }

    public void setFloor(int floor) {
        Floor = floor;
    }

    int Floor;


    public static void DESCEND(Player player){
        System.out.println("Zszedłeś po drabinie na piętro " + (player.getFloor() + 1));
        player.setFloor(player.getFloor() + 1);
    }
}
