import org.hamcrest.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class JUnitTest2 {

  @Test
  public void verifyHotelSearch() throws Exception {
    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    driver.get("http://www.expedia.co.uk/Hotels");

    // Wizard
    WebElement destination = driver.findElement(By.id("H-destination"));
    destination.clear();
    destination.sendKeys("Las Vegas");

    Calendar fromDate = Calendar.getInstance();
    fromDate.add(Calendar.DAY_OF_MONTH, 5);
    WebElement from = driver.findElement(By.id("H-fromDate"));
    from.clear();
    from.sendKeys(String.format("%1$te/%1$tm/%1$tY", fromDate));

    Calendar toDate = Calendar.getInstance();
    toDate.add(Calendar.DAY_OF_MONTH, 10);
    WebElement to = driver.findElement(By.id("H-toDate"));
    to.clear();
    to.sendKeys(String.format("%1$te/%1$tm/%1$tY", toDate));

    driver.findElement(By.id("H-searchButton")).click();

    // Search Results
    WebElement resultTitle = driver.findElement(By.id("hotelResultTitle"));
    org.junit.Assert.assertTrue("Title doesn't include the destination!", resultTitle.getText().contains("Las Vegas"));

  }
}
