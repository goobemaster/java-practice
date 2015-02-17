package gabor.sections;

import org.openqa.selenium.WebDriver;

import gabor.WebTestSection;
import java.util.Calendar;

public class WizardSection extends WebTestSection {

  public WizardSection(WebDriver driver, String rootSelector) {
    super(driver, rootSelector);

    addElement("Destination", "#H-destination");
    addElement("CheckIn", "#H-fromDate");
    addElement("CheckOut", "#H-toDate");
    addElement("SearchButton", "#H-searchButton");
  }

  public void searchForHotel(String destination, int checkInLambda, int checkOutLambda) throws Exception {
    this.element("Destination").clear();
    this.element("Destination").sendKeys(destination);

    Calendar fromDate = Calendar.getInstance();
    fromDate.add(Calendar.DAY_OF_MONTH, checkInLambda);
    this.element("CheckIn").clear();
    this.element("CheckIn").sendKeys(String.format("%1$te/%1$tm/%1$tY", fromDate));

    Calendar toDate = Calendar.getInstance();
    toDate.add(Calendar.DAY_OF_MONTH, checkOutLambda);
    this.element("CheckOut").clear();
    this.element("CheckOut").sendKeys(String.format("%1$te/%1$tm/%1$tY", toDate));

    this.element("SearchButton").click();
  }

}
