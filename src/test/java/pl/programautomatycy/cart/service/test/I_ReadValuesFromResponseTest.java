package pl.programautomatycy.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

public class I_ReadValuesFromResponseTest {

    private ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void readCalculateValuesJsonPath() {
        boolean calculate = true;

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        response.getBody().prettyPrint();

        String subtotal = response.body().jsonPath().getString("subtotal");
        Double subtotalTax = response.body().jsonPath().getDouble("subtotal_tax");
        Object cartContentTaxes = response.getBody().jsonPath().getMap("cart_contents_taxes").get("1");

        Map<String, Double> cartContentTaxesMap = response.getBody().jsonPath().getMap("cart_contents_taxes");
        System.out.println(cartContentTaxesMap.get("1"));
    }

    @Test
    public void readValuesAddItemJSONobject() {

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", "142");
        bodyRequest.put("quantity", "1");
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";

        // ważne
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
        String jsonString = response.getBody().print();
        JSONObject obj = new JSONObject(jsonString);
        String key = obj.getString("key");
        Integer product_id = obj.getInt("product_id");
        Double total = obj.getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");
        System.out.println(total);
        System.out.println(product_id);
        System.out.println(key);
    }

    @Test
    public void readValuesAddItemJSONobjectByKey() {

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", "138");
        bodyRequest.put("quantity", "1");
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        // ważne
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
        String jsonString = response.getBody().prettyPrint();
        JSONObject obj = new JSONObject(jsonString);

        Integer product_id = obj.getJSONObject("013d407166ec4fa56eb1e1f8cbe183b9").getInt("product_id");
        String product_price = obj.getJSONObject("013d407166ec4fa56eb1e1f8cbe183b9").getString("product_price");
        Double total = obj.getJSONObject("013d407166ec4fa56eb1e1f8cbe183b9").getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");
        System.out.println(product_price);
        System.out.println(product_id);
        System.out.println(total);
    }

    @Test
    public void getCartContentMap() {
        String endpoint_cart_content = "cocart/v1/get-cart";

        Response response = serviceHelper.sendGetRequest(endpoint_cart_content);

        Map<String, Object> products = response.getBody().jsonPath().get();
        for (Map.Entry<String, Object> product: products.entrySet()) {

            Map<String, Object> values = (Map<String, Object>) product.getValue();
            System.out.println(values.get("product_id"));

            Map<String, Object> lineTaxData = (Map<String, Object>) values.get("line_tax_data");
            Map<String, Double> total = (Map<String, Double>) lineTaxData.get("total");
            System.out.println(total.get("1"));

            System.out.println("##########################################################");
        }
    }
}
