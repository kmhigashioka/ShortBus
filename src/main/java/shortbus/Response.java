package shortbus;

/**
 * Response object given from Request.
 *
 * @param <T> Result type
 */
public class Response<T> {
	/**
	 * Request's result data
	 */
	public T data;
	/**
	 * Request's result exception (if there's any)
	 */
	public Exception exception;

	/**
	 * Return if request has exception
	 * 
	 * @return true if exception occured; otherwise false
	 */
	public boolean hasException() {
		return exception != null;
	}
}
