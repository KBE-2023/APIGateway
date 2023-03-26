package unittest;


import apigw.apigw.ApigwApplication;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;



@SpringBootTest(classes = ApigwApplication.class)
@AutoConfigureWebTestClient
public class ApiGatewayUnitTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void contextLoads() {
        // This test method will pass if the application context loads without any errors
    }

    @Test
    public void shouldRouteRequestToProductService() {
        webTestClient.get()
                .uri("/products/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Response from Product Service");
    }

    @Test
    public void shouldRouteRequestToBasketService() {
        webTestClient.post()
                .uri("/baskets/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Response from Basket Service");
    }

}
