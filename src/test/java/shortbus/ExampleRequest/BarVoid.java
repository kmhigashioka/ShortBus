package shortbus.ExampleRequest;

import shortbus.RequestHandler;

public class BarVoid implements RequestHandler<FooVoid, Void> {

	@Override
	public Void handle(FooVoid request) {
		return null;
	}

}
