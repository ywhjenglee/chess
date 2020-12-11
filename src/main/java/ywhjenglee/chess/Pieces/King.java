package ywhjenglee.chess.Pieces;

public class King extends Piece {
    
    public King(boolean pColor, int x, int y) {
        super("King", pColor, x, y);
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        paddedLegalMoves[x+1][y] = true;
        paddedLegalMoves[x-1][y] = true;
        paddedLegalMoves[x][y+1] = true;
        paddedLegalMoves[x][y-1] = true;
        paddedLegalMoves[x+1][y+1] = true;
        paddedLegalMoves[x-1][y+1] = true;
        paddedLegalMoves[x+1][y-1] = true;
        paddedLegalMoves[x-1][y-1] = true;
        removeAllyOccupied(paddedChessBoard);
        removeKingInCheck(paddedChessBoard);
        paddedLegalMoves[x][y] = true;
    }

    private void removeKingInCheck(Piece[][] pPaddedChessBoard) {
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (paddedLegalMoves[i][j] && isInCheck(pPaddedChessBoard)) {
                    paddedLegalMoves[i][j] = false;
                }
            }
        }
    }

    public boolean isInCheck(Piece[][] pPaddedChessBoard) {
        /*
        // Check Pawn and King
        if (pPaddedChessBoard[x+1][y+1] != null && pPaddedChessBoard[x+1][y+1].getColor() != aColor) {
            if (pPaddedChessBoard[x+1][y+1].getClass() == King.class ||
            (pPaddedChessBoard[x+1][y+1].getClass() == Pawn.class && pPaddedChessBoard[x+1][y+1].getColor())) {
                return true;
            }
        }
        if (pPaddedChessBoard[x][y+1] != null && pPaddedChessBoard[x][y+1].getColor() != aColor) {
            if (pPaddedChessBoard[x][y+1].getClass() == King.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x-1][y+1] != null && pPaddedChessBoard[x-1][y+1].getColor() != aColor) {
            if (pPaddedChessBoard[x-1][y+1].getClass() == King.class ||
            (pPaddedChessBoard[x-1][y+1].getClass() == Pawn.class && pPaddedChessBoard[x-1][y+1].getColor())) {
                return true;
            }
        }
        if (pPaddedChessBoard[x+1][y] != null && pPaddedChessBoard[x+1][y].getColor() != aColor) {
            if (pPaddedChessBoard[x+1][y].getClass() == King.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x-1][y] != null && pPaddedChessBoard[x-1][y].getColor() != aColor) {
            if (pPaddedChessBoard[x-1][y].getClass() == King.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x+1][y-1] != null && pPaddedChessBoard[x+1][y-1].getColor() != aColor) {
            if (pPaddedChessBoard[x+1][y-1].getClass() == King.class ||
            (pPaddedChessBoard[x+1][y-1].getClass() == Pawn.class && !pPaddedChessBoard[x+1][y-1].getColor())) {
                return true;
            }
        }
        if (pPaddedChessBoard[x][y-1] != null && pPaddedChessBoard[x][y-1].getColor() != aColor) {
            if (pPaddedChessBoard[x][y-1].getClass() == King.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x-1][y-1] != null && pPaddedChessBoard[x-1][y-1].getColor() != aColor) {
            if (pPaddedChessBoard[x-1][y-1].getClass() == King.class ||
            (pPaddedChessBoard[x-1][y-1].getClass() == Pawn.class && !pPaddedChessBoard[x-1][y-1].getColor())) {
                return true;
            }
        }*/
        // Check Knight
        if (pPaddedChessBoard[x+1][y+2] != null && pPaddedChessBoard[x+1][y+2].getColor() != aColor) {
            if (pPaddedChessBoard[x+1][y+2].getClass() == Knight.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x-1][y+2] != null && pPaddedChessBoard[x-1][y+2].getColor() != aColor) {
            if (pPaddedChessBoard[x-1][y+2].getClass() == Knight.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x+1][y-2] != null && pPaddedChessBoard[x+1][y-2].getColor() != aColor) {
            if (pPaddedChessBoard[x+1][y-2].getClass() == Knight.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x-1][y-2] != null && pPaddedChessBoard[x-1][y-2].getColor() != aColor) {
            if (pPaddedChessBoard[x-1][y-2].getClass() == Knight.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x+2][y+1] != null && pPaddedChessBoard[x+2][y+1].getColor() != aColor) {
            if (pPaddedChessBoard[x+2][y+1].getClass() == Knight.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x-2][y+1] != null && pPaddedChessBoard[x-2][y+1].getColor() != aColor) {
            if (pPaddedChessBoard[x-2][y+1].getClass() == Knight.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x+2][y-1] != null && pPaddedChessBoard[x+2][y-1].getColor() != aColor) {
            if (pPaddedChessBoard[x+2][y-1].getClass() == Knight.class) {
                return true;
            }
        }
        if (pPaddedChessBoard[x-2][y-1] != null && pPaddedChessBoard[x-2][y-1].getColor() != aColor) {
            if (pPaddedChessBoard[x-2][y-1].getClass() == Knight.class) {
                return true;
            }
        }
        /*
        // Check Bishop and Queen
        boolean NE = false;
        boolean NW = false;
        boolean SE = false;
        boolean SW = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && y+i < 10 && !NE) {
                if (pPaddedChessBoard[x+i][y+i] != null && pPaddedChessBoard[x+i][y+i].getColor() != aColor) {
                    if (pPaddedChessBoard[x+i][y+i].getClass() == Bishop.class || pPaddedChessBoard[x+i][y+i].getClass() == Queen.class) {
                        return true;
                    } else {
                        NE = true;
                    }
                }
            }
            if (x-i > 1 && y+i < 10 && !NW) {
                if (pPaddedChessBoard[x-i][y+i] != null && pPaddedChessBoard[x-i][y+i].getColor() != aColor) {
                    if (pPaddedChessBoard[x-i][y+i].getClass() == Bishop.class || pPaddedChessBoard[x-i][y+i].getClass() == Queen.class) {
                        return true;
                    } else {
                        NW = true;
                    }
                }
            }
            if (x+i < 10 && y-i > 1 && !SE) {
                if (pPaddedChessBoard[x+i][y-i] != null && pPaddedChessBoard[x+i][y-i].getColor() != aColor) {
                    if (pPaddedChessBoard[x+i][y-i].getClass() == Bishop.class || pPaddedChessBoard[x+i][y-i].getClass() == Queen.class) {
                        return true;
                    } else {
                        SE = true;
                    }
                }
            }
            if (x-i > 1 && y-i > 1 && !SW) {
                if (pPaddedChessBoard[x-i][y-i] != null && pPaddedChessBoard[x-i][y-i].getColor() != aColor) {
                    if (pPaddedChessBoard[x-i][y-i].getClass() == Bishop.class || pPaddedChessBoard[x-i][y-i].getClass() == Queen.class) {
                        return true;
                    } else {
                        SW = true;
                    }
                }
            }
        }*/
        // Check Rook and Queen
        boolean E = false;
        boolean W = false;
        boolean N = false;
        boolean S = false;
        for (int i = 1; i < 8; i++) {
            if (x+i < 10 && !E) {
                if (pPaddedChessBoard[x+i][y] != null && pPaddedChessBoard[x+i][y].getColor() != aColor) {
                    if (pPaddedChessBoard[x+i][y].getClass() == Rook.class || pPaddedChessBoard[x+i][y].getClass() == Queen.class) {
                        return true;
                    } else {
                        E = true;
                    }
                }
            }
            if (x-i > 1 && !W) {
                if (pPaddedChessBoard[x-i][y] != null && pPaddedChessBoard[x-i][y].getColor() != aColor) {
                    if (pPaddedChessBoard[x-i][y].getClass() == Rook.class || pPaddedChessBoard[x-i][y].getClass() == Queen.class) {
                        return true;
                    } else {
                        W = true;
                    }
                }
            }
            if (y+i < 10 && !N) {
                if (pPaddedChessBoard[x][y+i] != null && pPaddedChessBoard[x][y+i].getColor() != aColor) {
                    if (pPaddedChessBoard[x][y+i].getClass() == Rook.class || pPaddedChessBoard[x][y+i].getClass() == Queen.class) {
                        return true;
                    } else {
                        N = true;
                    }
                }
            }
            if (y-i > 1 && !S) {
                if (pPaddedChessBoard[x][y-i] != null && pPaddedChessBoard[x][y-i].getColor() != aColor) {
                    if (pPaddedChessBoard[x][y-i].getClass() == Rook.class || pPaddedChessBoard[x][y-i].getClass() == Queen.class) {
                        return true;
                    } else {
                        S = true;
                    }
                }
            }
        }
        return false;
    }
}
