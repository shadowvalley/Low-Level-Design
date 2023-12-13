package Request;

import lombok.AllArgsConstructor;

/**
 * Elevator Request Class
 * */

@AllArgsConstructor
public class Request {
    public int currentFloor;
    public int desiredFloor;
    public Location elevatorState;
    public Direction elevatorDirection;
}
