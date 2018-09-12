package project;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class EntityServiceTest {

	@Mock
	private EntityProcessor processor;
	
	private EntityService service;
	
	@Before
	public void setUp() {
		service = new EntityService(processor);
	}
	
	@Test
	public void shouldReturnValidEntityWhenValuesQuantityIsGreaterThanZero() {
		Entity entity = new Entity();
		entity.setName("Hector");

		Mockito.doAnswer(new Answer<Void>() {
			public Void answer(InvocationOnMock invocation) throws Throwable {
				Entity entity = (Entity) invocation.getArguments()[0];
				entity.addValue(5);
				entity.addValue(2);
				System.out.println("In mock!");
				return null;
			}
		}).when(processor).process(entity);
		
		service.execute(entity);
		
		assertTrue(entity.isValid());
	}
	
	@Test
	public void shouldReturnInvalidEntityWhenValuesQuantityIsEqualThanZero() {
		Entity entity = new Entity();
		entity.setName("Hellen");
		
		service.execute(entity);
		
		assertFalse(entity.isValid());	
	}
}
