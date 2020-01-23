package uimaps;

import core.Element;
import enums.ByValue;

public class PurchaseFlightMap {
  public Element pFlightNumber = new Element(ByValue.XPATH, "//p[contains(text(),'Flight Number:')]");
  public Element selectCardType = new Element(ByValue.XPATH, "//select[@name='cardType']");
  public Element buttonPurchaseFlight = new Element(ByValue.XPATH, "//input[@value='Purchase Flight']");
  
  public Element getFormField(String fieldName) {
    return new Element(ByValue.XPATH, "//input[@name='" + fieldName + "']");
  }
}
