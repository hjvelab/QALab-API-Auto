@TestGeneral
Feature: PetStore - Store

  @TestCrearOrden
  Scenario Outline: Crear de Orden - POST
    Given definidio la url <url>
    When creo la orden con orderId 567123, petId 2, quantity 1, shipDate "2025-08-25T00:56:48.836+0000", status "placed", complete "true"
    And valido el codigo de respuesta sea <code>
    Examples:
      | url                                          | code |
      | "https://petstore.swagger.io/v2/store/order" | 200  |

  @TestConsultarOrden
  Scenario Outline: Consultar Order - GET
    Given definidio la url <urlOrden>
    When consulto la orden de ID <ordenId>
    And valido el codigo de respuesta sea <rpta>
    Examples:
      | urlOrden                               | ordenId    | rpta  |
      | "https://petstore.swagger.io/v2/store" | "567123"   | 200   |