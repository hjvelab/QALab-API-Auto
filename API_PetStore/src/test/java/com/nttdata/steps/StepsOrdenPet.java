package com.nttdata.steps;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class StepsOrdenPet {

    private String url_ordenPet;
    Response response;

    public String getUrl_ordenPet() {
        return url_ordenPet;
    }

    public void setUrl_ordenPet(String url_ordenPet) {
        this.url_ordenPet = url_ordenPet;
    }

    public void consultarOrden(String orderId){
        response = RestAssured
                .given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .baseUri(this.url_ordenPet)
                .when()
                .get("/order/"+orderId)
                .then().extract().response();
        ;
    }

    public void validarType(int code) {

        Assert.assertNotNull("El body del del response retorna null", response.body());
        Assert.assertEquals("El status code no coincide",code,response.getStatusCode());
        Assert.assertTrue("Body no debería contener 'complete' false ",response.jsonPath().getBoolean("complete"));

    }

    public void crearOrden(int orderId, int petId, int quantity, String shipDate,String status, String complete){
       response = RestAssured
                .given()
                .contentType("application/json")
                .body("{"
                        + "\"id\": " + orderId + ","
                        + "\"petId\": " + petId + ","
                        + "\"quantity\": " + quantity + ","
                        + "\"shipDate\": \"" + shipDate + "\","
                        + "\"status\": \"" + status + "\","
                        + "\"complete\": " + complete
                        + "}")
                .log().all()
                .when()
                .post(this.url_ordenPet)
               .then().extract().response();
       ;
    }




}
