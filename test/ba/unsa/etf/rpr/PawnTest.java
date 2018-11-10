package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @org.junit.jupiter.api.Test
    void move1() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("E4")
        );
    }
    @org.junit.jupiter.api.Test
    void moveDiagonal() {
        Pawn p = new Pawn("D5", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> p.move("F3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveTwo() {
        Pawn p = new Pawn("C7", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> p.move("C5")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Pawn p = new Pawn("F4", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> p.move("F3")
        );
    }
    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("K2", ChessPiece.Color.WHITE)
        );
    }
    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("H10", ChessPiece.Color.WHITE)
        );
    }
    @org.junit.jupiter.api.Test
    void constructor3() {
        assertDoesNotThrow(
                () -> new Pawn("G4", ChessPiece.Color.WHITE)
        );
    }

}