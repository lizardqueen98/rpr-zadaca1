package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    @org.junit.jupiter.api.Test
    void moveDiagonal() {
        Queen q = new Queen("D5", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> q.move("E6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveTwo() {
        Queen q = new Queen("C2", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> q.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Queen q = new Queen("F4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> q.move("F3")
        );
    }
    @org.junit.jupiter.api.Test
    void constructorTest(){
        assertThrows(IllegalArgumentException.class,()->new Queen("D10",ChessPiece.Color.BLACK));
    }
    @org.junit.jupiter.api.Test
    void moveRandom(){
        Queen q = new Queen("d4", ChessPiece.Color.WHITE);
        assertThrows(IllegalChessMoveException.class,
                ()->q.move("h6")
        );
    }
    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("K2", ChessPiece.Color.WHITE)
        );
    }
    @org.junit.jupiter.api.Test
    void constructor3() {
        assertDoesNotThrow(
                () -> new Queen("G4", ChessPiece.Color.WHITE)
        );
    }
}
