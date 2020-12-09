package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public class King extends Piece {
    
    public King(boolean pColor) {
        super("King", pColor);
    }

    public void generatePossibleMoves(Tile[][] pChessBoard, Tile pTile){
        int x = pTile.getTileX();
        int y = pTile.getTileY();
        legalMoves[x][y] = true;
        legalMoves[x+1][y] = true;
        legalMoves[x-1][y] = true;
        legalMoves[x][y+1] = true;
        legalMoves[x][y-1] = true;
        legalMoves[x+1][y+1] = true;
        legalMoves[x-1][y+1] = true;
        legalMoves[x+1][y-1] = true;
        legalMoves[x-1][y-1] = true;
        removeOutOfBounds();
        removeAllyOccupied(pChessBoard);
    }
}
