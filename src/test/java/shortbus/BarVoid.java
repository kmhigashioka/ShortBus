package shortbus;

public class BarVoid implements RequestHandler<FooVoid, Void> {

	@Override
	public Void handle(FooVoid request) {
		return null;
	}

}
