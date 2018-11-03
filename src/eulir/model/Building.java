package eulir.model;

import java.util.Arrays;

public class Building {
	Elevator[] build;
	Floor[] floors;

	public Building(int numOfElevators, int numOfFloors) {
		build = new Elevator[numOfElevators];
		floors = new Floor[numOfFloors];
		Arrays.setAll(floors, i -> new Floor(i + 1));

	}
}
