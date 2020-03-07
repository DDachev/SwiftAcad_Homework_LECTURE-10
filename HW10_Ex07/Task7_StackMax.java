package bg.swift.HW10;

import java.util.LinkedList;
import java.util.Scanner;

public class Task7_StackMax {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> stack = new LinkedList<>();
		LinkedList<Integer> growingStack = new LinkedList<>();
		String input = sc.nextLine();

		while (!"END".equals(input)) {
			String[] command = input.split(" ");

			if (command[0].equals("PUSH")) {
				stack.push(Integer.parseInt(command[1]));

				if (growingStack.size() == 0 || growingStack.peek() < Integer.parseInt(command[1])) {
					growingStack.push(Integer.parseInt(command[1]));
				} else {
					growingStack.push(growingStack.peek());
				}
			}

			if (command[0].equals("POP")) {
				System.out.println(stack.pop());
				growingStack.pop();
			}

			if (command[0].equals("MAX")) {
				System.out.println(growingStack.peek());
			}
			input = sc.nextLine();
		}

		for (int a : stack) {
			System.out.print(a + " ");
		}
		sc.close();
	}
}
