package project;

import java.util.Random;

public class EntityProcessor {

	public void process(Entity entity) {
		if (new Random().nextBoolean()) {
			entity.addValue(10);
			entity.addValue(1);
			entity.addValue(2);
			System.out.println("In real method!");
		}
	}

}
