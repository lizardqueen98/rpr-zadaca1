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
          System.out.println("Black move: ");
          blackMove = ulaz.nextLine();
      }while(!whiteMove.equals("X") || !blackMove.equals("X"));

    }
}
