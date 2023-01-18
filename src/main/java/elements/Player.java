package elements;

import util.Action;

public class Player extends Entity {
    private String name;
    private Action facing;
    public String race;
    public Player(int posX, int posY) {
        super(posX, posY, 20, 10, 10);
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
