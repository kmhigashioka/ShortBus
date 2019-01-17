package shortbus;

public interface Mediator {
	public <T> Response<T> request(Request<T> request);
}
