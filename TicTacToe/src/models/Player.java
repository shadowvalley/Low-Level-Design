package models;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class Player {
    public String name;
    PieceType pieceType;
}
