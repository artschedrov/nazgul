package util;

import elements.Armor;
import elements.Bat;
import elements.Floor;
import elements.Goblin;
import game.Reference;

import java.util.Random;

public class Functions {
    private  static String[] messages = {" ", " ", " ", " "};
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
                            Reference.monsters.add(new Goblin("Goblin", x, y, 20));
                            System.out.println("Goblin create");
                            break;
                        case BAT:
                            Reference.monsters.add(new Bat("Bat", x,y, 4, 2, 12, 12));
                            System.out.println("Bat create");
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
                Reference.player.setStr(10);
                Reference.player.setDex(10);
                Reference.player.setCon(10);
                Reference.player.setHP(10);
                Reference.player.equipArmor(Armor.softLeatherArmour);
                Reference.currentFloor = new Floor(2);
                break;
            case ELF:
                Reference.player.setRace("Elf");
                Reference.player.setName("Aenorin");
                Reference.player.setStr(9);
                Reference.player.setDex(12);
                Reference.player.setCon(9);
                Reference.player.setHP(9);
                Reference.player.equipArmor(Armor.softLeatherArmour);
                Reference.currentFloor = new Floor(2);
                break;

            case DWARF:
                Reference.player.setRace("Dwarf");
                Reference.player.setName("Bramdur");
                Reference.player.setStr(12);
                Reference.player.setDex(9);
                Reference.player.setCon(12);
                Reference.player.setHP(12);
                Reference.player.equipArmor(Armor.softLeatherArmour);
                Reference.currentFloor = new Floor(2);
                break;
        }

        switch(tile) {
            case NOTHING:
                Reference.player.move(action);
                for (int i = 0; i < messages.length; i++) {
                    messages[i] = " ";
                }
                break; //Move the player if it is in front of one of these tiles
            case WALL:
                messages[0] = "You ran into a wall!";
                break;
            case STAIRS:
                Reference.player.move(action);
                Reference.currentFloor = new Floor(Floor.currentFloor + 1);
                messages[0] = "You went into a new floor!";
                //floorsCleared++;
                Functions.initMovingTiles();
                break;
            case GOBLIN:
            case BAT:
                Functions.monsterEncounter(action);
                break; //Handles encounters with monsters
        }

    }

    public static void moveMonsters() {
        for(int i=0;i<Reference.monsters.size();i++) {
            Reference.monsters.get(i).moveRandom();
        }
    }

    public static void monsterEncounter(Action action) {
        int monsterX=0, monsterY=0;
        boolean playerMissed = false;

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

        for(int i=0;i<Reference.monsters.size();i++) {
            if (Reference.monsters.get(i).getX() == monsterX && Reference.monsters.get(i).getY() == monsterY) {
                int checkHitPlayer = getRandomNumber(20);
                int checkHitMonster = getRandomNumber(20);

                if(checkHitPlayer > Reference.monsters.get(i).getDef()) {
                    int checkDamage = getRandomNumber(Reference.player.getWeapon().getDmg());
                    int playerAttack = checkDamage;
                    Reference.monsters.get(i).damage(playerAttack);
                    messages[0] = "You are hit the " + Reference.monsters.get(i).getName() + " !";
                    messages[1] = "You attacked the " + Reference.monsters.get(i).getName() + " and left him with " + playerAttack + " HP!";
                    if (Reference.monsters.get(i).getHP() <= 0) {
                        messages[2] = "You killed the " + Reference.monsters.get(i).getName();
                        return;
                    }
                } else {
                    messages[0] = "You are missed!";
                    playerMissed = true;
                }

                if((checkHitMonster > Reference.player.getAC()) && (Reference.monsters.get(i).getHP() > 0)) {
                    int checkDamageMonster = getRandomNumber(Reference.monsters.get(i).getStr());
                    int monsterAttack = checkDamageMonster;
                    if (playerMissed) {
                        messages[1] = "The " + Reference.monsters.get(i).getName() + " hit you!";
                        messages[2] = "The " + Reference.monsters.get(i).getName() + " attacked you and left you with " + monsterAttack + " HP!";
                        messages[3] = " ";
                        playerMissed = false;
                    } else {
                        messages[2] = "The " + Reference.monsters.get(i).getName() + " hit you!";
                        messages[3] = "The " + Reference.monsters.get(i).getName() + " attacked you and left you with " + monsterAttack + " HP!";
                    }
                    Reference.player.damage(monsterAttack);
                } else {
                    if (Reference.monsters.get(i).getHP() <= 0) {
                        return;
                    }
                    else if (playerMissed) {
                        messages[1] = "The " + Reference.monsters.get(i).getName() + " missed.";
                        messages[2] = " ";
                        messages[3] = " ";
                        playerMissed = false;
                    } else {
                        messages[2] = "The " + Reference.monsters.get(i).getName() + " missed.";
                        messages[3] = " ";
                    }
                }
            }
        }
    }

    public static void checkPlayerDeath() {
        if(Reference.player.getHP()<=0) {
            messages[0] = "You died!";
            messages[1] = "Press any button to continue";
            Reference.player.setDead();
        }
    }

    public static int getRandomNumber(int n) {
        Random rand = new Random();
        return rand.nextInt(n)+1;
    }

    public static String getMessageFromArray(int index) {
        return messages[index];
    }
}
