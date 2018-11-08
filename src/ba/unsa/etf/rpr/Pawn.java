package ba.unsa.etf.rpr;

import static java.lang.Character.toLowerCase;

public class Pawn extends ChessPiece{
    public Pawn(String position, Color boja){
        super(position, boja);
    }
    @Override
    public void move(String position) throws IllegalChessMoveException{
        new Pawn(position,this.getColor());
        int indeks1 = brojevi.indexOf(this.getPosition().charAt(1));
        int indeks2 = brojevi.indexOf(position.charAt(1));
        if(this.getPosition().charAt(0)!=position.charAt(0)) throw new IllegalChessMoveException("Nedozvoljeno pomjeranje.");
        else if(this.getPosition().charAt(1)=='2' || this.getPosition().charAt(1)=='7'){
            if(Math.abs(indeks2-indeks1)==2) super.move(position);
        }
        else if(Math.abs(indeks1-indeks2)==1) super.move(position);
        else throw new IllegalChessMoveException("Nedozvoljeno pomjeranje.");
    }
}
