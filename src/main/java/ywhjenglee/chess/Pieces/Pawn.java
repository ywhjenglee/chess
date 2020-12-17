package ywhjenglee.chess.Pieces;

public class Pawn extends Piece {

    private boolean enPassant;
    
    public Pawn(boolean pColor, int pX, int pY) {
        super(pColor, pX, pY);
        enPassant = false;
    }

    public void setEnPassant(boolean pValue) {
        enPassant = pValue;
    }

    public boolean getEnPassant() {
        return enPassant;
    }

    public String getName() {
        if (aColor) {
            return "♙";
        } else {
            return "♟";
        }
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        if (aColor) {
            if (pChessBoard[x][y+1] == null) {
                aLegalMoves[x][y+1] = 1;
                if (pChessBoard[x][y+2] == null && !hasMoved) {
                    aLegalMoves[x][y+2] = 3;
                }
            }
            if (pChessBoard[x+1][y+1] != null && !pChessBoard[x+1][y+1].getColor()) {
                aLegalMoves[x+1][y+1] = 2;
            }
            if (pChessBoard[x-1][y+1] != null && !pChessBoard[x-1][y+1].getColor()) {
                aLegalMoves[x-1][y+1] = 2;
            }
            if (pChessBoard[x+1][y] != null && !pChessBoard[x+1][y].getColor() &&
            pChessBoard[x+1][y].getClass() == Pawn.class) {
                Pawn pawn = (Pawn) pChessBoard[x+1][y];
                if (pawn.getEnPassant()) {
                    aLegalMoves[x+1][y+1] = 4;
                }
            }
            if (pChessBoard[x-1][y] != null && !pChessBoard[x-1][y].getColor() &&
            pChessBoard[x-1][y].getClass() == Pawn.class) {
                Pawn pawn = (Pawn) pChessBoard[x-1][y];
                if (pawn.getEnPassant()) {
                    aLegalMoves[x-1][y+1] = 4;
                }
            }
        } else {
            if (pChessBoard[x][y-1] == null) {
                aLegalMoves[x][y-1] = 1;
                if (pChessBoard[x][y-2] == null && !hasMoved) {
                    aLegalMoves[x][y-2] = 3;
                }
            }
            if (pChessBoard[x+1][y-1] != null && pChessBoard[x+1][y-1].getColor() != aColor) {
                aLegalMoves[x+1][y-1] = 2;
            }
            if (pChessBoard[x-1][y-1] != null && pChessBoard[x-1][y-1].getColor() != aColor) {
                aLegalMoves[x-1][y-1] = 2;
            }
            if (pChessBoard[x+1][y] != null && pChessBoard[x+1][y].getColor() &&
            pChessBoard[x+1][y].getClass() == Pawn.class) {
                Pawn pawn = (Pawn) pChessBoard[x+1][y];
                if (pawn.getEnPassant()) {
                    aLegalMoves[x+1][y-1] = 4;
                }
            }
            if (pChessBoard[x-1][y] != null && pChessBoard[x-1][y].getColor() &&
            pChessBoard[x-1][y].getClass() == Pawn.class) {
                Pawn pawn = (Pawn) pChessBoard[x-1][y];
                if (pawn.getEnPassant()) {
                    aLegalMoves[x-1][y-1] = 4;
                }
            }
        }
        removeKingInCheck(pChessBoard);
        aLegalMoves[x][y] = 7;
    }
}
