package ywhjenglee.chess;

import ywhjenglee.chess.Pieces.Piece;
import ywhjenglee.chess.Pieces.Pawn;
import ywhjenglee.chess.Pieces.Knight;
import ywhjenglee.chess.Pieces.Bishop;
import ywhjenglee.chess.Pieces.Rook;
import ywhjenglee.chess.Pieces.Queen;
import ywhjenglee.chess.Pieces.King;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Random;

public class ChessModel {

    private String aGameMode;
    private Piece[][] aChessBoard;
    private List<Piece> whitesPieces;
    private List<Piece> blacksPieces;
    private List<Piece> whitesCaptures;
    private List<Piece> blacksCaptures;

    private Rook wRookQ;
    private Rook bRookQ;
    private Knight wKnight1;
    private Knight bKnight1;
    private Bishop wBishop1;
    private Bishop bBishop1;
    private Queen wQueen;
    private Queen bQueen;
    private King wKing;
    private King bKing;
    private Bishop wBishop2;
    private Bishop bBishop2;
    private Knight wKnight2;
    private Knight bKnight2;
    private Rook wRookK;
    private Rook bRookK;

    private boolean whiteTurn;
    private int turnCount;
    private Piece selectedPiece;
    private String aResult;
    private boolean wCheck = false;
    private boolean bCheck = false;
    private Pawn pawnEnPassant;
    private Piece pieceToPromote;

    public ChessModel(String pGameMode) {
        aGameMode = pGameMode;
        aChessBoard = new Piece[12][12];
        whitesCaptures = new ArrayList<>();
        blacksCaptures = new ArrayList<>();
        whiteTurn = true;
        aResult = "Game Ongoing";
        setUpPieces();
    }

    private void setUpPieces() {
        switch (aGameMode) {
            case "Standard":
                setUpStandard();
                break;
            case "Fischer Random":
                setUpFischerRandom();
                break;
        }
        setPiecesOnChessBoard();
    }

    private void setUpStandard() {
        // White back rank pieces
        wRookQ = new Rook(true, 2, 2, true);
        wKnight1 = new Knight(true, 3, 2);
        wBishop1 = new Bishop(true, 4, 2);
        wQueen = new Queen(true, 5, 2);
        wKing = new King(true, 6, 2);
        wBishop2 = new Bishop(true, 7, 2);
        wKnight2 = new Knight(true, 8, 2);
        wRookK = new Rook(true, 9, 2, false);
        // Black back rank pieces
        bRookQ = new Rook(false, 2, 9, true);
        bKnight1 = new Knight(false, 3, 9);
        bBishop1 = new Bishop(false, 4, 9);
        bQueen = new Queen(false, 5, 9);
        bKing = new King(false, 6, 9);
        bBishop2 = new Bishop(false, 7, 9);
        bKnight2 = new Knight(false, 8, 9);
        bRookK = new Rook(false, 9, 9, false);
        // Add back rank pieces to their respective array list
        Piece[] wBackRank = {wRookQ, wKnight1, wBishop1, wQueen, wKing, wBishop2, wKnight2, wRookK};
        Piece[] bBackRank = {bRookQ, bKnight1, bBishop1, bQueen, bKing, bBishop2, bKnight2, bRookK};
        whitesPieces = new ArrayList<>(Arrays.asList(wBackRank));
        blacksPieces = new ArrayList<>(Arrays.asList(bBackRank));
        // Pawns
        for (int i = 2; i < 10; i++) {
            Piece wPawn = new Pawn(true, i, 3);
            Piece bPawn = new Pawn(false, i, 8);
            whitesPieces.add(wPawn);
            blacksPieces.add(bPawn);
        }
    }

