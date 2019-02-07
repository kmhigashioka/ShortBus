package shortbus.ExampleNotification;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import shortbus.AggregateException;
import shortbus.Mediator;
import shortbus.Response;
import shortbus.TestSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestSetup.class, Bar1Notification.class, Bar2Notification.class,
		Bar3Notification.class, Dong1.class, Dong2.class })
public class ExampleTest {

	@Autowired
	Mediator mediator;

	@Test
	public void sendNotification() {
		FooNotification notification = new FooNotification();
		mediator.notify(notification);
		assertThat(notification.counter).isEqualTo(2);
	}

	@Test
	public void sendNotificationHandleExceptions() {
		Ding ding = new Ding();
		Response<Void> response = mediator.notify(ding);
		assertThat(response.hasException()).isTrue();
		List<Exception> exceptions = ((AggregateException) response.exception).getExceptions();
		assertThat(exceptions.get(0)).isInstanceOf(RuntimeException.class);
		assertThat(exceptions.get(0).getMessage()).isEqualTo("Thrown Dong1 Exception.");
		assertThat(exceptions.get(1)).isInstanceOf(UnsupportedOperationException.class);
		assertThat(exceptions.get(1).getMessage()).isEqualTo("Thrown Dong2 Exception.");
	}
}
