package ba.unsa.etf.rpr;

public class Main {
     public static void main(String[] args) {
         King k = new King("E1", ChessPiece.Color.WHITE);
         try {
             k.move("D2");
         }
         catch(Exception e){

         }
    }
}
