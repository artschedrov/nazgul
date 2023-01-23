package game;

import elements.Floor;
import elements.Inventory;
import elements.Monster;
import elements.Player;

import java.util.ArrayList;

public class Reference {
    public static final int windowWidth = 1000;
    public static final int windowHeight = 600;
    public static final int floorCount = 4;
    public static Player player;
    public static Inventory inventory;
    public static Floor currentFloor;
    public static ArrayList<Monster> monsters;

}
