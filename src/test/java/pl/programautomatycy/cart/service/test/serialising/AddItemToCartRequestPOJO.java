package pl.programautomatycy.cart.service.test.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddItemToCartRequestPOJO {

    @JsonProperty
    private String product_id;

    @JsonProperty
    private String quantity;

    @JsonProperty
    private Boolean return_cart;

    public AddItemToCartRequestPOJO(String product_id, String quantity, Boolean return_cart) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.return_cart = return_cart;
    }

}
