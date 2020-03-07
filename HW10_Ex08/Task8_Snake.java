package bg.swift.HW10_Ex08;

import java.util.Scanner;

public class Task8_Snake {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Field field = new Field();
		Snake snake = new Snake();
		field.print(snake);
		System.out.println("Insert direction: 'w' - UP; 's' - DOWN; 'a' - LEFT; 'd' - RIGHT");
		int countOfCommand = 0;
		
		while (true) {
			if(countOfCommand != 0) {
			field.print(snake);	
			}
			String input = sc.nextLine();
			snake.changeDirection(input);
			try {
				snake.move(field);
			} catch (SnakeBittenException | SnakeOutOfBoundsException e) {
				System.out.println("GOOD GAME! Result: " + snake.getScore() + "!");
				sc.close();
				break;
			}
			countOfCommand++;
		}
	}
}
