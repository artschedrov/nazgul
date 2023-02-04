package elements;

public class Armor {
    public static Armor unarmored = new Armor("Unarmored", 0);
    public static Armor softLeatherArmour = new Armor("Soft Leather Armor", 4);
    public static Armor softStuddedLeather = new Armor("Soft Studded Leather", 5);
    public static Armor hardLeatherArmour = new Armor("Hard Leather Armour", 6);
    public static Armor hardStuddedLeather = new Armor("Hard Studded Leather", 7);
    public static Armor leatherScaleMail = new Armor("Leather Scale Mail", 11);

    private String name;
    private int armorAc;

    public Armor(String name, int armorAc) {
        this.name=name; this.armorAc=armorAc;
    }

    public String getName() {return name;}

    public int getAc() {return this.armorAc;}
}
