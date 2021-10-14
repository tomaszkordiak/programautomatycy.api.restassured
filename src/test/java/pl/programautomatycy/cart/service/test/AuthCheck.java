package pl.programautomatycy.cart.service.test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import java.util.Base64;

public class AuthCheck {

    public static String clientId = "7i6Tg5l8x5fBYA5rVZt1CoP1WXvQdcAD";
    public static String redirectUri = "https://qa.app.service.qone.mateco.eu";
    public static String scope = "service-app:login";
    public static String username = "<to be filled in>";
    public static String password = "<to be filled in>";

    public static String encode(String str1, String str2) {
        return new String(Base64.getEncoder().encode((str1 + ":" + str2).getBytes()));
    }

    public static Response getCode() {
        String authorization = encode(username, password);

        return
                given()
                        .header("authorization", "Basic " + authorization)
                        .contentType(ContentType.URLENC)
                        .formParam("response_type", "code")
                        .queryParam("client_id", clientId)
                        .queryParam("redirect_uri", redirectUri)
                        .queryParam("scope", scope)
                        .post("https://mateco-dev.eu.auth0.com/authorize?audience=qservice")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }

    public static String parseForOAuth2Code(Response response) {
        return response.jsonPath().getString("code");
    }

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "<to_be_filled_in>";
    }

    @Test
    public void iShouldGetCode() {
        Response response = getCode();
        String code = parseForOAuth2Code(response);

        Assertions.assertNotNull(code);
    }
}