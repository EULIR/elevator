package eulir.model.arrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Arrangement {
	public static int[] theLift(final int[][] queues, final int capacity) {
		ArrayList<Integer> stop = new ArrayList<>();
		boolean direction = true;
		int floor = 0;
		stop.add(floor);
		ArrayList<Integer> lift = new ArrayList<>();
		while (!isEmpty(queues) || !lift.isEmpty()) {
			if (direction && floor == queues.length - 1)
				direction = false;
			else if (!direction && floor == 0)
				direction = true;
			if (lift.contains(floor)) {
				stop.add(floor);
				lift.removeAll(new ArrayList<>(Collections.singletonList(floor)));
			}
			ArrayList<Integer> newFloor = new ArrayList<>();
			for (int i = 0; i < queues[floor].length; i++) {
				int target = queues[floor][i];
				if (stop.get(stop.size() - 1) != floor && (target > floor) == direction)
					stop.add(floor);
				if (lift.size() < capacity && (target > floor) == direction)
					lift.add(target);
				else
					newFloor.add(target);
			}
			queues[floor] = newFloor.stream().mapToInt(i -> i).toArray();
			floor = (direction) ? floor + 1 : floor - 1;
		}
		floor = 0;
		if (stop.get(stop.size() - 1) != floor)
			stop.add(floor);
		return stop.stream().mapToInt(i -> i).toArray();
	}

	private static boolean isEmpty(int[][] queues) {
		return Arrays.stream(queues).noneMatch(queue -> queue.length != 0);
	}
}