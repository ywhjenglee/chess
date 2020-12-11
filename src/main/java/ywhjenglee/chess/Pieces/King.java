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

    private void removeKingInCheck(Piece[][] paddedChessBoard) {
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (paddedLegalMoves[i][j] && isInCheck(paddedChessBoard)) {
                    paddedLegalMoves[i][j] = false;
                }
            }
        }
    }

    public boolean isInCheck(Piece[][] paddedChessBoard) {
        // Check Pawn and King
        if (paddedChessBoard[x+1][y+1] != null && paddedChessBoard[x+1][y+1].getColor() != aColor) {
            if (paddedChessBoard[x+1][y+1].getClass() == King.class ||
            (paddedChessBoard[x+1][y+1].getClass() == Pawn.class && paddedChessBoard[x+1][y+1].getColor())) {
                return true;
            }
        }
        if (paddedChessBoard[x][y+1] != null && paddedChessBoard[x][y+1].getColor() != aColor) {
            if (paddedChessBoard[x][y+1].getClass() == King.class) {
                return true;
            }
        }
        if (paddedChessBoard[x-1][y+1] != null && paddedChessBoard[x-1][y+1].getColor() != aColor) {
            if (paddedChessBoard[x-1][y+1].getClass() == King.class ||
            (paddedChessBoard[x-1][y+1].getClass() == Pawn.class && paddedChessBoard[x-1][y+1].getColor())) {
                return true;
            }
        }
        if (paddedChessBoard[x+1][y] != null && paddedChessBoard[x+1][y].getColor() != aColor) {
            if (paddedChessBoard[x+1][y].getClass() == King.class) {
                return true;
            }
        }
        if (paddedChessBoard[x-1][y] != null && paddedChessBoard[x-1][y].getColor() != aColor) {
            if (paddedChessBoard[x-1][y].getClass() == King.class) {
                return true;
            }
        }
        if (paddedChessBoard[x+1][y-1] != null && paddedChessBoard[x+1][y-1].getColor() != aColor) {
            if (paddedChessBoard[x+1][y-1].getClass() == King.class ||
            (paddedChessBoard[x+1][y-1].getClass() == Pawn.class && !paddedChessBoard[x+1][y-1].getColor())) {
                return true;
            }
        }
        if (paddedChessBoard[x][y-1] != null && paddedChessBoard[x][y-1].getColor() != aColor) {
            if (paddedChessBoard[x][y-1].getClass() == King.class) {
                return true;
            }
        }
        if (paddedChessBoard[x-1][y-1] != null && paddedChessBoard[x-1][y-1].getColor() != aColor) {
            if (paddedChessBoard[x-1][y-1].getClass() == King.class ||
            (paddedChessBoard[x-1][y-1].getClass() == Pawn.class && !paddedChessBoard[x-1][y-1].getColor())) {
                return true;
            }
        }
        // Check Knight
        if (paddedChessBoard[x+1][y+2] != null && paddedChessBoard[x+1][y+2].getColor() != aColor) {
            if (paddedChessBoard[x+1][y+2].getClass() == Knight.class) {
                return true;
            }
        }
        if (paddedChessBoard[x-1][y+2] != null && paddedChessBoard[x-1][y+2].getColor() != aColor) {
            if (paddedChessBoard[x-1][y+2].getClass() == Knight.class) {
                return true;
            }
        }
        if (paddedChessBoard[x+1][y-2] != null && paddedChessBoard[x+1][y-2].getColor() != aColor) {
            if (paddedChessBoard[x+1][y-2].getClass() == Knight.class) {
                return true;
            }
        }
        if (paddedChessBoard[x-1][y-2] != null && paddedChessBoard[x-1][y-2].getColor() != aColor) {
            if (paddedChessBoard[x-1][y-2].getClass() == Knight.class) {
                return true;
            }
        }
        if (paddedChessBoard[x+2][y+1] != null && paddedChessBoard[x+2][y+1].getColor() != aColor) {
            if (paddedChessBoard[x+2][y+1].getClass() == Knight.class) {
                return true;
            }
        }
        if (paddedChessBoard[x-2][y+1] != null && paddedChessBoard[x-2][y+1].getColor() != aColor) {
            if (paddedChessBoard[x-2][y+1].getClass() == Knight.class) {
                return true;
            }
        }
        if (paddedChessBoard[x+2][y-1] != null && paddedChessBoard[x+2][y-1].getColor() != aColor) {
            if (paddedChessBoard[x+2][y-1].getClass() == Knight.class) {
                return true;
            }
        }
        if (paddedChessBoard[x-2][y-1] != null && paddedChessBoard[x-2][y-1].getColor() != aColor) {
            if (paddedChessBoard[x-2][y-1].getClass() == Knight.class) {
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
                if (paddedChessBoard[x+i][y+i] != null && paddedChessBoard[x+i][y+i].getColor() != aColor) {
                    if (paddedChessBoard[x+i][y+i].getClass() == Bishop.class || paddedChessBoard[x+i][y+i].getClass() == Queen.class) {
                        return true;
                    } else {
                        NE = true;
                    }
                }
            }
            if (x-i > 1 && y+i < 10 && !NW) {
                if (paddedChessBoard[x-i][y+i] != null && paddedChessBoard[x-i][y+i].getColor() != aColor) {
                    if (paddedChessBoard[x-i][y+i].getClass() == Bishop.class || paddedChessBoard[x-i][y+i].getClass() == Queen.class) {
                        return true;
                    } else {
                        NW = true;
                    }
                }
            }
            if (x+i < 10 && y-i > 1 && !SE) {
                if (paddedChessBoard[x+i][y-i] != null && paddedChessBoard[x+i][y-i].getColor() != aColor) {
                    if (paddedChessBoard[x+i][y-i].getClass() == Bishop.class || paddedChessBoard[x+i][y-i].getClass() == Queen.class) {
                        return true;
                    } else {
                        SE = true;
                    }
                }
            }
            if (x-i > 1 && y-i > 1 && !SW) {
                if (paddedChessBoard[x-i][y-i] != null && paddedChessBoard[x-i][y-i].getColor() != aColor) {
                    if (paddedChessBoard[x-i][y-i].getClass() == Bishop.class || paddedChessBoard[x-i][y-i].getClass() == Queen.class) {
                        return true;
                    } else {
                        SW = true;
                    }
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
                if (paddedChessBoard[x+i][y] != null && paddedChessBoard[x+i][y].getColor() != aColor) {
                    if (paddedChessBoard[x+i][y].getClass() == Rook.class || paddedChessBoard[x+i][y].getClass() == Queen.class) {
                        return true;
                    } else {
                        E = true;
                    }
                }
            }
            if (x-i > 1 && !W) {
                if (paddedChessBoard[x-i][y] != null && paddedChessBoard[x-i][y].getColor() != aColor) {
                    if (paddedChessBoard[x-i][y].getClass() == Rook.class || paddedChessBoard[x-i][y].getClass() == Queen.class) {
                        return true;
                    } else {
                        W = true;
                    }
                }
            }
            if (y+i < 10 && !N) {
                if (paddedChessBoard[x][y+i] != null && paddedChessBoard[x][y+i].getColor() != aColor) {
                    if (paddedChessBoard[x][y+i].getClass() == Rook.class || paddedChessBoard[x][y+i].getClass() == Queen.class) {
                        return true;
                    } else {
                        N = true;
                    }
                }
            }
            if (y-i > 1 && !S) {
                if (paddedChessBoard[x][y-i] != null && paddedChessBoard[x][y-i].getColor() != aColor) {
                    if (paddedChessBoard[x][y-i].getClass() == Rook.class || paddedChessBoard[x][y-i].getClass() == Queen.class) {
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
