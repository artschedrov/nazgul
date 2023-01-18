package elements;

import game.Reference;
import util.Action;
import util.Functions;
import util.Tile;

public class Monster extends Entity {

    private String name;

    public Monster(int posX, int posY, int health) {
        super(posX, posY, health, 5, 5);
        this.name = name;
    }

    public void moveRandom() {
        switch(Functions.getRandomNumber(4)) {
            case 1:
                if(Reference.currentFloor.getTile(this.getX(), this.getY()-1) == Tile.NOTHING)
                    super.move(Action.FOWARD);
                else if(Reference.currentFloor.getTile(this.getX(), this.getY()-1) == Tile.PLAYER)
                    Functions.monsterEncounter(Action.FOWARD);
                break;
            case 2:
                if(Reference.currentFloor.getTile(this.getX()-1, this.getY()) == Tile.NOTHING)
                    super.move(Action.LEFT);
                else if(Reference.currentFloor.getTile(this.getX()-1, this.getY()) == Tile.PLAYER)
                    Functions.monsterEncounter(Action.LEFT);
                break;
            case 3:
                if(Reference.currentFloor.getTile(this.getX(), this.getY()+1) == Tile.NOTHING)
                    super.move(Action.BACKWARDS);
                else if(Reference.currentFloor.getTile(this.getX(), this.getY()+1) == Tile.PLAYER)
                    Functions.monsterEncounter(Action.BACKWARDS);
                break;
            case 4:
                if(Reference.currentFloor.getTile(this.getX()+1, this.getY()) == Tile.NOTHING)
                    super.move(Action.RIGHT);
                else if(Reference.currentFloor.getTile(this.getX()+1, this.getY()) == Tile.PLAYER)
                    Functions.monsterEncounter(Action.RIGHT);
                break;
        }
    }

    public String getName() {
        return name;
    }
}
