package gabor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.*;
import java.util.concurrent.TimeUnit;
import gabor.pages.*;

public class WebTest {
  static WebDriver driver;
  static String baseUrl;

  public HotelLaunchPage hotelLaunchPage;
  public HotelSearchPage hotelSearchPage;

  @BeforeClass
  public static void setUp() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    baseUrl = "http://www.expedia.co.uk/";
  }

  @Before
  public void SetUpTest() {
    this.hotelLaunchPage = new HotelLaunchPage(driver, baseUrl);
    this.hotelSearchPage = new HotelSearchPage(driver, baseUrl);
  }

  @AfterClass
  public static void tearDown() {
    driver.close();
  }
}
