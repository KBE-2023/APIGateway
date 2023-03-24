package apigw.apigw.configuration;
/*
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

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
*/