package shortbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;

/**
 * Default implementation of Mediator
 *
 */
public class MediatorImpl implements Mediator {

	private ApplicationContext ctx;

	/**
	 * Initializes a new instance of Mediator
	 * @param ctx Application context of Spring
	 */
	public MediatorImpl(ApplicationContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public <T> Response<T> request(Request<T> request) {
		Response<T> response = new Response<>();
		try {
			MediatorPlan<T> plan = new MediatorPlan<>(RequestHandler.class, "handle", request.getClass(), ctx);
			response.data = plan.invoke(request);
		} catch (Exception e) {
			response.exception = e;
		}
		return response;
	}

	class MediatorPlan<T> {
		Method handleMethod;
		Object handlerInstanceBuilder;

		public MediatorPlan(Class<?> handlerType, String handlerMethodName, Class<?> messageType,
				ApplicationContext context) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
			handlerInstanceBuilder = getBean(handlerType, messageType, context);
			handleMethod = handlerInstanceBuilder.getClass().getDeclaredMethod(handlerMethodName, messageType);
		}

		private Object getBean(Class<?> handlerType, Class<?> messageType, ApplicationContext context)
				throws ClassNotFoundException {
			Map<String, ?> beans = context.getBeansOfType(handlerType);
			for (Entry<String, ?> entry : beans.entrySet()) {
				Class<?> clazz = entry.getValue().getClass();
				Type[] interfaces = clazz.getGenericInterfaces();
				for (Type interace : interfaces) {
					Type parameterType = ((ParameterizedType) interace).getActualTypeArguments()[0];
					if (parameterType.equals(messageType)) {
						return entry.getValue();
					}
				}
			}

			throw new ClassNotFoundException("Handler not found. Did you forget to register this?");
		}

		public T invoke(Request<T> request)
				throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			return (T) handleMethod.invoke(handlerInstanceBuilder, request);
		}
	}

}
