package Map;

import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class camera {
	boolean xkey = false;
	boolean ykey = false;
	int x = 0;
	int y = 0;
	int speedX = 0;
	int speedY = 0;
	LinkedList<String> directionqueue = new LinkedList<String>();
	LinkedList<String> verticalqueue = new LinkedList<String>();
	LinkedList<String> horizontalqueue = new LinkedList<String>();

	public camera(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
		if (horizontalqueue.isEmpty()) {
			speedX = 0;
		} else if (horizontalqueue.getFirst() == "left") {
			speedX = -10;
		} else if (horizontalqueue.getFirst() == "right") {
			speedX = 10;
		}
		if (verticalqueue.isEmpty()) {
			speedY = 0;
		} else if (verticalqueue.getFirst() == "up") {
			speedY = -10;
		} else if (verticalqueue.getFirst() == "down") {
			speedY = 10;
		}
		x += speedX;
		y += speedY;
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			horizontalqueue.remove("left");
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			horizontalqueue.remove("right");
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			verticalqueue.remove("up");
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			verticalqueue.remove("down");
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (!horizontalqueue.contains("left")) {
				horizontalqueue.addFirst("left");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (!horizontalqueue.contains("right")) {
				horizontalqueue.addFirst("right");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (!verticalqueue.contains("up")) {
				verticalqueue.addFirst("up");
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (!verticalqueue.contains("down")) {
				verticalqueue.addFirst("down");
			}
		}
	}
}
