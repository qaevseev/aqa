package com.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class R_GetUserTest {

    private static final String API_KEY = "reqres-free-v1"; // ← 🔁 вставь сюда свой настоящий ключ

    @Test
    @DisplayName("Проверка получения юзера с ID = 2 (через API-ключ)")
    @Description("Проверяет, что API возвращает пользователя Janet Weaver с правильным email.")
    void getUserById() {
        RestAssured.baseURI = "https://reqres.in";

        Response response = RestAssured
                .given()
                .header("x-api-key", API_KEY)   // ← 🔐 ключ нужен обязательно
                .log().all()
                .when()
                .get("/api/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .extract().response();

        logUserName(response);
    }

    @Step("Имя пользователя: {response}")
    void logUserName(Response response) {
        String name = response.path("data.first_name");
        System.out.println("User name: " + name);
    }
}