package eulir.test;

import eulir.model.Building;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import static eulir.model.Building.GOINGDOWN;
import static eulir.model.Building.GOINGUP;

public class Test {
	public static void main(String[] args) {
		final int numOfElevator = 6;
		final int numOfFloor = 25;
		Building apartmentA = new Building(numOfElevator, numOfFloor);
		apartmentA.log();
		for (int i = 0; i < 10; i++) {
			int current = (int) (Math.random() * numOfFloor) + 1;
			System.out.println(current + " floor calls");
			int targetNum = (int) (Math.random() * (numOfFloor - 1)) + 1;
			HashSet<Integer> floor = new HashSet<>();
			for (int j = 0; j < targetNum; j++) {
				floor.add((int) (Math.random() * numOfFloor) + 1);
			}
			int target[] = new int[floor.size()];
			Iterator iterator = floor.iterator();
			int j = 0;
			while (iterator.hasNext()) {
				target[j] = (int) iterator.next();
				j++;
			}
			int direction = Math.random() > 0.5 ? GOINGUP : GOINGDOWN;
			System.out.println("to " + Arrays.toString(target) + " floor. Going " + (direction == GOINGUP ? "up" : "down"));
			apartmentA.outsideRequest(current, target, direction);
			apartmentA.log();
		}
	}
}
