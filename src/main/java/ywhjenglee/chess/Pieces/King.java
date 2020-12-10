package ywhjenglee.chess.Pieces;

import ywhjenglee.chess.Tile;

public class King extends Piece {
    
    public King(boolean pColor, int pX, int pY) {
        super("King", pColor, pX, pY);
    }

    public void generatePossibleMoves(Tile[][] pChessBoard) {
        legalMoves[x+1][y] = true;
        legalMoves[x-1][y] = true;
        legalMoves[x][y+1] = true;
        legalMoves[x][y-1] = true;
        legalMoves[x+1][y+1] = true;
        legalMoves[x-1][y+1] = true;
        legalMoves[x+1][y-1] = true;
        legalMoves[x-1][y-1] = true;
        removeOutOfBounds();
        removeAllyOccupied(pChessBoard);
        removeKingInCheck(pChessBoard);
        legalMoves[x][y] = true;
    }

    private void removeKingInCheck(Tile[][] pChessBoard) {
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (legalMoves[i][j] && isInCheck(pChessBoard, i, j)) {
                    legalMoves[i][j] = false;
                }
            }
        }
    }

    public boolean isInCheck(Tile[][] pChessBoard, int pX, int pY) {
        // Check Pawn and King
        if (pChessBoard[pX+1][pY+1].getPiece() != null && pChessBoard[pX+1][pY+1].getPiece().getColor() != aColor) {
            if (pChessBoard[pX+1][pY+1].getPiece().getClass() == King.class ||
            (pChessBoard[pX+1][pY+1].getPiece().getClass() == Pawn.class && pChessBoard[pX+1][pY+1].getPiece().getColor())) {
                return true;
            }
        }
        if (pChessBoard[pX][pY+1].getPiece() != null && pChessBoard[pX][pY+1].getPiece().getColor() != aColor) {
            if (pChessBoard[pX][pY+1].getPiece().getClass() == King.class) {
                return true;
            }
        }
        if (pChessBoard[pX-1][pY+1].getPiece() != null && pChessBoard[pX-1][pY+1].getPiece().getColor() != aColor) {
            if (pChessBoard[pX-1][pY+1].getPiece().getClass() == King.class ||
            (pChessBoard[pX-1][pY+1].getPiece().getClass() == Pawn.class && pChessBoard[pX-1][pY+1].getPiece().getColor())) {
                return true;
            }
        }
        if (pChessBoard[pX+1][pY].getPiece() != null && pChessBoard[pX+1][pY].getPiece().getColor() != aColor) {
            if (pChessBoard[pX+1][pY].getPiece().getClass() == King.class) {
                return true;
            }
        }
        if (pChessBoard[pX-1][pY].getPiece() != null && pChessBoard[pX-1][pY].getPiece().getColor() != aColor) {
            if (pChessBoard[pX-1][pY].getPiece().getClass() == King.class) {
                return true;
            }
        }
        if (pChessBoard[pX+1][pY-1].getPiece() != null && pChessBoard[pX+1][pY-1].getPiece().getColor() != aColor) {
            if (pChessBoard[pX+1][pY-1].getPiece().getClass() == King.class ||
            (pChessBoard[pX+1][pY-1].getPiece().getClass() == Pawn.class && !pChessBoard[pX+1][pY-1].getPiece().getColor())) {
                return true;
            }
        }
        if (pChessBoard[pX][pY-1].getPiece() != null && pChessBoard[pX][pY-1].getPiece().getColor() != aColor) {
            if (pChessBoard[pX][pY-1].getPiece().getClass() == King.class) {
                return true;
            }
        }
        if (pChessBoard[pX-1][pY-1].getPiece() != null && pChessBoard[pX-1][pY-1].getPiece().getColor() != aColor) {
            if (pChessBoard[pX-1][pY-1].getPiece().getClass() == King.class ||
            (pChessBoard[pX-1][pY-1].getPiece().getClass() == Pawn.class && !pChessBoard[pX-1][pY-1].getPiece().getColor())) {
                return true;
            }
        }
        // Check Knight
        if (pChessBoard[pX+1][pY+2].getPiece() != null && pChessBoard[pX+1][pY+2].getPiece().getColor() != aColor) {
            if (pChessBoard[pX+1][pY+2].getPiece().getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[pX-1][pY+2].getPiece() != null && pChessBoard[pX-1][pY+2].getPiece().getColor() != aColor) {
            if (pChessBoard[pX-1][pY+2].getPiece().getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[pX+1][pY-2].getPiece() != null && pChessBoard[pX+1][pY-2].getPiece().getColor() != aColor) {
            if (pChessBoard[pX+1][pY-2].getPiece().getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[pX-1][pY-2].getPiece() != null && pChessBoard[pX-1][pY-2].getPiece().getColor() != aColor) {
            if (pChessBoard[pX-1][pY-2].getPiece().getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[pX+2][pY+1].getPiece() != null && pChessBoard[pX+2][pY+1].getPiece().getColor() != aColor) {
            if (pChessBoard[pX+2][pY+1].getPiece().getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[pX-2][pY+1].getPiece() != null && pChessBoard[pX-2][pY+1].getPiece().getColor() != aColor) {
            if (pChessBoard[pX-2][pY+1].getPiece().getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[pX+2][pY-1].getPiece() != null && pChessBoard[pX+2][pY-1].getPiece().getColor() != aColor) {
            if (pChessBoard[pX+2][pY-1].getPiece().getClass() == Knight.class) {
                return true;
            }
        }
        if (pChessBoard[pX-2][pY-1].getPiece() != null && pChessBoard[pX-2][pY-1].getPiece().getColor() != aColor) {
            if (pChessBoard[pX-2][pY-1].getPiece().getClass() == Knight.class) {
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
                if (pChessBoard[pX+i][pY+i].getPiece() != null && pChessBoard[pX+i][pY+i].getPiece().getColor() != aColor) {
                    if (pChessBoard[pX+i][pY+i].getPiece().getClass() == Bishop.class || pChessBoard[pX+i][pY+i].getPiece().getClass() == Queen.class) {
                        return true;
                    } else {
                        NE = true;
                    }
                }
            }
            if (x-i > 1 && y+i < 10 && !NW) {
                if (pChessBoard[pX-i][pY+i].getPiece() != null && pChessBoard[pX-i][pY+i].getPiece().getColor() != aColor) {
                    if (pChessBoard[pX-i][pY+i].getPiece().getClass() == Bishop.class || pChessBoard[pX-i][pY+i].getPiece().getClass() == Queen.class) {
                        return true;
                    } else {
                        NW = true;
                    }
                }
            }
            if (x+i < 10 && y-i > 1 && !SE) {
                if (pChessBoard[pX+i][pY-i].getPiece() != null && pChessBoard[pX+i][pY-i].getPiece().getColor() != aColor) {
                    if (pChessBoard[pX+i][pY-i].getPiece().getClass() == Bishop.class || pChessBoard[pX+i][pY-i].getPiece().getClass() == Queen.class) {
                        return true;
                    } else {
                        SE = true;
                    }
                }
            }
            if (x-i > 1 && y-i > 1 && !SW) {
                if (pChessBoard[pX-i][pY-i].getPiece() != null && pChessBoard[pX-i][pY-i].getPiece().getColor() != aColor) {
                    if (pChessBoard[pX-i][pY-i].getPiece().getClass() == Bishop.class || pChessBoard[pX-i][pY-i].getPiece().getClass() == Queen.class) {
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
                if (pChessBoard[pX+i][pY].getPiece() != null && pChessBoard[pX+i][pY].getPiece().getColor() != aColor) {
                    if (pChessBoard[pX+i][pY].getPiece().getClass() == Rook.class || pChessBoard[pX+i][pY].getPiece().getClass() == Queen.class) {
                        return true;
                    } else {
                        E = true;
                    }
                }
            }
            if (x-i > 1 && !W) {
                if (pChessBoard[pX-i][pY].getPiece() != null && pChessBoard[pX-i][pY].getPiece().getColor() != aColor) {
                    if (pChessBoard[pX-i][pY].getPiece().getClass() == Rook.class || pChessBoard[pX-i][pY].getPiece().getClass() == Queen.class) {
                        return true;
                    } else {
                        W = true;
                    }
                }
            }
            if (y+i < 10 && !N) {
                if (pChessBoard[pX][pY+i].getPiece() != null && pChessBoard[pX][pY+i].getPiece().getColor() != aColor) {
                    if (pChessBoard[pX][pY+i].getPiece().getClass() == Rook.class || pChessBoard[pX][pY+i].getPiece().getClass() == Queen.class) {
                        return true;
                    } else {
                        N = true;
                    }
                }
            }
            if (y-i > 1 && !S) {
                if (pChessBoard[pX][pY-i].getPiece() != null && pChessBoard[pX][pY-i].getPiece().getColor() != aColor) {
                    if (pChessBoard[pX][pY-i].getPiece().getClass() == Rook.class || pChessBoard[pX][pY-i].getPiece().getClass() == Queen.class) {
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
