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

    // Add DOWN request to the queue
    public void addDownRequestsToQueue(Request downRequest) {
        if (downRequest.elevatorState == Location.OUTSIDE) {
            downRequests.offer(new Request(
                    downRequest.currentFloor,
                    downRequest.currentFloor,
                    Location.OUTSIDE,
                    Direction.DOWN
            ));
            System.out.printf("DOWN request => Current Floor -> %d and Desired Floor -> %d from Location -> %s",
                    downRequest.currentFloor, downRequest.desiredFloor, downRequest.elevatorState.toString());
        }
        downRequests.offer(downRequest);
        System.out.printf("DOWN request => Current Floor -> %d and Desired Floor -> %d from Location -> %s",
                downRequest.currentFloor, downRequest.desiredFloor, downRequest.elevatorState.toString());
    }

    // Process all the UP requests
    private void processUpRequest() {
        while(!upRequests.isEmpty()) {
            Request req = upRequests.poll();
            this.currentFloor = req.desiredFloor; // SIMULATE GOING UP
            System.out.println("Processing up requests. Elevator stopped at floor " + this.currentFloor + ".");
        }

        // Change elevator direction to DOWN
        if(!downRequests.isEmpty()) {
            this.direction = Direction.DOWN;
        } else {
            this.direction = Direction.IDLE;
        }
    }

    // Process all the DOWN requests
    private void processDownRequest() {
        while(!downRequests.isEmpty()) {
            Request req = downRequests.poll();
            this.currentFloor = req.desiredFloor; // SIMULATE GOING DOWN
            System.out.println("Processing down requests. Elevator stopped at floor " + this.currentFloor + ".");
        }

        // Change elevator direction to UP
        if(!upRequests.isEmpty()) {
            this.direction = Direction.UP;
        } else {
            this.direction = Direction.IDLE;
        }
    }

    // Process Requests
    private void processRequests() {
        if(this.direction == Direction.UP || this.direction == Direction.IDLE) {
            processUpRequest();
            processDownRequest();
        } else {
            processDownRequest();
            processUpRequest();
        }
    }

    // Run all requests
    public void run() {
        while (!upRequests.isEmpty() || !downRequests.isEmpty()) {
            processRequests();
        }

        System.out.println("Finished all requests.");
        this.direction = Direction.IDLE;
    }
}
