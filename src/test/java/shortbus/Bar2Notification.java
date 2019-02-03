package shortbus;

public class Bar2Notification implements NotificationHandler<FooNotification> {

	@Override
	public void handle(FooNotification notification) {
		notification.counter++;
	}

}
