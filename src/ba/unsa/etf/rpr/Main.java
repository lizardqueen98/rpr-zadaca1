package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) {
         Board b = new Board();
         try {
                 b.move(Pawn.class, ChessPiece.Color.WHITE, "E4");
                 b.move(Pawn.class, ChessPiece.Color.WHITE, "E5");
                 b.move(Pawn.class, ChessPiece.Color.WHITE, "E6");
                 b.move(Pawn.class, ChessPiece.Color.WHITE, "D7");
                 b.move(Pawn.class, ChessPiece.Color.WHITE, "C8");
                 b.move(Queen.class, ChessPiece.Color.WHITE, "E2");
         } catch(Exception e) {
             System.out.println(e.getMessage());
         }
         if(b.isCheck(ChessPiece.Color.BLACK))System.out.println("sah");
    }
}
