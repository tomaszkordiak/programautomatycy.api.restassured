package pl.programautomatycy.cart.service.test.deserialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Total {

    @JsonProperty("1")
    private String total1;

    public String getTotal1() {
        return total1;
    }
}
