package eulir.model;

import eulir.algorithm.NearestElevatorSolution;

public class Algorithm {
	//TODO: different algorithms to implement best elevator choices
	public static int chooseElevator(Elevator[] elevatorStatus, int targetFloor) {
		return NearestElevatorSolution.chooseElevator(elevatorStatus, targetFloor);
	}
}
