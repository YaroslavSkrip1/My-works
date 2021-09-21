package test.skillup.editor.menu;

import java.util.Scanner;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in);

	public int startMenu() {
		
		int command = scanner.nextInt();
		return command;
	}
	
	
}
