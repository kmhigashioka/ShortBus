package shortbus;

/**
 * Defines a handler for a request.
 *
 * @param <T> Request
 * @param <R> Result type
 */
public interface RequestHandler<T, R> {
	/**
	 * Handles a request
	 * 
	 * @param request Request parameter
	 * @return Result type
	 */
	public R handle(T request);
}
