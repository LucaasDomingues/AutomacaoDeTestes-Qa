package utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import core.DriverSingleton;

public class Evidence {
  private static WebDriver webDriver = DriverSingleton.getDriver();
  private static String dateAndTime = getDateAndTime();
  private static int index = 0;
  
  public static void takeEvidence(String name) throws Exception {
    index++;
    String fileWithPath = System.getProperty("user.dir") + "\\output\\" + dateAndTime + "\\" + index + "_" + name + ".png";
    TakesScreenshot scrShot = ((TakesScreenshot) webDriver);
    File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    File DestFile = new File(fileWithPath);
    FileUtils.copyFile(SrcFile, DestFile);
  }
  
  private static String getDateAndTime() {
    Calendar cal = Calendar.getInstance();
    Date date = cal.getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
    String formattedDate = dateFormat.format(date);
    return formattedDate;
  }
}
