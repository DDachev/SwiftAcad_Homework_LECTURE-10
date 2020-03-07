package bg.swift.HW10_Ex08;

import java.util.LinkedList;

public class Snake {
	private static final int START_LENGTH = 5;
	private LinkedList<Segment> body = new LinkedList<>();
	private String direction = "d";

	protected Snake() {
		for (int i = START_LENGTH - 1; i >= 0; i--) {
			body.add(new Segment(i, 0));
		}
	}

	protected boolean isLayingOn(int x, int y) {
		for (Segment segment : body) {
			if (segment.isOnCoordinates(x, y)) {
				return true;
			}
		}
		return false;
	}

	protected void changeDirection(String newDirection) {
		switch (direction) {
		case "d":
			if ("a" == newDirection) {
				return;
			}
			direction = newDirection;
		case "s":
			if ("w" == newDirection) {
				return;
			}
			direction = newDirection;
		case "a":
			if ("d" == newDirection) {
				return;
			}
			direction = newDirection;
		case "w":
			if ("s" == newDirection) {
				return;
			}
			direction = newDirection;
		}
	}

	protected void move(Field field) throws SnakeOutOfBoundsException, SnakeBittenException {
		Segment head = body.peek();
		int newHeadX = head.getX();
		int newHeadY = head.getY();

		switch (direction) {
		case "d":
			newHeadX++;
			break;
		case "s":
			newHeadY++;
			break;
		case "a":
			newHeadX--;
			break;
		case "w":
			newHeadY--;
			break;
		}
		for (Segment segment : body) {
			if (segment.isOnCoordinates(newHeadX, newHeadY)) {
				throw new SnakeBittenException("[" + newHeadX + "," + newHeadY + "]");
			}
		}
		if (newHeadX < 0 || newHeadY < 0 || field.field.length < newHeadX || field.field[0].length < newHeadY) {
			throw new SnakeOutOfBoundsException("[" + newHeadX + "," + newHeadY + "]");
		}

		if (field.appleX == newHeadX && field.appleY == newHeadY) {
			field.appleEaten(this);
		} else {
			body.removeLast();
		}
		body.addFirst(new Segment(newHeadX, newHeadY));
	}

	protected int getScore() {
		return this.body.size() - START_LENGTH;
	}
}
