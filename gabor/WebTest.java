package gabor;

import gabor.pages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class WebTest {
  static WebDriver driver;
  static String baseUrl;

  static public HotelLaunchPage hotelLaunchPage;

  @BeforeClass
  public static void setUp() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    baseUrl = "http://www.expedia.co.uk/";

    hotelLaunchPage = new HotelLaunchPage(driver, baseUrl);
  }

  @AfterClass
  public static void tearDown() {
    driver.close();
  }
}
