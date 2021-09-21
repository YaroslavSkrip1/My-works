package test.skillup.editor;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import test.skillup.editor.instances.AbstractEditor;
import test.skillup.editor.instances.ArrayEditor;
import test.skillup.editor.instances.MatrixEditor;
import test.skillup.editor.instances.TextEditor;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//matrixEditor();
	
		
		Scanner scanner = new Scanner(System.in);
		EditorService editorService = new EditorService();
		
		while (true) {
			try {
			boolean exit = false;
			System.out.print("Create editor - 1, Select editor - 2, List editors - 3, Exit - 0: ");
			int command = scanner.nextInt();
			switch (command) {
			case 1: {
				editorService.openCreationMenu();
				break;
			}
			case 2: { 
				System.out.print("Enter editor name: ");
				String name = scanner.next();
				AbstractEditor<?> editor = editorService.get(name);
				editor.openEditorMenu();
				break;
			}
			case 3: {
				editorService.print();
				break;
			}
			case 0: {
				exit = true;
				break;
			}
			default:
			}

			if (exit) {
				break;
			}
			}catch (InputMismatchException e) {
				System.out.println("Enter to value from 1 to 3 or 0");	
				scanner.next();
			}
		}
	}

	public static void textEditor() {
		TextEditor textEditor = new TextEditor();
		
		textEditor.add("A1", "Text 1");
		textEditor.add("A2", "Text 2");
		textEditor.add("A3", "Text 3");

		textEditor.print();

		textEditor.remove("A2");
		textEditor.print();

		System.out.println(textEditor.get("A3"));

		textEditor.add("A1", "New Text");
		textEditor.print();
	}

	public static void arrayEditor() {

		ArrayEditor arrayEditor = new ArrayEditor();
		arrayEditor.add("A1", Arrays.asList(1d, 5d, 8d, 7.5d, 4d, 9d));
		arrayEditor.add("A4", Arrays.asList(3d, 5d, 6d, 7.5d, 4d, 9d));
		arrayEditor.add("A5", Arrays.asList(2d, 5d, 8d, 71.5d, 8d, 9d));
		arrayEditor.print();
	}

	public static void matrixEditor() {
		MatrixEditor matrixEditor = new MatrixEditor();

		matrixEditor.add("M1", Arrays.asList(Arrays.asList(1, 5, 6), Arrays.asList(3, 2, 7), Arrays.asList(8, 4, 9)));

		matrixEditor.print();
	}
}
