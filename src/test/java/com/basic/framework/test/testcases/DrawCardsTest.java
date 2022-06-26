package com.basic.framework.test.testcases;

import com.basic.framework.test.setUp.Setup;
import com.basic.framework.test.businesslogic.APIRequests;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DrawCardsTest extends Setup {


    @Test()
    public void getIDAndPrintResponse() {
        String id = APIRequests.getDeckId();
        Response res = APIRequests.getRequestToDrawCard(id);
        Assertions.assertEquals(res.statusCode(), 200);
        for (int i = 0; i < res.jsonPath().getInt("cards.size()"); i++) {
            System.out.println("Records from " + i + " iteration");
            System.out.println(res.jsonPath().get("cards[" + i + "].code").toString());
            System.out.println(res.jsonPath().get("cards[" + i + "].image").toString());
            System.out.println(res.jsonPath().get("cards[" + i + "].images").toString());
            System.out.println(res.jsonPath().get("cards[" + i + "].value").toString());
            System.out.println(res.jsonPath().get("cards[" + i + "].suit").toString());
            System.out.println();

        }


    }

}
