package scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.DriverSingleton;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchaseConfirmationPage;
import pages.PurchaseFlightPage;

public class CasoDeTeste1 {
  HomePage homePage;
  FlightsPage flightsPage;
  PurchaseFlightPage purchaseFlightPage;
  PurchaseConfirmationPage purchaseConfirmationPage;
  
  @Before
  public void beforeTest() throws Exception {
    homePage = new HomePage();
    flightsPage = new FlightsPage();
    purchaseFlightPage = new PurchaseFlightPage();
    purchaseConfirmationPage = new PurchaseConfirmationPage();
  }
  
  @After
  public void after() {
    DriverSingleton.getDriver().close();
  }
  
  @Test
  public void script() throws Exception {
    try {
      homePage.chooseTravel("http://blazedemo.com/index.php", "San Diego", "London");
      String flight = "234";
      flightsPage.chooseFlight(flight);
      String month = "05";
      String year = "2019";
      purchaseFlightPage.fillForm(flight, "Kevin Gonçalves", "Rua 123", "Udia", "MG", "1234", "Diner's Club", "9876", month, year,
          "Kevin Kesser");
      purchaseConfirmationPage.validateResult("Thank you for your purchase today!", month + " /" + year);
      Thread.sleep(5000);
    } catch (Exception e) {
      e.printStackTrace();
      throw new Exception(e.getMessage());
    }
  }
}
