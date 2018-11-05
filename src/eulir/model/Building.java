package eulir.model;

import java.util.Arrays;
import java.util.Stack;

public class Building {
	private Elevator[] build;
	private int floors;
	private Stack<Integer> request;

	public Building(int numOfElevators, int numOfFloors) {
		build = new Elevator[numOfElevators];
		floors = numOfFloors;
		Arrays.setAll(build, Elevator::new);
		request = new Stack<>();
	}

	public void outsideRequest(int floorNum) {
		if (floorNum <= floors && floorNum >= 1)
			request.push(floorNum);
		else
			throw new IllegalArgumentException("floor not available");
	}


}
