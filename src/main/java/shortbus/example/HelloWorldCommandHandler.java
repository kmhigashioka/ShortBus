package shortbus.example;

import org.springframework.stereotype.Component;

import shortbus.RequestHandler;

@Component
public class HelloWorldCommandHandler implements RequestHandler<HelloWorldCommand, String> {

	@Override
	public String handle(HelloWorldCommand request) {
		return "Hello";
	}

}
