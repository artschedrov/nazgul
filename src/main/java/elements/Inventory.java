package elements;

import java.util.Arrays;

public class Inventory {
    private String[] bag;
    private int bagSize;

    public Inventory(int bagSize) {
        this.bagSize = bagSize;
        bag = new String[bagSize];
        Arrays.fill(bag, "Empty");
        bag[0] = "a Scroll of Identity";
    }

    public String[] getBag() {
        return bag;
    }

    public boolean addItemToBag(String item) {
        for (int i = 0; bag.length > i; i++) {
            if (bag[i] == "Empty") {
                bag[i] = item;
                return true;
            }
        }
        return false;
    }

    public void deleteItemFromBag(int index) {
        bag[index] = "Empty";
    }
}
