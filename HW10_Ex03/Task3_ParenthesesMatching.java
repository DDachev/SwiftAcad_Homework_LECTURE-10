package bg.swift.HW10;

import java.util.LinkedList;
import java.util.Scanner;

public class Task3_ParenthesesMatching {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert the line with parentheses: ");
		String line = sc.nextLine();
		String[] info = line.split("");
		LinkedList<String> stack = new LinkedList<>();

		for (int i = 0; i < info.length; i++) {
			if (info[i].equals("(") || info[i].equals("{") || info[i].equals("[")) {
				stack.push(info[i]);
			}
			if (info[i].equals(")")) {
				if (stack.peek().equals("(")) {
					stack.poll();
				} else {
					System.out.println("False");
					break;
				}
			}
			if (info[i].equals("}")) {
				if (stack.peek().equals("{")) {
					stack.poll();
				} else {
					System.out.println("False");
					break;
				}
			}
			if (info[i].equals("]")) {
				if (stack.peek().equals("[")) {
					stack.poll();
				} else {
					System.out.println("False");
					break;
				}
			}
		}

		if (stack.isEmpty()) {
			System.out.println("True");
		}
		sc.close();
	}
}
