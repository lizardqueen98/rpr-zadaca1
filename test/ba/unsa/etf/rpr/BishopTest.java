package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    @org.junit.jupiter.api.Test
    void moveDiagonal() {
        Bishop b = new Bishop("D5", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("G2")
        );
    }

    @org.junit.jupiter.api.Test
    void moveTwo() {
        Bishop b = new Bishop("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> b.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Bishop b = new Bishop("E3", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> b.move("E2")
        );
    }
    @org.junit.jupiter.api.Test
    void moveRandom(){
        Bishop b = new Bishop("D5", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                ()->b.move("h6")
        );
    }
}