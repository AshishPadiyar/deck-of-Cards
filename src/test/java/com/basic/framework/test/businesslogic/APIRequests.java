package com.basic.framework.test.businesslogic;

import com.basic.framework.test.setUp.Setup;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIRequests extends Setup {


    public static String getDeckId() {
        String id = null;
        try {
            id = given().
                    formParam("deck_count", 1)
                    .when().
                            get("/new" + config.getProperty("shuffleEndPoint")).
                            then().
                            assertThat().log().all().statusCode(200).extract().path("deck_id").toString();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return id;

    }

    public static Response getRequestToDrawCard(String deckId) {
        return
                given().
                        formParam("count", 2).
                        when().
                        get("/" + deckId + config.getProperty("drawCardEndPoint")).
                        then().
                        assertThat().log().all().statusCode(200).extract().response();

    }
}
