package pages;

import uimaps.FlightsMap;

public class FlightsPage {
  private FlightsMap flightsMap = new FlightsMap();
  
  public void chooseFlight(String flightNumber) throws Exception {
    flightsMap.getFlightButton(flightNumber).click();
  }
}
