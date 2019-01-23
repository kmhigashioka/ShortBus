# ShortBus
ShortBus is an in-process mediator with low-friction API implemented in Java.
This project is based from [mhinze/ShortBus](https://github.com/mhinze/ShortBus).

## Setting Up

ShortBus is dependent on Spring. You'll need to configure a mediator for dependency.
```
@Configuration
public class MediatorConfig {
    @Bean
    public Mediator getMediator(ApplicationContext ctx) {
        return new MediatorImpl(ctx);
    }
}
```

## Usage
ShortBus supports Request/Response messages. This dispatched to a single handler. 

### Request/Response
The Request/Response interface handles both command and query. First, create a message:
```
public class Ping implements Request<String> {
}
```
Then, create a handler:
```
@Component
public class Pong implements RequestHandler<Ping, String> {
    @override
    public String handle(Ping request) {
        return "Pong!";
    }
}
```
Make sure to annotate with Spring's `@Component`.

### Invoking
To invoke each message:
```
@RestController
public class PingPongController {

    @AutoWired
    Mediator mediator;
    
    public String pingPong() {
        Ping ping = new Ping();
        Response<String> response = mediator.send(ping);
        return response.data; // "Pong!"
    }
}
```
