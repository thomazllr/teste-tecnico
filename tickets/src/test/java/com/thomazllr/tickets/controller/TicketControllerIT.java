package com.thomazllr.tickets.controller;

import com.thomazllr.tickets.commons.FileUtils;
import com.thomazllr.tickets.commons.TicketUtils;
import com.thomazllr.tickets.config.IntegrationTestConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TicketControllerIT extends IntegrationTestConfig {

    private static final String URL = "/v1/tickets";

    @Autowired
    private TicketUtils ticketUtils;

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
    @Sql(value = "/sql/init_tickets.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "/sql/clean_tickets.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Order(1)
    void findAll_ReturnsListOfTicketsAndDashboardStats_WhenSuccessful() {

        String expectedJson = fileUtils.readResourceFile("ticket/get-ticket-dashboard-response-200.json");

        given()
                .accept(ContentType.JSON)
                .when()
                .get(URL)
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(expectedJson));
    }
}

