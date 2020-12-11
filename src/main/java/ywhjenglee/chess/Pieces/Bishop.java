package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public class Bishop extends Piece {

    public Bishop(boolean pColor, int pX, int pY) {
        super("Bishop", pColor, pX, pY);
    }

    public void generatePossibleMoves(Tile[][] pChessBoard) {
        legalMoves = new boolean[12][12];
        boolean NE = false;
        boolean NW = false;
        boolean SE = false;
        boolean SW = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && y+i < 10 && !NE) {
                if (pChessBoard[x+i][y+i].getPiece() == null) {
                    legalMoves[x+i][y+i] = true;
                } else {
                    if (pChessBoard[x+i][y+i].getPiece().getColor() != aColor) {
                        legalMoves[x+i][y+i] = true;
                    }
                    NE = true;
                }
            }
            if (x-i > 1 && y+i < 10 && !NW) {
                if (pChessBoard[x-i][y+i].getPiece() == null) {
                    legalMoves[x-i][y+i] = true;
                } else {
                    if (pChessBoard[x-i][y+i].getPiece().getColor() != aColor) {
                        legalMoves[x-i][y+i] = true;
                    }
                    NW = true;
                }
            }
            if (x+i < 10 && y-i > 1 && !SE) {
                if (pChessBoard[x+i][y-i].getPiece() == null) {
                    legalMoves[x+i][y-i] = true;
                } else {
                    if (pChessBoard[x+i][y-i].getPiece().getColor() != aColor) {
                        legalMoves[x+i][y-i] = true;
                    }
                    SE = true;
                }
            }
            if (x-i > 1 && y-i > 1 && !SW) {
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
        legalMoves[x][y] = true;
    }
}
