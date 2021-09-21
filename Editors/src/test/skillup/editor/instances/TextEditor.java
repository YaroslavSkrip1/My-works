package test.skillup.editor.instances;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TextEditor extends AbstractEditor<String> {

	@Override
	public void print() {
		System.out.println(data);
	}

	@Override
	public void openEditorMenu() {
		boolean exit = false;
		while (true) {
			try {
				System.out.print("Add text - 1, Get text - 2, Remove text - 3, Manage text - 4, Back - 0: ");
				int type = scanner.nextInt();
				switch (type) {
				case 0: {
					exit = true;
					break;
				}
				case 1: {
					addNewText();throw new Exception("Enter text");
					
					//break;
				}
				case 2: {
					getText();
					break;
				}
				case 3: {
					deleteText();
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
			} catch (Exception e) {
				System.out.println("Enter to value from 1 to 4 or 0");
				scanner.next();
			}
		}
	}

	public void openTextMenu() {
		System.out.print("Enter text name: ");
		String name = scanner.next();
		boolean exit = false;
		while (true) {
			try {
				System.out.print(
						"Get words count - 1, Get unique words count - 2, Replace word - 3, Get counts per word - 4, Get counts unique per word - 5, Back - 0: ");
				int type = scanner.nextInt();
				switch (type) {
				case 0: {
					exit = true;
					break;
				}
				case 1: {
					calculateWordsCount(name);
					break;
				}
				case 2: {
					calculateUniqueWordsCount(name);
					break;
				}
				case 3: {
					replaceWords(name);
					break;
				}
				case 4: {
					calculateCountsPerWords(name);
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
			}
		}
	}

	@SuppressWarnings("resource")
	private void addNewText() {
		
			System.out.print("Enter text name: ");
			String name = scanner.next();
			System.out.print("Enter text: ");
			Scanner textScanner = new Scanner(System.in);
			String text = textScanner.next();
			add(name, text);
			openTextMenu();
		
	}

	private void getText() {
		System.out.print("Enter text name: ");
		String name = scanner.next();
		System.out.println(get(name));
	}

	private void deleteText() {
		System.out.print("Enter text name: ");
		String name = scanner.next();
		remove(name);
	}

	private void calculateWordsCount(String name) {
		String text = get(name);
		String[] words = text.split(" ");
		System.out.println("Words count: " + words.length);
	}

	private void calculateUniqueWordsCount(String name) {
		String text = get(name);
		String[] words = text.split(" ");
		Set<String> uniqueWords = new HashSet<String>();
		// uniqueWords.addAll(Arrays.asList(words));
		for (String word : words) {
			uniqueWords.add(word);
		}
		System.out.println("Unique words count: " + uniqueWords.size());
	}

	private void replaceWords(String name) {
		System.out.print("Enter word to replace: ");
		String toReplace = scanner.next();
		System.out.print("Enter new word: ");
		String newWord = scanner.next();
		String text = get(name);
		text = text.replaceAll(toReplace, newWord);
		add(name, text);
	}

	private void calculateCountsPerWords(String name) {
		String text = get(name);
		String[] words = text.split(" ");
		Map<String, Integer> matrix = new HashMap<String, Integer>();
		for (String word : words) {
			if (!matrix.containsKey(word)) {
				matrix.put(word, 1);
			} else {
				matrix.put(word, matrix.get(word) + 1);
			}

		}
		System.out.print(matrix);
	}

	private void calculateCountsAllWords(String name) {
		String text = get(name);
		String[] words = text.split(" ");
		Map<String, Integer> uniqueWords = new HashMap<String, Integer>();
		for (String word : words) {
			if (!uniqueWords.containsKey(word)) {
				uniqueWords.put(word, 1);
			} else {
				uniqueWords.put(word, uniqueWords.get(word) + 1);
			}
		}
		System.out.println(uniqueWords);
	}

	public void calculateAllWord() {

		for (String text : data.values()) {
			String[] words = text.split(" ");
			Set<String> uniqueWords = new HashSet<String>();
			// uniqueWords.addAll(Arrays.asList(words));
			for (String word : words) {
				uniqueWords.add(word);
			}
			System.out.println("Unique words count: " + uniqueWords.size());
		}

	}
}
