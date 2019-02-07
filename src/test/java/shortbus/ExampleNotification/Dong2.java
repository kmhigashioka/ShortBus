package shortbus.ExampleNotification;

import shortbus.NotificationHandler;

public class Dong2 implements NotificationHandler<Ding> {

	@Override
	public void handle(Ding notification) {
		throw new UnsupportedOperationException("Thrown Dong2 Exception.");
	}

}
