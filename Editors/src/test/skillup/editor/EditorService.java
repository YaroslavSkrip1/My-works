package test.skillup.editor;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import test.skillup.editor.instances.AbstractEditor;
import test.skillup.editor.instances.ArrayEditor;
import test.skillup.editor.instances.MatrixEditor;
import test.skillup.editor.instances.TextEditor;

public class EditorService {

	private Scanner scanner = new Scanner(System.in);
	private Map<String, AbstractEditor<?>> editors = new HashMap<String, AbstractEditor<?>>();

	public void add(String name, AbstractEditor<?> editor) {
		editors.put(name, editor);
	}

	public AbstractEditor<?> get(String name) {
		return editors.get(name);
	}

	public void print() {
		System.out.println("Editors:");
		for (String key : editors.keySet()) {
			System.out.println("-" + key);
		}
	}

	public void openCreationMenu() {
			
		boolean exit = false;
		
		while (true) {
			try {
			System.out.print("Text editor - 1, Array editor - 2, Matrix editors - 3, Back - 0: ");
			int type = scanner.nextInt();
			switch (type) {
			case 0: {
				exit = true;
				break;
			}
			case 1: {
				System.out.print("Enter name for Text Editor: ");
				TextEditor editor = new TextEditor();
				add(scanner.next(), editor);
				editor.openEditorMenu();
				break;
			}
			case 2: {
				System.out.print("Enter name for Array Editor: ");
				ArrayEditor editor = new ArrayEditor();
				add(scanner.next(), editor);
				editor.openEditorMenu();
				break;
			}
			case 3: {
				System.out.print("Enter name for Matrix Editor: ");
				MatrixEditor editor = new MatrixEditor();
				add(scanner.next(), editor);
				editor.openEditorMenu();
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
}
