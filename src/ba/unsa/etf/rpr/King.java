package ba.unsa.etf.rpr;

import static java.lang.Character.toLowerCase;

public class King extends ChessPiece {
    public King(String position, Color boja){
        super(position,boja);
    }
    @Override
    public void move(String position){
        for(int i=0;i<8;i++) {
            if (toLowerCase(position.charAt(0))!=slova.charAt(i)) throw new IllegalArgumentException("Neispravna pozicija");
            if (position.charAt(1)!=brojevi.charAt(i)) throw new IllegalArgumentException("Neispravna pozicija");
        }
        int indeks1 = slova.indexOf(this.getPosition().charAt(0));
        int indeks2 = brojevi.indexOf(this.getPosition().charAt(1));
        if(position.charAt(0)==slova.charAt(indeks1) || position.charAt(0)==slova.charAt(indeks1+1) || position.charAt(0)==slova.charAt(indeks1-1)){
            if(position.charAt(1)==slova.charAt(indeks2) || position.charAt(1)==slova.charAt(indeks2+1) || position.charAt(1)==slova.charAt(indeks2-1)){
                this.setPosition(position);
            }
        }
        else throw new IllegalChessMoveException("Nedozvoljeno pomjeranje.");
    }
}
