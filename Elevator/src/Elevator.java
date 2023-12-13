import Request.Direction;
import Request.Request;
import Request.Location;

import java.util.PriorityQueue;

/**
 * Elevator class
 * */
public class Elevator {
    int currentFloor;
    Direction direction;
    PriorityQueue<Request> upRequests;  // Min-Heap
    PriorityQueue<Request> downRequests; // Max-Heap

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;
        this.direction = Direction.IDLE;
        upRequests = new PriorityQueue<>((a,b) -> a.desiredFloor - b.desiredFloor);
        downRequests = new PriorityQueue<>((a,b) -> b.desiredFloor - a.desiredFloor);
    }

    // Add UP request to the queue
    public void addUpRequestsToQueue(Request upRequest) {
        if (upRequest.elevatorState == Location.OUTSIDE) {
            upRequests.offer(new Request(
                    upRequest.currentFloor,
                    upRequest.currentFloor,
                    Location.OUTSIDE,
                    Direction.UP
            ));
            System.out.printf("UP request => Current Floor -> %d and Desired Floor -> %d from Location -> %s",
                    upRequest.currentFloor, upRequest.desiredFloor, upRequest.elevatorState.toString());
        }
        upRequests.offer(upRequest);
        System.out.printf("UP request => Current Floor -> %d and Desired Floor -> %d from Location -> %s",
                upRequest.currentFloor, upRequest.desiredFloor, upRequest.elevatorState.toString());
    }
}
