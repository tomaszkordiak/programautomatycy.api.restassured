package pl.programautomatycy.cart.service.test.deserialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LineTaxData {

    @JsonProperty
    private Subtotal subtotal;

    @JsonProperty
    private Total total;

    public Subtotal getSubtotal() {return subtotal;}

    public Total getTotal() {return total;}
}
