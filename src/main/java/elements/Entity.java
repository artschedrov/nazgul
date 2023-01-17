package elements;

import util.Action;

public class Entity {
    protected int posX;
    protected int posY;

    protected float health;
    protected int maxHealth;

    protected int strenght;
    protected int defence;

    public Entity(int posX, int posY, int health) {

        this.setPos(posX, posY);
        this.health=health;
    }
    public void setPos(int posX, int posY) {
        this.posX=posX; this.posY=posY;
    }
    public int getX() {return posX;}

    /**Getter Method*/
    public int getY() {return posY;}

    public float getHP() {return health;}

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
