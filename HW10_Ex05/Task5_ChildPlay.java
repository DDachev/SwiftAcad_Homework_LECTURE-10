package bg.swift.HW10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5_ChildPlay {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert the number of children: ");
		int numberOfChildren = sc.nextInt();
		System.out.println("Insert their height:");
		int numberOfRounds = 0;
		boolean hasANextRound = true;
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < numberOfChildren; i ++) {
			list.add(sc.nextInt());
		}
		
		while (hasANextRound) {
			hasANextRound = false;
			for (int i = list.size() - 1; i > 0; i--) {
				if (list.get(i) > list.get(i - 1)) {
					list.remove(i);
					hasANextRound = true;
				}
			}
			if(hasANextRound) {
				numberOfRounds++;
			}
		}
		System.out.println(numberOfRounds);
		sc.close();
	}
}
