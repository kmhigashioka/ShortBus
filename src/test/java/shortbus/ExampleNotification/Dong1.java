package shortbus.ExampleNotification;

import shortbus.NotificationHandler;

public class Dong1 implements NotificationHandler<Ding> {

	@Override
	public void handle(Ding notification) {
		throw new RuntimeException("Thrown Dong1 Exception.");
	}

}
