package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class B_POSTmethodBodyFormDataTest {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyFormData() {
        Integer productId = 142;
        Integer quantity = 10;
        Boolean returnCart = true;

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.addItem(productId, quantity, returnCart, endpoint);
    }

    @Test
    public void addItemWithBodyMap() {
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("product_id", 138);
        queryParamsBody.put("quantity", 1);
        queryParamsBody.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }

    @Test
    public void calculateWithBodyMap() {
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("return", true);


        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }

    @Test
    public void getCart() {
        String endpoint = "/cocart/v1/get-cart";

        Response response = serviceHelper.sendGetRequest(endpoint);
        Assertions.assertEquals(200, response.statusCode());
    }
}
