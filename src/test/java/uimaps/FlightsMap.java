package uimaps;

import core.Element;
import enums.ByValue;

public class FlightsMap {
  public Element getFlightButton(String flightNumber) {
    return new Element(ByValue.XPATH, "(//td[text()='" + flightNumber + "']/..//input)[1]");
  }
}
