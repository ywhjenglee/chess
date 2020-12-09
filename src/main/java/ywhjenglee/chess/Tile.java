package ywhjenglee.chess;

import ywhjenglee.chess.Pieces.Piece;

public class Tile {
    
    private final int x, y;
    private Piece aPiece;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
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

