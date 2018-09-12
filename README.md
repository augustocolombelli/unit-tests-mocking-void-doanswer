### Unit Tests - DoAnswer
Simple example using the resource DoAnswer of Mockito 

#### How can we use this resource?
We can use the Do Answer when we have some void method that changes some attribute that is used to validate another rule in the code. Unfortunately, in real life, we have this kind of code in software with a lot of legacy code. Using this feature, you can use unit tests to simulate changes in attributes.

Configure the test to run with Mockito:
```
@RunWith(MockitoJUnitRunner.class)
public class EntityServiceTest {
...
}
```
Annotation in the class with the method that you need to mock:
```
	@Mock
	private EntityProcessor processor;
```
Example of unit test that is using this resource:
```
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
```
#### What is necessary for to use this resource?
In this example, its used junit-4.10.jar and mockito-all-1.10.19. 
