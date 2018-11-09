package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Program {
     public static void main(String[] args) {
      Board b = new Board();
      Scanner ulaz = new Scanner(System.in);
      String whiteMove;
      String blackMove;
      do {
          System.out.println("White move: ");
          whiteMove = ulaz.nextLine();
          if(whiteMove.equals("X")) break;
          System.out.println("Black move: ");
          blackMove = ulaz.nextLine();
          if(blackMove.equals("X")) break;
          try {
              if (whiteMove.length() == 2) {
                  b.move(Pawn.class, ChessPiece.Color.WHITE, whiteMove);
              } else if (whiteMove.length() == 3) {
                  switch (whiteMove.charAt(0)) {
                      case 'K':
                          b.move(King.class, ChessPiece.Color.WHITE, whiteMove);
                          break;
                      case 'Q':
                          b.move(Queen.class, ChessPiece.Color.WHITE, whiteMove);
                          break;
                      case 'R':
                          b.move(Rook.class, ChessPiece.Color.WHITE, whiteMove);
                          break;
                      case 'B':
                          b.move(Bishop.class, ChessPiece.Color.WHITE, whiteMove);
                          break;
                      case 'N':
                          b.move(Knight.class, ChessPiece.Color.WHITE, whiteMove);
                          break;

                  }
              }
          }
          catch(Exception e){
              System.out.println("Illegal move.\nUnesite ponovo.");
              continue;
          }
          try {
              if (blackMove.length() == 2) {
                  b.move(Pawn.class, ChessPiece.Color.BLACK, blackMove);
              } else if (blackMove.length() == 3) {
                  switch (blackMove.charAt(0)) {
                      case 'K':
                          b.move(King.class, ChessPiece.Color.BLACK, blackMove);
                          break;
                      case 'Q':
                          b.move(Queen.class, ChessPiece.Color.BLACK, blackMove);
                          break;
                      case 'R':
                          b.move(Rook.class, ChessPiece.Color.BLACK, blackMove);
                          break;
                      case 'B':
                          b.move(Bishop.class, ChessPiece.Color.BLACK, blackMove);
                          break;
                      case 'N':
                          b.move(Knight.class, ChessPiece.Color.BLACK, blackMove);
                          break;

                  }
              }
          }
          catch(Exception e){
              System.out.println("Illegal move.\nUnesite ponovo.");
          }

      }while(true);

    }
}
