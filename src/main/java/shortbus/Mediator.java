package shortbus;

/**
 * Defines Mediator to encapsulate request/response.
 *
 */
public interface Mediator {
	/**
	 * Send a request to a single handler.
	 * 
	 * @param request the actual command/query
	 * @param <T> the expected return type
	 * @return Response object
	 */
	public <T> Response<T> request(Request<T> request);

	/**
	 * Send a notification to all handler.
	 * 
	 * @param notification the actual notification
	 * @return Response object
	 */
	public Response<Void> notify(Notification notification);
}
