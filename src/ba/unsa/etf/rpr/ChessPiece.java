package ba.unsa.etf.rpr;

import static java.lang.Character.toLowerCase;

public abstract class ChessPiece {
    public enum Color{BLACK,WHITE};
    private String position;
    private Color boja;
    //public static Character[] slova={'a', 'b','c', 'd', 'e', 'f', 'g', 'h'};
    public static String slova="abcdefgh";
    //public static Character[] brojevi={'1', '2','3', '4', '5', '6', '7', '8'};
    public static String brojevi="12345678";
    public String getPosition(){
        return position;
    }
    public Color getColor(){
        return boja;
    }
    public ChessPiece(String position, Color boja){
        for(int i=0;i<8;i++) {
            if (toLowerCase(position.charAt(0))!=slova.charAt(i)) throw new IllegalArgumentException("Neispravna pozicija");
            if (position.charAt(1)!=brojevi.charAt(i)) throw new IllegalArgumentException("Neispravna pozicija");
        }
        this.position=position;
        this.boja=boja;
    }
    public abstract void move(String position);

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBoja(Color boja) {
        this.boja = boja;
    }
}
