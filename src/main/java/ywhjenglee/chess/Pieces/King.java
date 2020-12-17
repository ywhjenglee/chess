package ywhjenglee.chess.Pieces;

public class King extends Piece {
    
    public King(boolean pColor, int x, int y) {
        super(pColor, x, y);
    }

    public String getName() {
        if (aColor) {
            return "♔";
        } else {
            return "♚";
        }
    }

    public void generatePossibleMoves(Piece[][] pChessBoard) {
        super.generatePossibleMoves(pChessBoard);
        if (pChessBoard[x+1][y] == null) {
            aLegalMoves[x+1][y] = 1;
        } else {
            if (pChessBoard[x+1][y].getColor() != aColor) {
                aLegalMoves[x+1][y] = 2;
            }
        }
        if (pChessBoard[x-1][y] == null) {
            aLegalMoves[x-1][y] = 1;
        } else {
            if (pChessBoard[x-1][y].getColor() != aColor) {
                aLegalMoves[x-1][y] = 2;
            }
        }
        if (pChessBoard[x][y+1] == null) {
            aLegalMoves[x][y+1] = 1;
        } else {
            if (pChessBoard[x][y+1].getColor() != aColor) {
                aLegalMoves[x][y+1] = 2;
            }
        }
        if (pChessBoard[x][y-1] == null) {
            aLegalMoves[x][y-1] = 1;
        } else {
            if (pChessBoard[x][y-1].getColor() != aColor) {
                aLegalMoves[x][y-1] = 2;
            }
        }
        if (pChessBoard[x+1][y+1] == null) {
            aLegalMoves[x+1][y+1] = 1;
        } else {
            if (pChessBoard[x+1][y+1].getColor() != aColor) {
                aLegalMoves[x+1][y+1] = 2;
            }
        }
        if (pChessBoard[x-1][y+1] == null) {
            aLegalMoves[x-1][y+1] = 1;
        } else {
            if (pChessBoard[x-1][y+1].getColor() != aColor) {
                aLegalMoves[x-1][y+1] = 2;
            }
        }
        if (pChessBoard[x+1][y-1] == null) {
            aLegalMoves[x+1][y-1] = 1;
        } else {
            if (pChessBoard[x+1][y-1].getColor() != aColor) {
                aLegalMoves[x+1][y-1] = 2;
            }
        }
        if (pChessBoard[x-1][y-1] == null) {
            aLegalMoves[x-1][y-1] = 1;
        } else {
            if (pChessBoard[x-1][y-1].getColor() != aColor) {
                aLegalMoves[x-1][y-1] = 2;
            }
        }
        generateCastling(pChessBoard);
        removeKingInCheck(pChessBoard);
        aLegalMoves[x][y] = 7;
    }

