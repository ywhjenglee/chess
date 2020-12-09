package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public class Bishop extends Piece {

    public Bishop(boolean pColor) {
        super("Bishop", pColor);
    }

    public void generatePossibleMoves(Tile[][] pChessBoard, Tile pTile){
        int x = pTile.getTileX();
        int y = pTile.getTileY();
        legalMoves[x][y] = true;
        boolean NE = false;
        boolean NW = false;
        boolean SE = false;
        boolean SW = false;
        for (int i = 1; i < 8; i++) {
            if (x+1 < 10 && y+1 < 10 && !NE) {
                if (pChessBoard[x+i][y+i].getPiece() == null) {
                    legalMoves[x+i][y+i] = true;
                } else {
                    if (pChessBoard[x+i][y+i].getPiece().getColor() != aColor) {
                        legalMoves[x+i][y+i] = true;
                    }
                    NE = true;
                }
            }
            if (x-1 > 1 && y+1 < 10 && !NW) {
                if (pChessBoard[x-i][y+i].getPiece() == null) {
                    legalMoves[x-i][y+i] = true;
                } else {
                    if (pChessBoard[x-i][y+i].getPiece().getColor() != aColor) {
                        legalMoves[x-i][y+i] = true;
                    }
                    NW = true;
                }
            }
            if (x+1 < 10 && y-1 > 1 && !SE) {
                if (pChessBoard[x+i][y-i].getPiece() == null) {
                    legalMoves[x+i][y-i] = true;
                } else {
                    if (pChessBoard[x+i][y-i].getPiece().getColor() != aColor) {
                        legalMoves[x+i][y-i] = true;
                    }
                    SE = true;
                }
            }
            if (x-1 > 1 && y-1 > 1 && !SW) {
                if (pChessBoard[x-i][y-i].getPiece() == null) {
                    legalMoves[x-i][y-i] = true;
                } else {
                    if (pChessBoard[x-i][y-i].getPiece().getColor() != aColor) {
                        legalMoves[x-i][y-i] = true;
                    }
                    SW = true;
                }
            }
        }
    }
}
