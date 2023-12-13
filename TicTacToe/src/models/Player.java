package models;

import lombok.*;

@AllArgsConstructor
@Value
public class Player {
    public String name;
    public PlayingPiece playingPiece;
}
