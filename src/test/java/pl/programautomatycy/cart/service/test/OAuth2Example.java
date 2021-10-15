package pl.programautomatycy.cart.service.test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import kong.unirest.HttpRequestWithBody;
import kong.unirest.Unirest;
import net.minidev.json.JSONObject;
import org.json.JSONException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.net.http.HttpResponse;

public class OAuth2Example {

//    private final String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IlFqTXdSakpGT1VKRk0wSTVNRVkwTmpVelF6azFNa1F3T1VaRFJESTFRamM0TWprMk9ERkNOdyJ9.eyJodHRwOi8vbWF0ZWNvLmV1L29pZCI6IjZkZjlkODljLTY1MjAtNDgzNC04ZDFiLWU0ODBlZWUwNzg0NCIsImh0dHBzOi8vc2VydmljZS5xb25lL2VtYWlsIjoicGlvdHIuYnJ6eXNraUBtYXRlY28uZXUiLCJodHRwczovL3NlcnZpY2UucW9uZS9uYW1lIjoiUGlvdHIgQnJ6eXNraSIsImh0dHBzOi8vc2VydmljZS5xb25lL29pZCI6IjZkZjlkODljLTY1MjAtNDgzNC04ZDFiLWU0ODBlZWUwNzg0NCIsImlzcyI6Imh0dHBzOi8vbWF0ZWNvLWRldi5ldS5hdXRoMC5jb20vIiwic3ViIjoid2FhZHxrUVV4VHhISWJfNEY4YUxpSG0wLUY2dTBKN2QwV3hvZDZyYXJGZy05eWU0IiwiYXVkIjoicXNlcnZpY2UiLCJpYXQiOjE2MzQyMTM4NjksImV4cCI6MTYzNDMwMDI2OSwiYXpwIjoiN2k2VGc1bDh4NWZCWUE1clZadDFDb1AxV1h2UWRjQUQiLCJzY29wZSI6InNlcnZpY2UtYXBwOmxvZ2luIG1hY2hpbmVzOnJlYWQgY2hlY2t1cHM6ZXhlY3V0ZSB0YXNrczpyZWFkIHVzZXJzOnVwZGF0ZSB0aW1lc2hlZXRzOmNyZWF0ZS1vd24gcGljdHVyZXM6Y3JlYXRlIHRhc2tzOnVzZS1wYXJ0cyB0YXNrczp1cGRhdGUgbGluazphY2Nlc3MgZHluYW1pY3M6YWNjZXNzIG1hY2hpbmVzOnJlbGVhc2UgbWFjaGluZXM6c3dpdGNoLXN3YXAgbWV0cmljczpsb2dpbiBtZXRyaWNzOnJlYWQgdXNlcnM6cmVhZCByZXBvcnRzOnJlYWQgdGltZXNoZWV0czpyZWFkIGNoZWNrdXBzOnJlYWQgbWFjaGluZXM6bW92ZSBjbG9zZWRUYXNrczp1cGRhdGUgcGljdHVyZXM6cmVhZCB0aW1lc2hlZXRzOmNyZWF0ZS1hbGwgd29ya2luZy1kYXk6cmVnaXN0ZXIgZHluYW1pY3M6YWNjZXNzIGxpbms6YWNjZXNzIHBsYW5uaW5nOmxvZ2luIHBsYW5uaW5nOnVwZGF0ZSBtYWNoaW5lczpyZWxlYXNlIG1hY2hpbmVzOnN3aXRjaC1zd2FwIHN0b2NrLW1hbmFnZW1lbnQ6cmVhZCIsInBlcm1pc3Npb25zIjpbXX0.BHeYGjB3xEbnZhOo2fVNQr3u1Nc85DAQ52sdf0DgEbFhmDHExPx1uvL_GHzl7__IArgF7Sm_WzZpw6V2er2qmOCo022pxGzXCnrCz0HVqHxIqVVL-uSfYh5T_FE_eJiEa2gDaB5anMwvlZYOzU_oTpHNi1gNia41CPL2es6t7SwCXM2kcTwwOBysz9ty1Y-mZWU7e9-DOT8hbAxYnqTnt9oO3fl4c4MCy1UNJGOMKik8wbissP9Hm2XymWwEMsRZ3FINqZd-ffmgfKz-ej2nOHk5SwiaZpc8fzoIABPOtgBaVtpC8nnwgi4dCHO1dHQ63Yz7cN4YQZ0urPpfLZzK5g";

