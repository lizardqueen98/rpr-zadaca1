package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) {
         Board b = new Board();
         try {
             /*b.move(Knight.class, ChessPiece.Color.WHITE, "C3");
             System.out.println(b.board.get("c3").getPosition());
             if(b.board.containsKey("c3")) System.out.println("ima");
             if(b.board.containsKey("b1")) System.out.println("nema");*/
             b.move(Knight.class, ChessPiece.Color.BLACK, "a2");
         }
         catch(IllegalChessMoveException e){
             System.out.println(e.getMessage());
         }
    }
}
