package ywhjenglee.chess.Pieces;

public class Queen extends Piece {
    
    public Queen(boolean pColor, int pX, int pY) {
        super("Queen", pColor, pX, pY);
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        boolean E = false;
        boolean W = false;
        boolean N = false;
        boolean S = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && !E) {
                if (paddedChessBoard[x+i][y] == null) {
                    paddedLegalMoves[x+i][y] = true;
                } else {
                    if (paddedChessBoard[x+i][y].getColor() != aColor) {
                        paddedLegalMoves[x+i][y] = true;
                    }
                    E = true;
                }
            }
            if (x-i > 1 && !W) {
                if (paddedChessBoard[x-i][y] == null) {
                    paddedLegalMoves[x-i][y] = true;
                } else {
                    if (paddedChessBoard[x-i][y].getColor() != aColor) {
                        paddedLegalMoves[x-i][y] = true;
                    }
                    W = true;
                }
            }
            if (y+i < 10 && !N) {
                if (paddedChessBoard[x][y+i] == null) {
                    paddedLegalMoves[x][y+i] = true;
                } else {
                    if (paddedChessBoard[x][y+i].getColor() != aColor) {
                        paddedLegalMoves[x][y+i] = true;
                    }
                    N = true;
                }
            }
            if (y-i > 1 && !S) {
                if (paddedChessBoard[x][y-i] == null) {
                    paddedLegalMoves[x][y-i] = true;
                } else {
                    if (paddedChessBoard[x][y-i].getColor() != aColor) {
                        paddedLegalMoves[x][y-i] = true;
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
                if (paddedChessBoard[x+i][y+i] == null) {
                    paddedLegalMoves[x+i][y+i] = true;
                } else {
                    if (paddedChessBoard[x+i][y+i].getColor() != aColor) {
                        paddedLegalMoves[x+i][y+i] = true;
                    }
                    NE = true;
                }
            }
            if (x-i > 1 && y+i < 10 && !NW) {
                if (paddedChessBoard[x-i][y+i] == null) {
                    paddedLegalMoves[x-i][y+i] = true;
                } else {
                    if (paddedChessBoard[x-i][y+i].getColor() != aColor) {
                        paddedLegalMoves[x-i][y+i] = true;
                    }
                    NW = true;
                }
            }
            if (x+i < 10 && y-i > 1 && !SE) {
                if (paddedChessBoard[x+i][y-i] == null) {
                    paddedLegalMoves[x+i][y-i] = true;
                } else {
                    if (paddedChessBoard[x+i][y-i].getColor() != aColor) {
                        paddedLegalMoves[x+i][y-i] = true;
                    }
                    SE = true;
                }
            }
            if (x-i > 1 && y-i > 1 && !SW) {
                if (paddedChessBoard[x-i][y-i] == null) {
                    paddedLegalMoves[x-i][y-i] = true;
                } else {
                    if (paddedChessBoard[x-i][y-i].getColor() != aColor) {
                        paddedLegalMoves[x-i][y-i] = true;
                    }
                    SW = true;
                }
            }
        }
        removeKingWillBeInCheck(paddedChessBoard);
        paddedLegalMoves[x][y] = true;
    }
}
