package elements;

import java.util.Arrays;

public class Inventory {
    private Item[] bag;
    private int bagSize;

    public Inventory(int bagSize) {
        this.bagSize = bagSize;
        bag = new Item[bagSize];
        //Arrays.fill(bag, "Empty");
    }

    public Item[] getBag() {
        return bag;
    }

    public Item getBagItem(int index) {
        return bag[index];
    }

    public boolean addItemToBag(Item item) {
        for (int i = 0; bag.length > i; i++) {
            if (bag[i] == null) {
                bag[i] = item;
                return true;
            }
        }
        return false;
    }

    public void deleteItemFromBag(int index) {
        bag[index] = null;
    }

    public boolean useItemFromBag(int slot) {
        if ( !(bag[slot] == null )) {
            deleteItemFromBag(slot);
            return true;
        }
        return false;
    }
}
