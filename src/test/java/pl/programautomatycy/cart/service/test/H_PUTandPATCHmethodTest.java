package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

public class H_PUTandPATCHmethodTest {

    ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void updateProductPut() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("key1", "value1");
        bodyRequest.put("ke2", "value2");
        bodyRequest.put("ke3", "value3");

        String endpoint = "/cocart/v1/someEndpoint";

        Response response = serviceHelper.sendPutRequest(bodyRequest.toString(), endpoint);
        response.body().print();
    }

    @Test
    public void updateProductPatch() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("key1", "value1");
        bodyRequest.put("ke2", "value2");
        bodyRequest.put("ke3", "value3");

        String endpoint = "/cocart/v1/someEndpoint";

        Response response = serviceHelper.sendPatchRequest(bodyRequest.toString(), endpoint);
        response.body().print();
    }
}
