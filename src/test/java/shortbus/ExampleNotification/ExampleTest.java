package shortbus.ExampleNotification;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import shortbus.Mediator;
import shortbus.TestSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestSetup.class, Bar1Notification.class, Bar2Notification.class,
		Bar3Notification.class })
public class ExampleTest {

	@Autowired
	Mediator mediator;

	@Test
	public void sendNotification() {
		FooNotification notification = new FooNotification();
		mediator.notify(notification);
		assertThat(notification.counter).isEqualTo(2);
	}
}
