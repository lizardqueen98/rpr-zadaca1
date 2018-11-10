package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Program {
     public static void main(String[] args) {
      Board b = new Board();
      Scanner ulaz = new Scanner(System.in);
      String whiteMove=null;
      String blackMove=null;
      boolean whiteMoved = false;
      do {
          if(!whiteMoved) {
              System.out.println("White move: ");
              whiteMove = ulaz.nextLine();
              if (whiteMove.equals("X")) break;
              try {
                  if (whiteMove.length() == 2) {
                      b.move(Pawn.class, ChessPiece.Color.WHITE, whiteMove);
                  } else if (whiteMove.length() == 3) {
                      switch (whiteMove.charAt(0)) {
                          case 'K':
                              b.move(King.class, ChessPiece.Color.WHITE, whiteMove.substring(1));
                              break;
                          case 'Q':
                              b.move(Queen.class, ChessPiece.Color.WHITE, whiteMove.substring(1));
                              break;
                          case 'R':
                              b.move(Rook.class, ChessPiece.Color.WHITE, whiteMove.substring(1));
                              break;
                          case 'B':
                              b.move(Bishop.class, ChessPiece.Color.WHITE, whiteMove.substring(1));
                              break;
                          case 'N':
                              b.move(Knight.class, ChessPiece.Color.WHITE, whiteMove.substring(1));
                              break;
                          default: throw new IllegalChessMoveException("Nelegalna pozicija");

                      }
                  }
                  else throw new IllegalChessMoveException("Nelegalna pozicija");
                  if (b.isCheck(ChessPiece.Color.WHITE)) System.out.println("Check!!!");
              } catch (Exception e) {
                  System.out.println("Illegal move.\nUnesite ponovo.");
                  continue;
              }
          }
          else whiteMoved=false;
          System.out.println("Black move: ");
          blackMove = ulaz.nextLine();
          if(blackMove.equals("X")) break;
          try {
              if (blackMove.length() == 2) {
                  b.move(Pawn.class, ChessPiece.Color.BLACK, blackMove);
              } else if (blackMove.length() == 3) {
                  switch (blackMove.charAt(0)) {
                      case 'K':
                          b.move(King.class, ChessPiece.Color.BLACK, blackMove.substring(1));
                          break;
                      case 'Q':
                          b.move(Queen.class, ChessPiece.Color.BLACK, blackMove.substring(1));
                          break;
                      case 'R':
                          b.move(Rook.class, ChessPiece.Color.BLACK, blackMove.substring(1));
                          break;
                      case 'B':
                          b.move(Bishop.class, ChessPiece.Color.BLACK, blackMove.substring(1));
                          break;
                      case 'N':
                          b.move(Knight.class, ChessPiece.Color.BLACK, blackMove.substring(1));
                          break;
                      default: throw new IllegalChessMoveException("Nelegalna pozicija");

                  }
              }
              else throw new IllegalChessMoveException("Nelegalna pozicija");
              if(b.isCheck(ChessPiece.Color.BLACK)) System.out.println("Check!!!");
          }
          catch(Exception e){
              System.out.println("Illegal move.\nUnesite ponovo.");
              whiteMoved=true;
          }

      }while(true);

    }
}
