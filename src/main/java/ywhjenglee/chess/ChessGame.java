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

public class ChessGame {
    
    private static final boolean WHITE = true;
    private static final boolean BLACK = false;
    private static Tile[][] chessBoard;
    private static Piece selectedPiece;
    private static Tile selectedTile;
    private static int turnCount;
    private static boolean whiteTurn;
    private static King wKing;
    private static King bKing;
    private static List<Piece> whitesPieces;
    private static List<Piece> blacksPieces;
    private static List<Piece> allPieces;
    private static List<Piece> whitesCaptures;
    private static List<Piece> blacksCaptures;
    private static boolean wCheck = false;
    private static boolean bCheck = false;

    public ChessGame() {
        chessBoard = new Tile[12][12];
        selectedPiece = null;
        turnCount = 0;
        whiteTurn = true;
        whitesPieces = new ArrayList<>();
        blacksPieces = new ArrayList<>();
        allPieces = new ArrayList<>();
        whitesCaptures = new ArrayList<>();
        blacksCaptures = new ArrayList<>();
        createTiles();
        setPieces();
    }

    private static void createTiles() {
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 12; i++) {
                chessBoard[i][j] = new Tile(i, j);
            }
        }
    }

    private static void setPieces() {
        for (int i = 2; i < 10; i++) {
            Piece wPawn = new Pawn(WHITE, i, 3);
            chessBoard[i][3].setPiece(wPawn);
            Piece bPawn = new Pawn(BLACK, i, 8);
            chessBoard[i][8].setPiece(bPawn);
            whitesPieces.add(wPawn);
            blacksPieces.add(bPawn);
        }
        Piece wRook1 = new Rook(WHITE, 2, 2);
        chessBoard[2][2].setPiece(wRook1);
        Piece wKnight1 = new Knight(WHITE, 3, 2);
        chessBoard[3][2].setPiece(wKnight1);
        Piece wBishop1 = new Bishop(WHITE, 4, 2);
        chessBoard[4][2].setPiece(wBishop1);
        Piece wQueen = new Queen(WHITE, 5, 2);
        chessBoard[5][2].setPiece(wQueen);
        wKing = new King(WHITE, 6, 2);
        chessBoard[6][2].setPiece(wKing);
        Piece wBishop2 = new Bishop(WHITE, 7, 2);
        chessBoard[7][2].setPiece(wBishop2);
        Piece wKnight2 = new Knight(WHITE, 8, 2);
        chessBoard[8][2].setPiece(wKnight2);
        Piece wRook2 = new Rook(WHITE, 9, 2);
        chessBoard[9][2].setPiece(wRook2);
        whitesPieces.add(wRook1);
        whitesPieces.add(wKnight1);
        whitesPieces.add(wBishop1);
        whitesPieces.add(wQueen);
        whitesPieces.add(wKing);
        whitesPieces.add(wBishop2);
        whitesPieces.add(wKnight2);
        whitesPieces.add(wRook2);

        Piece bRook1 = new Rook(BLACK, 2, 9);
        chessBoard[2][9].setPiece(bRook1);
        Piece bKnight1 = new Knight(BLACK, 3, 9);
        chessBoard[3][9].setPiece(bKnight1);
        Piece bBishop1 = new Bishop(BLACK, 4, 9);
        chessBoard[4][9].setPiece(bBishop1);
        Piece bQueen = new Queen(BLACK, 5, 9);
        chessBoard[5][9].setPiece(bQueen);
        bKing = new King(BLACK, 6, 9);
        chessBoard[6][9].setPiece(bKing);
        Piece bBishop2 = new Bishop(BLACK, 7, 9);
        chessBoard[7][9].setPiece(bBishop2);
        Piece bKnight2 = new Knight(BLACK, 8, 9);
        chessBoard[8][9].setPiece(bKnight2);
        Piece bRook2 = new Rook(BLACK, 9, 9);
        chessBoard[9][9].setPiece(bRook2);
        blacksPieces.add(bRook1);
        blacksPieces.add(bKnight1);
        blacksPieces.add(bBishop1);
        blacksPieces.add(bQueen);
        blacksPieces.add(bKing);
        blacksPieces.add(bBishop2);
        blacksPieces.add(bKnight2);
        blacksPieces.add(bRook2);

        allPieces.addAll(whitesPieces);
        allPieces.addAll(blacksPieces);
    }

    public static void selectPiece(Piece pPiece) {
        if (pPiece.getColor() == whiteTurn) {
            selectedPiece = pPiece;
            selectedTile = chessBoard[pPiece.getX()][pPiece.getY()];
        }
    }

    public static boolean[][] getSelectedLegalMoves() {
        if (selectedPiece != null) {
            selectedPiece.generatePossibleMoves(chessBoard);
            return selectedPiece.getLegalMoves();
        }
        return new boolean[12][12];
    }

    public void movePiece(int pX, int pY) {
        if (selectedPiece != null) {
            boolean[][] legalMoves = selectedPiece.getLegalMoves();
            if (legalMoves[pX][pY]) {
                if (selectedTile.getTileX() != pX && selectedTile.getTileY() != pY) {
                    if (chessBoard[pX][pY].getPiece() != null) {
                        if (whiteTurn) {
                            whitesCaptures.add(chessBoard[pX][pY].getPiece());
                            blacksPieces.remove(chessBoard[pX][pY].getPiece());
                        } else {
                            blacksCaptures.add(chessBoard[pX][pY].getPiece());
                            whitesPieces.remove(chessBoard[pX][pY].getPiece());
                        }
                    }
                    chessBoard[pX][pY].setPiece(selectedPiece);
                    selectedPiece.setPosition(pX, pY);
                    selectedPiece.setHasMoved();
                    selectedTile.removePiece();
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
            if (bKing.isInCheck(chessBoard, bKing.getX(), bKing.getY())) {
                System.out.println("Black King in Check");
                bCheck = true;
            }
        } else {
            if (wKing.isInCheck(chessBoard, wKing.getX(), wKing.getY())) {
                System.out.println("White King in Check");
                wCheck = true;
            }
        }
    }

    private boolean scanGameOver() {
        if (whiteTurn) {
            for (Piece piece : whitesPieces) {
                piece.generatePossibleMoves(chessBoard);
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
                piece.generatePossibleMoves(chessBoard);
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
            System.out.println("Black Wins");
        } else if (bCheck) {
            System.out.println("White Wins");
        } else {
            System.out.println("Stalemate");
        }
    }

    public int getTurnCount() {
        return turnCount;
    }

    public static Tile getTile(int pX, int pY) {
        return chessBoard[pX][pY];
    }

    public static Piece getSelectedPiece() {
        return selectedPiece;
    }

    public List<Piece> getWhitesPieces() {
        return Collections.unmodifiableList(whitesPieces);
    }

    public List<Piece> getBlacksPieces() {
        return Collections.unmodifiableList(blacksPieces);
    }

    public List<Piece> getAllPieces() {
        return Collections.unmodifiableList(allPieces);
    }

    public List<Piece> getWhitesCaptures() {
        return Collections.unmodifiableList(whitesCaptures);
    }

    public List<Piece> getBlacksCaptures() {
        return Collections.unmodifiableList(blacksCaptures);
    }
}
