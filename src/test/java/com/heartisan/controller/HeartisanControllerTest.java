package com.heartisan.controller;

import com.jayway.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("development")
@RunWith(SpringRunner.class)
public class HeartisanControllerTest extends RestAssured {

    @Test
    public void sayHelloSuccess() {
        given()
                .accept("application/json")
                .header("Content-Type", "application/json")
                .get("/sayHello")
                .then()
                .log().all()
                .assertThat()
                .and()
                .statusCode(200);
    }
}
