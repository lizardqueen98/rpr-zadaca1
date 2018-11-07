package ba.unsa.etf.rpr;

import static java.lang.Character.toLowerCase;

public class Rook extends ChessPiece{
    public Rook(String position, Color boja){
        super(position,boja);
    }
    @Override
    public void move(String position) throws IllegalChessMoveException{
        new Rook(position,this.getColor());
        if(toLowerCase(this.getPosition().charAt(0))==toLowerCase(position.charAt(0))) this.setPosition(position);
        else if(this.getPosition().charAt(1)==position.charAt(1)) this.setPosition(position);
        else throw new IllegalChessMoveException("Nedozvoljeno pomjeranje.");
    }
}
