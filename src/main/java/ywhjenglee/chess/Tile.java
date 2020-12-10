package ywhjenglee.chess;

import ywhjenglee.chess.Pieces.Piece;

public class Tile {
    
    private final int x, y;
    private Piece aPiece;

    public Tile(int pX, int pY) {
        x = pX;
        y = pY;
    }

    public void setPiece(Piece pPiece) {
        aPiece = pPiece;
    }

    public void removePiece() {
        aPiece = null;
    }

    public Piece getPiece() {
        return aPiece;
    }

    public int getTileX() {
        return x;
    }

    public int getTileY() {
        return y;
    }
}

