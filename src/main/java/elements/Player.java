package elements;

import util.Action;

public class Player extends Entity {
    private Action facing;
    public String race;
    public Player(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void move(Action dir) {
        super.move(dir);
    }

    public void move() {
        this.move(facing);
    }

    public void setFacing(Action dir) {this.facing=dir;}
    public void setRace(String race) {
        this.race = race;
    }
}
