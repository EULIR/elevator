package eulir.algorithm;

import eulir.model.Elevator;

public class NearestElevatorSolution {
	//Time complexity: O(n)
	public static int chooseElevator(Elevator[] elevatorStatus, int targetFloor) {
		int targetElevator = elevatorStatus[0].getID();
		int difference = Integer.MAX_VALUE;
		for (Elevator elevator : elevatorStatus) {
			int differ = Math.abs(targetFloor - elevator.getCurrentFloor());
			if (differ < difference) {
				difference = differ;
				targetElevator = elevator.getID();
			}
		}
		return targetElevator;
	}
}
