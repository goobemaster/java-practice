package gabor.pages;

import gabor.WebTestPage;
import gabor.sections.*;
import org.openqa.selenium.WebDriver;

public class HotelLaunchPage extends WebTestPage {
  public WizardSection wizard;

  public HotelLaunchPage(WebDriver driver, String baseUrl) {
    super(driver, baseUrl);

    setUrl("Hotels");
    setUrlMatcher("\\/Hotels$");

    wizard = new WizardSection(driver, "#widgetcatalogWizard");
    addElement("ResultTitle", "#hotelResultTitle");
  }
}
