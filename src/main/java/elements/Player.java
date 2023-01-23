package elements;

import util.Action;

public class Player extends Entity {
    private String name;
    private Action facing;
    public String race;
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private boolean alive = true;
    public Player(int posX, int posY) {
        super(posX, posY, 20, 10, 10, 10, 10);
        this.equippedWeapon = Weapon.smallSword;
        this.equippedArmor = Armor.softLeatherArmour;
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

    public String getRace() {
        return this.race;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAC() {
        return this.ac;
    }
    public void setAC() {
        ac = super.getDex() + equippedArmor.getAc();
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
        //this.strenght=1;
        //this.strenght+=this.equippedWeapon.getDmg();
    }

    public void equipArmor(Armor armor) {
        this.equippedArmor = armor;
        this.ac = getAC();
        this.ac+=this.equippedArmor.getAc();
    }

    public Weapon getWeapon() {return equippedWeapon;}
    /**Getter Method*/
    public Armor getArmor() {
        return equippedArmor;
    }

    public boolean isAlive() {return alive;}
    /**Sets isAlive() to false*/
    public void setDead() {this.alive=false;}
}
