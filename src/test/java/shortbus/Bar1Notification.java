package shortbus;

public class Bar1Notification implements NotificationHandler<FooNotification> {

	@Override
	public void handle(FooNotification notification) {
		notification.counter++;
	}

}
