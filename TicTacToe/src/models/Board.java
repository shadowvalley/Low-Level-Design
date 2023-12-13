package models;

public class Board {
    public int size;

    // Board <has> pieces.
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }
}
