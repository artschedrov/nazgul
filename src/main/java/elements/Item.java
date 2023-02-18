package elements;

import game.Reference;
import util.ItemType;

public class Item {
    protected int posX;
    protected int posY;
    private String name;
    private String color;
    private ItemType itemType;
    protected boolean isIdentified = false;
    protected int property;
    private String info;

    public Item(int posX,
                int posY,
                String name,
                String color,
                ItemType itemType,
                boolean isIdentified,
                int property,
                String info
    ) {
        this.setPos(posX, posY);
        this.name = name;
        this.color = color;
        this.itemType = itemType;
        this.isIdentified = isIdentified;
        this.property = property;
        this.info = info;
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
        if(isIdentified) {
            return name;
        } else {
            return color;
        }
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

    public void setIdentified(boolean isIdentified) {
        this.isIdentified = isIdentified;
    }
    public boolean checkIdentified() {
        return this.isIdentified;
    }

    public int getProperty() {
        return this.property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public static void useItem(Item item) {
        if(item.getItemType() == ItemType.POTION) {
            switch (item.getColor()) {
                case "Yellow":
                    Reference.player.heal(item.getProperty());
                    break;
                case "Black":
                    Reference.player.negativeEffect(item);
                    break;
                case "Brown":
                    break;
            }
        }
    }

    public String getInfo() {
        return this.info;
    }
}
