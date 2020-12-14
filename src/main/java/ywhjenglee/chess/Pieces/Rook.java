package ywhjenglee.chess.Pieces;

public class Rook extends Piece {

    private boolean aSide;
    /*
    true = queenSide/left
    false = kingSide/right
    */
    
    public Rook(boolean pColor, int pX, int pY, boolean pSide) {
        super(pColor, pX, pY);
        aSide = pSide;
    }

    public boolean getSide() {
        return aSide;
    }

    public String getName() {
        if (aColor) {
            return "♖";
        } else {
            return "♜";
        }
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        boolean E = false;
        boolean W = false;
        boolean N = false;
        boolean S = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && !E) {
                if (pChessBoard[x+i][y] == null) {
                    aLegalMoves[x+i][y] = 1;
                } else {
                    if (pChessBoard[x+i][y].getColor() != aColor) {
                        aLegalMoves[x+i][y] = 2;
                    }
                    E = true;
                }
            }
            if (x-i > 1 && !W) {
                if (pChessBoard[x-i][y] == null) {
                    aLegalMoves[x-i][y] = 1;
                } else {
                    if (pChessBoard[x-i][y].getColor() != aColor) {
                        aLegalMoves[x-i][y] = 2;
                    }
                    W = true;
                }
            }
            if (y+i < 10 && !N) {
                if (pChessBoard[x][y+i] == null) {
                    aLegalMoves[x][y+i] = 1;
                } else {
                    if (pChessBoard[x][y+i].getColor() != aColor) {
                        aLegalMoves[x][y+i] = 2;
                    }
                    N = true;
                }
            }
            if (y-i > 1 && !S) {
                if (pChessBoard[x][y-i] == null) {
                    aLegalMoves[x][y-i] = 1;
                } else {
                    if (pChessBoard[x][y-i].getColor() != aColor) {
                        aLegalMoves[x][y-i] = 2;
                    }
                    S = true;
                }
            }
        }
        removeKingInCheck(pChessBoard);
        aLegalMoves[x][y] = 1;
    }
}
