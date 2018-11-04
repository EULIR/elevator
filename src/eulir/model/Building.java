package eulir.model;

import java.util.Arrays;

public class Building {
	private Elevator[] build;
	private Floor[] floors;

	public Building(int numOfElevators, int numOfFloors) {
		build = new Elevator[numOfElevators];
		floors = new Floor[numOfFloors];
		Arrays.setAll(floors, i -> new Floor(i + 1));
		Arrays.setAll(build, Elevator::new);
	}

}
