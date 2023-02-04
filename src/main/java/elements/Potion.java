package elements;

import util.ItemType;
import java.util.Random;

public class Potion extends Item {
//    public static Potion potionOfHeal = new Potion(
//            0,
//            0,
//            "A Potion of Heal",
//            "Yellow",
//            ItemType.POTION,
//            false,
//            5
//    );
    public static Potion potionOfCurse = new Potion(
            0,
            0,
            "A Potion of Curse",
            "Black",
        ItemType.POTION,
        true,
            2,
            "This black liquid is the cursed black magic of Mordor. Increases strength by 4 points but at the same time reduces constitution by 4 points.");

    public static Potion potionHealWounds = new Potion(
            0,
            0,
            "A Potion of heal wounds",
            "Yellow",
            ItemType.POTION,
            true,
            4,
            "It's yellow liquid heal your wounds");
    //public static Potion potionOfDexterity = new Potion(0,0,"A Potion of Dexterity", "Green", ItemType.POTION, false);
    //public static Potion potionOfConstitution = new Potion(0,0,"A Potion of Constitution", "Brown", ItemType.POTION, false);

    public static Potion[] potions = {potionOfCurse, potionHealWounds};

    private static ItemType itemType;

    public Potion(int posX, int posY, String name, String color, ItemType itemType, boolean isIdentified, int property, String info) {
        super(posX, posY, name, color, itemType, isIdentified, property, info);
        this.setPos(posX, posY);
        this.setIdentified(isIdentified);
        System.out.println("[Potion]: Creating potion");
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

    public boolean checkIdentified() {
        return super.checkIdentified();
    }

    public int getProperty() {
        return super.getProperty();
    }

    private static Potion copyPotion(Potion potion) {
        return new Potion(
                potion.posX,
                potion.posY,
                potion.getName(),
                potion.getColor(),
                ItemType.POTION,
                potion.checkIdentified(),
                potion.getProperty(),
                potion.getInfo()
        );
    }

    public static Potion getRandomPotion() {
        int rand = new Random().nextInt(potions.length);
        return copyPotion(potions[rand]);
    }

    public String getInfo() {
        return super.getInfo();
    }
}
