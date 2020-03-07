package bg.swift.HW10;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1_UniqueNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert the number: ");
		int number = sc.nextInt();
		Set<Integer> hashSet = new HashSet<>();

		for (int i = 0; i < number; i++) {
			hashSet.add(sc.nextInt());
		}

		for (int i : hashSet) {
			System.out.print(i + " ");
		}
		sc.close();
	}
}
