package util;

import elements.Floor;
import game.Reference;

import java.util.Random;

public class Functions {

    private static String message = " ";
    public static void handlePlayerAction(Action action) {
        Tile tile = null;

        switch (action) {
            case FOWARD:
                tile = Reference.currentFloor.getTile(Reference.player.getX(), Reference.player.getY()-1);break;
            case LEFT:
                tile = Reference.currentFloor.getTile(Reference.player.getX()-1, Reference.player.getY()); break;
            case BACKWARDS:
                tile = Reference.currentFloor.getTile(Reference.player.getX(), Reference.player.getY()+1); break;
            case RIGHT:
                tile = Reference.currentFloor.getTile(Reference.player.getX()+1, Reference.player.getY()); break;
            case SPACE:
                Reference.currentFloor = new Floor(1);
                break;
            case HUMAN:
                Reference.player.setRace("Human");
                Reference.player.setName("Glodram");
                Reference.currentFloor = new Floor(2);
                break;
            case ELF:
                Reference.player.setRace("Elf");
                Reference.player.setName("Aenorin");
                Reference.currentFloor = new Floor(2);
                break;

            case DWARF:
                Reference.player.setRace("Dwarf");
                Reference.player.setName("Bramdur");
                Reference.currentFloor = new Floor(2);
                break;
//            case RACE:
//                Reference.currentFloor = new Floor(2);
//                Reference.player.setRace("Race");
//                break;
        }

        switch(tile) {
            case NOTHING:
                Reference.player.move(action);
                message = " ";
//                message2 = " ";
//                message3 = " ";
                break; //Move the player if it is in front of one of these tiles
            case WALL:
                message = "You ran into a wall!";
//                message2 = " ";
//                message3 = " ";
                break;
        }

    }
    public static int getRandomNumber(int n) {
        Random rand = new Random();
        return rand.nextInt(n)+1;
    }
}
