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
        int indeks3 = slova.indexOf(toLowerCase(this.getPosition().charAt(0)));
        int indeks4 = slova.indexOf(toLowerCase(position.charAt(0)));
        if((this.getPosition().charAt(1)=='2' || this.getPosition().charAt(1)=='7') && indeks2-indeks1==2){
            super.move(position);
        }
        else if(indeks2-indeks1==1 && (Math.abs(indeks3-indeks4)==1 || Math.abs(indeks3-indeks4)==0)){
            super.move(position);
        }
        else throw new IllegalChessMoveException("Nedozvoljeno pomjeranje.");
    }
}
