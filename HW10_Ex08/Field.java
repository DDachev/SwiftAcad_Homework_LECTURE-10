package bg.swift.HW10_Ex08;

import java.util.Random;

public class Field {
	private static final Random rand = new Random();
	private static final int X_SIZE = 60;
	private static final int Y_SIZE = 20;

	char[][] field = new char[X_SIZE][Y_SIZE];
	int appleX = X_SIZE / 2;
	int appleY = Y_SIZE / 2;

	protected void print(Snake snake) {
		for (int i = 0; i < field.length + 2; i++) {
			System.out.print('#');
		}
		System.out.println();
		for (int j = 0; j < field[0].length; j++) {
			System.out.print('#');
			for (int i = 0; i < field.length; i++) {
				if (snake.isLayingOn(i, j)) {
					System.out.print('o');
				} else if (appleX == i && appleY == j) {
					System.out.print('x');
				} else {
					System.out.print(' ');
				}
			}
			System.out.print('#');
			System.out.println();
		}
		for (int i = 0; i < field.length + 2; i++) {
			System.out.print('#');
		}
		System.out.println();
	}

	protected void appleEaten(Snake snake) {
		int newX = rand.nextInt(X_SIZE);
		int newY = rand.nextInt(Y_SIZE);

		if (appleX == newX && appleY == newY) {
			appleEaten(snake);
			return;
		}
		if (snake.isLayingOn(newX, newY)) {
			appleEaten(snake);
			return;
		}
		appleX = newX;
		appleY = newY;
	}
}
