package elements;

public class Armor {
    public static Armor unarmored = new Armor("Unarmored", 0);
    public static Armor softLeatherArmour = new Armor("Leather Armor", 1);
    public static Armor softStuddedLeather = new Armor("Studded Leather", 2);
    //public static Armor hardLeatherArmour = new Armor("Hard Leather Armour", 6);
    //public static Armor hardStuddedLeather = new Armor("Hard Studded Leather", 7);
    public static Armor leatherScaleMail = new Armor("Scale Mail", 4);

    private String name;
    private int armorAc;

    public Armor(String name, int armorAc) {
        this.name=name; this.armorAc=armorAc;
    }

    public String getName() {return name;}

    public int getAc() {return this.armorAc;}
}
