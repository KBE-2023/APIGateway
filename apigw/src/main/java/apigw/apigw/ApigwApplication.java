package apigw.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApigwApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigwApplication.class, args);
	}


	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/products/**")
						.filters(f -> f.addRequestHeader("Hello", "World"))
						.uri("http://localhost:8087/products/**"))

				.route(p -> p
						.path("/baskets/**")
						.filters(f -> f.addRequestHeader("Hello", "World"))
						.uri("http://localhost:8090/baskets/**"))

				.build();
	}

}
