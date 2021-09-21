package test.skillup.editor.instances;

import java.util.List;
import java.util.Scanner;

public class MatrixEditor extends AbstractEditor<List<List<Integer>>> {

	@Override
	public void print() {
		//matrix.get(0).get(0);
		for (List<List<Integer>> matrix : data.values()) {
			for (List<Integer> row : matrix) {
				System.out.println(row);
			}
		}
	}
	


	@Override
	public void openEditorMenu() {
		// TODO Auto-generated method stub

	}

}
