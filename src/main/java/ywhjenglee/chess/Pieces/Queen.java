package ywhjenglee.chess.Pieces;

public class Queen extends Piece {
    
    public Queen(boolean pColor, int pX, int pY) {
        super(pColor, pX, pY);
    }

    public String getName() {
        if (aColor) {
            return "♕";
        } else {
            return "♛";
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
