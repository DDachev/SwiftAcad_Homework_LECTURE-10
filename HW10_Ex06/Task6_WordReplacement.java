package bg.swift.HW10;

import java.util.HashMap;
import java.util.Scanner;

public class Task6_WordReplacement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert the text: ");
		String input = sc.nextLine();
		System.out.println("Insert the number of lines: ");
		int numberOfLines = sc.nextInt();
		System.out.println("Insert the words: ");
		HashMap<String, String> map = new HashMap<>();

//		Fix the next line
		sc.nextLine();

		for (int i = 0; i < numberOfLines; i++) {
			String words = sc.nextLine();
			String[] info = words.split(" ");
			map.put(info[0], info[1]);
		}

		System.out.println(printNewText(map, input));
		sc.close();
	}

	private static String printNewText(HashMap<String, String> map, String line) {
		String[] words = line.split(" ");
		String output = "";
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i].toLowerCase())) {
				output += map.get(words[i].toLowerCase()) + " ";
			} else {
				output += words[i] + " ";
			}
		}
		return output;
	}
}

