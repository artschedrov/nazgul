package game;

import elements.*;
import gui.GameBoard;
import util.Functions;

import javax.swing.*;
import java.util.ArrayList;
//import java.util.ArrayList;

public class Main {
    private static JFrame window;
    private static GameBoard gameBoard;

    public static void main(String[] args) {
        createWindow();
        createGameBoard();
        initGame();
    }

    private static void createWindow() {
        System.out.println("[Main]: Creating window");
        window = new JFrame("Nazgûl");
        window.setVisible(true);
        window.setResizable(false);
        window.setBounds(200, 80, Reference.windowWidth, Reference.windowHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void createGameBoard() {
        System.out.println("[Main]: Creating GameBoard");
        gameBoard = new GameBoard();
        window.add(gameBoard);
        gameBoard.requestFocusInWindow();
    }
    public static void initGame() {
        //initialization
        Reference.currentFloor = new Floor(0);
        Reference.player = new Player(3, 2);
        Reference.inventory = new Inventory(6);
        Reference.monsters = new ArrayList<Monster>();
        Reference.items = new ArrayList<Item>();
        Functions.initMovingTiles();
        Functions.initItemsTiles();
    }
}