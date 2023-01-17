package util;

import elements.Floor;
import elements.Goblin;
import game.Reference;

import java.util.Random;

public class Functions {

    private static String message = " ";

    public static void initMovingTiles() {

        Reference.monsters.clear();

        for(int y=0;y<Reference.currentFloor.getHeight()-1;y++) {
            for(int x=0;x<Reference.currentFloor.getWidth()-1;x++) {
                if(Floor.currentFloor > 1) {
                    switch(Reference.currentFloor.getTile(x, y)) {
                        case PLAYER:
                            Reference.player.setPos(x, y);
                            System.out.println("Player create");
                            break;
                        case GOBLIN:
                            Reference.monsters.add(new Goblin("Goblin", x, y, 5));
                            System.out.println("Goblin create");
                        default:
                            break;
                    }
                }

            }
        }
    }


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
            case STAIRS:
                Reference.player.move(action);
                Reference.currentFloor = new Floor(Floor.currentFloor + 1);
                message = "You went into a new floor!";
                //message2 = " ";
                //message3 = " ";
                //floorsCleared++;
                Functions.initMovingTiles();
                break; //Randomly change floor
        }

    }

    public static void moveMonsters() {
        for(int i=0;i<Reference.monsters.size();i++) {
            Reference.monsters.get(i).moveRandom();
        }
    }

    public static void monsterEncounter(Action action) {
        int monsterX=0, monsterY=0;

        switch(action) {
            case FOWARD:
                monsterX = Reference.player.getX(); monsterY = Reference.player.getY()-1; break;
            case LEFT:
                monsterX = Reference.player.getX()-1; monsterY = Reference.player.getY(); break;
            case BACKWARDS:
                monsterX = Reference.player.getX(); monsterY = Reference.player.getY()+1; break;
            case RIGHT:
                monsterX = Reference.player.getX()+1; monsterY = Reference.player.getY(); break;
        }

//        for(int i=0;i<Reference.goblins.size();i++) {
//            if(Reference.goblins.get(i).getX() == monsterX && Reference.goblins.get(i).getY() == monsterY) {
//                float playerAttack = Reference.player.getStr()-(Reference.monsters.get(i).getDef()/10)*Reference.player.getStr();
//                float monsterAttck = Reference.monsters.get(i).getStr()-(Reference.player.getDef()/10)*Reference.monsters.get(i).getStr();
//                Reference.monsters.get(i).damage(playerAttack);
//                Reference.player.damage(monsterAttck);
//                message2 = "You attacked the monster and left him with "+Reference.monsters.get(i).getHP()+" HP!";
//                message3 = "The monster attacked you!";
//            }
//        }
    }

    public static int getRandomNumber(int n) {
        Random rand = new Random();
        return rand.nextInt(n)+1;
    }
}
