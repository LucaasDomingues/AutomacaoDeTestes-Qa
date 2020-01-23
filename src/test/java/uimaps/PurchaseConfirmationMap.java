package uimaps;

import core.Element;
import enums.ByValue;

public class PurchaseConfirmationMap {
  public Element h1Result = new Element(ByValue.XPATH, "//h1");
  public Element tdExpiration = new Element(ByValue.XPATH, "(//td[text()='Expiration']/following::td)[1]");
}
