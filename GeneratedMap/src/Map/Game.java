package Map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Game extends JPanel {
	String maptype;
	static int dimensions = 1025;
	static int tilesize = 1;
	static int gametilesize = 32;
	static tileValues[][] map = new tileValues[dimensions][dimensions];
	static Background[][] floorTiles = new Background[dimensions][dimensions];
	static Background[][] gameTiles = new Background[dimensions][dimensions];
	static Background[][] moistureTiles = new Background[dimensions][dimensions];
	static Background[][] heightTiles = new Background[dimensions][dimensions];

	int camx = 0;
	int camy = 0;

	static camera Camera = new camera(500 * 16, 500 * 16);

	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				Camera.keyReleased(e);
				for (int i = 0; i < dimensions; i++) {
					for (int j = 0; j < dimensions; j++) {
						// gameTiles[i][j].keyReleased(e);
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				Camera.keyPressed(e);
				for (int i = 0; i < dimensions; i++) {
					for (int j = 0; j < dimensions; j++) {
						// gameTiles[i][j].keyPressed(e);
					}
				}
			}
		});
		setFocusable(true);
	}

	private void move() {
		for (int i = 0; i < dimensions - 1; i++) {
			for (int j = 0; j < dimensions - 1; j++) {
				gameTiles[i][j].move();
			}
		}
	}

	private void update() {
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				gameTiles[i][j].update();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		if (this.maptype == "default") {
			System.out.print("Drawing Island...");
			if (floorTiles[0][0] != null) {
				for (int i = 0; i < (dimensions - 1); i++) {
					for (int j = 0; j < (dimensions - 1); j++) {
						floorTiles[i][j].paint(g2d);
					}
				}
			}
		}
		if (this.maptype == "game") {
			g.translate(0, 0);
			g.translate(-Camera.x, -Camera.y);
			// System.out.print("Drawing Game Island...");
			if (gameTiles[0][0] != null) {
				for (int i = 0; i < (dimensions - 1); i++) {
					for (int j = 0; j < (dimensions - 1); j++) {
						if (gameTiles[i][j].x >= Camera.x - 32 && gameTiles[i][j].x <= Camera.x + 1100
								&& gameTiles[i][j].y >= Camera.y - 32 && gameTiles[i][j].y <= Camera.y + 1100) {
							gameTiles[i][j].paint(g2d);
						}
					}
				}
			}
			// g.translate(-Camera.x, -Camera.y);
		}
		if (this.maptype == "height") {
			System.out.print("Drawing Heightmap...");
			for (int i = 0; i < (dimensions - 1); i++) {
				for (int j = 0; j < (dimensions - 1); j++) {
					heightTiles[i][j].paint(g2d);
				}
			}
		}
		// System.out.print("Drawing Complete...");
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.print("Do you have a map? Y / N: ");
		Scanner sc = new Scanner(System.in);
		char input = 'x';
		boolean hasMap = false;
		while (true) {
			String inputs = sc.next();
			input = inputs.charAt(0);
			System.out.println(input);
			if (input == 'Y' || input == 'y') {
				hasMap = true;
				break;
			}
			if (input == 'N' || input == 'n') {
				hasMap = false;
				break;
			}
		}
		if (hasMap == true) {
			System.out.print("Input length: ");
			dimensions = sc.nextInt();
			System.out.print("Input map:");
			for (int i = 0; i < dimensions; i++) {
				for (int j = 0; j < dimensions; j++) {
					int he = sc.nextInt();
					int mo = sc.nextInt();
					map[i][j] = new tileValues(he, mo);
				}
			}
		} else if (hasMap == false) {
			System.out.print("Input length(must be (2^x)+1): ");
			dimensions = sc.nextInt();
			for (int i = 0; i < dimensions; i++) {
				for (int j = 0; j < dimensions; j++) {
					map[i][j] = new tileValues(0, 0);
				}
			}
			System.out.print("Loading...");
			MapGenerator.GenerateMap(map, dimensions);
			MoistureMap.GenerateMap(map, dimensions);
		}

		JFrame frame = new JFrame("Procedurally Generated Map");
		Game game = new Game();
		game.maptype = "default";
		frame.add(game);
		frame.setSize(1054, 1108);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame gameTest = new JFrame("test game");
		Game testgame = new Game();
		testgame.maptype = "game";
		gameTest.add(testgame);
		gameTest.setSize(1054, 1108);
		gameTest.setVisible(true);
		gameTest.setResizable(true);
		gameTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame moistureMap = new JFrame("Moisture distribution");
		Game moisture = new Game();
		moisture.maptype = "moisture";
		moistureMap.add(moisture);
		moistureMap.setSize(1054, 1108);
		moistureMap.setVisible(true);
		moistureMap.setResizable(true);
		moistureMap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame heightMap = new JFrame("Heightmap");
		Game height = new Game();
		height.maptype = "height";
		heightMap.add(height);
		heightMap.setSize(1054, 1108);
		heightMap.setVisible(true);
		heightMap.setResizable(true);
		heightMap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MapDrawer.drawMap(map, dimensions);
		testgame.repaint();
		game.repaint();
		moisture.repaint();
		height.repaint();
		System.out.println("Complete");
		System.out.print("Do you want a text copy of this map? Y / N: ");
		input = 'x';
		while (input != 'Y' && input != 'y' && input != 'N' && input != 'n') {
			String inputs = sc.next();
			input = inputs.charAt(0);
			System.out.println(input);
			if (input == 'Y' || input == 'y') {
			}
			if (input == 'N' || input == 'n') {
			}
		}
		if (input == 'Y' || input == 'y') {
			for (int i = 0; i < dimensions; i++) {
				for (int j = 0; j < dimensions; j++) {
					System.out.print(map[i][j].height + " " + map[i][j].moisture + " ");
				}
				System.out.println("");
			}
			System.out.println("Length is: " + dimensions);
		}
		while (true) {
			Camera.update();
			testgame.move();
			testgame.update();
			testgame.repaint();
			Thread.sleep(25);
		}
	}
}