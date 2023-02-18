package elements;

import gui.GameBoard;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<ArrayList<Item>> bag2;
    public Inventory() {
        bag2 = new ArrayList<ArrayList<Item>>();
    }

    public ArrayList<ArrayList<Item>> getBag2() {
        return bag2;
    }
    public Item getBagItem2(int slot, int index) {
        return bag2.get(slot).get(index);
    }

    //TODO Need refactor
    public void addItemToBag2(Item item) {
        if(bag2.isEmpty()) {
            bag2.add(new ArrayList<Item>());
            bag2.get(0).add(item);
        } else {
            for(int i = 0; i < bag2.size(); i++) {
                if(bag2.get(i).get(0).getItemType() == item.getItemType()) {
                    if(bag2.get(i).get(0).getColor() == item.getColor()) {
                        if(bag2.get(i).get(0).isIdentified == item.isIdentified) {
                            bag2.get(i).add(item);
                            return;
                        } else {
                            addNewItem(i, item);
                            return;
                        }
                    } else {
                        if(i == bag2.size() - 1) {
                            addNewItem(i, item);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void addNewItem(int i, Item item) {
        bag2.add(new ArrayList<Item>());
        bag2.get(i+1).add(item);
    }

    public void deleteItemFromBag(int slot) {
        if (bag2.get(slot).size() == 1) {
            bag2.remove(slot);
        } else {
            bag2.get(slot).remove(bag2.get(slot).size() - 1);
        }
    }
}
