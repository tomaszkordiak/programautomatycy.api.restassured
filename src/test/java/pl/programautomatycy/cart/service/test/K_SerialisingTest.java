package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.junit.Test;
import pl.programautomatycy.cart.service.test.serialising.AddItemToCartRequestPOJO;

public class K_SerialisingTest {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItem() {
        String productId = "142";
        String quantity = "1";
        boolean returnCart = true;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(productId, quantity, returnCart);

        String endpoint =  "cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest, endpoint);
        response.getBody().prettyPrint();

    }
}
