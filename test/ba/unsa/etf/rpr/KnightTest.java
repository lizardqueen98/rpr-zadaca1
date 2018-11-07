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
}