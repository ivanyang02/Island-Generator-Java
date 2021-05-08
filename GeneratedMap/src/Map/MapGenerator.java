package Map;

import java.util.Arrays;
import java.util.LinkedList;

public class MapGenerator {

	public static tileValues[][] GenerateMap(tileValues anArray[][], int d) {
		boolean acceptable = false;
		byte sealevel = 6;
		byte mountainheight = 9;
		int e = d - 1;
		byte avg = 0;
		int sidelength = e;
		int[][] step = new int[d][d];
		LinkedList<Integer> horizontalqueue = new LinkedList<Integer>();
		LinkedList<Integer> verticalqueue = new LinkedList<Integer>();
		while (acceptable == false) {
			anArray[0][0].height = (byte) Math.ceil(Math.random() * 1 + 6);
			anArray[0][e].height = (byte) Math.ceil(Math.random() * 1 + 6);
			anArray[e][0].height = (byte) Math.ceil(Math.random() * 1 + 6);
			anArray[e][e].height = (byte) Math.ceil(Math.random() * 1 + 6);
			int counter = 0;
			while (true) {
				if (e / 2 != 1) {
					counter++;
					e = e / 2;
				} else {
					break;
				}
			}
			e = d - 1;
			System.out.print("Generating Island...");
			for (int q = 0; q < counter + 1; q++) {
				if (q == 2) {
					for (int x = 0; x < e; x++) {
						if (anArray[0][x].height != 0) {
							anArray[0][x].height = 0;
						}
						if (anArray[x][e].height != 0) {
							anArray[x][e].height = 0;
						}
						if (anArray[e][x].height != 0) {
							anArray[e][x].height = 0;
						}
						if (anArray[x][0].height != 0) {
							anArray[x][0].height = 0;
						}
					}
				}
				/*
				 * outerloop: for (int i = 0; i < d; i++) { for (int j = 1; j < d; j++) { if
				 * (anArray[0][j] != 0) { sidelength = Math.abs(j - i); break outerloop; } } }
				 */
				for (int k = 0; k < e; k += sidelength) {
					for (int l = 0; l < e; l += sidelength) {
						avg = (byte) (anArray[k][l].height + anArray[k][l + sidelength].height
								+ anArray[k + sidelength][l].height + anArray[k + sidelength][l + sidelength].height);
						avg /= 4;
						anArray[k + sidelength / 2][l + sidelength / 2].height = (byte) (avg
								+ (byte) Math.ceil(Math.random() * 3 - 1));
						anArray[k + sidelength / 2][l].height = (byte) (avg + (byte) Math.ceil(Math.random() * 4 - 2));
						anArray[k][l + sidelength / 2].height = (byte) (avg + (byte) Math.ceil(Math.random() * 4 - 2));
						anArray[k + sidelength][l + sidelength / 2].height = (byte) (avg
								+ (byte) Math.ceil(Math.random() * 4 - 2));
						anArray[k + sidelength / 2][l + sidelength].height = (byte) (avg
								+ (byte) Math.ceil(Math.random() * 4 - 2));
					}
				}
				sidelength /= 2;
			}
			System.out.print("Smoothing Edges...");
			counter = 0;
			for (int q = 0; q < 2; q++) {
				for (int i = 1; i < d - 1; i++) {
					for (int j = 1; j < d - 1; j++) {

						if (anArray[i - 1][j - 1].height > sealevel) {
							counter++;
						}
						if (anArray[i - 1][j].height > sealevel) {
							counter++;
						}
						if (anArray[i - 1][j + 1].height > sealevel) {
							counter++;
						}
						if (anArray[i][j - 1].height > sealevel) {
							counter++;
						}
						if (anArray[i][j + 1].height > sealevel) {
							counter++;
						}
						if (anArray[i + 1][j - 1].height > sealevel) {
							counter++;
						}
						if (anArray[i + 1][j].height > sealevel) {
							counter++;
						}
						if (anArray[i + 1][j + 1].height > sealevel) {
							counter++;
						}
						if (counter > 5 && anArray[i][j].height <= sealevel) {
							anArray[i][j].height = (byte) (sealevel + 1);
						} else if (counter < 4 && anArray[i][j].height > sealevel) {
							anArray[i][j].height = sealevel;
						}
						counter = 0;
					}
				}
			}
			for (int levels = 11; levels > 5; levels--) {
				for (int q = 0; q < 1; q++) {
					for (int i = 1; i < d - 1; i++) {
						for (int j = 1; j < d - 1; j++) {

							if (anArray[i - 1][j - 1].height > levels) {
								counter++;
							}
							if (anArray[i - 1][j].height > levels) {
								counter++;
							}
							if (anArray[i - 1][j + 1].height > levels) {
								counter++;
							}
							if (anArray[i][j - 1].height > levels) {
								counter++;
							}
							if (anArray[i][j + 1].height > levels) {
								counter++;
							}
							if (anArray[i + 1][j - 1].height > levels) {
								counter++;
							}
							if (anArray[i + 1][j].height > levels) {
								counter++;
							}
							if (anArray[i + 1][j + 1].height > levels) {
								counter++;
							}
							if (counter > 5 && anArray[i][j].height <= levels) {
								anArray[i][j].height = (byte) (levels + 1);
							} else if (counter < 4 && anArray[i][j].height > levels) {
								anArray[i][j].height = (byte) levels;
							}
							counter = 0;
						}
					}
				}
			}
			System.out.print("Removing Smaller Islands...");
			horizontalqueue.add(e / 2);
			verticalqueue.add(e / 2);
			for (int r = 0; r < d; r++) {
				Arrays.fill(step[r], Integer.MAX_VALUE);
			}
			step[sidelength / 2][sidelength / 2] = 0;
			while (!horizontalqueue.isEmpty() && !verticalqueue.isEmpty()) {
				int curx = horizontalqueue.poll();
				int cury = verticalqueue.poll();
				if (cury - 1 > 0) {
					if (step[cury - 1][curx] > step[cury][curx] + 1 && anArray[cury - 1][curx].height > 6) {
						step[cury - 1][curx] = step[cury][curx] + 1;
						horizontalqueue.add(curx);
						verticalqueue.add(cury - 1);
					}
				}
				if (step[cury + 1][curx] > step[cury][curx] + 1 && anArray[cury + 1][curx].height > 6 && cury + 1 < d) {
					step[cury + 1][curx] = step[cury][curx] + 1;
					horizontalqueue.add(curx);
					verticalqueue.add(cury + 1);
				}
				if (curx - 1 > 0) {
					if (step[cury][curx - 1] > step[cury][curx] + 1 && anArray[cury][curx - 1].height > 6) {
						step[cury][curx - 1] = step[cury][curx] + 1;
						horizontalqueue.add(curx - 1);
						verticalqueue.add(cury);
					}
				}
				if (step[cury][curx + 1] > step[cury][curx] + 1 && anArray[cury][curx + 1].height > 6 && curx + 1 < d) {
					step[cury][curx + 1] = step[cury][curx] + 1;
					horizontalqueue.add(curx + 1);
					verticalqueue.add(cury);
				}
			}
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < d; j++) {
					if (anArray[i][j].height > 6 && step[i][j] == Integer.MAX_VALUE) {
						anArray[i][j].height = 6;
					}
				}
			}
			horizontalqueue.add(1);
			verticalqueue.add(1);
			for (int r = 0; r < d; r++) {
				Arrays.fill(step[r], Integer.MAX_VALUE);
			}
			step[sidelength / 2][sidelength / 2] = 0;
			while (!horizontalqueue.isEmpty() && !verticalqueue.isEmpty()) {
				int curx = horizontalqueue.poll();
				int cury = verticalqueue.poll();
				if (cury - 1 >= 0 && cury + 1 < d && curx - 1 >= 0 && curx + 1 < d) {
					if (step[cury - 1][curx] > step[cury][curx] + 1 && anArray[cury - 1][curx].height <= 6) {
						step[cury - 1][curx] = step[cury][curx] + 1;
						horizontalqueue.add(curx);
						verticalqueue.add(cury - 1);
					}
					if (step[cury + 1][curx] > step[cury][curx] + 1 && anArray[cury + 1][curx].height <= 6) {
						step[cury + 1][curx] = step[cury][curx] + 1;
						horizontalqueue.add(curx);
						verticalqueue.add(cury + 1);
					}
					if (step[cury][curx - 1] > step[cury][curx] + 1 && anArray[cury][curx - 1].height <= 6) {
						step[cury][curx - 1] = step[cury][curx] + 1;
						horizontalqueue.add(curx - 1);
						verticalqueue.add(cury);
					}
					if (step[cury][curx + 1] > step[cury][curx] + 1 && anArray[cury][curx + 1].height <= 6) {
						step[cury][curx + 1] = step[cury][curx] + 1;
						horizontalqueue.add(curx + 1);
						verticalqueue.add(cury);
					}
				}
			}
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < d; j++) {
					if (anArray[i][j].height <= 6 && step[i][j] == Integer.MAX_VALUE) {
						anArray[i][j].height = 7;
					}
				}
			}
			for (int i = 1; i < d - 1; i++) {
				for (int j = 1; j < d - 1; j++) {
					if (anArray[i][j].height > sealevel) {
						counter++;
					}
				}
			}
			// if (counter > (d / 2 + 1) * (d / 2 + 1)) {
			acceptable = true;
			// } else {
			// counter = 0;
			// }
		}

		// generating rivers
		System.out.print("Generating Rivers...");
		for (int i = 1; i < d - 1; i++) {
			for (int j = 1; j < d - 1; j++) {
				if (anArray[i][j].height == 13) {
					if (Math.floor(Math.random() * 2000) + 1 < 2) {
						anArray[i][j].height = 100;
						anArray[i][j].biome = "river";
					}
				} else if (anArray[i][j].height >= 12) {
					if (Math.floor(Math.random() * 4000) + 1 < 2) {
						anArray[i][j].height = 100;
						anArray[i][j].biome = "river";
					}
				} else if (anArray[i][j].height >= 11) {
					if (Math.floor(Math.random() * 6000) + 1 < 2) {
						anArray[i][j].height = 100;
						anArray[i][j].biome = "river";
					}
				}
			}
		}
		for (int i = 1; i < d - 1; i++) {
			for (int j = 1; j < d - 1; j++) {
				if (anArray[i][j].height == 100) {
					horizontalqueue.add(j);
					verticalqueue.add(i);
					int[][][] parent = new int[d][d][2];
					parent[i][j][0] = -1;
					parent[i][j][1] = -1;
					for (int r = 0; r < d; r++) {
						Arrays.fill(step[r], Integer.MAX_VALUE);
					}
					step[i][j] = 0;
					anArray[i][j].height = 101;
					while_loop: while (!horizontalqueue.isEmpty() && !verticalqueue.isEmpty()) {
						int curx = horizontalqueue.poll();
						int cury = verticalqueue.poll();
						if (anArray[cury][curx].height <= 4) {
							if (Math.abs(cury - i) > 40 && Math.abs(curx - j) > 40) {
								anArray[cury][curx].height = 101;
								LinkedList<Integer> xqueue = new LinkedList<Integer>();
								LinkedList<Integer> yqueue = new LinkedList<Integer>();
								xqueue.add(curx);
								yqueue.add(cury);
								while (!xqueue.isEmpty() && !yqueue.isEmpty()) {
									int parx = xqueue.poll();
									int pary = yqueue.poll();
									anArray[pary][parx].height = 101;
									anArray[pary][parx].biome = "river";
									if (parent[pary][parx][0] != -1 && parent[pary][parx][1] != -1) {
										xqueue.add(parent[pary][parx][0]);
										yqueue.add(parent[pary][parx][1]);
									} else {
										break;
									}
								}
								horizontalqueue.clear();
								verticalqueue.clear();
								break while_loop;
							}
						}
						if (step[cury][curx - 1] > step[cury][curx] + Math.pow(2, anArray[cury][curx - 1].height)
								&& curx - 1 > 0) {
							step[cury][curx
									- 1] = (int) (step[cury][curx] + Math.pow(2, anArray[cury][curx - 1].height));
							parent[cury][curx - 1][0] = curx;
							parent[cury][curx - 1][1] = cury;
							horizontalqueue.add(curx - 1);
							verticalqueue.add(cury);
						}
						if (curx + 1 < d && step[cury][curx + 1] > step[cury][curx]
								+ Math.pow(2, anArray[cury][curx + 1].height)) {
							step[cury][curx
									+ 1] = (int) (step[cury][curx] + Math.pow(2, anArray[cury][curx + 1].height));
							parent[cury][curx + 1][0] = curx;
							parent[cury][curx + 1][1] = cury;
							horizontalqueue.add(curx + 1);
							verticalqueue.add(cury);
						}
						if (step[cury - 1][curx] > step[cury][curx] + Math.pow(2, anArray[cury - 1][curx].height)
								&& cury - 1 > 0) {
							step[cury - 1][curx] = (int) (step[cury][curx]
									+ Math.pow(2, anArray[cury - 1][curx].height));
							parent[cury - 1][curx][0] = curx;
							parent[cury - 1][curx][1] = cury;
							horizontalqueue.add(curx);
							verticalqueue.add(cury - 1);
						}
						if (cury + 1 < d && step[cury + 1][curx] > step[cury][curx]
								+ Math.pow(2, anArray[cury + 1][curx].height)) {
							step[cury + 1][curx] = (int) (step[cury][curx]
									+ Math.pow(2, anArray[cury + 1][curx].height));
							parent[cury + 1][curx][0] = curx;
							parent[cury + 1][curx][1] = cury;
							horizontalqueue.add(curx);
							verticalqueue.add(cury + 1);
						}
					}
				}
			}
		}
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				if (anArray[i][j].height < 7 && anArray[i][j].biome == "none") {
					anArray[i][j].biome = "ocean";
				} else if (anArray[i][j].height < 10 && anArray[i][j].biome == "none") {
					anArray[i][j].biome = "plain";
				} else if (anArray[i][j].biome == "none") {
					anArray[i][j].biome = "mountain";
				}
			}
		}
		System.out.print("Island Generated...");
		/*
		 * for (int i = 0; i < d; i++) { for (int j = 0; j < d; j++) {
		 * System.out.print(anArray[i][j]+" "); } System.out.println(""); }
		 */
		return anArray;
	}
}
