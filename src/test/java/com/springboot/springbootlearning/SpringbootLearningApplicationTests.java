package com.springboot.springbootlearning;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class SpringbootLearningApplicationTests {

    @Test
    void contextLoads() {
    }

    private final static String BASE_URI = "http://localhost";

    @Value("${local.server.port}")
    private int port;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    private ValidatableResponse response;

    @BeforeEach
    public void configureRestAssured() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = port;

    }

    @Test
    public void verifyGet() {
        System.out.println(dbName);
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(contextPath + "/user/findAll")
                .then()
                .assertThat().statusCode(200);
        String Actual = response.extract().asString();
        System.out.println("Result :" + Actual);
        assertTrue(Actual.length() > 0);
    }

    @Test
    public void createAUser() throws JSONException {

        JSONObject user = new JSONObject();

        user.put("firstName", "Timmy");
        user.put("lastName", "singh");

        response = given()
                .contentType(ContentType.JSON).body(user.toString())
                .when()
                .post(contextPath+"/user/save")
                .then()
                .log().all().assertThat().statusCode(200);

        System.out.println(response.extract().asString());


    }
}
