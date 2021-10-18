package pl.programautomatycy.cart.service.test.deserialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subtotal {

    @JsonProperty("1")
    private String subtotal1;

    public String getSubtotal1() {
        return subtotal1;
    }


}
