package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public class Pawn extends Piece {
    
    public Pawn(boolean pColor, int pX, int pY) {
        super("Pawn", pColor, pX, pY);
    }

    public void generatePossibleMoves(Tile[][] pChessBoard) {
        legalMoves[x][y] = true;
        if (aColor) {
            if (pChessBoard[x][y+1].getPiece() == null) {
                legalMoves[x][y+1] = true;
                if (pChessBoard[x][y+2].getPiece() == null && !hasMoved) {
                    legalMoves[x][y+2] = true;
                }
            }
            if (pChessBoard[x+1][y+1].getPiece() != null && pChessBoard[x+1][y+1].getPiece().getColor() != aColor) {
                legalMoves[x+1][y+1] = true;
            }
            if (pChessBoard[x-1][y+1].getPiece() != null && pChessBoard[x-1][y+1].getPiece().getColor() != aColor) {
                legalMoves[x-1][y+1] = true;
            }
        } else {
            if (pChessBoard[x][y-1].getPiece() == null) {
                legalMoves[x][y-1] = true;
                if (pChessBoard[x][y-2].getPiece() == null && !hasMoved) {
                    legalMoves[x][y-2] = true;
                }
            }
            if (pChessBoard[x+1][y-1].getPiece() != null && pChessBoard[x+1][y+1].getPiece().getColor() != aColor) {
                legalMoves[x+1][y-1] = true;
            }
            if (pChessBoard[x-1][y-1].getPiece() != null && pChessBoard[x-1][y+1].getPiece().getColor() != aColor) {
                legalMoves[x-1][y-1] = true;
            }
        }
    }
}
