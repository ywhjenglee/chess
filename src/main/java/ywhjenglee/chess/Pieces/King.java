package ywhjenglee.chess.Pieces;

public class King extends Piece {
    
    public King(boolean pColor, int x, int y) {
        super("King", pColor, x, y);
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        aLegalMoves[x+1][y] = true;
        aLegalMoves[x-1][y] = true;
        aLegalMoves[x][y+1] = true;
        aLegalMoves[x][y-1] = true;
        aLegalMoves[x+1][y+1] = true;
        aLegalMoves[x-1][y+1] = true;
        aLegalMoves[x+1][y-1] = true;
        aLegalMoves[x-1][y-1] = true;
        removeAllyOccupied(pChessBoard);
        removeKingInCheck(pChessBoard);
        aLegalMoves[x][y] = true;
    }

    public boolean isInCheck(Piece[][] pChessBoard) {
        // Check Pawn and King
        if (pChessBoard[x+1][y+1] != null && pChessBoard[x+1][y+1].getColor() != aColor) {
            if (pChessBoard[x+1][y+1].getClass() == King.class || pChessBoard[x+1][y+1].getClass() == Pawn.class) {
                return true;
            }
        }
        if (pChessBoard[x][y+1] != null && pChessBoard[x][y+1].getColor() != aColor) {
            if (pChessBoard[x][y+1].getClass() == King.class) {
                return true;
            }
        }
        if (pChessBoard[x-1][y+1] != null && pChessBoard[x-1][y+1].getColor() != aColor) {
            if (pChessBoard[x-1][y+1].getClass() == King.class || pChessBoard[x-1][y+1].getClass() == Pawn.class) {
                return true;
            }
        }
        if (pChessBoard[x+1][y] != null && pChessBoard[x+1][y].getColor() != aColor) {
            if (pChessBoard[x+1][y].getClass() == King.class) {
                return true;
            }
        }
        if (pChessBoard[x-1][y] != null && pChessBoard[x-1][y].getColor() != aColor) {
            if (pChessBoard[x-1][y].getClass() == King.class) {
                return true;
            }
        }
        if (pChessBoard[x+1][y-1] != null && pChessBoard[x+1][y-1].getColor() != aColor) {
            if (pChessBoard[x+1][y-1].getClass() == King.class || pChessBoard[x+1][y-1].getClass() == Pawn.class) {
                return true;
            }
        }
        if (pChessBoard[x][y-1] != null && pChessBoard[x][y-1].getColor() != aColor) {
            if (pChessBoard[x][y-1].getClass() == King.class) {
                return true;
            }
        }
        if (pChessBoard[x-1][y-1] != null && pChessBoard[x-1][y-1].getColor() != aColor) {
            if (pChessBoard[x-1][y-1].getClass() == King.class || pChessBoard[x-1][y-1].getClass() == Pawn.class) {
                return true;
            }
        }
        // Check Knight
        if (pChessBoard[x+1][y+2] != null && pChessBoard[x+1][y+2].getColor() != aColor) {
            if (pChessBoard[x+1][y+2].getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[x-1][y+2] != null && pChessBoard[x-1][y+2].getColor() != aColor) {
            if (pChessBoard[x-1][y+2].getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[x+1][y-2] != null && pChessBoard[x+1][y-2].getColor() != aColor) {
            if (pChessBoard[x+1][y-2].getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[x-1][y-2] != null && pChessBoard[x-1][y-2].getColor() != aColor) {
            if (pChessBoard[x-1][y-2].getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[x+2][y+1] != null && pChessBoard[x+2][y+1].getColor() != aColor) {
            if (pChessBoard[x+2][y+1].getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[x-2][y+1] != null && pChessBoard[x-2][y+1].getColor() != aColor) {
            if (pChessBoard[x-2][y+1].getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[x+2][y-1] != null && pChessBoard[x+2][y-1].getColor() != aColor) {
            if (pChessBoard[x+2][y-1].getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[x-2][y-1] != null && pChessBoard[x-2][y-1].getColor() != aColor) {
            if (pChessBoard[x-2][y-1].getClass() == Knight.class) {
                return true;
            }
        }
        // Check Bishop and Queen
        boolean NE = false;
        boolean NW = false;
        boolean SE = false;
        boolean SW = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && y+i < 10 && !NE) {
                if (pChessBoard[x+i][y+i] != null) {
                    if (pChessBoard[x+i][y+i].getColor() != aColor &&
                    (pChessBoard[x+i][y+i].getClass() == Bishop.class || pChessBoard[x+i][y+i].getClass() == Queen.class)) {
                        return true;
                    }
                    NE = true;
                }
            }
            if (x-i > 1 && y+i < 10 && !NW) {
                if (pChessBoard[x-i][y+i] != null) {
                    if (pChessBoard[x-i][y+i].getColor() != aColor &&
                    (pChessBoard[x-i][y+i].getClass() == Bishop.class || pChessBoard[x-i][y+i].getClass() == Queen.class)) {
                        return true;
                    }
                    NW = true;
                }
            }
            if (x+i < 10 && y-i > 1 && !SE) {
                if (pChessBoard[x+i][y-i] != null) {
                    if (pChessBoard[x+i][y-i].getColor() != aColor &&
                    (pChessBoard[x+i][y-i].getClass() == Bishop.class || pChessBoard[x+i][y-i].getClass() == Queen.class)) {
                        return true;
                    }
                    SE = true;
                }
            }
            if (x-i > 1 && y-i > 1 && !SW) {
                if (pChessBoard[x-i][y-i] != null) {
                    if (pChessBoard[x-i][y-i].getColor() != aColor &&
                    (pChessBoard[x-i][y-i].getClass() == Bishop.class || pChessBoard[x-i][y-i].getClass() == Queen.class)) {
                        return true;
                    }
                    SW = true;
                }
            }
        }
        // Check Rook and Queen
        boolean E = false;
        boolean W = false;
        boolean N = false;
        boolean S = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && !E) {
                if (pChessBoard[x+i][y] != null) {
                    if (pChessBoard[x+i][y].getColor() != aColor &&
                    (pChessBoard[x+i][y].getClass() == Rook.class || pChessBoard[x+i][y].getClass() == Queen.class)) {
                        return true;
                    }
                    E = true;
                }
            }
            if (x-i > 1 && !W) {
                if (pChessBoard[x-i][y] != null) {
                    if (pChessBoard[x-i][y].getColor() != aColor &&
                    (pChessBoard[x-i][y].getClass() == Rook.class || pChessBoard[x-i][y].getClass() == Queen.class)) {
                        return true;
                    }
                    W = true;
                }
            }
            if (y+i < 10 && !N) {
                if (pChessBoard[x][y+i] != null) {
                    if (pChessBoard[x][y+i].getColor() != aColor &&
                    (pChessBoard[x][y+i].getClass() == Rook.class || pChessBoard[x][y+i].getClass() == Queen.class)) {
                        return true;
                    }
                    N = true;
                }
            }
            if (y-i > 1 && !S) {
                if (pChessBoard[x][y-i] != null) {
                    if (pChessBoard[x][y-i].getColor() != aColor &&
                    (pChessBoard[x][y-i].getClass() == Rook.class || pChessBoard[x][y-i].getClass() == Queen.class)) {
                        return true;
                    }
                    S = true;
                }
            }
        }
        return false;
    }
}
