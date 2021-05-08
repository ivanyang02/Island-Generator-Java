package Map;

import java.util.Arrays;
import java.util.LinkedList;

public class MoistureMap {
	public static tileValues[][] GenerateMap(tileValues anArray[][], int d) {
		int[][] step = new int[d][d];
		LinkedList<Integer> horizontalqueue = new LinkedList<Integer>();
		LinkedList<Integer> verticalqueue = new LinkedList<Integer>();
		for (int r = 0; r < d; r++) {
			Arrays.fill(step[r], Integer.MAX_VALUE);
		}

		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				if (anArray[i][j].height <= 6) {
					horizontalqueue.add(j);
					verticalqueue.add(i);
					step[i][j] = 0;
				}
			}
		}
		while (!horizontalqueue.isEmpty() && !verticalqueue.isEmpty()) {
			int curx = horizontalqueue.poll();
			int cury = verticalqueue.poll();
			if (cury - 1 >= 0 && cury + 1 < d && curx - 1 >= 0 && curx + 1 < d) {
				if (step[cury - 1][curx] > step[cury][curx] + 1) {
					step[cury - 1][curx] = step[cury][curx] + 1;
					horizontalqueue.add(curx);
					verticalqueue.add(cury - 1);
				}
				if (step[cury + 1][curx] > step[cury][curx] + 1) {
					step[cury + 1][curx] = step[cury][curx] + 1;
					horizontalqueue.add(curx);
					verticalqueue.add(cury + 1);
				}
				if (step[cury][curx - 1] > step[cury][curx] + 1) {
					step[cury][curx - 1] = step[cury][curx] + 1;
					horizontalqueue.add(curx - 1);
					verticalqueue.add(cury);
				}
				if (step[cury][curx + 1] > step[cury][curx] + 1) {
					step[cury][curx + 1] = step[cury][curx] + 1;
					horizontalqueue.add(curx + 1);
					verticalqueue.add(cury);
				}
			}
		}
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				anArray[i][j].moisture = step[i][j];
			}
		}
		System.out.print("Moisture Generated...");
		return anArray;
	}
}
