package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.ByValue;
import exceptions.ElementException;

public class Element {
  private WebDriver driver;
  private String value;
  private ByValue byValue;
  private Integer timeSeconds = 5;
  
  /**
   * @param by
   *          representa by utilizado para mapear o Element
   * @param value
   *          representa o valor do mapeamento do Element
   */
  public Element(ByValue by, String value) {
    this.byValue = by;
    this.value = value;
    this.driver = DriverSingleton.getDriver();
  }
  
  /**
   * seta o tempo de espera
   * 
   * @param time
   *          String com o tempo em segundos de espera
   */
  public void setTimeWait(Integer timeSeconds) {
    this.timeSeconds = timeSeconds;
  }
  
  /**
   * instancia uma WebElement do Element
   * 
   * @return WebElement do proprio Element
   * @throws Exception
   */
  public WebElement createWebElement() throws Exception {
    Thread.sleep(1000);
    WebDriverWait wait = new WebDriverWait(driver, timeSeconds);
    DriverSingleton.esperarPaginaCarregar();
    switch (byValue) {
      case XPATH:
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
      case ID:
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
      case CLASS_NAME:
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(value)));
      default:
        return null;
    }
  }
  
  /**
   * Clica no Element
   * 
   * @return uma String vazia ou a mensagem de erro
   * @throws Exception
   */
  public void click() throws Exception {
    try {
      createWebElement().click();
    } catch (Exception e) {
      throw new ElementException(e, byValue, value);
    }
  }
  
  /**
   * Preenche o campo de texto desejado
   * 
   * @param text
   *          String desejada para preencher o campo
   */
  public void sendKeys(String text) throws Exception {
    try {
      createWebElement().sendKeys(text);
    } catch (Exception e) {
      throw new ElementException(e, byValue, value);
    }
  }
  
  public void sendKeysWithClear(String text) throws Exception {
    try {
      WebElement webE = createWebElement();
      webE.clear();
      webE.sendKeys(text);
    } catch (Exception e) {
      throw new ElementException(e, byValue, value);
    }
  }
  
  public String getText() throws Exception {
    try {
      return createWebElement().getText();
    } catch (Exception e) {
      throw new ElementException(e, byValue, value);
    }
  }
  
  /**
   * Seleciona uma opcao em um drop down utilizando um valor visivel
   * 
   * @param visibleText
   *          Opcao desejada no select
   */
  public void select(String visibleText) throws Exception {
    try {
      Select select = new Select(createWebElement());
      select.selectByVisibleText(visibleText);
    } catch (Exception e) {
      throw new ElementException(e, byValue, value);
    }
  }
  
  /**
   * wait a element disappear
   * 
   * @param time
   *          waiting time wanted
   * @return true if the element disappears or false if is present
   */
  public Boolean waitDisappear(Integer time) {
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(value)));
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
  /**
   * wait a element appear
   * 
   * @return true if the element appears or false if it is not present
   */
  public Boolean waitAppear() {
    WebDriverWait wait = new WebDriverWait(driver, timeSeconds);
    DriverSingleton.esperarPaginaCarregar();
    try {
      wait.until(ExpectedConditions.visibilityOf(createWebElement()));
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
