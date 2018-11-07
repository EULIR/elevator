package eulir.model;

import java.text.MessageFormat;
import java.util.stream.IntStream;

public class Building {
	private Elevator[] build;
	private int floors;

	public Building(int numOfElevators, int numOfFloors) {
		build = new Elevator[numOfElevators];
		floors = numOfFloors;
		IntStream.range(0, numOfElevators).forEach(i -> build[i] = new Elevator(i, numOfFloors));
	}

	public void outsideRequest(int floorNum, int destination) {
		if (floorNum <= floors && floorNum >= 1)
			request(floorNum, destination);
		else
			throw new IllegalArgumentException("floor not available");
	}

	private void request(int floorNum, int destination) {
		int idOfElevator = Algorithm.chooseElevator(this.build, floorNum);
		build[idOfElevator].setOutsideOrder(floorNum);
		build[idOfElevator].setInsideOrder(destination);
	}

	public int numOfElevator() {
		return build.length;
	}

	public Elevator orderElevator(int idOfElevator) {
		if (idOfElevator >= 0 && idOfElevator <= build.length)
			return build[idOfElevator];
		throw new IllegalArgumentException("elevator not available");
	}

	public void log() {
		System.out.println();
		for (Elevator aBuild : build) {
			System.out.println(MessageFormat.format("Elevator {0} is currently at {1} floor.", aBuild.getID(), aBuild.getCurrentFloor()));
		}
		System.out.println();
	}
}
