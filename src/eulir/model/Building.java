package eulir.model;

import java.util.stream.IntStream;

public class Building {
	private Elevator[] build;
	private int floors;

	public Building(int numOfElevators, int numOfFloors) {
		build = new Elevator[numOfElevators];
		floors = numOfFloors;
		IntStream.range(0, numOfElevators).forEach(i -> build[i] = new Elevator(i, numOfFloors));
	}

	public void outsideRequest(int floorNum) {
		if (floorNum <= floors && floorNum >= 1)
			request(floorNum);
		else
			throw new IllegalArgumentException("floor not available");
	}

	public void request(int floorNum) {
		int[] currentFloor = new int[build.length];
		for (int i = 0; i < currentFloor.length; i++) {
			currentFloor[i] = build[i].getCurrentFloor();
		}
		int idOfElevator = Algorithm.chooseElevator(currentFloor, floorNum);
		build[idOfElevator].setOutsideOrder(floorNum);
	}

	public int numOfElevator() {
		return build.length;
	}

	public Elevator orderElevator(int idOfElevator) {
		if (idOfElevator >= 0 && idOfElevator <= build.length)
			return build[idOfElevator];
		throw new IllegalArgumentException("elevator not available");
	}
}
