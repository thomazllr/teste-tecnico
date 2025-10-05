package com.thomazllr.tickets.controller;

import com.thomazllr.tickets.commons.FileUtils;
import com.thomazllr.tickets.config.IntegrationTestConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.javacrumbs.jsonunit.assertj.JsonAssertions;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Sql(value = "/sql/clean-tickets.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class TicketControllerIT extends IntegrationTestConfig {

    private static final String URL = "/v1/tickets";

    @Autowired
    private FileUtils fileUtils;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    @DisplayName("GET v1/tickets returns a list with all tickets and dashboard stats")
    @Sql("/sql/init-tickets-find-all.sql")
    @Order(1)
    void findAll_ReturnsListOfTicketsAndDashboardStats_WhenSuccessful() {

        String expectedJson = fileUtils.readResourceFile("ticket/get-ticket-dashboard-response-200.json");

        given()
                .accept(ContentType.JSON)
                .queryParam("year", 2025)
                .queryParam("month", 10)
                .when()
                .get(URL)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(expectedJson));
    }

    @Test
    @DisplayName("POST v1/tickets creates a new ticket and returns the created ticket with status 201")
    @Sql("/sql/init-tickets-save.sql")
    @Order(2)
    void save_ReturnsCreatedTicket_WhenSuccessful() {

        String ticketRequestJson = fileUtils.readResourceFile("ticket/post-ticket-request-200.json");

        String expectedJsonResponse = fileUtils.readResourceFile("ticket/post-ticket-response-201.json");

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(ticketRequestJson)
                .when()
                .post(URL)
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body(equalTo(expectedJsonResponse));
    }

    @ParameterizedTest
    @MethodSource("provideInvalidTicketRequests")
    @DisplayName("POST v1/tickets returns 400 when request has invalid fields")
    @Order(3)
    void save_ReturnsBadRequest_WhenRequestIsInvalid(String requestFile, String responseFile) {
        String ticketRequestJson = fileUtils.readResourceFile("ticket/" + requestFile);
        String expectedJsonResponse = fileUtils.readResourceFile("ticket/" + responseFile);

        var response = RestAssured.given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(ticketRequestJson)
                .when()
                .post(URL)
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .log().all()
                .extract().response().body().asString();

        JsonAssertions.assertThatJson(response)
                .whenIgnoringPaths("timestamp")
                .when(Option.IGNORING_ARRAY_ORDER)
                .isEqualTo(expectedJsonResponse);
    }


    private static Stream<Arguments> provideInvalidTicketRequests() {
        return Stream.of(
                Arguments.of("post-request-ticket-empty-fields-400.json", "post-response-ticket-empty-fields-400.json"),
                Arguments.of("post-request-ticket-blank-fields-400.json", "post-response-ticket-blank-fields-400.json"),
                Arguments.of("post-request-ticket-null-client-400.json", "post-response-ticket-null-client-400.json"),
                Arguments.of("post-request-ticket-null-module-400.json", "post-response-ticket-null-module-400.json")
        );
    }

}

