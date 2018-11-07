package ba.unsa.etf.rpr;

import static java.lang.Character.toLowerCase;

public abstract class ChessPiece {
    public enum Color{BLACK,WHITE};
    private String position;
    private Color boja;
    public static String slova="abcdefgh";
    public static String brojevi="12345678";
    public String getPosition(){
        return position;
    }
    public Color getColor(){
        return boja;
    }
    public ChessPiece(String position, Color boja){
        boolean ima_slovo=false;
        boolean ima_broj=false;
        if(position.equals("") || position.length()>2) throw new IllegalArgumentException("Neispravna pozicija");
        for(int i=0;i<8;i++) {
            if (toLowerCase(position.charAt(0))==slova.charAt(i)) ima_slovo=true;
            if (position.charAt(1)==brojevi.charAt(i)) ima_broj=true;
        }
        if(ima_slovo && ima_broj) {
            this.position = position;
            this.boja = boja;
        }
        else throw new IllegalArgumentException("Neispravna pozicija");
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBoja(Color boja) {
        this.boja = boja;
    }
    public abstract void move(String position) throws IllegalChessMoveException;
}
