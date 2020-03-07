package bg.swift.HW10_Ex09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task9_ExpressionCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Double> numbers = new ArrayList<>();
		List<String> operators = new ArrayList<>();

		System.out.println("Insert the algortihm expression: ");
		String input = sc.nextLine();
		sc.close();
		input = input.replace(" ", "");
		char[] newInput = input.toCharArray();

//		Insert the operators in an ArrayList 
		for (int i = 0; i < input.length(); i++) {
			if (newInput[i] == '(' || newInput[i] == ')' || newInput[i] == '-' || newInput[i] == '+'
					|| newInput[i] == '*' || newInput[i] == '/' || newInput[i] == '^') {
				operators.add(String.valueOf(newInput[i]));
				newInput[i] = ' ';
			}
		}
		input = String.valueOf(newInput);
		String[] onlyNumbers = input.trim().split(" ");

//		Insert the numbers in an ArrayList
		for (int i = 0; i < onlyNumbers.length; i++) {
			if (!onlyNumbers[i].equals("")) {
				try {
					numbers.add(Double.parseDouble(onlyNumbers[i]));
				} catch (NumberFormatException e) {
					System.out.println("Invalid operator.");
					return;
				}
			}
		}

		int indexOfOperator = 0;

//		Calculate expression
		while (operators.size() > 0) {
			indexOfOperator = findFirstHighestPriorityOperand(operators);
			calculate(numbers, operators, operators.get(indexOfOperator), indexOfOperator);
		}
		System.out.printf("%f", numbers.get(0));
	}

	private static int findFirstHighestPriorityOperand(List<String> expression) {
		int nonClosedParentheses = 0;
		int indexOfFirstParentheses = 0;
		int indexOfLastParentheses = 0;
		for (int i = 0; i < expression.size(); i++) {
			if (expression.get(i).equals("(")) {
				nonClosedParentheses++;
				indexOfFirstParentheses = i;
				expression.remove(i);
				i--;
				continue;
			}
			if (expression.get(i).equals(")")) {
				nonClosedParentheses--;
				indexOfLastParentheses = i;
				expression.remove(i);
				continue;
			}
		}

		if (nonClosedParentheses == 0 && indexOfLastParentheses != 0) {
			return indexOfFirstParentheses;
		}

		for (int i = 0; i < expression.size(); i++) {
			if (expression.get(i).equals("^")) {
				return i;
			}
		}
		for (int i = 0; i < expression.size(); i++) {
			if (expression.get(i).equals("*") || expression.get(i).equals("/")) {
				return i;
			}
		}
		for (int i = 0; i < expression.size(); i++) {
			if (expression.get(i).equals("+") || expression.get(i).equals("-")) {
				return i;
			}
		}
		return -1;
	}

	private static void calculate(List<Double> numbers, List<String> operators, String operator, int indexOfOperator) {
		double result = 0;
		if (operators.get(indexOfOperator).equals("^")) {
			result = Math.pow(numbers.get(indexOfOperator), numbers.get(indexOfOperator + 1));
			operators.remove(indexOfOperator);
			numbers.set(indexOfOperator, result);
			numbers.remove(indexOfOperator + 1);
			return;
		}
		if (operators.get(indexOfOperator).equals("*")) {
			result = numbers.get(indexOfOperator) * numbers.get(indexOfOperator + 1);
			operators.remove(indexOfOperator);
			numbers.set(indexOfOperator, result);
			numbers.remove(indexOfOperator + 1);
			return;
		}
		if (operators.get(indexOfOperator).equals("/")) {
			result = numbers.get(indexOfOperator) / numbers.get(indexOfOperator + 1);
			operators.remove(indexOfOperator);
			numbers.set(indexOfOperator, result);
			numbers.remove(indexOfOperator + 1);
			return;
		}
		if (operators.get(indexOfOperator).equals("+")) {
			result = numbers.get(indexOfOperator) + numbers.get(indexOfOperator + 1);
			operators.remove(indexOfOperator);
			numbers.set(indexOfOperator, result);
			numbers.remove(indexOfOperator + 1);
			return;
		}
		if (operators.get(indexOfOperator).equals("-")) {
			if (operators.size() == numbers.size()) {
				result = -numbers.get(indexOfOperator);
				operators.remove(indexOfOperator);
				numbers.set(indexOfOperator, result);
				return;
			}
			result = numbers.get(indexOfOperator) - numbers.get(indexOfOperator + 1);
			operators.remove(indexOfOperator);
			numbers.set(indexOfOperator, result);
			numbers.remove(indexOfOperator + 1);
			return;
		}
	}
}
