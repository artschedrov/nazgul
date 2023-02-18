package elements;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> bag;

    public Inventory() {
        bag = new ArrayList<Item>();
    }

    public ArrayList<Item> getBag() {
        return bag;
    }

    public Item getBagItem(int index) {
        return bag.get(index);
    }

    public boolean addItemToBag(Item item) {
        bag.add(item);
        return true;
    }

    public void deleteItemFromBag(int index) {
        bag.remove(index);
    }

    public boolean useItemFromBag(int slot) {
        if ( !(bag.get(slot) == null )) {
            deleteItemFromBag(slot);
            return true;
        }
        return false;
    }
}
