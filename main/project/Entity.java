package project;

import java.util.ArrayList;
import java.util.List;

public class Entity {

	public String name;
	public List<Integer> values;
	public boolean valid;

	public Entity() {
		values = new ArrayList<Integer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void addValue(Integer value) {
		values.add(value);
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
