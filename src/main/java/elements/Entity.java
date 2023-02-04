package elements;

import game.Reference;
import util.Action;

public class Entity {
    protected int posX;
    protected int posY;

    protected int health;
    protected int maxHealth;

    protected int str;
    protected int dex;
    protected int con;
    protected int ac;

    public Entity(int posX, int posY, int health, int str, int dex, int con, int ac) {
        this.setPos(posX, posY);
        this.health = health;
        this.maxHealth = health;
        this.str = str;
        this.dex = dex;
        this.con = con;
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

    public void setHP(int con) {
        this.health = con;
    }
    public int getHP() {
        return health;
    }

    /**Getter Method*/
    public int getMaxHP() {
        maxHealth = getCon();
        return maxHealth;
    }

    public void setStr(int str) {
        this.str = str;
    }
    public int getStr() {
        return str;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }
    public int getDex() {
        return this.dex;
    }

    public void setCon(int con) {
        this.con = con;
    }
    public int getCon() {
        return con;
    }

    /**Getter Method*/
    public int getAC() {
        return ac;
    }

    public void setAC(int dex) {
        this.ac = dex;
    }



    public void damage(int amount) {
        this.health-=amount;
    }

//    public void heal(int amount) {
//        this.health+=amount;
//        if(health>maxHealth) health=maxHealth;
//    }

    public int getDef() {return ac;}

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
