package elements;

public class Bat extends Monster {
    private String name;
    public Bat(String name, int posX, int posY, int health) {
        super(posX, posY, health);
        this.name = name;
        System.out.println("[Bat]: Creating bat");
    }

    public void moveRandom() {
        super.moveRandom();
    }

    public String getName() {
        return super.getName();
    }
}
