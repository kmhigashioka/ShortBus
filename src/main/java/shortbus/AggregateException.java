package shortbus;

import java.util.List;

public class AggregateException extends Exception {

	private static final long serialVersionUID = 1L;
	private List<Exception> exceptions;

	public AggregateException(List<Exception> exceptions) {
		this.exceptions = exceptions;
	}

	public List<Exception> getExceptions() {
		return exceptions;
	}

}
