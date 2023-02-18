package gui;

import elements.Floor;
import game.Main;
import game.Reference;
import util.Action;
import util.Functions;
import util.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameBoard extends JPanel implements KeyListener {
    boolean switchStatus = false;
    public GameBoard() {
        addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //repaint();
        //revalidate();
        //Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Reference.windowWidth, Reference.windowHeight);
        g.setColor(Color.WHITE);

        //g.drawRoundRect(5, 5, Reference.windowWidth-10, Reference.windowHeight-150, 5, 5);


        //Floor
        g.setColor(Color.WHITE);

        int x, y;
        if(Reference.currentFloor.isFirstFloor()) {
            x=280; y=100;
            g.setFont(new Font("arial", Font.ITALIC, 16));
            g.setColor(Color.gray);
            g.drawString("\"Come not between the Nazgûl and his prey! Or he will not slay thee in thy turn.", 190, 300);
            g.drawString("He will bear thee away to the houses of lamentation, beyond all darkness,", 190, 320);
            g.drawString("where thy flesh shall be devoured, and thy shriveled mind be left naked to the Lidless Eye...\"", 190, 340);

        }
        else if(Floor.currentFloor == 1) {
            x=280; y=100;
            g.drawString("Choose your race:", 200, 70);
            g.drawString("[H]uman", 200, 100);
            g.drawString("[E]lf", 200, 125);
            g.drawString("[D]warf", 200, 150);

        } else {
            x=200; y=100;
            //g.drawRoundRect(15, 15, Reference.windowWidth-220, Reference.windowHeight-150, 5, 5);
            //g.drawRoundRect(5, Reference.windowHeight-140, Reference.windowWidth-15, Reference.windowHeight-500, 5, 5);

            if (Floor.currentFloor == 2) {
                g.drawString("Use WASD or arrow keys to move", 350, 150);
                g.drawString("Walk towards the stairs > to start", 350, 170);
                g.drawString("A spell has been cast on you that hides your identity.", 350, 100);
                g.drawString("The enemy will think that you are an orc.", 350, 120);
            }


        }

//        for(int i=0;i<Reference.currentFloor.getHeight();i++) {
//            for(int j=0;j<Reference.currentFloor.getWidth();j++) {
//                g.drawString(""+Reference.currentFloor.getTileChar(j, i), x, y);
//                x+=10;
//            }
//            //y+=15; x=15;
//            if(Reference.currentFloor.isFirstFloor()) {
//                x=280; y+=15;
//                g.setFont(new Font("Monospaced", Font.PLAIN, 15));
//                g.drawString("Press SPACE to start", 420, 510);
//            } else {
//                x=200; y+=15;
//            }
//        }

        drawChars(g, x, y);
        //Player stats
        if(!Reference.currentFloor.isFirstFloor() && !(Floor.currentFloor == 1)) {
            g.setFont(new Font("arial", Font.PLAIN, 15));
            g.setColor(Color.CYAN);
            g.drawString(Reference.player.getName(), 10, 50);
            g.drawString(Reference.player.race, 10, 70);
            g.setFont(new Font("arial", Font.PLAIN, 15));
            g.setColor(Color.WHITE);
            g.drawString("HP: " + Reference.player.getHP() + "/" + Reference.player.getMaxHP(), 10, 110);
            g.drawString("AC: " + Reference.player.getAC(), 10, 135);
            g.drawString("STR: " + Reference.player.getStr(), 10, 165);
            g.drawString("DEX: " + Reference.player.getDex(), 10, 190);
            g.drawString("CON: " + Reference.player.getCon(), 10, 215);
            g.drawString("Gold: ", 10, 245);
            g.drawString("Keys: ", 10, 270);
            g.drawString("Weapon Equipped:", 10, 300);
            g.drawString(Reference.player.getWeapon().getName(), 20, 325);
            g.drawString("Armor Equipped:", 10, 350);
            g.drawString(Reference.player.getArmor().getName(), 20, 375);

            //Message

            g.drawString(Functions.getMessageFromArray(0), 30, 480);
            g.drawString(Functions.getMessageFromArray(1), 30, 500);
            g.drawString(Functions.getMessageFromArray(2), 30, 520);
            g.drawString(Functions.getMessageFromArray(3), 30, 540);

        }
        if(switchStatus) {
            switchPlayerInventory(g);
            g.drawString(Functions.getMessageFromArray(0), 30, 480);
            g.drawString(Functions.getMessageFromArray(1), 30, 500);
            g.drawString(Functions.getMessageFromArray(2), 30, 520);
            g.drawString(Functions.getMessageFromArray(3), 30, 540);
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        repaint();
        revalidate();
        if (Floor.currentFloor == 1) {
            switch (arg0.getKeyCode()) {
                case KeyEvent.VK_H:
                    Functions.handlePlayerAction(Action.HUMAN);
                    break;
                case KeyEvent.VK_E:
                    Functions.handlePlayerAction(Action.ELF);
                    break;
                case KeyEvent.VK_D:
                    Functions.handlePlayerAction(Action.DWARF);
                    break;
            }

        } else {
            if (Reference.player.isAlive()) {
                switch(arg0.getKeyCode()) {
                    //Move player foward
                    case KeyEvent.VK_SPACE:
                        if (Floor.currentFloor == 0) {
                            Functions.handlePlayerAction(Action.SPACE);
                        }
                        break;
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:
                        Reference.player.setFacing(Action.FOWARD);
                        Functions.handlePlayerAction(Action.FOWARD);
                        Reference.currentFloor.updatePlayerPos();
                        Functions.moveMonsters();
                        Reference.currentFloor.updateMonstersPos();
                        break;
                    //Move player left
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        Reference.player.setFacing(Action.LEFT);
                        Functions.handlePlayerAction(Action.LEFT);
                        Reference.currentFloor.updatePlayerPos();
                        Functions.moveMonsters();
                        Reference.currentFloor.updateMonstersPos();
                        break;
                    //Move player Backwards
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        Reference.player.setFacing(Action.BACKWARDS);
                        Functions.handlePlayerAction(Action.BACKWARDS);
                        Reference.currentFloor.updatePlayerPos();
                        Functions.moveMonsters();
                        Reference.currentFloor.updateMonstersPos();
                        break;
                    //Move player right
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        Reference.player.setFacing(Action.RIGHT);
                        Functions.handlePlayerAction(Action.RIGHT);
                        Reference.currentFloor.updatePlayerPos();
                        Functions.moveMonsters();
                        Reference.currentFloor.updateMonstersPos();
                        break;
                    case KeyEvent.VK_B:
                        setSwitchStatus();
                        break;
                    case KeyEvent.VK_Y:
                        Functions.makeDecision(true);
                        Reference.currentFloor.updatePlayerPos();
                        break;
                    //Make decision No
                    case KeyEvent.VK_N:
                        Functions.makeDecision(false);
                        Reference.currentFloor.updatePlayerPos();
                        break;
                    case KeyEvent.VK_I:
                        Functions.handlePlayerAction(Action.INFO);
                        break;
                    case KeyEvent.VK_U:
                        Functions.handlePlayerAction(Action.USE);
                        break;
                    case KeyEvent.VK_1:
                        Functions.initItemOptions(0);
                        break;
                    case KeyEvent.VK_2:
                        Functions.initItemOptions(1);
                        break;
                    case KeyEvent.VK_3:
                        Functions.initItemOptions(2);
                        break;
                    case KeyEvent.VK_4:
                        Functions.initItemOptions(3);
                        break;
                    case KeyEvent.VK_5:
                        Functions.initItemOptions(4);
                        break;
                    case KeyEvent.VK_6:
                        Functions.initItemOptions(5);
                        break;
                }
                Functions.checkPlayerDeath();
            } else {
                Main.initGame();
            }

        }
    }

    public void drawChars(Graphics g, int x, int y) {
        for(int i=0;i<Reference.currentFloor.getHeight();i++) {
            for(int j=0;j<Reference.currentFloor.getWidth();j++) {
                g.drawString(""+Reference.currentFloor.getTileChar(j, i), x, y);
                x+=10;
            }
            //y+=15; x=15;
            if(Reference.currentFloor.isFirstFloor()) {
                x=280; y+=15;
                g.setFont(new Font("Monospaced", Font.PLAIN, 15));
                g.drawString("Press SPACE to start", 420, 510);
            } else {
                x=200; y+=15;
            }
        }
    }

    public void setSwitchStatus() {
        if(switchStatus) {
            switchStatus = false;
        } else {
            switchStatus = true;
        }
    }

    public void switchPlayerInventory(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Reference.windowWidth, 800);
        g.setColor(Color.WHITE);
        g.drawRoundRect(5, 5, Reference.windowWidth-10, Reference.windowHeight-150, 5, 5);
        g.setFont(new Font("arial", Font.PLAIN, 15));
        g.setColor(Color.PINK);
        g.drawString("Your inventory", 10,50);
        int xcord = 20;
        int ycord = 75;
        g.setColor(Color.WHITE);
        for(int i = 0; i < Reference.inventory.getBag().size(); i++) {
            int slotShift = i + 1;
            if(Reference.inventory.getBagItem(i) == null) {
                //g.drawString("["+slotShift+"] " + "Empty", xcord, ycord + 25 * i);
            } else {
                if(Reference.inventory.getBagItem(i).checkIdentified()) {
                    g.drawString("["+slotShift+"] " + Reference.inventory.getBagItem(i).getName(), xcord, ycord + 25 * i);
                } else {
                    g.drawString("["+slotShift+"] " + "A " + Reference.inventory.getBagItem(i).getColor() + " Potion", xcord, ycord + 25 * i);
                }

            }
        }
    }
    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }
}
