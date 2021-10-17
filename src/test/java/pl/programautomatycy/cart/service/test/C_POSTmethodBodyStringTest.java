package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class C_POSTmethodBodyStringTest {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyString() {
        String bodyRequest = """
                {
                    "product_id": "142",
                    "quantity": "5",
                    "return_cart": true
                }""";

        String endpoint = "/cocart/v1/add-item";
        System.out.println(bodyRequest);

        Response response = serviceHelper.sendPostRequest(bodyRequest, endpoint);

        System.out.println(response.getBody().print());

        Assertions.assertEquals(200, response.statusCode());

    }

    @Test
    public void calculate() {

        boolean calculate = true;

        String bodyRequest = "{\n" +
                " \"return\": " + calculate +"\n" +
                "}";

        String endpoint = "/cocart/v1/calculate";

        Response response = serviceHelper.sendPostRequest(bodyRequest, endpoint);

        response.body().print();

    }
}
