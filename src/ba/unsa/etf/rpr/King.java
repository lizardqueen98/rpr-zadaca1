package ba.unsa.etf.rpr;

import static java.lang.Character.toLowerCase;

public class King extends ChessPiece {
    public King(String position, Color boja){
        super(position,boja);
    }
    @Override
    public void move(String position) throws IllegalChessMoveException {
        //ne smije se staviti na istu poziciju
        if(this.getPosition().equals(position)) throw new IllegalChessMoveException("Nedozvoljeno pomjeranje.");
        //u svakoj klasi pozivam konstruktor, koji ce baciti izuzetak, ako pozicija ne posoji na tabli, da ne bi morala opet ispitivati
        new King(position, this.getColor());
        int indeks1 = slova.indexOf(toLowerCase(this.getPosition().charAt(0)));
        int indeks2 = brojevi.indexOf(this.getPosition().charAt(1));
        int indeks3 = slova.indexOf(toLowerCase(position.charAt(0)));
        int indeks4 = brojevi.indexOf(position.charAt(1));
        if ((Math.abs(indeks1 - indeks3) == 1 || Math.abs(indeks1 - indeks3) == 0) && (Math.abs(indeks2 - indeks4) == 1 || Math.abs(indeks2 - indeks4) == 0))
            super.move(position);
        else throw new IllegalChessMoveException("Nedozvoljeno pomjeranje.");
    }
}
