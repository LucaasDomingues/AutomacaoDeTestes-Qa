package pages;

import uimaps.PurchaseFlightMap;

public class PurchaseFlightPage {
  private PurchaseFlightMap purchaseFlightMap = new PurchaseFlightMap();
  
  public void fillForm(String flight, String name, String address, String city, String state, String zipCode, String cardType,
      String creditCardNumber, String month, String year, String nameOnCard) throws Exception {
    String flightNumber = purchaseFlightMap.pFlightNumber.getText();
    flightNumber = flightNumber.split("Flight Number: ")[1];
    if (!flightNumber.equals(flight)) {
      throw new Exception("Flight Number encoerente. Esperado: '" + flight + "', encontrado: '" + flightNumber + "'.");
    }
    purchaseFlightMap.getFormField("inputName").sendKeys(name);
    purchaseFlightMap.getFormField("address").sendKeys(address);
    purchaseFlightMap.getFormField("city").sendKeys(city);
    purchaseFlightMap.getFormField("state").sendKeys(state);
    purchaseFlightMap.getFormField("zipCode").sendKeys(zipCode);
    purchaseFlightMap.selectCardType.select(cardType);
    purchaseFlightMap.getFormField("creditCardNumber").sendKeys(creditCardNumber);
    purchaseFlightMap.getFormField("creditCardMonth").sendKeysWithClear(month);
    purchaseFlightMap.getFormField("creditCardYear").sendKeysWithClear(year);
    purchaseFlightMap.getFormField("nameOnCard").sendKeys(nameOnCard);
    purchaseFlightMap.getFormField("rememberMe").click();
    purchaseFlightMap.buttonPurchaseFlight.click();
  }
}
