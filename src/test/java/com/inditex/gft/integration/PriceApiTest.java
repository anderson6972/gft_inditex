package com.inditex.gft.integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@Tag("integracion")
public class PriceApiTest {
    private static final String BASE_URL = "http://localhost:8080/prices";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    private JSONObject readJsonFile(String filePath) throws IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return new JSONObject(content);
    }

    @Test
    @DisplayName("Test 1: Petición a las 10:00 del día 14 del producto 35455 para la brand 1")
    void test1Integracion() throws IOException, JSONException {
        JSONObject jsonTest = readJsonFile("src/test/postman/test1.json");

        given()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-14 10:00:00")
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("productId", equalTo(jsonTest.getInt("productId")))
                .body("brandId", equalTo(jsonTest.getInt("brandId")))
                .body("priceList", equalTo(jsonTest.getInt("priceList")))
                .body("startDate", equalTo(jsonTest.getString("startDate")))
                .body("endDate", equalTo(jsonTest.getString("endDate")))
                .body("price", equalTo((float) jsonTest.getDouble("price")));
    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void test2Integracion() throws IOException, JSONException {
        JSONObject jsonTest = readJsonFile("src/test/postman/test2.json");

        given()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-14 16:00:00")
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("productId", equalTo(jsonTest.getInt("productId")))
                .body("brandId", equalTo(jsonTest.getInt("brandId")))
                .body("priceList", equalTo(jsonTest.getInt("priceList")))
                .body("startDate", equalTo(jsonTest.getString("startDate")))
                .body("endDate", equalTo(jsonTest.getString("endDate")))
                .body("price", equalTo((float) jsonTest.getDouble("price")));
    }

    @Test
    @DisplayName("Test 3: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void test3Integracion() throws IOException, JSONException {
        JSONObject jsonTest = readJsonFile("src/test/postman/test3.json");

        given()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-14 21:00:00")
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("productId", equalTo(jsonTest.getInt("productId")))
                .body("brandId", equalTo(jsonTest.getInt("brandId")))
                .body("priceList", equalTo(jsonTest.getInt("priceList")))
                .body("startDate", equalTo(jsonTest.getString("startDate")))
                .body("endDate", equalTo(jsonTest.getString("endDate")))
                .body("price", equalTo((float) jsonTest.getDouble("price")));
    }

    @Test
    @DisplayName("Test 4: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void test4Integracion() throws IOException, JSONException {
        JSONObject jsonTest = readJsonFile("src/test/postman/test4.json");

        given()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-15 10:00:00")
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("productId", equalTo(jsonTest.getInt("productId")))
                .body("brandId", equalTo(jsonTest.getInt("brandId")))
                .body("priceList", equalTo(jsonTest.getInt("priceList")))
                .body("startDate", equalTo(jsonTest.getString("startDate")))
                .body("endDate", equalTo(jsonTest.getString("endDate")))
                .body("price", equalTo((float) jsonTest.getDouble("price")));
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
    void test5Integracion() throws IOException, JSONException {
        JSONObject jsonTest = readJsonFile("src/test/postman/test5.json");

        given()
                .queryParam("productId", 35455)
                .queryParam("brandId", 1)
                .queryParam("applicationDate", "2020-06-16 21:00:00")
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("productId", equalTo(jsonTest.getInt("productId")))
                .body("brandId", equalTo(jsonTest.getInt("brandId")))
                .body("priceList", equalTo(jsonTest.getInt("priceList")))
                .body("startDate", equalTo(jsonTest.getString("startDate")))
                .body("endDate", equalTo(jsonTest.getString("endDate")))
                .body("price", equalTo((float) jsonTest.getDouble("price")));
    }
}
