package shortbus;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import shortbus.example.HelloWorldCommand;
import shortbus.example.HelloWorldCommandHandler;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		Mediator mediator = new MediatorImpl(ctx);
		Response<String> response = mediator.request(new HelloWorldCommand());
		System.out.println(response);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			HelloWorldCommandHandler commandhandler = ctx.getBean(HelloWorldCommandHandler.class);
			System.out.println(commandhandler);

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

}
