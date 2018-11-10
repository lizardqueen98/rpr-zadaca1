package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void move() {
        Knight k = new Knight("B1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("C3")
        );

    }
    @Test
    void moveNedozvoljeno() {
        Knight k = new Knight("d4", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> k.move("f4")
        );
    }
    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Knight("K2", ChessPiece.Color.WHITE)
        );
    }
    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Knight("H10", ChessPiece.Color.WHITE)
        );
    }
    @org.junit.jupiter.api.Test
    void constructor3() {
        assertDoesNotThrow(
                () -> new Knight("G4", ChessPiece.Color.WHITE)
        );
    }
}