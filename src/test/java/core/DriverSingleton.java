package core;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSingleton {
  private static WebDriver driver;
  
  /**
   * Gerencia uma instancia singular do driver.
   * 
   * @return WebDriver
   * @throws IOException
   */
  public static WebDriver getDriver() {
    if (driver != null)
      return driver;
    try {
      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    } catch (Exception e) {
      Assert.fail("Não foi possível iniciar a instância do driver.");
    }
    return driver;
  }
  
  /**
   * Encerra a instancia do webdriver
   */
  public static void closeDriver() {
    if (driver == null)
      return;
    driver.close();
    driver = null;
  }
  
  /**
   * Navega ate determinado endereco
   * 
   * @param url
   *          Endereco a ser acessado
   * @throws URISyntaxException
   */
  public static void navegar(String url) throws URISyntaxException {
    DriverSingleton.getDriver().navigate().to(url);
    esperarPaginaCarregar();
  }
  
  /**
   * Aguarda que a pagina esteja carregada
   */
  public static void esperarPaginaCarregar() {
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 10);
    wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
  }
}
