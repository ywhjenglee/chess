package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public class Knight extends Piece {

    public Knight(boolean pColor) {
        super("Knight", pColor);
    }

    public void generatePossibleMoves(Tile[][] pChessBoard, Tile pTile) {
        int x = pTile.getTileX();
        int y = pTile.getTileY();
        legalMoves[x+1][y+2] = true;
        legalMoves[x-1][y+2] = true;
        legalMoves[x+1][y-2] = true;
        legalMoves[x-1][y-2] = true;
        legalMoves[x+2][y+1] = true;
        legalMoves[x-2][y+1] = true;
        legalMoves[x+2][y-1] = true;
        legalMoves[x-2][y-1] = true;
        removeOutOfBounds();
    }
}
