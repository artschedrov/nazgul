package elements;

import util.ItemType;

import java.util.Random;

public class Potion extends Item {
    public static Potion potionOfHeal = new Potion(0, 0,"A Potion of Heal", "Yellow", ItemType.POTION);
    public static Potion potionOfCurse = new Potion(0, 0,"A Potion of Curse", "Black", ItemType.POTION);
    public static Potion potionOfDexterity = new Potion(0,0,"A Potion of Dexterity", "Green", ItemType.POTION);

    public static Potion[] potions = { potionOfHeal, potionOfCurse, potionOfDexterity };

    private static ItemType itemType;

    public Potion(int posX, int posY, String name, String color, ItemType itemType) {
        super(posX, posY, name, color, itemType);
        this.setPos(posX, posY);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getColor() {
        return super.getColor();
    }

    public void setColor(String color) {
        super.setColor(color);
    }

    public ItemType getItemType() {
        return super.getItemType();
    }

    public void setPos(int x, int y) {
        super.setPos(x, y);
    }
    public static Potion getRandomPotion() {
        int rand = new Random().nextInt(potions.length);
        return potions[rand];
    }
}
