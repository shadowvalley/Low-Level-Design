package models;

public abstract class PlayingPiece {
    PieceType pieceType;

    public PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
