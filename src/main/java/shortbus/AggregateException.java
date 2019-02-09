package shortbus;

import java.util.List;

/**
 * Aggregated list of exceptions
 * 
 */
public class AggregateException extends Exception {

	private static final long serialVersionUID = 1L;
	private List<Exception> exceptions;

	/**
	 * Initializes a new instance of AggregateException
	 * 
	 * @param exceptions list of Exception
	 */
	public AggregateException(List<Exception> exceptions) {
		this.exceptions = exceptions;
	}

	/**
	 * Get the list of Exception
	 * 
	 * @return exceptions
	 */
	public List<Exception> getExceptions() {
		return exceptions;
	}

}
