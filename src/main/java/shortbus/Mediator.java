package shortbus;

/**
 * Defines Mediator to encapsulate request/response.
 *
 */
public interface Mediator {
	/**
	 * Send a request to a single handler.
	 * @param request the actual command/query
	 * @return Response object
	 */
	public <T> Response<T> request(Request<T> request);
}
