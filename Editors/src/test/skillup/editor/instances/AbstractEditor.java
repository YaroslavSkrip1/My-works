  package test.skillup.editor.instances;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractEditor<T> {

	protected Scanner scanner = new Scanner(System.in);
	protected Map<String, T> data;

	public abstract void print();
	public abstract void openEditorMenu();
	

	public AbstractEditor() {
		data = new HashMap<String, T>();
	}

	public void add(String name, T t) {
		data.put(name, t);
	}

	
	public T get(String name) {
		return data.get(name);
	}

	public void remove(String name) {
		if (data.containsKey(name)) {
			data.remove(name);
		}
	}
	
	public Map<String, T> get() {
		return data;
	}
	
}
