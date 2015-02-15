package gabor.pages;

import gabor.WebTestPage;
import org.openqa.selenium.WebDriver;

public class HotelLaunchPage extends WebTestPage {

  public HotelLaunchPage(WebDriver driver, String baseUrl) {
    super(driver, baseUrl);

    setUrl("Hotels");
    setUrlMatcher("\\/Hotels$");
  }
}
