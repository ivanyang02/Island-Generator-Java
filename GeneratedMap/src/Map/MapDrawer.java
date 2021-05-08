package Map;

public class MapDrawer {
	public static void drawMap(tileValues anArray[][], int d) {
		boolean left = false;
		boolean right = false;
		boolean up = false;
		boolean down = false;
		boolean ur = false;
		boolean ul = false;
		boolean dr = false;
		boolean dl = false;
		System.out.print("Building Island...");
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				if (anArray[i][j].height >= (byte) 100) {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "red.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "water.png");
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "blue.png");
				}

				else if (anArray[i][j].height > (byte) 13) {
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height14.png");
					if (anArray[i][j].moisture <= 300) {
						Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
								Game.tilesize, "white.png");
						Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
								Game.gametilesize, Game.gametilesize, "white.png");
					} else {
						Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
								Game.tilesize, "lightgray.png");
						Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
								Game.gametilesize, Game.gametilesize, "lightgray.png");
					}
				}

				else if (anArray[i][j].height > (byte) 12) {
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height13.png");
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "lightgray.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "lightgray.png");

				} else if (anArray[i][j].height > (byte) 11) {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "lightgray.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "lightgray.png");
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height12.png");

				} else if (anArray[i][j].height > (byte) 10) {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "gray.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "gray.png");
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height11.png");

				} else if (anArray[i][j].height > (byte) 9) {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "darkgray.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "darkgray.png");
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height10.png");

				} else if (anArray[i][j].height > (byte) 8) {
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height9.png");
					if (anArray[i][j].moisture <= 4) {
						Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
								Game.tilesize, "sand.png");
						Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
								Game.gametilesize, Game.gametilesize, "sand.png");
					} else {
						Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
								Game.tilesize, "darkgreen.png");
						Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
								Game.gametilesize, Game.gametilesize, "grass1.png");
					}

				} else if (anArray[i][j].height > (byte) 7) {
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height8.png");
					if (anArray[i][j].moisture <= 5) {
						Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
								Game.tilesize, "sand.png");
						Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
								Game.gametilesize, Game.gametilesize, "sand.png");
					} else {
						Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
								Game.tilesize, "green.png");
						Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
								Game.gametilesize, Game.gametilesize, "grass2.png");
					}

				} else if (anArray[i][j].height > (byte) 6) {
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height7.png");

					if (anArray[i][j].moisture <= 6) {
						Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
								Game.tilesize, "sand.png");
						Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
								Game.gametilesize, Game.gametilesize, "sand.png");
					} else {
						Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
								Game.tilesize, "lightgreen.png");
						Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
								Game.gametilesize, Game.gametilesize, "grass1.png");
					}
				} else if (anArray[i][j].height > (byte) 5) {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "water.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "water.png");
					if (i > 0 && i < Game.dimensions - 1 && j > 0 && j < Game.dimensions - 1
							&& (anArray[i - 1][j].height == 7 || anArray[i + 1][j].height == 7
									|| anArray[i][j - 1].height == 7 || anArray[i][j + 1].height == 7)) {
						Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
								Game.tilesize, "blue.png");
					} else {
						Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
								Game.tilesize, "height6.png");
					}
				} else if (anArray[i][j].height > (byte) 4) {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "blue.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "water.png");
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height5.png");
				} else if (anArray[i][j].height > (byte) 3) {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "blue.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "water.png");
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height4.png");
				} else if (anArray[i][j].height > (byte) 2) {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "darkblue.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "water.png");
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height3.png");
				} else if (anArray[i][j].height > (byte) 1) {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "darkblue.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "water.png");
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height2.png");
				} else if (anArray[i][j].height > (byte) 0) {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "darkblue.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "water.png");
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height1.png");
				} else {
					Game.floorTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "darkblue.png");
					Game.gameTiles[i][j] = new Background(j * Game.gametilesize, i * Game.gametilesize,
							Game.gametilesize, Game.gametilesize, "water.png");
					Game.heightTiles[i][j] = new Background(j * Game.tilesize, i * Game.tilesize, Game.tilesize,
							Game.tilesize, "height0.png");
				}
			}
		}
		for (int i = 2; i < d - 2; i++) {
			for (int j = 2; j < d - 2; j++) {
				if (Game.gameTiles[i][j].height < 50 && Game.gameTiles[i][j].src == "sand.png") {
					up = false;
					down = false;
					left = false;
					right = false;
					if (Game.gameTiles[i - 1][j].src == "grass1.png" || Game.gameTiles[i - 1][j].src == "grass2.png") {
						up = true;
					}
					if (Game.gameTiles[i][j - 1].src == "grass1.png" || Game.gameTiles[i][j - 1].src == "grass2.png") {
						left = true;
					}
					if (Game.gameTiles[i][j + 1].src == "grass1.png" || Game.gameTiles[i][j + 1].src == "grass2.png") {
						right = true;
					}
					if (Game.gameTiles[i + 1][j].src == "grass1.png" || Game.gameTiles[i + 1][j].src == "grass2.png") {
						down = true;
					}
					if (up == true && right == true && left == true && down == false) {
						Game.gameTiles[i][j].src = "grass1.png";
					}
					if (up == true && right == false && left == true && down == true) {
						Game.gameTiles[i][j].src = "grass1.png";
					}
					if (up == true && right == true && left == false && down == true) {
						Game.gameTiles[i][j].src = "grass1.png";
					}
					if (up == false && right == true && left == true && down == true) {
						Game.gameTiles[i][j].src = "grass1.png";
					}
				}
			}
		}
		for (int i = 2; i < d - 2; i++) {
			for (int j = 2; j < d - 2; j++) {
				if (Game.gameTiles[i][j].height < 50 && Game.gameTiles[i][j].src == "sand.png") {
					Game.map[i][j].biome = "beach";
				}
			}
		}
		for (int i = 2; i < d - 2; i++) {
			for (int j = 2; j < d - 2; j++) {
				if (Game.gameTiles[i][j].height < 50 && Game.map[i][j].biome == "beach") {
					up = false;
					down = false;
					left = false;
					right = false;
					ur = false;
					ul = false;
					dr = false;
					dl = false;

					if (Game.map[i - 1][j - 1].biome == "plain") {
						ul = true;
					}
					if (Game.map[i - 1][j].biome == "plain") {
						up = true;
					}
					if (Game.map[i - 1][j + 1].biome == "plain") {
						ur = true;
					}
					if (Game.map[i][j - 1].biome == "plain") {
						left = true;
					}
					if (Game.map[i][j + 1].biome == "plain") {
						right = true;
					}
					if (Game.map[i + 1][j - 1].biome == "plain") {
						dl = true;
					}
					if (Game.map[i + 1][j].biome == "plain") {
						down = true;
					}
					if (Game.map[i + 1][j + 1].biome == "plain") {
						dr = true;
					}

					if (up == true && left == true && right == false && down == false && dr == false) {
						Game.gameTiles[i][j].src = "sandgrass1.png";
					} else if (up == true && left == false && right == true && dl == false && down == false) {
						Game.gameTiles[i][j].src = "sandgrass3.png";
					} else if (up == false && ur == false && left == true && right == false && down == true) {
						Game.gameTiles[i][j].src = "sandgrass6.png";
					} else if (ul == false && up == false && left == false && right == true && down == true) {
						Game.gameTiles[i][j].src = "sandgrass8.png";
					} else if (ul == true && up == false && ur == false && left == false && right == false
							&& dl == false && down == false && dr == false) {
						Game.gameTiles[i][j].src = "invertsand1.png";
					} else if (ul == false && up == false && ur == true && left == false && right == false
							&& dl == false && down == false && dr == false) {
						Game.gameTiles[i][j].src = "invertsand2.png";
					} else if (ul == false && up == false && ur == false && left == false && right == false
							&& dl == true && down == false && dr == false) {
						Game.gameTiles[i][j].src = "invertsand3.png";
					} else if (ul == false && up == false && ur == false && left == false && right == false
							&& dl == false && down == false && dr == true) {
						Game.gameTiles[i][j].src = "invertsand4.png";
					} else if (up == true) {
						Game.gameTiles[i][j].src = "sandgrass2.png";
					} else if (left == true) {
						Game.gameTiles[i][j].src = "sandgrass4.png";
					} else if (right == true) {
						Game.gameTiles[i][j].src = "sandgrass5.png";
					} else if (down == true) {
						Game.gameTiles[i][j].src = "sandgrass7.png";
					}
				}
			}
		} /*
			 * for (int i = 1; i < d - 1; i++) { for (int j = 1; j < d - 1; j++) { up =
			 * false; down = false; left = false; right = false; if
			 * (Game.gameTiles[i][j].src == "sand.png") { int num = (int) (Math.random() *
			 * 2) + 1; if (Game.gameTiles[i - 1][j].src == "water.png") { up = true; } if
			 * (Game.gameTiles[i + 1][j].src == "water.png") { down = true; } if
			 * (Game.gameTiles[i][j - 1].src == "water.png") { left = true; } if
			 * (Game.gameTiles[i][j + 1].src == "water.png") { right = true; } if (up ==
			 * true && down == false && left == false && right == false) { Game.gameTiles[i
			 * - 1][j].src = "sand_U_" + num + ".png"; } if (up == false && down == true &&
			 * left == false && right == false) { Game.gameTiles[i + 1][j].src = "sand_D_" +
			 * num + ".png"; } if (up == false && down == false && left == true && right ==
			 * false) { Game.gameTiles[i][j - 1].src = "sand_L_" + num + ".png"; } if (up ==
			 * false && down == false && left == false && right == true) {
			 * Game.gameTiles[i][j + 1].src = "sand_R_" + num + ".png"; } if (up == true &&
			 * down == false && left == true && right == false) { Game.gameTiles[i][j].src =
			 * "sand_UL.png"; } if (up == true && down == false && left == false && right ==
			 * true) { Game.gameTiles[i][j].src = "sand_UR.png"; } if (up == false && down
			 * == true && left == true && right == false) { Game.gameTiles[i][j].src =
			 * "sand_DL.png"; } if (up == false && down == true && left == false && right ==
			 * true) { Game.gameTiles[i][j].src = "sand_DR.png"; } } } }
			 */
	}
}
