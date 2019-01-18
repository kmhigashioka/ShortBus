package shortbus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestSetup {

	@Bean
	public Mediator getMediator(ApplicationContext ctx) {
		return new MediatorImpl(ctx);
	}
	
}