    private void setUpFischerRandom() {
        // Generate Fischer Random ID
        Random random = new Random();
        int fischerID = random.nextInt(960);
        // Light Bishop
        int i = 2 * (fischerID % 4) + 3;
        wBishop1 = new Bishop(true, i, 2);
        bBishop1 = new Bishop(false, i, 9);
        fischerID /= 4;
        // Dark Bishop
        int j = 2 * (fischerID % 4) + 2;
        wBishop2 = new Bishop(true, j, 2);
        bBishop2 = new Bishop(false, j, 9);
        fischerID /= 4;
        // Queen
        int k = (fischerID % 6) + 2;
        for (int n = 2; n < 10; n++) {
            if (n == i || n == j) {
                k++;
            }
            if (k == n) {
                wQueen = new Queen(true, k, 2);
                bQueen = new Queen(false, k, 9);
                break;
            }
        }
        fischerID /= 6;
        // Knights
        int[] knight1 = {2,2,2,2,3,3,3,4,4,5};
        int[] knight2 = {3,4,5,6,4,5,6,5,6,6};
        int p = knight1[fischerID];
        int q = knight2[fischerID];
        boolean knight1Placed = false;
        for (int n = 2; n < 10; n++) {
            if (n == i || n == j || n == k) {
                if (!knight1Placed) {
                    p++;
                }
                q++;
            }
            if (p == n) {
                wKnight1 = new Knight(true, p, 2);
                bKnight1 = new Knight(false, p, 9);
                knight1Placed = true;
            }
            if (q == n) {
                wKnight2 = new Knight(true, q, 2);
                bKnight2 = new Knight(false, q, 9);
                break;
            }
        }
        // Rooks and King
        boolean rookQueenPlaced = false;
        boolean kingPlaced = false;
        for (int n = 2; n < 10; n++) {
            if (n != i && n != j && n != k && n != p && n != q) {
                if (!rookQueenPlaced) {
                    wRookQ = new Rook(true, n, 2, true);
                    bRookQ = new Rook(false, n, 9, true);
                    rookQueenPlaced = true;
                    continue;
                } else {
                    if (!kingPlaced) {
                        wKing = new King(true, n, 2);
                        bKing = new King(false, n, 9);
                        kingPlaced = true;
                        continue;
                    } else {
                        wRookK = new Rook(true, n, 2, false);
                        bRookK = new Rook(false, n, 9, false);
                        break;
                    }
                }
            }
        }
        // Add back rank pieces to their respective array list
        Piece[] wBackRank = {wRookQ, wKnight1, wBishop1, wQueen, wKing, wBishop2, wKnight2, wRookK};
        Piece[] bBackRank = {bRookQ, bKnight1, bBishop1, bQueen, bKing, bBishop2, bKnight2, bRookK};
        whitesPieces = new ArrayList<>(Arrays.asList(wBackRank));
        blacksPieces = new ArrayList<>(Arrays.asList(bBackRank));
        // Pawns
        for (int n = 2; n < 10; n++) {
            Piece wPawn = new Pawn(true, n, 3);
            Piece bPawn = new Pawn(false, n, 8);
            whitesPieces.add(wPawn);
            blacksPieces.add(bPawn);
        }
    }

    private void setPiecesOnChessBoard() {
        for (Piece piece : whitesPieces) {
            aChessBoard[piece.getX()][piece.getY()] = piece;
        }
        for (Piece piece : blacksPieces) {
            aChessBoard[piece.getX()][piece.getY()] = piece;
        }
    }

    public void selectPiece(Piece pPiece) {
        if (pPiece.getColor() == whiteTurn) {
            selectedPiece = pPiece;
            selectedPiece.generatePossibleMoves(aChessBoard);
        }
    }

    public int[][] getVisibleSelectedLegalMoves() {
        if (selectedPiece != null) {
            int[][] visibleLegalMoves = new int[8][8];
            for (int j = 2; j < 10; j++) {
                for (int i = 2; i < 10; i++) {
                    visibleLegalMoves[i-2][j-2] = selectedPiece.getLegalMoves()[i][j];
                }
            }
            return visibleLegalMoves;
        }
        return new int[8][8];
    }

    public void movePiece(int pX, int pY) {
        if (!whiteTurn) {
            turnCount++;
        }
        if (selectedPiece != null) {
            int[][] legalMoves = selectedPiece.getLegalMoves();
            if (legalMoves[pX][pY] > 0) {
                if (selectedPiece.getX() == pX && selectedPiece.getY() == pY){
                    selectedPiece = null;
                    return;
                } else if (legalMoves[pX][pY] == 4) {
                    if (whiteTurn) {
                        whitesCaptures.add(pawnEnPassant);
                        blacksPieces.remove(pawnEnPassant);
                    } else {
                        blacksCaptures.add(pawnEnPassant);
                        whitesPieces.remove(pawnEnPassant);
                    }
                    pawnEnPassant.setEnPassant(false);
                    aChessBoard[pawnEnPassant.getX()][pawnEnPassant.getY()] = null;
                    pawnEnPassant = null;
                } else {
                    if (pawnEnPassant != null) {
                        pawnEnPassant.setEnPassant(false);
                        pawnEnPassant = null;
                    }
                    if (legalMoves[pX][pY] == 2) {
                        if (whiteTurn) {
                            whitesCaptures.add(aChessBoard[pX][pY]);
                            blacksPieces.remove(aChessBoard[pX][pY]);
                        } else {
                            blacksCaptures.add(aChessBoard[pX][pY]);
                            whitesPieces.remove(aChessBoard[pX][pY]);
                        }
                    } else if (legalMoves[pX][pY] == 3) {
                        pawnEnPassant = (Pawn) selectedPiece;
                        pawnEnPassant.setEnPassant(true);
                    } else if (legalMoves[pX][pY] == 5 || legalMoves[pX][pY] == 6) {
                        aChessBoard[selectedPiece.getX()][selectedPiece.getY()] = null;
                        if (legalMoves[pX][pY] == 5) {
                            if (whiteTurn) {
                                aChessBoard[pX][pY].setPosition(5, 2);
                                aChessBoard[pX][pY].setHasMoved();
                                selectedPiece.setPosition(4, 2);
                                selectedPiece.setHasMoved();
                                aChessBoard[4][2] = selectedPiece;
                                aChessBoard[5][2] = aChessBoard[pX][pY];

                            } else {
                                aChessBoard[pX][pY].setPosition(5, 9);
                                aChessBoard[pX][pY].setHasMoved();
                                selectedPiece.setPosition(4, 9);
                                selectedPiece.setHasMoved();
                                aChessBoard[4][9] = selectedPiece;
                                aChessBoard[5][9] = aChessBoard[pX][pY];
                            }
                        } else {
                            if (whiteTurn) {
                                aChessBoard[pX][pY].setPosition(7, 2);
                                aChessBoard[pX][pY].setHasMoved();
                                selectedPiece.setPosition(8, 2);
                                selectedPiece.setHasMoved();
                                aChessBoard[8][2] = selectedPiece;
                                aChessBoard[7][2] = aChessBoard[pX][pY];
                            } else {
                                aChessBoard[pX][pY].setPosition(7, 9);
                                aChessBoard[pX][pY].setHasMoved();
                                selectedPiece.setPosition(8, 9);
                                selectedPiece.setHasMoved();
                                aChessBoard[8][9] = selectedPiece;
                                aChessBoard[7][9] = aChessBoard[pX][pY];
                            }
                        }
                        aChessBoard[pX][pY] = null;
                        selectedPiece = null;
                        wCheck = false;
                        bCheck = false;
                        whiteTurn = !whiteTurn;
                        return;
                    }
                }
                aChessBoard[selectedPiece.getX()][selectedPiece.getY()] = null;
                aChessBoard[pX][pY] = selectedPiece;
                selectedPiece.setPosition(pX, pY);
                selectedPiece.setHasMoved();
                // Check promotion
                if (selectedPiece.getClass() == Pawn.class) {
                    if ((whiteTurn && selectedPiece.getY() == 9) ||
                    (!whiteTurn && selectedPiece.getY() == 2)) {
                        pieceToPromote = selectedPiece;
                        return;
                    }
                }
                selectedPiece = null;
                wCheck = false;
                bCheck = false;
                whiteTurn = !whiteTurn;
                scanCheck();
                if (scanGameOver()) {
                    findResult();
                }
            }
        }
    }

