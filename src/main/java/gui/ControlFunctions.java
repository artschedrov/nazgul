package gui;

import elements.Floor;
import util.Action;
import util.Functions;

import java.awt.event.KeyEvent;

public class ControlFunctions {
    public static void changeRace(KeyEvent keyEvent) {
        if (Floor.currentFloor == 1) {
            switch (keyEvent.getKeyCode()) {
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
        }
    }
}
