package eulir.model;

import eulir.algorithm.NearestElevatorSolution;
import eulir.algorithm.RandomSolution;

public class Algorithm {
	private static int solution = 1;

	private final static int NEAREST_ELEVATOR_SOLUTION = 0;
	private final static int RANDOM_SOLUTION = 1;

	//TODO: different algorithms to implement best elevator choices
	public static int chooseElevator(Elevator[] elevatorStatus, int targetFloor) {
		int answer;
		switch (solution) {
			case NEAREST_ELEVATOR_SOLUTION:
				answer = NearestElevatorSolution.chooseElevator(elevatorStatus, targetFloor);
				break;
			case RANDOM_SOLUTION:
				answer = RandomSolution.chooseElevator(elevatorStatus, targetFloor);
				break;
			default:
				answer = 0;
				break;
		}
		return answer;
	}
}
