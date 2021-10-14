package pl.programautomatycy.cart.service.test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.GetPropertyValues;

import java.util.Map;

public class ServiceHelper {

    GetPropertyValues getPropertyValues = new GetPropertyValues();

    private final String LOGIN = getPropertyValues.getPropValue("login");
    private final String PASSWORD = getPropertyValues.getPropValue("password");
    private final String BASE_URI = getPropertyValues.getPropValue("shopServerUrl");
    private final SampleRest SAMPLE_REST = new SampleRest();

    public void addItem(Integer productId, Integer quantity, Boolean returnCard, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive() //omija formularz rejestracji
                .basic(LOGIN, PASSWORD)
                .queryParam("product_id", productId)
                .queryParam("quantity", quantity)
                .queryParam("return_cart", returnCard)
                .baseUri(BASE_URI)
                .post(endpoint);
    }

    public void sendPostRequest(Map<String, Object> queryParamsBody, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .queryParams(queryParamsBody)
                .baseUri(BASE_URI)
                .post(endpoint);
    }

    public void sendPostRequest(String body, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .contentType(ContentType.JSON)
                .body(body)
                .baseUri(BASE_URI)
                .post(endpoint);
    }

    public Response sendGetRequest(String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .baseUri(BASE_URI)
                .get(endpoint)
                .then()
                .extract().response();

        return SAMPLE_REST.response;
    }
}

class SampleRest {
    public Response response;
}
