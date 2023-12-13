import Request.Direction;
import Request.Location;
import Request.Request;

public class Main {
    public static void main(String[] args) {
        System.out.println("Mini Elevator!");

        // Step - 1: Create an elevator
        Elevator elevator = new Elevator(0);

        // Generate UP requests for the elevator class
        Request u1 = new Request(elevator.currentFloor, 3, Location.INSIDE, Direction.UP);
        Request u2 = new Request(elevator.currentFloor, 6, Location.INSIDE, Direction.UP);
        Request u3 = new Request(4, 7, Location.OUTSIDE, Direction.UP);

        // Add UP requests to the queue
        elevator.addUpRequestsToQueue(u1);
        elevator.addUpRequestsToQueue(u2);
        elevator.addUpRequestsToQueue(u3);

        // Generate DOWN requests for the elevator class
        Request d1 = new Request(elevator.currentFloor, 4, Location.INSIDE, Direction.DOWN);
        Request d2 = new Request(elevator.currentFloor, 1, Location.INSIDE, Direction.DOWN);
        Request d3 = new Request(4, 2, Location.OUTSIDE, Direction.DOWN);

        // Add DOWN requests to the queue
        elevator.addDownRequestsToQueue(d1);
        elevator.addDownRequestsToQueue(d2);
        elevator.addDownRequestsToQueue(d3);
    }
}