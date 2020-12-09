package ywhjenglee.chess.Pieces;

public class Pawn extends Piece {

    private boolean enPassant;
    
    public Pawn(boolean pColor) {
        super("Pawn", pColor);
        enPassant = false;
    }
}
