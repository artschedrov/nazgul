package elements;

public class Bat extends Monster {
    private String name;
    public Bat(String name, int posX, int posY, int health, int str, int dex, int ac) {
        super(name, posX, posY, health, str, dex, ac);
        this.name = name;
        System.out.println("[Bat]: Creating bat");
    }

    public void moveRandom() {
        super.moveRandom();
    }

    public String getName() {
        return super.getName();
    }
    public int getAC() {
        return super.getDef();
    }
}
