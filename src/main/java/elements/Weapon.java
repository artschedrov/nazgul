package elements;

public class Weapon {
    public static Weapon unarmed = new Weapon("Unarmed", 1, 1);
    public static Weapon smallSword = new Weapon("Small Sword", 6, 1);
    private String name;
    private int dmg;
    private int countDice;

    public Weapon(String name, int dmg, int countDice) {
        this.name=name;
        this.dmg=dmg;
        this.countDice = countDice;
    }

    public int getDmg() {
        return dmg;
    }
    /**Getter Method*/
    public String getName() {
        return name;
    }
}
