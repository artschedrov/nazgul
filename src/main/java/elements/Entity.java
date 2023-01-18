package elements;

import util.Action;

public class Entity {
    protected int posX;
    protected int posY;

    protected int health;
    protected int maxHealth;

    protected int str;
    protected int ac;

    public Entity(int posX, int posY, int health, int str, int ac) {
        this.setPos(posX, posY);
        this.health = health;
        this.maxHealth = health;
        this.str = str;
        this.ac = ac;
    }
    public void setPos(int posX, int posY) {
        this.posX=posX; this.posY=posY;
    }
    public int getX() {
        return posX;
    }

    /**Getter Method*/
    public int getY() {
        return posY;
    }

    public int getHP() {
        return health;
    }

    /**Getter Method*/
    public int getMaxHP() {
        return maxHealth;
    }

    public int getStr() {
        return str;
    }

    /**Getter Method*/
    public int getAC() {
        return ac;
    }

    protected void move(Action dir) {
        switch(dir) {
            case FOWARD:
                this.posY--; break;
            case LEFT:
                this.posX--; break;
            case BACKWARDS:
                this.posY++; break;
            case RIGHT:
                this.posX++; break;
        }
    }
}
