package bg.swift.HW10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2_CommonSubset {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert the number N and M: ");
		int numberN = sc.nextInt();
		int numberM = sc.nextInt();
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < numberN; i++) {
			numbers.add(sc.nextInt());
		}

		int sizeOfList = numbers.size();
		boolean hasMatches = false;

		for (int i = 0; i < numberM; i++) {
			int currentNumberM = sc.nextInt();
			if (numbers.contains(currentNumberM)) {
				numbers.add(currentNumberM);
				hasMatches = true;
			}
		}

		if (hasMatches) {
			for (int i = sizeOfList; i < numbers.size(); i++) {
				System.out.print(numbers.get(i) + " ");
			}
		} else {
			System.out.println("NO");
		}
		sc.close();
	}
}
