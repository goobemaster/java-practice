package gabor;

import gabor.WebTestPage;
import gabor.pages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebTest {
  static WebDriver driver;
  static Map<String, WebTestPage> pages;
  static String baseUrl;

  @BeforeClass
  public static void setUp() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    baseUrl = "http://www.expedia.co.uk/";

    pages = new HashMap<String, WebTestPage>(0);
    pages.put("HotelLaunchPage", new HotelLaunchPage(driver, baseUrl));
  }

  @AfterClass
  public static void tearDown() {
    driver.close();
  }

  public WebTestPage page(String name) {
    return pages.get(name);
  }
}
