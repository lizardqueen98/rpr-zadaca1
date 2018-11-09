package ba.unsa.etf.rpr;

import java.util.Map;
import java.util.TreeMap;

import static ba.unsa.etf.rpr.ChessPiece.brojevi;
import static ba.unsa.etf.rpr.ChessPiece.slova;

public class Board {
    private Map<String,ChessPiece> board;
    private boolean Preskace(String position1, String position2, Class type){
        int indeks1 = slova.indexOf(position1.charAt(0));
        int indeks2 = brojevi.indexOf(position1.charAt(1));
        int indeks3 = slova.indexOf(position2.charAt(0));
        int indeks4 = brojevi.indexOf(position2.charAt(1));
            if(Math.abs(indeks1-indeks3)==Math.abs(indeks2-indeks4) && (type.equals(Queen.class) || type.equals(Bishop.class))){
                if(indeks1>indeks3 && indeks2>indeks4){
                    for(int i=indeks3+1;i<indeks1;i++){
                        if(board.containsKey(String.valueOf(slova.charAt(i))+String.valueOf(brojevi.charAt(i)))) return true;
                    }
                }
                else if(indeks1>indeks3 && indeks2<indeks4){
                    for(int i=indeks3+1;i<indeks1;i++){
                        if(board.containsKey(String.valueOf(slova.charAt(i))+String.valueOf(brojevi.charAt(6-i)))) return true;
                        //ovo je ustvari 7-i-1 jer smo ga uvecali
                    }
                }
                else if(indeks1<indeks3 && indeks2<indeks4){
                    for(int i=indeks1+1;i<indeks3;i++){
                        if(board.containsKey(String.valueOf(slova.charAt(6-i))+String.valueOf(brojevi.charAt(6-i)))) return true;
                    }
                }
                else if(indeks1<indeks3 && indeks2>indeks4){
                    for(int i=indeks1+1;i<indeks3;i++){
                        if(board.containsKey(String.valueOf(slova.charAt(6-i))+String.valueOf(brojevi.charAt(i)))) return true;
                    }
                }
            }
            else if(indeks1==indeks3 && (type.equals(Queen.class) || type.equals(Rook.class))){
                if(indeks2>indeks4){
                    for(int i=indeks4+1;i<indeks2;i++){
                        if(board.containsKey(String.valueOf(slova.charAt(indeks1))+String.valueOf(brojevi.charAt(i)))) return true;
                    }
                }
                else{
                    for(int i=indeks2+1;i<indeks4;i++){
                        if(board.containsKey(String.valueOf(slova.charAt(indeks1))+String.valueOf(brojevi.charAt(i)))) return true;
                    }
                }
            }
            else if(indeks2==indeks4 && (type.equals(Queen.class) || type.equals(Rook.class))){
                if(indeks1>indeks3){
                    for(int i=indeks3+1;i<indeks1;i++){
                       if(board.containsKey(String.valueOf(slova.charAt(i))+String.valueOf(brojevi.charAt(indeks2)))) return true;
                    }
                }
                else{
                    for(int i=indeks1+1;i<indeks3;i++){
                        if(board.containsKey(String.valueOf(slova.charAt(i))+String.valueOf(brojevi.charAt(indeks2)))) return true;
                    }
                }
            }
        return false;
    }
    public Board(){
        board = new TreeMap<>();
        board.put("a1",new Rook("a1", ChessPiece.Color.WHITE));
        board.put("a2",new Pawn("a2", ChessPiece.Color.WHITE));
        board.put("a7",new Pawn("a7", ChessPiece.Color.BLACK));
        board.put("a8",new Rook("a8", ChessPiece.Color.BLACK));
        board.put("b1",new Knight("b1", ChessPiece.Color.WHITE));
        board.put("b2",new Pawn("b2", ChessPiece.Color.WHITE));
        board.put("b7",new Pawn("b7", ChessPiece.Color.BLACK));
        board.put("b8",new Knight("b8", ChessPiece.Color.BLACK));
        board.put("c1",new Bishop("c1", ChessPiece.Color.WHITE));
        board.put("c2",new Pawn("c2", ChessPiece.Color.WHITE));
        board.put("c7",new Pawn("c7", ChessPiece.Color.BLACK));
        board.put("c8",new Bishop("c8", ChessPiece.Color.BLACK));
        board.put("d1",new Queen("d1", ChessPiece.Color.WHITE));
        board.put("d2",new Pawn("d2", ChessPiece.Color.WHITE));
        board.put("d7",new Pawn("d7", ChessPiece.Color.BLACK));
        board.put("d8",new Queen("d8", ChessPiece.Color.BLACK));
        board.put("e1",new King("e1", ChessPiece.Color.WHITE));
        board.put("e2",new Pawn("e2", ChessPiece.Color.WHITE));
        board.put("e7",new Pawn("e7", ChessPiece.Color.BLACK));
        board.put("e8",new King("e8", ChessPiece.Color.BLACK));
        board.put("f1",new Bishop("f1", ChessPiece.Color.WHITE));
        board.put("f2",new Pawn("f2", ChessPiece.Color.WHITE));
        board.put("f7",new Pawn("f7", ChessPiece.Color.BLACK));
        board.put("f8",new Bishop("f8", ChessPiece.Color.BLACK));
        board.put("g1",new Knight("g1", ChessPiece.Color.WHITE));
        board.put("g2",new Pawn("g2", ChessPiece.Color.WHITE));
        board.put("g7",new Pawn("g7", ChessPiece.Color.BLACK));
        board.put("g8",new Knight("g8", ChessPiece.Color.BLACK));
        board.put("h1",new Rook("h1", ChessPiece.Color.WHITE));
        board.put("h2",new Pawn("h2", ChessPiece.Color.WHITE));
        board.put("h7",new Pawn("h7", ChessPiece.Color.BLACK));
        board.put("h8",new Rook("h8", ChessPiece.Color.BLACK));

    }
    public void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException{
        //posto prima i velika i mala slova, pretvaramo sve u mala da je laksa manipulacija sa njima
        position=position.toLowerCase();
            if(type.equals(Knight.class)){
                for(Map.Entry<String,ChessPiece> entry : board.entrySet())
                    if (entry.getValue() instanceof Knight) {
                        if (entry.getValue().getColor() == color) {
                            String oldPosition = entry.getKey();
                            try {
                                board.get(oldPosition).move(position);
                            }
                            catch(IllegalChessMoveException e) {
                                //preskace sve naredne naredbe kako bi nasli figuru za koju je pomjeranje moguce
                                //ako nema niti jedne na samom kraju fje se baca izuzetak
                                continue;
                            }
                            if(board.containsKey(position)){
                                board.replace(position,entry.getValue());
                                board.remove(oldPosition);
                                return;
                            }
                            else{
                                board.put(position, entry.getValue());
                                board.remove(oldPosition);
                                return;
                            }
                        }
                    }
                    throw new IllegalChessMoveException("Nelegalan potez.");
                }
            else if(type.equals(King.class)){
            for(Map.Entry<String,ChessPiece> entry : board.entrySet())
                if (entry.getValue() instanceof King) {
                    if (entry.getValue().getColor() == color) {
                        String oldPosition = entry.getKey();
                        try {
                            board.get(oldPosition).move(position);
                        }
                        catch(IllegalChessMoveException e) {
                            continue;
                        }
                        if(board.containsKey(position)){
                            board.replace(position,entry.getValue());
                            board.remove(oldPosition);
                            return;
                        }
                        else{
                            board.put(position, entry.getValue());
                            board.remove(oldPosition);
                            return;
                        }
                    }
                }
                throw new IllegalChessMoveException("Nelegalan potez.");
            }
        else if(type.equals(Queen.class)){
            for(Map.Entry<String,ChessPiece> entry : board.entrySet())
                if (entry.getValue() instanceof Queen) {
                    if (entry.getValue().getColor() == color) {
                        String oldPosition = entry.getKey();
                        //provjeravamo da li ima figura izmedju pocetne i date pozicije
                        //jedan od parametara je tip klase, pa se u zavisnosti od toga u fji ispituju razliciti uslovi
                        if(Preskace(oldPosition, position, Queen.class)) throw new IllegalChessMoveException("Nelegalan potez.");
                        try {
                            board.get(oldPosition).move(position);
                        }
                        catch(IllegalChessMoveException e) {
                            continue;
                        }
                        if(board.containsKey(position)){
                            board.replace(position,entry.getValue());
                            board.remove(oldPosition);
                            return;
                        }
                        else{
                            board.put(position, entry.getValue());
                            board.remove(oldPosition);
                            return;
                        }
                    }
                }
                throw new IllegalChessMoveException("Nelegalan potez.");
            }
            else if(type.equals(Bishop.class)){
                for(Map.Entry<String,ChessPiece> entry : board.entrySet())
                    if (entry.getValue() instanceof Bishop) {
                        if (entry.getValue().getColor() == color) {
                            String oldPosition = entry.getKey();
                            if(Preskace(oldPosition, position, Bishop.class)) throw new IllegalChessMoveException("Nelegalan potez.");
                            try {
                                board.get(oldPosition).move(position);
                            }
                            catch(IllegalChessMoveException e) {
                                continue;
                            }
                            if(board.containsKey(position)){
                                board.replace(position,entry.getValue());
                                board.remove(oldPosition);
                                return;
                            }
                            else{
                                board.put(position, entry.getValue());
                                board.remove(oldPosition);
                                return;
                            }
                        }
                    }
                throw new IllegalChessMoveException("Nelegalan potez.");
            }

            else if(type.equals(Rook.class)){
                for(Map.Entry<String,ChessPiece> entry : board.entrySet())
                    if (entry.getValue() instanceof Rook) {
                        if (entry.getValue().getColor() == color) {
                            String oldPosition = entry.getKey();
                            if(Preskace(oldPosition, position, Rook.class)) throw new IllegalChessMoveException("Nelegalan potez.");
                            try {
                                board.get(oldPosition).move(position);
                            }
                            catch(IllegalChessMoveException e) {
                                continue;
                            }
                            if(board.containsKey(position)){
                                board.replace(position,entry.getValue());
                                board.remove(oldPosition);
                                return;
                            }
                            else{
                                board.put(position, entry.getValue());
                                board.remove(oldPosition);
                                return;
                            }
                        }
                    }
                throw new IllegalChessMoveException("Nelegalan potez.");
            }
            else if(type.equals(Pawn.class)){
                for(Map.Entry<String,ChessPiece> entry : board.entrySet())
                    if (entry.getValue() instanceof Pawn){
                        if (entry.getValue().getColor() == color) {
                            String oldPosition = entry.getKey();
                            //ako iden unaprijed ne smije biti druge figure na odredisnom mjestu
                            if(position.charAt(0)==oldPosition.charAt(0) && !board.containsKey(position)){
                                //ako ide dva mjesta unaprijed ne smije preskakati
                                if(oldPosition.charAt(1)=='2'){
                                    if(board.containsKey(String.valueOf(position.charAt(0))+"3"))
                                        throw new IllegalChessMoveException("Nelegalan potez.");
                                }
                                else if(oldPosition.charAt(1)=='7'){
                                    if(board.containsKey(String.valueOf(position.charAt(0))+"6"))
                                        throw new IllegalChessMoveException("Nelegalan potez.");
                                }
                                try {
                                    board.get(oldPosition).move(position);
                                }
                                catch(IllegalChessMoveException e) {
                                    continue;
                                }
                                board.put(position, entry.getValue());
                                board.remove(oldPosition);
                                return;
                            }
                            //moze gore lijevo/desno samo ako jede
                            else if(position.charAt(0)!=oldPosition.charAt(0) && board.containsKey(position)){
                                try {
                                    board.get(oldPosition).move(position);
                                }
                                catch(IllegalChessMoveException e) {
                                    continue;
                                }
                                board.replace(position,entry.getValue());
                                board.remove(oldPosition);
                                return;
                            }
                        }

                    }
                }
                throw new IllegalChessMoveException("Nelegalan potez.");
            }
    public void move(String oldPosition, String newPosition) throws IllegalChessMoveException{
        oldPosition=oldPosition.toLowerCase();
        newPosition=newPosition.toLowerCase();
            if(!board.containsKey(oldPosition)) throw new IllegalArgumentException("Nepostojeca figura.");
            move(board.get(oldPosition).getClass(),board.get(oldPosition).getColor(), newPosition);
    }
    boolean isCheck(ChessPiece.Color color) {
        String kingPosition=new String();
        for (Map.Entry<String, ChessPiece> entry : board.entrySet())
            if (entry.getValue() instanceof King) {
                if (entry.getValue().getColor() == color) {
                    kingPosition = entry.getKey();
                }
            }
        String figurePosition = new String();
        for (Map.Entry<String, ChessPiece> entry : board.entrySet())
            if (entry.getValue().getColor() != color) {
                figurePosition = entry.getKey();
                try {
                    //jedino pijun ne moze unatrag pa njega moramo posebno, a za ostale figure ako moze vracamo je na staro
                    if (entry.getValue() instanceof Pawn) {
                        int indeks1 = brojevi.indexOf(kingPosition.charAt(1));
                        int indeks2 = brojevi.indexOf(figurePosition.charAt(1));
                        int indeks3 = slova.indexOf(kingPosition.charAt(0));
                        int indeks4 = slova.indexOf(figurePosition.charAt(0));
                        if (entry.getValue().getColor() == ChessPiece.Color.WHITE) {
                            if (Math.abs(indeks3 - indeks4) == 1 && indeks1 - indeks2 == 1) return true;
                        } else if (entry.getValue().getColor() == ChessPiece.Color.BLACK) {
                            if (Math.abs(indeks3 - indeks4) == 1 && indeks2 - indeks1 == 1) return true;
                        }
                    } else {
                        if (Preskace(figurePosition, kingPosition, entry.getValue().getClass()))
                            throw new IllegalChessMoveException("Nelegalan potez.");
                        board.get(figurePosition).move(kingPosition);
                        board.get(figurePosition).move(figurePosition);
                        return true;
                    }
                } catch (IllegalChessMoveException e){

                }
            }
            return false;
    }
    }