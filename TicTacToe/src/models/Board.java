package models;

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
}