    private String getToken() {
        var response = Unirest.post("https://mateco-dev.eu.auth0.com/oauth/token")
                .header("content-type", "application/x-www-form-urlencoded")
                .body("grant_type=client_credentials&client_id=y5OjwtNwzrD81mWIpdnbOVhWuNC4Ocwy&client_secret=YhixBqQckEXoDhSai3Gwhe0ZlHxFL7qTYAFbhfCjX7NrRVjbKeWrT2HR333elzvg&audience=qservice")
                .asString();

        System.out.println(response.getBody());

        String tokenJsonString = response.getBody();

        String myJSON ="{\"name\":\"studytonight\",\"address\":\"Noida\"}";
        try
        {
            org.json.JSONObject jsonToken = new org.json.JSONObject(tokenJsonString);
            System.out.println("JSON Object: "+jsonToken);
            Object token = jsonToken.get("access_token");
            return token.toString();
        }
        catch (JSONException e)
        {
            System.out.println("Error "+e.toString());
            return null;
        }

    }


    @Test
    public void test1() {

    String token = getToken();

    Response resp =
        RestAssured.given()
            .auth()
            .oauth2(token)
            .get(
                "https://machine.qa.service.qone.mateco.eu/machines/types?company=CZ01&brands=HAULOTTE, GENIE")
            .then()
            .extract()
            .response();

    resp.prettyPrint();
    System.out.println("Code " + resp.getStatusCode());
    System.out.println("Code " + resp.getBody().asString());
    }

    @Test
    public void test2() {
        Response oauth_token ;

    oauth_token =
        RestAssured.given()
            .auth()
            .basic("jasper.quirynen@mateco.eu", "yardman123")
            .queryParams("client_id", "y5OjwtNwzrD81mWIpdnbOVhWuNC4Ocwy")
            .queryParams(
                "client_secret",
                "YhixBqQckEXoDhSai3Gwhe0ZlHxFL7qTYAFbhfCjX7NrRVjbKeWrT2HR333elzvg")
            .queryParams("grant_type", "Authorization Code")
            .queryParams("redirect_uri", "https://qa.app.service.qone.mateco.eu")
            .queryParams("scope", "service-app:login")
            .when()
            .post("https://mateco-dev.eu.auth0.com/oauth/token")
            .then()
            .extract()
            .response();

    oauth_token.prettyPrint();
    }

    @Test
    public void test3() {
        RestAssured.baseURI = "https://qa.app.service.qone.mateco.eu";

        RequestSpecification request = RestAssured.given();

        String payload = "{\n" +
                "    \"client_id\": \"y5OjwtNwzrD81mWIpdnbOVhWuNC4Ocwy\",\n" +
                "    \"client_secret\": \"YhixBqQckEXoDhSai3Gwhe0ZlHxFL7qTYAFbhfCjX7NrRVjbKeWrT2HR333elzvg\",\n" +
                "}";

        Response resp = request.body(payload).post("https://mateco-dev.eu.auth0.com/oauth/token");
        resp.prettyPrint();
    }

    @Test
    public void test4() {
        var response = Unirest.post("https://mateco-dev.eu.auth0.com/oauth/token")
                .header("content-type", "application/x-www-form-urlencoded")
                .body("grant_type=client_credentials&client_id=y5OjwtNwzrD81mWIpdnbOVhWuNC4Ocwy&client_secret=YhixBqQckEXoDhSai3Gwhe0ZlHxFL7qTYAFbhfCjX7NrRVjbKeWrT2HR333elzvg&audience=qservice")
                .asJson();

    System.out.println(response.getBody().toString());

        String myJSON ="{\"name\":\"studytonight\",\"address\":\"Noida\"}";
        try
        {
            org.json.JSONObject jsonObject = new org.json.JSONObject(response.getBody().toString());
            System.out.println("JSON Object: "+jsonObject);
        }
        catch (JSONException e)
        {
            System.out.println("Error "+e.toString());
        }
    }

    @Test
    public void postAttendanceLog() {
        String token = getToken();

        String bodyRequest = "{\n" +
                "    \"email\": \"karel.desmet@mateco.eu\",\n" +
                "    \"type\": \"IN\",\n" +
                "    \"timestamp\": \"2021-10-14T06:00:00.000Z\"\n" +
                "}";

        Response resp =
                RestAssured.given()
                        .auth()
                        .oauth2(token)
                        .contentType(ContentType.JSON)
                        .body(bodyRequest)
                        .post(
                                "https://service-user.qa.service.qone.mateco.eu/attendance-logs?ACTIVE-COMPANY=CZ01&ACTIVE-BRANCH=STPDB")
                        .then()
                        .extract()
                        .response();

//        Assertions.assertEquals(201, resp.statusCode());

        resp.prettyPrint();
        System.out.println("Code " + resp.getStatusCode());
        System.out.println("Code " + resp.getBody().asString());
    }
}
