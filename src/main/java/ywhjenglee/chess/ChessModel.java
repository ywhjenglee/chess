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
        aChessBoard = new Piece[8][8];
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
        for (int i = 0; i < 8; i++) {
            Piece wPawn = new Pawn(true, i, 1);
            aChessBoard[i][1] = wPawn;
            Piece bPawn = new Pawn(false, i, 6);
            aChessBoard[i][6] = bPawn;
            whitesPieces.add(wPawn);
            blacksPieces.add(bPawn);
        }
        Piece wRook1 = new Rook(true, 0, 0);
        aChessBoard[0][0] = wRook1;
        Piece wKnight1 = new Knight(true, 1, 0);
        aChessBoard[1][0] = wKnight1;
        Piece wBishop1 = new Bishop(true, 2, 0);
        aChessBoard[2][0] = wBishop1;
        Piece wQueen = new Queen(true, 3, 0);
        aChessBoard[3][0] = wQueen;
        wKing = new King(true, 4, 0);
        aChessBoard[4][0] = wKing;
        Piece wBishop2 = new Bishop(true, 5, 0);
        aChessBoard[5][0] = wBishop2;
        Piece wKnight2 = new Knight(true, 6, 0);
        aChessBoard[6][0] = wKnight2;
        Piece wRook2 = new Rook(true, 7, 0);
        aChessBoard[7][0] = wRook2;
        whitesPieces.add(wRook1);
        whitesPieces.add(wKnight1);
        whitesPieces.add(wBishop1);
        whitesPieces.add(wQueen);
        whitesPieces.add(wKing);
        whitesPieces.add(wBishop2);
        whitesPieces.add(wKnight2);
        whitesPieces.add(wRook2);

        Piece bRook1 = new Rook(false, 0, 7);
        aChessBoard[0][7] = bRook1;
        Piece bKnight1 = new Knight(false, 1, 7);
        aChessBoard[1][7] = bKnight1;
        Piece bBishop1 = new Bishop(false, 2, 7);
        aChessBoard[2][7] = bBishop1;
        Piece bQueen = new Queen(false, 3, 7);
        aChessBoard[3][7]= bQueen;
        bKing = new King(false, 4, 7);
        aChessBoard[4][7] = bKing;
        Piece bBishop2 = new Bishop(false, 5, 7);
        aChessBoard[5][7] = bBishop2;
        Piece bKnight2 = new Knight(false, 6, 7);
        aChessBoard[6][7] = bKnight2;
        Piece bRook2 = new Rook(false, 7, 7);
        aChessBoard[7][7] = bRook2;
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

    public boolean[][] getSelectedLegalMoves() {
        if (selectedPiece != null) {
            return selectedPiece.getLegalMoves();
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
        Piece[][] paddedChessBoard = new Piece[12][12];
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                paddedChessBoard[i+2][j+2] = aChessBoard[i][j];
            }
        }
        if (whiteTurn) {
            if (bKing.isInCheck(paddedChessBoard)) {
                System.out.println("Black King in Check");
                bCheck = true;
            }
        } else {
            if (wKing.isInCheck(paddedChessBoard)) {
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
                for (int j = 0; j < 8; j++) {
                    for (int i = 0; i < 8; i++) {
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
                for (int j = 0; j < 8; j++) {
                    for (int i = 0; i < 8; i++) {
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
