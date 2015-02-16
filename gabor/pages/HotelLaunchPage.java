package gabor.pages;

import org.openqa.selenium.WebDriver;

import gabor.WebTestPage;
import gabor.sections.*;

public class HotelLaunchPage extends WebTestPage {
  public WizardSection wizard;

  public HotelLaunchPage(WebDriver driver, String baseUrl) {
    super(driver, baseUrl);

    setUrl("Hotels");
    setUrlMatcher("\\/Hotels$");

    wizard = new WizardSection(driver, "#widgetcatalogWizard");
    addElement("PageId", "#pageId");
  }

  public boolean pageCheck() {
    return this.element("PageId").getAttribute("value").equals("page.Hotels");
  }
}
