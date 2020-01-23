package pages;

import core.DriverSingleton;
import uimaps.HomeMap;

public class HomePage {
  private HomeMap homeMap = new HomeMap();
  
  public void chooseTravel(String url, String departure, String destination) throws Exception {
    DriverSingleton.navegar(url);
    homeMap.selectDeparture.select(departure);
    homeMap.selectDestination.select(destination);
    homeMap.buttonFindFlights.click();
  }
}
