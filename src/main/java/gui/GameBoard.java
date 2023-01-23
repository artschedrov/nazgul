package gui;

import elements.Floor;
import game.Main;
import game.Reference;
import util.Action;
import util.Functions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameBoard extends JPanel implements KeyListener {
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

            g.drawString("Items in your bag:", 830, 50);
            g.drawString("[1] " + Reference.inventory.getBag()[0], 830, 75);
            g.drawString("[2] " + Reference.inventory.getBag()[1], 830, 95);
            g.drawString("[3] " + Reference.inventory.getBag()[2], 830, 115);
            g.drawString("[4] " + Reference.inventory.getBag()[3], 830, 135);
            g.drawString("[5] " + Reference.inventory.getBag()[4], 830, 155);
            g.drawString("[6] " + Reference.inventory.getBag()[5], 830, 175);
            //Message

            g.drawString(Functions.getMessageFromArray(0), 15, 480);
            g.drawString(Functions.getMessageFromArray(1), 15, 500);
            g.drawString(Functions.getMessageFromArray(2), 15, 520);
            g.drawString(Functions.getMessageFromArray(3), 15, 540);

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
                }
                Functions.checkPlayerDeath();
            } else {
                Main.initGame();
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
