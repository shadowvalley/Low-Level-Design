package Request;

/**
 * Elevator Request Class
 * */

public class Request {
    public int currentFloor;
    public int desiredFloor;
    public Location elevatorState;
    public Direction elevatorDirection;

    public Request(int currentFloor, int desiredFloor, Location location, Direction direction) {
        this.currentFloor = currentFloor;
        this.desiredFloor = desiredFloor;
        this.elevatorState = location;
        this.elevatorDirection = direction;
    }
}
