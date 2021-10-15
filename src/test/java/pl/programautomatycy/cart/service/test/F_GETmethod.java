package pl.programautomatycy.cart.service.test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.minidev.json.JSONObject;
import org.junit.Test;

import java.util.Map;

public class F_GETmethod {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void getCartContent() {
        String endpoint_cart_content = "cocart/v1/get-cart";

        Response response = serviceHelper.sendGetRequest(endpoint_cart_content);
        response.getBody().prettyPrint();


    }

    @Test
    public void countItems() {
        String endpoint = "cocart/v1/count-items";

        Response response = serviceHelper.sendGetRequest(endpoint);
        response.getBody().print();


    }

    @Test
    public void restoreItemsToCartWithParameters() {

        String endpoint = "cocart/v1/item";
        String parameters = "?cart_item_key=1385974ed5904a438616ff7bdb3f7439&return_cart=true";

        Response response = serviceHelper.sendGetRequest(endpoint + parameters);
        response.getBody().prettyPrint();

    }

    @Test
    public void restoreItemToCartBody() {

        String bodyRequest = """
                {
                    "cart_item_key": "1385974ed5904a438616ff7bdb3f7439",
                    "return_cart": true
                }""";

        String endpoint = "cocart/v1/item";

        Response response = serviceHelper.sendGetRequest(bodyRequest, endpoint);
        response.getBody().prettyPrint();

    }
}
