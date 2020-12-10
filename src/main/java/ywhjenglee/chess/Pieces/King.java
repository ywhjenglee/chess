package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public class King extends Piece {
    
    public King(boolean pColor, int pX, int pY) {
        super("King", pColor, pX, pY);
    }

    public void generatePossibleMoves(Tile[][] pChessBoard) {
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