    private void scanCheck() {
        if (whiteTurn) {
            if (wKing.isInCheck(aChessBoard)) {
                System.out.println("White King in Check");
                wCheck = true;
            }
        } else {
            if (bKing.isInCheck(aChessBoard)) {
                System.out.println("Black King in Check");
                bCheck = true;
            }
        }
    }

    private boolean scanGameOver() {
        if (whiteTurn) {
            for (Piece piece : whitesPieces) {
                piece.generatePossibleMoves(aChessBoard);
                int[][] legalMoves = piece.getLegalMoves();
                for (int j = 2; j < 10; j++) {
                    for (int i = 2; i < 10; i++) {
                        if (legalMoves[i][j] > 0 && legalMoves[i][j] < 7) {
                            return false;
                        }
                    }
                }
            }
        } else {
            for (Piece piece : blacksPieces) {
                piece.generatePossibleMoves(aChessBoard);
                int[][] legalMoves = piece.getLegalMoves();
                for (int j = 2; j < 10; j++) {
                    for (int i = 2; i < 10; i++) {
                        if (legalMoves[i][j] > 0 && legalMoves[i][j] < 7) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void findResult() {
        if (wCheck) {
            aResult = "Black Wins";
        } else if (bCheck) {
            aResult = "White Wins";
        } else {
            aResult = "Stalemate";
        }
    }

    public void setPiecePromoteTo(Piece pPiece) {
        aChessBoard[pieceToPromote.getX()][pieceToPromote.getY()] = pPiece;
        pPiece.setPosition(pieceToPromote.getX(), pieceToPromote.getY());
        pPiece.setHasMoved();
        if (pieceToPromote.getColor()) {
            whitesPieces.remove(pieceToPromote);
            whitesPieces.add(pPiece);
        } else {
            blacksPieces.remove(pieceToPromote);
            blacksPieces.add(pPiece);
        }
        selectedPiece = null;
        pieceToPromote = null;
        wCheck = false;
        bCheck = false;
        whiteTurn = !whiteTurn;
        scanCheck();
        if (scanGameOver()) {
            findResult();
        }
    }

    public boolean getWhiteTurn() {
        return whiteTurn;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public String getResult() {
        return aResult;
    }

    public Piece getPiece(int pX, int pY) {
        return aChessBoard[pX][pY];
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public Piece getPieceToPromote() {
        return pieceToPromote;
    }
    
    public List<Piece> getWhitesPieces() {
        return Collections.unmodifiableList(whitesPieces);
    }

    public List<Piece> getBlacksPieces() {
        return Collections.unmodifiableList(blacksPieces);
    }

    public List<Piece> getAllPieces() {
        List<Piece> allPieces = new ArrayList<>();
        allPieces.addAll(whitesPieces);
        allPieces.addAll(blacksPieces);
        return Collections.unmodifiableList(allPieces);
    }

    public List<Piece> getWhitesCaptures() {
        return Collections.unmodifiableList(whitesCaptures);
    }

    public List<Piece> getBlacksCaptures() {
        return Collections.unmodifiableList(blacksCaptures);
    }
}
