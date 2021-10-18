package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import pl.programautomatycy.cart.service.test.deserialising.*;

import java.util.Map;

public class L_Deserialisng {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemResponseDeserialising() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", "142");
        bodyRequest.put("quantity", "1");
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        AddItemResponse responseBody = response.as(AddItemResponse.class);

    //        Map<String, String> total = (Map<String, String>)
    // responseBody.getLine_tax_data().getTotal();
    //        Object tot = total.get("1");
    //        System.out.println(tot);
        System.out.println(responseBody.getLine_tax_data().getTotal().getTotal1());
    }
}
