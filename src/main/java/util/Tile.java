package util;

public enum Tile {

    NOTHING('.'),
    WALL('#'),
    PLAYER('@'),
    STAIRS('>'),
    TRAP(','),
    HP_POTION('!'),
    GOLD('$'),
    TREASURE('T'),
    DOOR('/'),
    MONSTER('M'),
    SPACE(' '),
    HAFTED_WEAPON('\\'),
    EDGED_WEAPON('|'),
    SPACE1('`'),
    STAFF('_'),
    SOFT_ARMOUR('('),
    GOBLIN('g'),
    KOBOLD('k'),
    BAT('b');


    private char symbol;

    Tile(char symbol) {
        this.symbol=symbol;
    }

    public char symbol() {return symbol;}
}
