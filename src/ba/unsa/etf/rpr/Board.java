package ba.unsa.etf.rpr;

import java.util.Map;
import java.util.TreeMap;

public class Board {
    public Map<String,ChessPiece> board;
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
            if(type.getName().equals("ba.unsa.etf.rpr.Knight")){
                for(Map.Entry<String,ChessPiece> entry : board.entrySet())
                    if (entry.getValue() instanceof Knight) {
                        if (entry.getValue().getColor() == color) {
                            String oldPosition = entry.getKey();
                            try {
                                if(board.containsKey(position)){
                                    board.get(oldPosition).move(position);
                                    board.replace(position,entry.getValue());
                                    board.remove(oldPosition);
                                }
                                else{
                                    board.get(oldPosition).move(position);
                                    board.put(position, entry.getValue());
                                    board.remove(oldPosition);
                                }
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        break;
                    }
            }
            else if(type.getName().equals("ba.unsa.etf.rpr.King")){
            for(Map.Entry<String,ChessPiece> entry : board.entrySet())
                if (entry.getValue() instanceof King) {
                    if (entry.getValue().getColor() == color) {
                        String oldPosition = entry.getKey();
                        try {
                            if(board.containsKey(position)){
                                board.get(oldPosition).move(position);
                                board.replace(position,entry.getValue());
                                board.remove(oldPosition);
                            }
                            else{
                                board.get(oldPosition).move(position);
                                board.put(position, entry.getValue());
                                board.remove(oldPosition);
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    break;
                }
        }
        else if(type.getName().equals("ba.unsa.etf.rpr.Queen")){
            for(Map.Entry<String,ChessPiece> entry : board.entrySet())
                if (entry.getValue() instanceof Queen) {
                    if (entry.getValue().getColor() == color) {
                        String oldPosition = entry.getKey();
                        try {
                            if(board.containsKey(position)){
                                board.get(oldPosition).move(position);
                                board.replace(position,entry.getValue());
                                board.remove(oldPosition);
                            }
                            else{
                                board.get(oldPosition).move(position);
                                board.put(position, entry.getValue());
                                board.remove(oldPosition);
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    break;
                }
        }
    }
    public void move(String oldPosition, String newPosition){

    }
    boolean isCheck(ChessPiece.Color color){
        return true;
    }
}
