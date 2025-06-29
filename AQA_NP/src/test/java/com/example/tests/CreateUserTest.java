package com.example.tests;

import com.example.base.BaseTest;
import com.example.models.User;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTest extends BaseTest {

    @Test
    void createUser() {
        User user = new User();
        user.name = "Neo";
        user.job = "The One";

        given()
            .contentType("application/json")
            .body(user)
        .when()
            .post("/api/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Neo"));
    }
}
