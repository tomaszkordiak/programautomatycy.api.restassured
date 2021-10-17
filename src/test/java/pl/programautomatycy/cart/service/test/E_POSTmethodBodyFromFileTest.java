package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import utils.JsonBodyRequestHelper;
import org.junit.Test;

public class E_POSTmethodBodyFromFileTest {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyFromFile() {
        JSONObject bodyRequest = JsonBodyRequestHelper.getJsonFromFile
                ("request-add-item-to-cart", "add_item_body");

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toJSONString(), endpoint);
        response.body().print();

    }
}
