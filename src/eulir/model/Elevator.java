package eulir.model;

import java.text.MessageFormat;

public class Elevator {
	private int ID;
	private int currentFloor = 1;
	private int direction;
	private boolean status;
	private boolean occupied;
	//private int insideOrder;

	static int DIRECTION_STAY = 2;
	static int DIRECTION_UP = 1;
	static int DIRECTION_DOWN = 0;

	static boolean OCCUPIED = true;
	static boolean UNOCCUPIED = false;

	static int INSIDE = 1;
	static int OUTSIDE = 0;

	public Elevator(int ID) {
		this.ID = ID;
		direction = DIRECTION_STAY;
		status = false;
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
		order(floor, INSIDE);
	}

	public void setOutsideOrder(int floor) {
		order(floor, OUTSIDE);
	}
}
