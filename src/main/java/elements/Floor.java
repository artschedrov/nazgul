package elements;

import java.util.ArrayList;

import game.Reference;
import util.Functions;
import util.ResourceManager;
import util.Tile;

public class Floor {
    public ArrayList<ArrayList<Tile>> tiles;
    private boolean firstFloor;
    public static int currentFloor;

    /**Creates a floor
     * @param floorNumber - The ordinal number of this floor in the file*/
    public Floor(int floorNumber) {
        System.out.println("[Floor]: Creating floor"+floorNumber);

        tiles = new ArrayList<ArrayList<Tile>>();

        ArrayList<String> strs = ResourceManager.readFloorFile("src/main/java/resources/floor/floor"+floorNumber+".txt");

        for(int i=0;i<strs.size()-1;i++) {
            char[] charray = strs.get(i).toCharArray();
            tiles.add(new ArrayList<Tile>());
            for(int j=0;j<charray.length;j++) {
                switch(charray[j]) {
                    case '.':
                        tiles.get(i).add(Tile.NOTHING); break;
                    case '#':
                        tiles.get(i).add(Tile.WALL); break;
                    case '@':
                        tiles.get(i).add(Tile.PLAYER); break;
                    case '>':
                        tiles.get(i).add(Tile.STAIRS); break;
                    case ',':
                        tiles.get(i).add(Tile.TRAP); break;
                    case '$':
                        tiles.get(i).add(Tile.GOLD); break;
                    case 'T':
                        tiles.get(i).add(Tile.TREASURE); break;
                    case '!':
                        tiles.get(i).add(Tile.POTION); break;
                    case '?':
                        tiles.get(i).add(Tile.SCROLL); break;
                    case '/':
                        tiles.get(i).add(Tile.DOOR); break;
                    case 'g':
                        tiles.get(i).add(Tile.GOBLIN); break;
                    case ' ':
                        tiles.get(i).add(Tile.SPACE); break;
                    case '\\':
                        tiles.get(i).add(Tile.HAFTED_WEAPON); break;
                    case '|':
                        tiles.get(i).add(Tile.EDGED_WEAPON); break;
                    case '`':
                        tiles.get(i).add(Tile.SPACE1); break;
                    case '_':
                        tiles.get(i).add(Tile.STAFF); break;
                    case '(':
                        tiles.get(i).add(Tile.SOFT_ARMOUR); break;
                    case 'k':
                        tiles.get(i).add(Tile.KOBOLD); break;
                    case 'b':
                        tiles.get(i).add(Tile.BAT); break;
                }
            }
        }

        if(floorNumber == 0) firstFloor = true;
        else firstFloor = false;
        currentFloor = floorNumber;
    }

    public void updatePlayerPos() {
        //Deletes old pos
        for(int i=0;i<this.getHeight();i++) {
            for(int j=0;j<this.getWidth();j++) {
                if(tiles.get(i).get(j) == Tile.PLAYER) {
                    tiles.get(i).set(j, Tile.NOTHING);
                }

            }
        }
        //Sets new pos
        tiles.get(Reference.player.getY()).set(Reference.player.getX(), Tile.PLAYER);
    }

    /**Gets the size of the floor on the y coordinate*/
    public int getHeight() {
        return tiles.size();
    }

    /**Gets the size of the floor on the x coordinate*/
    public int getWidth() {
        return tiles.get(0).size();
    }

    /**Returns one tile of the floor
     * @param x - The x coordinate of the tile
     * @param y - The y coordinate of the tile*/
    public Tile getTile(int x, int y) {return tiles.get(y).get(x);}

    /**Returns one tile of the floor
     * @param x - The x coordinate of the tile
     * @param y - The y coordinate of the tile*/
    public char getTileChar(int x, int y) {return tiles.get(y).get(x).symbol();}

    public void updateMonstersPos() {
        //Deletes old pos
        for(int i=0;i<this.getHeight();i++) {
            for(int j=0;j<this.getWidth();j++) {
                switch (tiles.get(i).get(j)) {
                    case GOBLIN:
                    case BAT:
                        tiles.get(i).set(j, Tile.NOTHING);
                        break;

                }
            }
        }
        //Sets new pos
        for(int i=0;i<Reference.monsters.size();i++) {
            if(Reference.monsters.get(i).getHP()<=0)
                Reference.monsters.remove(i);
            else
                switch (Reference.monsters.get(i).getName()) {
                    case "Bat":
                        tiles.get(Reference.monsters.get(i).getY()).set(Reference.monsters.get(i).getX(), Tile.BAT);
                        break;
                    case "Goblin":
                        tiles.get(Reference.monsters.get(i).getY()).set(Reference.monsters.get(i).getX(), Tile.GOBLIN);
                        break;
                }
        }
    }
    public boolean isFirstFloor() {return firstFloor;}
}
