package eulir.test;

import eulir.model.Building;

import static eulir.model.Building.GOINGUP;

public class Test {
	public static void main(String[] args) {
		final int numOfElevator = 2;
		final int numOfFloor = 11;
		Building apartmentA = new Building(numOfElevator, numOfFloor);
		apartmentA.log();
		for (int i = 0; i < 10; i++) {
			int current = (int) (Math.random() * numOfFloor) + 1;
			System.out.println(current + " floor calls");
			int target = (int) (Math.random() * numOfFloor) + 1;
			System.out.println("to " + target + " floor");
			//apartmentA.outsideRequest(current, target, GOINGUP);
			apartmentA.log();
		}
	}
}
