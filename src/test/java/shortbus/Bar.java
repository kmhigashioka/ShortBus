package shortbus;

public class Bar implements RequestHandler<Foo, String> {

	@Override
	public String handle(Foo request) {
		return "Bar!";
	}

}
