package ba.unsa.etf.rpr;

import static java.lang.Character.toLowerCase;

public class Queen extends ChessPiece {
    public Queen(String position, Color boja){
        super(position,boja);
    }
    @Override
    public void move(String position) throws IllegalChessMoveException{
        new Queen(position,this.getColor());
        int indeks1 = slova.indexOf(toLowerCase(this.getPosition().charAt(0)));
        int indeks2 = brojevi.indexOf(this.getPosition().charAt(1));
        int indeks3 = slova.indexOf(toLowerCase(position.charAt(0)));
        int indeks4 = brojevi.indexOf(position.charAt(1));
        if(toLowerCase(this.getPosition().charAt(0))==toLowerCase(position.charAt(0))) this.setPosition(position);
        else if(this.getPosition().charAt(1)==position.charAt(1)) this.setPosition(position);
        else if(Math.abs(indeks1-indeks3)==Math.abs(indeks2-indeks4)) this.setPosition(position);
        else throw new IllegalChessMoveException("Nedozvoljeno pomjeranje.");
    }
}
