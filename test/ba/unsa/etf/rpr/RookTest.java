package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    @org.junit.jupiter.api.Test
    void moveDiagonal() {
        Rook r = new Rook("D5", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                () -> r.move("E6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveTwo() {
        Rook r = new Rook("C2", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> r.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Rook r = new Rook("F4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("F3")
        );
    }
    @org.junit.jupiter.api.Test
    void constructorTest(){
        assertThrows(IllegalArgumentException.class,()->new Rook("D10",ChessPiece.Color.BLACK));
    }

}