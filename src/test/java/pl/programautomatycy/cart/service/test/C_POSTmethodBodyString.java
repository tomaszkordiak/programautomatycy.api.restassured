package pl.programautomatycy.cart.service.test;

import org.junit.Test;

public class C_POSTmethodBodyString {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyString() {
        String bodyRequest = "{\n" +
                "    \"product_id\": 142,\n" +
                "    \"quantity\": 5,\n" +
                "    \"return_cart\": true\n" +
                "}";
        System.out.println(bodyRequest);
    }
}
