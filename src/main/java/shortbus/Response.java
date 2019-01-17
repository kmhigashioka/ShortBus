package shortbus;

public class Response<T> {
	public T data;
	public Exception exception;

	public boolean hasException() {
		return exception != null;
	}
}
