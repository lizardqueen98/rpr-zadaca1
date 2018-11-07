package ba.unsa.etf.rpr;

public class Queen extends ChessPiece {
    public Queen(String position, Color boja){
        super(position,boja);
    }
    @Override
    public void move(String position) throws IllegalChessMoveException{
        Bishop b = new Bishop(this.getPosition(),this.getColor());
        Rook r = new Rook(this.getPosition(),this.getColor());
        b.move(position);
        r.move(position);
        this.setPosition(position);
    }
}
