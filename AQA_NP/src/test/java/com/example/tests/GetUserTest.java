package com.example.tests;

import com.example.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {

    @Test
    void checkUserExists() {
        given()
        .when()
            .get("/api/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2));
    }
}
