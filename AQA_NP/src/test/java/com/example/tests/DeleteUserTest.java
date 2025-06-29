package com.example.tests;

import com.example.base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class DeleteUserTest extends BaseTest {

    @Test
    void deleteUser() {
        given()
        .when()
            .delete("/api/users/2")
        .then()
            .statusCode(204);
    }
}
