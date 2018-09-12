package project;

public class EntityService {

	private EntityProcessor processor;

	public EntityService(EntityProcessor processor) {
		this.processor = processor;
	}
	
	public void execute(Entity entity) {
		processor.process(entity);
		
		if(entity.getValues().size() > 0) {
			entity.setValid(true);
		}else {
			entity.setValid(false);
		}
	}

}
