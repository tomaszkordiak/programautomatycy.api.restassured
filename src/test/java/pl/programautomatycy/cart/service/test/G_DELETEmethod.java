package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.junit.Test;

public class G_DELETEmethod {

    ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void removeItemFromCart() {

            String endpoint = "cocart/v1/item";
            String parameters = "?cart_item_key=1385974ed5904a438616ff7bdb3f7439&return_cart=true";

            Response response = serviceHelper.sendDeleteRequest(endpoint + parameters);
            response.getBody().prettyPrint();

    }

    @Test
    public void removeItemFromCartBody() {

        String bodyRequest = """
                {
                    "cart_item_key": "1385974ed5904a438616ff7bdb3f7439",
                    "return_cart": true
                }""";
        String endpoint = "cocart/v1/item";

        Response response = serviceHelper.sendDeleteRequest(bodyRequest, endpoint);
        response.getBody().prettyPrint();

    }
}
