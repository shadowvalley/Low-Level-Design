package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;

    // Board <has> pieces.
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    // 1. Add piece to Board
    boolean addPieceToBoard(int row, int col, PlayingPiece playingPiece) {
        if(board[row][col] != null) {
            return false;
        }
        board[row][col] = playingPiece;
        return true;
    }

    // 2. Print the piece
    void printBoard() {
        for(int i=0; i<size; i++) {
            for(int j=0;j<size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
        }
    }

    // 3. Find all free cells
    List<Pair<Integer, Integer>> getAllFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for(int i=0; i<size; i++) {
            for(int j=0;j<size; j++) {
                if(board[i][j] == null) {
                    freeCells.add(new Pair<>(i, j));
                }
            }
        }
        return freeCells;
    }
}
