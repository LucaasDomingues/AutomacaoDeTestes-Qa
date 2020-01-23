package uimaps;

import core.Element;
import enums.ByValue;

public class HomeMap {
  public Element selectDeparture = new Element(ByValue.XPATH, "//select[@name='fromPort']");
  public Element selectDestination = new Element(ByValue.XPATH, "//select[@name='toPort']");
  public Element buttonFindFlights = new Element(ByValue.XPATH, "//input[@value='Find Flights']");
}
