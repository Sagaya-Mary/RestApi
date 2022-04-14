package com.dfs.product.wiremocktest;

import java.net.URISyntaxException;
import java.net.URI;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestWIreMock {

    private static final int PORT = 8090;
    private static final String HOST = "localhost";

    private static WireMockServer server = new WireMockServer(PORT);

    @BeforeAll
    public static void setup() {
        server.start();
        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
        mockResponse.withStatus(200);
        WireMock.configureFor(HOST, PORT); // http://localhost:8080
        WireMock.stubFor(
                WireMock.get("/products/all")
                        .willReturn(mockResponse)
        );
    }

    @Test
    public void TestGetEndPoint() throws URISyntaxException {
        RestAssured.given()

                .when()
                .get(new URI("http://localhost:8090/products/all"))
                .then()
                .assertThat()
                .statusCode(200);
    }

    @AfterAll
    public static void teardown() {
        if (null != server && server.isRunning()) {
            server.shutdownServer();
        }

    }
}
