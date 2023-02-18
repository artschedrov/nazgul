package elements;

import game.Reference;
import util.Action;
import util.Functions;
import util.Tile;

public class Goblin extends Monster {

    private String name;

    public Goblin(String name, int posX, int posY, int health) {
        super(name, posX, posY, health, 12, 16, 16);
        this.name = name;
        System.out.println("[Goblin]: Creating goblin");
    }
    public void moveRandom() {
        super.moveRandom();
    }
    public String getName() {
        return super.getName();
    }
    public int getAC() {
        return super.getDef();
    }
}
