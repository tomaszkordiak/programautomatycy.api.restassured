package pl.programautomatycy.cart.service.test.deserialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddItemResponse {

    @JsonProperty
    private String key;

    @JsonProperty
    private String product_id;

    @JsonProperty
    private String quantity;

    @JsonProperty
    private String variation_id;

    @JsonProperty
    private Object variation;

    @JsonProperty
    private String data_hash;

    @JsonProperty
    private LineTaxData line_tax_data;

    @JsonProperty
    private String line_subtotal;

    @JsonProperty
    private String line_subtotal_tax;

    @JsonProperty
    private String line_total;

    @JsonProperty
    private String line_tax;

    @JsonProperty
    private Object data;

    @JsonProperty
    private String product_price;

    @JsonProperty
    private String product_name;

    @JsonProperty
    private String product_title;

    @JsonProperty
    private String product_tax;

    public String getKey() {
        return key;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getVariation_id() {
        return variation_id;
    }

    public Object getVariation() {
        return variation;
    }

    public String getData_hash() {
        return data_hash;
    }

    public LineTaxData getLine_tax_data() {
        return line_tax_data;
    }

    public String getLine_subtotal() {
        return line_subtotal;
    }

    public String getLine_subtotal_tax() {
        return line_subtotal_tax;
    }

    public String getLine_total() {
        return line_total;
    }

    public String getLine_tax() {
        return line_tax;
    }

    public Object getData() {
        return data;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getProduct_title() {
        return product_title;
    }

    public String getProduct_tax() {
        return product_tax;
    }

    public String getProduct_price() {
        return product_price;
    }
}
