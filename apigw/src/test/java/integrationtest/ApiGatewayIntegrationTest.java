package integrationtest;

import apigw.apigw.ApigwApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import org.mockserver.integration.ClientAndServer;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@SpringBootTest(classes = ApigwApplication.class)
@AutoConfigureWebTestClient
public class ApiGatewayIntegrationTest {

    private ClientAndServer mockServer;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    public void startMockServer() {
        mockServer = ClientAndServer.startClientAndServer(8087, 8090);
    }

    @AfterEach
    public void stopMockServer() {
        mockServer.stop();
    }

    @Test
    public void shouldRouteRequestToProductService() {
        mockServer.when(request().withMethod("GET").withPath("/products/"))
                .respond(response().withStatusCode(200).withBody("Response from Product Service"));

        webTestClient.get()
                .uri("/products/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Response from Product Service");
    }

    @Test
    public void shouldRouteRequestToBasketService() {
        mockServer.when(request().withMethod("POST").withPath("/baskets/"))
                .respond(response().withStatusCode(200).withBody("Response from Basket Service"));

        webTestClient.post()
                .uri("/baskets/")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Response from Basket Service");
    }
}

