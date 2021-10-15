package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

public class D_POSTmethodBodyJSONobject {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyJsonObject() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", "140");
        bodyRequest.put("quantity", "5");
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
        response.body().print();


    }

    @Test
    public void calculate() {

        boolean calculate = true;

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        response.body().print();

    }
}