    private void generateCastling(Piece[][] pChessBoard) {
        if (!this.hasMoved) {
            for (int i = 2; i < 10; i++) {
                CastlingLoop:
                if (aColor) {
                    boolean[][] checkUnAttacked = new boolean[12][12];
                    if (pChessBoard[i][2] != null && pChessBoard[i][2].getColor() == aColor &&
                    pChessBoard[i][2].getClass() == Rook.class) {
                        Rook rook = (Rook) pChessBoard[i][2];
                        if (rook.hasMoved) {
                            break;
                        }
                        if (rook.getSide()) {
                            if (i <= 5) {
                                for (int m = 1; i+m <= 5; m++) {
                                    if (pChessBoard[i+m][2] != null && pChessBoard[i+m][2] != this) {
                                        break CastlingLoop;
                                    }
                                }
                            } else {
                                for (int m = 1; i-m > 5; m++) {
                                    if (pChessBoard[i-m][2] != null) {
                                        break CastlingLoop;
                                    }
                                }
                            }
                            checkUnAttacked[x][2] = true;
                            if (x <= 4) {
                                for (int m = 1; x+m <= 4; m++) {
                                    if (pChessBoard[x+m][2] != null) {
                                        break CastlingLoop;
                                    }
                                    checkUnAttacked[x+m][2] = true;
                                }
                            } else {
                                for (int m = 1; x-m >= 4; m++) {
                                    if (pChessBoard[x-m][2] != null && pChessBoard[x-m][2] != rook) {
                                        break CastlingLoop;
                                    }
                                    checkUnAttacked[x-m][2] = true;
                                }
                            }
                            if (castlingCheckUnAttacked(checkUnAttacked, pChessBoard)) {
                                aLegalMoves[i][2] = 5;
                            }
                        } else {
                            if (i <= 7) {
                                for (int m = 1; i+m <= 7; m++) {
                                    if (pChessBoard[i+m][2] != null) {
                                        break CastlingLoop;
                                    }
                                }
                            } else {
                                for (int m = 1; i-m > 7; m++) {
                                    if (pChessBoard[i-m][2] != null && pChessBoard[i-m][2] != this) {
                                        break CastlingLoop;
                                    }
                                }
                            }
                            checkUnAttacked[x][2] = true;
                            for (int m = 1; x+m <= 8; m++) {
                                if (pChessBoard[x+m][2] != null && pChessBoard[x+m][2] != rook) {
                                    break CastlingLoop;
                                }
                                checkUnAttacked[x+m][2] = true;
                            }
                            if (castlingCheckUnAttacked(checkUnAttacked, pChessBoard)) {
                                aLegalMoves[i][2] = 6;
                            }
                        }
                    }
                } else {
                    boolean[][] checkUnAttacked = new boolean[12][12];
                    if (pChessBoard[i][9] != null && pChessBoard[i][9].getColor() == aColor &&
                    pChessBoard[i][9].getClass() == Rook.class) {
                        Rook rook = (Rook) pChessBoard[i][9];
                        if (rook.hasMoved) {
                            break;
                        }
                        if (rook.getSide()) {
                            if (i <= 5) {
                                for (int m = 1; i+m <= 5; m++) {
                                    if (pChessBoard[i+m][9] != null && pChessBoard[i+m][9] != this) {
                                        break CastlingLoop;
                                    }
                                }
                            } else {
                                for (int m = 1; i-m > 5; m++) {
                                    if (pChessBoard[i-m][9] != null) {
                                        break CastlingLoop;
                                    }
                                }
                            }
                            checkUnAttacked[x][9] = true;
                            if (x <= 4) {
                                for (int m = 1; x+m <= 4; m++) {
                                    if (pChessBoard[x+m][9] != null) {
                                        break CastlingLoop;
                                    }
                                    checkUnAttacked[x+m][9] = true;
                                }
                            } else {
                                for (int m = 1; x-m >= 4; m++) {
                                    if (pChessBoard[x-m][9] != null && pChessBoard[x-m][9] != rook) {
                                        break CastlingLoop;
                                    }
                                    checkUnAttacked[x-m][9] = true;
                                }
                            }
                            if (castlingCheckUnAttacked(checkUnAttacked, pChessBoard)) {
                                aLegalMoves[i][9] = 5;
                            }
                        } else {
                            if (i <= 7) {
                                for (int m = 1; i+m <= 7; m++) {
                                    if (pChessBoard[i+m][9] != null) {
                                        break CastlingLoop;
                                    }
                                }
                            } else {
                                for (int m = 1; i-m > 7; m++) {
                                    if (pChessBoard[i-m][9] != null && pChessBoard[i-m][9] != this) {
                                        break CastlingLoop;
                                    }
                                }
                            }
                            checkUnAttacked[x][9] = true;
                            for (int m = 1; x+m <= 8; m++) {
                                if (pChessBoard[x+m][9] != null && pChessBoard[x+m][9] != rook) {
                                    break CastlingLoop;
                                }
                                checkUnAttacked[x+m][9] = true;
                            }
                            if (castlingCheckUnAttacked(checkUnAttacked, pChessBoard)) {
                                aLegalMoves[i][9] = 6;
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean castlingCheckUnAttacked(boolean[][] pCheckUnAttacked, Piece[][] pChessBoard) {
        for (int j = 2; j < 10; j++) {
            for (int i = 2; i < 10; i++) {
                if (pCheckUnAttacked[i][j]) {
                    Piece[][] tempBoard = new Piece[12][12];
                    for (int n = 2; n < 10; n++) {
                        for (int m = 2; m < 10; m++) {
                            tempBoard[m][n] = pChessBoard[m][n];
                        }
                    }
                    tempBoard[i][j] = this;
                    tempBoard[x][y] = null;
                    int tempX = this.getX();
                    int tempY = this.getY();
                    this.setPosition(i, j);
                    if (this.isInCheck(tempBoard)) {
                        tempBoard[i][j] = null;
                        tempBoard[x][y] = this;
                        this.setPosition(tempX, tempY);
                        return false;
                    }
                    tempBoard[i][j] = null;
                    tempBoard[x][y] = this;
                    this.setPosition(tempX, tempY);
                }
            }
        }
        return true;
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
