package eulir.algorithm;

import eulir.model.Elevator;

public class RandomSolution {
	public static int chooseElevator(Elevator[] elevatorStatus, int targetFloor) {
		return (int) (Math.random() * elevatorStatus.length);
	}
}
