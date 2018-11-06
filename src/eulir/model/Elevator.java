package eulir.model;

import java.text.MessageFormat;

public class Elevator {
	private int ID;
	private int currentFloor;
	private int direction;
	private boolean status;
	private boolean occupied;
	//private int insideOrder;
	private int numOfFloor;

	static int DIRECTION_STAY = 2;
	static int DIRECTION_UP = 1;
	static int DIRECTION_DOWN = 0;

	static boolean OCCUPIED = true;
	static boolean UNOCCUPIED = false;

	static int INSIDE = 1;
	static int OUTSIDE = 0;

	public Elevator(int ID, int numOfFloor) {
		currentFloor = 1;
		this.ID = ID;
		direction = DIRECTION_STAY;
		status = false;
		this.numOfFloor = numOfFloor;
		occupied = UNOCCUPIED;
	}

	private void order(int floor, int orderDirection) {
		if (floor > currentFloor) {
			System.out.println(MessageFormat.format("The elevator{0} has gone upstair from {1} floor to {2} floor by an {3}", this.ID, currentFloor, floor, orderDirection == 1 ? "inside call" : "outside call"));
			direction = DIRECTION_UP;
			status = false;
			currentFloor = floor;
		} else if (floor < currentFloor) {
			System.out.println(MessageFormat.format("The elevator{0} has gone downstair from {1} floor to {2} floor by an {3}", this.ID, currentFloor, floor, orderDirection == 1 ? "inside call" : "outside call"));
			direction = DIRECTION_DOWN;
			status = false;
			currentFloor = floor;
		} else {
			System.out.println(MessageFormat.format("The elevator{0} has been held at {1} floor by an {2}", this.ID, currentFloor, orderDirection == 1 ? "inside call" : "outside call"));
			direction = DIRECTION_STAY;
			status = true;
		}
	}

	public void setInsideOrder(int floor) {
		occupied = OCCUPIED;
		order(floor, INSIDE);
		occupied = UNOCCUPIED;
	}

	public void setOutsideOrder(int floor) {
		occupied = OCCUPIED;
		order(floor, OUTSIDE);
		occupied = UNOCCUPIED;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}
}
