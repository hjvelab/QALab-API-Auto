package com.nttdata.glue;

import com.nttdata.steps.StepsOrdenPet;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrdenStepDef {

    @Steps
    StepsOrdenPet ordenPet;

    @Given("definidio la url {string}")
    public void definidioLaUrl(String url) {
        ordenPet.setUrl_ordenPet(url);
        System.out.println("La url seteada es:"+url);
    }

    @When("creo la orden con orderId {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete {string}")
    public void creoLaOrdenConOrderIdPetIdQuantityShipDateStatusComplete(int orderIdnuevo, int petId, int quantity, String shipDate, String status, String complete) {
        ordenPet.crearOrden(orderIdnuevo,petId,quantity,shipDate,status,complete);
    }

    @And("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int code) {
        ordenPet.validarType(code);
        System.out.println("El status actual es: "+code);
    }

    @When("consulto la orden de ID {string}")
    public void consultoLaOrdenDeIDOrdenId(String idOrden) {
        ordenPet.consultarOrden(idOrden);
    }
}
