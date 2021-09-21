package test.skillup.editor.instances;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

public class ArrayEditor extends AbstractEditor<List<Double>> {

	@Override
	public void print() {
		System.out.println(data);
	}

	@Override
	public void openEditorMenu() {

		boolean exit = false;
		while (true) {
			try {
				System.out.print("Add array - 1, Get array - 2, Remove array - 3, Manage array - 4, Back - 0: ");
				int type = scanner.nextInt();

				switch (type) {
				case 0: {
					exit = true;
					break;
				}
				case 1: {
					addNewArray();
					break;
				}
				case 2: {

					break;
				}
				case 3: {

					break;
				}
				case 4: {
					openTextMenu();
					break;
				}
				default:
				}
				if (exit) {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter to value from 1 to 4 or 0");
				scanner.next();
			}
		}
	}

	public void openTextMenu() {

		String name = scanner.next();
		boolean exit = false;

		while (true) {
			try {
				System.out.print(
						"Sort array - 1, Get min and max - 2, Replace word - 3, Calculate value - 4, Concateneate array - 5, Back - 0: ");
				int type = scanner.nextInt();

				switch (type) {

				case 0: {
					exit = true;
					break;
				}
				case 1: {
					arraySort();
					break;
				}
				case 2: {
					arrayMaxAndMin();
					break;
				}
				case 3: {
					arrayAddValue();
					break;
				}
				case 4: {

					break;
				}
				case 5: {
					// calculateCountsAllWords(name);
					break;
				}
				default:
				}
				if (exit) {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter to value from 1 to 4 or 0");
				scanner.next();
				e.printStackTrace();
			}

		}

	}

	private void addNewArray() {
		System.out.print("Enter array name: ");
		String name = scanner.next();
		System.out.print("Enter numbers: ");
		Scanner arrayScanner = new Scanner(System.in);
		List<Double> arraySize = new ArrayList<Double>();

		
			while (true) {
				if (arrayScanner.hasNextDouble()) {
					double i = arrayScanner.nextDouble();
					arraySize.add(i);
					if (i == -1) {
						break;
					}
				} else
					System.out.println("Enter value");

			}

			add(name, arraySize);
			openTextMenu();
	}

	private void arraySort() {
		System.out.print("Enter text name: ");
		String name = scanner.next();
		List<Double> sort = new ArrayList<Double>(get(name));
		Collections.sort(sort);
		System.out.println(sort);
	}

	private void arrayMaxAndMin() {

		System.out.print("Enter text name: ");
		String name = scanner.next();
		List<Double> array = new ArrayList<Double>(get(name));

		Double min = Collections.min(array);
		Double max = Collections.max(array);
		System.out.println("Minimum value is: " + min);
		System.out.println("Maximum value is: " + max);

	}

	private void arrayAddValue() {

		System.out.print("Enter text name: ");
		String name = scanner.next();
		List<Double> number = get(name);
		List<Double> minArray = new ArrayList<Double>();
		System.out.println("Enter value");
		double x = scanner.nextDouble();
		for (Double numbers : number) {
			if (x < numbers) {
				minArray.add(x);
			}
		}
		System.out.println(minArray.size());
	}

}
