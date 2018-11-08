package eulir.model;

import java.text.MessageFormat;
import java.util.Arrays;

import static eulir.model.Building.GOINGDOWN;
import static eulir.model.Building.GOINGUP;

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
			System.out.println(MessageFormat.format("The elevator {0} has gone upstair from {1} floor to {2} floor by an {3}", this.ID, currentFloor, floor, orderDirection == 1 ? "inside call" : "outside call"));
			direction = DIRECTION_UP;
			status = false;
			currentFloor = floor;
		} else if (floor < currentFloor) {
			System.out.println(MessageFormat.format("The elevator {0} has gone downstair from {1} floor to {2} floor by an {3}", this.ID, currentFloor, floor, orderDirection == 1 ? "inside call" : "outside call"));
			direction = DIRECTION_DOWN;
			status = false;
			currentFloor = floor;
		} else {
			System.out.println(MessageFormat.format("The elevator {0} has been held at {1} floor by an {2}", this.ID, currentFloor, orderDirection == 1 ? "inside call" : "outside call"));
			direction = DIRECTION_STAY;
			status = true;
		}
	}

	public void setInsideOrder(int[] floor, int direction) {
		occupied = OCCUPIED;
		Arrays.sort(floor);
		int index = floor.length;
		for (int i = 0; i < floor.length; i++) {
			if (floor[i] > currentFloor) {
				index = i;
				break;
			}
		}
		int[] down = new int[index];
		int[] up = new int[floor.length - index];
		System.arraycopy(floor, 0, down, 0, index);
		System.arraycopy(floor, index, up, 0, floor.length - index);
		if (direction == GOINGUP) {
			for (int i = 0; i < up.length; i++) {
				order(up[i], INSIDE);
			}
			for (int i = down.length - 1; i >= 0; i--) {
				order(down[i], INSIDE);
			}
		} else if (direction == GOINGDOWN) {
			for (int i = down.length - 1; i >= 0; i--) {
				order(down[i], INSIDE);
			}
			for (int i = 0; i < up.length; i++) {
				order(up[i], INSIDE);
			}
		}
		occupied = UNOCCUPIED;
	}

	public void setOutsideOrder(int floor, int direction) {
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

	public int getID() {
		return this.ID;
	}
}
