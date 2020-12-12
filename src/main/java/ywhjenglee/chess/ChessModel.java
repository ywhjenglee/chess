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

public class ChessModel {

    private Piece[][] aChessBoard;
    private List<Piece> whitesPieces;
    private List<Piece> blacksPieces;
    private List<Piece> whitesCaptures;
    private List<Piece> blacksCaptures;

    private boolean whiteTurn;
    private int turnCount;
    private Piece selectedPiece;

    private King wKing;
    private King bKing;
    private boolean wCheck = false;
    private boolean bCheck = false;

    public ChessModel() {
        aChessBoard = new Piece[12][12];
        whitesPieces = new ArrayList<>();
        blacksPieces = new ArrayList<>();
        whitesCaptures = new ArrayList<>();
        blacksCaptures = new ArrayList<>();

        whiteTurn = true;
        turnCount = 0;
        selectedPiece = null;
        setPieces();
    }

    private void setPieces() {
        for (int i = 2; i < 10; i++) {
            Piece wPawn = new Pawn(true, i, 3);
            aChessBoard[i][3] = wPawn;
            Piece bPawn = new Pawn(false, i, 8);
            aChessBoard[i][8] = bPawn;
            whitesPieces.add(wPawn);
            blacksPieces.add(bPawn);
        }
        Piece wRook1 = new Rook(true, 2, 2);
        aChessBoard[2][2] = wRook1;
        Piece wKnight1 = new Knight(true, 3, 2);
        aChessBoard[3][2] = wKnight1;
        Piece wBishop1 = new Bishop(true, 4, 2);
        aChessBoard[4][2] = wBishop1;
        Piece wQueen = new Queen(true, 5, 2);
        aChessBoard[5][2] = wQueen;
        wKing = new King(true, 6, 2);
        aChessBoard[6][2] = wKing;
        Piece wBishop2 = new Bishop(true, 7, 2);
        aChessBoard[7][2] = wBishop2;
        Piece wKnight2 = new Knight(true, 8, 2);
        aChessBoard[8][2] = wKnight2;
        Piece wRook2 = new Rook(true, 9, 2);
        aChessBoard[9][2] = wRook2;
        whitesPieces.add(wRook1);
        whitesPieces.add(wKnight1);
        whitesPieces.add(wBishop1);
        whitesPieces.add(wQueen);
        whitesPieces.add(wKing);
        whitesPieces.add(wBishop2);
        whitesPieces.add(wKnight2);
        whitesPieces.add(wRook2);

        Piece bRook1 = new Rook(false, 2, 9);
        aChessBoard[2][9] = bRook1;
        Piece bKnight1 = new Knight(false, 3, 9);
        aChessBoard[3][9] = bKnight1;
        Piece bBishop1 = new Bishop(false, 4, 9);
        aChessBoard[4][9] = bBishop1;
        Piece bQueen = new Queen(false, 5, 9);
        aChessBoard[5][9]= bQueen;
        bKing = new King(false, 6, 9);
        aChessBoard[6][9] = bKing;
        Piece bBishop2 = new Bishop(false, 7, 9);
        aChessBoard[7][9] = bBishop2;
        Piece bKnight2 = new Knight(false, 8, 9);
        aChessBoard[8][9] = bKnight2;
        Piece bRook2 = new Rook(false, 9, 9);
        aChessBoard[9][9] = bRook2;
        blacksPieces.add(bRook1);
        blacksPieces.add(bKnight1);
        blacksPieces.add(bBishop1);
        blacksPieces.add(bQueen);
        blacksPieces.add(bKing);
        blacksPieces.add(bBishop2);
        blacksPieces.add(bKnight2);
        blacksPieces.add(bRook2);
    }

    public void selectPiece(Piece pPiece) {
        if (pPiece.getColor() == whiteTurn) {
            selectedPiece = pPiece;
            selectedPiece.generatePossibleMoves(aChessBoard);
        }
    }

    public boolean[][] getVisibleSelectedLegalMoves() {
        if (selectedPiece != null) {
            boolean[][] aVisibleLegalMoves = new boolean[8][8];
            for (int j = 2; j < 10; j++) {
                for (int i = 2; i < 10; i++) {
                    aVisibleLegalMoves[i-2][j-2] = selectedPiece.getLegalMoves()[i][j];
                }
            }
            return aVisibleLegalMoves;
        }
        return new boolean[8][8];
    }

    public void movePiece(int pX, int pY) {
        if (selectedPiece != null) {
            boolean[][] legalMoves = selectedPiece.getLegalMoves();
            if (legalMoves[pX][pY]) {
                if (selectedPiece.getX() != pX || selectedPiece.getY() != pY) {
                    if (aChessBoard[pX][pY] != null) {
                        if (whiteTurn) {
                            whitesCaptures.add(aChessBoard[pX][pY]);
                            blacksPieces.remove(aChessBoard[pX][pY]);
                        } else {
                            blacksCaptures.add(aChessBoard[pX][pY]);
                            whitesPieces.remove(aChessBoard[pX][pY]);
                        }
                    }
                    aChessBoard[selectedPiece.getX()][selectedPiece.getY()] = null;
                    aChessBoard[pX][pY] = selectedPiece;
                    selectedPiece.setPosition(pX, pY);
                    selectedPiece.setHasMoved();
                    wCheck = false;
                    bCheck = false;
                    scanCheck();
                    if (scanGameOver()) {
                        getResult();
                    }
                    whiteTurn = !whiteTurn;
                    turnCount++;
                }
                selectedPiece = null;
            }
        }
    }

    private void scanCheck() {
        if (whiteTurn) {
            if (bKing.isInCheck(aChessBoard)) {
                System.out.println("Black King in Check");
                bCheck = true;
            }
        } else {
            if (wKing.isInCheck(aChessBoard)) {
                System.out.println("White King in Check");
                wCheck = true;
            }
        }
    }

    private boolean scanGameOver() {
        if (whiteTurn) {
            for (Piece piece : whitesPieces) {
                piece.generatePossibleMoves(aChessBoard);
                boolean[][] legalMoves = piece.getLegalMoves();
                for (int j = 2; j < 10; j++) {
                    for (int i = 2; i < 10; i++) {
                        if (legalMoves[i][j]) {
                            return false;
                        }
                    }
                }
            }
        } else {
            for (Piece piece : blacksPieces) {
                piece.generatePossibleMoves(aChessBoard);
                boolean[][] legalMoves = piece.getLegalMoves();
                for (int j = 2; j < 10; j++) {
                    for (int i = 2; i < 10; i++) {
                        if (legalMoves[i][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void getResult() {
        if (wCheck) {
            System.out.println("false Wins");
        } else if (bCheck) {
            System.out.println("true Wins");
        } else {
            System.out.println("Stalemate");
        }
    }

    public int getTurnCount() {
        return turnCount;
    }

    public Piece getPiece(int pX, int pY) {
        return aChessBoard[pX][pY];
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
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
