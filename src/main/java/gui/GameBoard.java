package gui;

import elements.Floor;
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
        repaint(); revalidate();

        //Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Reference.windowWidth, Reference.windowHeight);
        g.setColor(Color.WHITE);

        g.drawRoundRect(5, 5, Reference.windowWidth-10, Reference.windowHeight-150, 5, 5);


        //Floor
        g.setColor(Color.WHITE);

        int x, y;
        if(Reference.currentFloor.isFirstFloor()) {
            x=280; y=100;
            g.setFont(new Font("arial", Font.ITALIC, 18));
            g.setColor(Color.gray);
            g.drawString("\"Come not between the Nazgûl and his prey! Or he will not slay thee in thy turn.", 210, 300);
            g.drawString("He will bear thee away to the houses of lamentation, beyond all darkness,", 210, 320);
            g.drawString("where thy flesh shall be devoured, and thy shriveled mind be left naked to the Lidless Eye...\"", 210, 340);

        }
        else if(Floor.currentFloor == 1) {
            x=280; y=100;
            g.drawString("Choose your race:", 200, 70);
            g.drawString("[H]uman", 200, 100);
            g.drawString("[E]lf", 200, 125);
            g.drawString("[D]warf", 200, 150);

        } else {
            x=200; y=100;
            g.drawRoundRect(5, 5, Reference.windowWidth-220, Reference.windowHeight-150, 5, 5);
            //g.drawRoundRect(790, 5, Reference.windowWidth-800, Reference.windowHeight-150, 5, 5);
            g.drawRoundRect(5, Reference.windowHeight-140, Reference.windowWidth-15, Reference.windowHeight-500, 5, 5);


        }

        for(int i=0;i<Reference.currentFloor.getHeight();i++) {
            for(int j=0;j<Reference.currentFloor.getWidth();j++) {
                g.drawString(""+Reference.currentFloor.getTileChar(j, i), x, y);
                x+=10;
            }
            //y+=15; x=15;
            if(Reference.currentFloor.isFirstFloor()) {
                x=280; y+=15;
//                g.drawString("a roguelike", 640, 210);
//                g.setFont(new Font("arial", Font.ITALIC, 18));
//                g.setColor(Color.gray);
//                g.drawString("\"Come not between the Nazgûl and his prey! Or he will not slay thee in thy turn.", 230, 300);
//                g.drawString("He will bear thee away to the houses of lamentation, beyond all darkness,", 230, 320);
//                g.drawString("where thy flesh shall be devoured, and thy shriveled mind be left naked to the Lidless Eye...\"", 230, 340);

                g.setFont(new Font("Monospaced", Font.PLAIN, 15));
                g.drawString("Press SPACE to start", 420, 510);
            }
            else if(Floor.currentFloor == 1) {
                x=200; y+=15;
//                g.drawString("Ascii Roguelike", 200, 70);
            } else {
                x=200; y+=15;
            }
        }

        //Player stats
        if(!Reference.currentFloor.isFirstFloor() && !(Floor.currentFloor == 1)) {
            g.setFont(new Font("arial", Font.PLAIN, 15));
            g.setColor(Color.GREEN);
            g.drawString(Reference.player.getName(), 800, 50);
            g.drawString(Reference.player.race, 800, 70);
            g.setFont(new Font("arial", Font.PLAIN, 15));
            g.setColor(Color.WHITE);
            g.drawString("HP: ", 800, 110);
            g.drawString("STR: ", 800, 135);
            g.drawString("DEF: ", 800, 165);
            g.drawString("Gold: ", 800, 190);
            g.drawString("Keys: ", 800, 215);
            g.drawString("Weapon Equipped:", 800, 240);
            g.drawString("Armor Equipped:", 800, 265);
        }
        //g.drawString(Reference.player.getWeapon().getName(), 810, 205);
        //g.drawString("Armor Equipped:", 800, 230);
        //g.drawString(Reference.player.getArmor().getName(), 810, 250);

        //Message
//        g.drawString(Functions.getMessage(), 15, 480);
//        g.drawString(Functions.getMessage2(), 15, 500);
//        g.drawString(Functions.getMessage3(), 15, 520);

        //Floor
//        g.setColor(Color.WHITE);
//
//        int x, y;
//        if(Reference.currentFloor.isFirstFloor()) {x=200; y=100;}
//        else {x=15; y=20;}
//
//        for(int i=0;i<Reference.currentFloor.getHeight();i++) {
//            for(int j=0;j<Reference.currentFloor.getWidth();j++) {
//                g.drawString(""+Reference.currentFloor.getTileChar(j, i), x, y);
//                x+=10;
//            }
//            //y+=15; x=15;
//            if(Reference.currentFloor.isFirstFloor()) {x=200; y+=15;}
//            else {x=15; y+=15;}
//        }
//
//        //Player stats
//        g.setFont(new Font("arial", Font.PLAIN, 30));
//        g.drawString("Player", 800, 50);
//        g.setFont(new Font("arial", Font.PLAIN, 15));
//
//        g.drawString("Weapon Equipped:", 800, 185);
//
//        g.drawString("Armor Equipped:", 800, 230);
//
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
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
//                    Functions.handlePlayerAction(Action.RACE);
//
//                    break;
            }

        }
        switch(arg0.getKeyCode()) {
            //Move player foward
            case KeyEvent.VK_SPACE:
                Functions.handlePlayerAction(Action.SPACE);
                break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                Reference.player.setFacing(Action.FOWARD);
                Functions.handlePlayerAction(Action.FOWARD);
                Reference.currentFloor.updatePlayerPos();
//                Functions.moveMonsters();
//                Reference.currentFloor.updateMonstersPos();
                break;
            //Move player left
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                Reference.player.setFacing(Action.LEFT);
                Functions.handlePlayerAction(Action.LEFT);
                Reference.currentFloor.updatePlayerPos();
//                Functions.moveMonsters();
//                Reference.currentFloor.updateMonstersPos();
                break;
            //Move player Backwards
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                Reference.player.setFacing(Action.BACKWARDS);
                Functions.handlePlayerAction(Action.BACKWARDS);
                Reference.currentFloor.updatePlayerPos();
//                Functions.moveMonsters();
//                Reference.currentFloor.updateMonstersPos();
                break;
            //Move player right
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                Reference.player.setFacing(Action.RIGHT);
                Functions.handlePlayerAction(Action.RIGHT);
                Reference.currentFloor.updatePlayerPos();
//                Functions.moveMonsters();
//                Reference.currentFloor.updateMonstersPos();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }
}
