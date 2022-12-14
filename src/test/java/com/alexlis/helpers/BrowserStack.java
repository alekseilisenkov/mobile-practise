package com.alexlis.helpers;

import com.alexlis.config.MainConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class BrowserStack {

    public static String videoUrl(String sessionId) {
        MainConfig config = ConfigFactory.create(MainConfig.class, System.getProperties());
        String userName = config.getUserName();
        String accessKey = config.getAccessKey();

        return given()
                .auth().basic(userName, accessKey)
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}
