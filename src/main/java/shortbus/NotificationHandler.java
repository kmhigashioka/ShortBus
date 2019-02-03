package shortbus;

/**
 * Defines a handler for all notification.
 * 
 * @param <T> Notification
 */
public interface NotificationHandler<T> {
	/**
	 * Handles all notification
	 * @param Object parameter of Notification
	 */
	public void handle(T notification);
}
