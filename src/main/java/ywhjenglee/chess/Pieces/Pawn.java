package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public class Pawn extends Piece {

    private boolean enPassant;
    
    public Pawn(boolean pColor) {
        super("Pawn", pColor);
        enPassant = false;
    }

    public void generatePossibleMoves(Tile[][] pChessBoard, Tile pTile){
        
    }
}
