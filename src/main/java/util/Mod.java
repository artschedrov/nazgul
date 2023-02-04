package util;

public class Mod {
    protected int modificator = 0;

    public Mod() {}

    public int getModificator() {
        return modificator;
    }

    public void setModificator(int modificator) {
        this.modificator = modificator;
    }

    public static int calculateModificator(int characteristic) {
        int mod = 0;
        if(characteristic <= 9) {
            return calculateNegativeMod(characteristic, mod);
        } else {
            return calculatePositiveMod(characteristic, mod);
        }
    }

    public static int calculatePositiveMod(int characteristic, int mod) {
        switch(characteristic) {
            case 10:
            case 11:
                break;
            case 12:
            case 13:
                mod = 1;
                break;
            case 14:
            case 15:
                mod = 2;
                break;
            case 16:
            case 17:
                mod = 3;
                break;
            case 18:
            case 19:
                mod = 4;
                break;
            case 20:
            case 21:
                mod = 5;
                break;
            case 22:
            case 23:
                mod = 6;
                break;
            case 24:
            case 25:
                mod = 7;
                break;
            case 26:
            case 27:
                mod = 8;
                break;
            case 28:
            case 29:
                mod = 9;
                break;
            case 30:
                mod = 10;
                break;
        }
        return mod;
    }

    public static int calculateNegativeMod(int characteristic, int mod) {
        switch (characteristic) {
            case 1 -> mod = -5;
            case 2, 3 -> mod = -4;
            case 4, 5 -> mod = -3;
            case 6, 7 -> mod = -2;
            case 8, 9 -> mod = -1;
        }
        return mod;
    }
}
