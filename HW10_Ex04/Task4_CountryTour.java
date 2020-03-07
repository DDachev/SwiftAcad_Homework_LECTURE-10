package bg.swift.HW10_Ex04;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task4_CountryTour {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert the number of cities: ");
		int numberOfCities = sc.nextInt();
		List<City> cities = new LinkedList<>();

		for (int i = 0; i < numberOfCities; i++) {
			System.out.println("Insert the distance to other city and the provisions:");
			int distance = sc.nextInt();
			int provision = sc.nextInt();
			cities.add(new City(distance, provision));
		}
		System.out.println(startingPositionOfTour(cities));
		sc.close();
	}

	private static String startingPositionOfTour(List<City> cities) {
		boolean hasAPosition;
		for (int i = 0; i < cities.size(); i++) {
			int provision = 0;
			hasAPosition = true;
			for (int j = i; j < cities.size() + i; j++) {
				City currentCity = cities.get(j % cities.size());
				provision += currentCity.getProvision();
				if (currentCity.getDistance() > provision) {
					hasAPosition = false;
					break;
				}
				provision -= currentCity.getDistance();
			}
			if (hasAPosition) {
				return String.valueOf(i + 1);
			}
		}
		return "NO";
	}
}
