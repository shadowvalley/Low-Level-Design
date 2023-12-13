import Request.Direction;
import Request.Request;

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

}
