package elements;

import util.ItemType;

public class Item {
    protected int posX;
    protected int posY;
    private String name;
    private String color;
    private ItemType itemType;

    public Item(int posX, int posY, String name, String color, ItemType itemType) {
        this.setPos(posX, posY);
        this.name = name;
        this.color = color;
        this.itemType = itemType;
    }

    public void setPos(int posX, int posY) {
        this.posX=posX; this.posY=posY;
    }

    public int getX() {
        return posX;
    }

    /**Getter Method*/
    public int getY() {
        return posY;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ItemType getItemType() {
        return itemType;
    }
}
