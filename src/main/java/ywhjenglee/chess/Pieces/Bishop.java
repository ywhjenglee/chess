package ywhjenglee.chess.Pieces;

public class Bishop extends Piece {

    public Bishop(boolean pColor, int pX, int pY) {
        super(pColor, pX, pY);
    }

    public String getName() {
        if (aColor) {
            return "♗";
        } else {
            return "♝";
        }
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        boolean NE = false;
        boolean NW = false;
        boolean SE = false;
        boolean SW = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && y+i < 10 && !NE) {
                if (pChessBoard[x+i][y+i] == null) {
                    aLegalMoves[x+i][y+i] = 1;
                } else {
                    if (pChessBoard[x+i][y+i].getColor() != aColor) {
                        aLegalMoves[x+i][y+i] = 2;
                    }
                    NE = true;
                }
            }
            if (x-i > 1 && y+i < 10 && !NW) {
                if (pChessBoard[x-i][y+i] == null) {
                    aLegalMoves[x-i][y+i] = 1;
                } else {
                    if (pChessBoard[x-i][y+i].getColor() != aColor) {
                        aLegalMoves[x-i][y+i] = 2;
                    }
                    NW = true;
                }
            }
            if (x+i < 10 && y-i > 1 && !SE) {
                if (pChessBoard[x+i][y-i] == null) {
                    aLegalMoves[x+i][y-i] = 1;
                } else {
                    if (pChessBoard[x+i][y-i].getColor() != aColor) {
                        aLegalMoves[x+i][y-i] = 2;
                    }
                    SE = true;
                }
            }
            if (x-i > 1 && y-i > 1 && !SW) {
                if (pChessBoard[x-i][y-i] == null) {
                    aLegalMoves[x-i][y-i] = 1;
                } else {
                    if (pChessBoard[x-i][y-i].getColor() != aColor) {
                        aLegalMoves[x-i][y-i] = 2;
                    }
                    SW = true;
                }
            }
        }
        removeKingInCheck(pChessBoard);
        aLegalMoves[x][y] = 7;
    }
}
