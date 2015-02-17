package gabor.sections;

import org.openqa.selenium.WebDriver;

import gabor.WebTestSection;

public class ResultSection extends WebTestSection {

  public ResultSection(WebDriver driver, String rootSelector) {
    super(driver, rootSelector);

    addElement("BookLink", "a:first-child");
    addElement("HotelName", ".hotelName");
    addElement("Price", "span.actualPrice");
  }

  public String hotelName() throws Exception {
    return this.element("HotelName").getText();
  }

  public Integer price() throws Exception {
    return Integer.parseInt(this.element("Price").getText().replaceAll("[^0-9]", ""));
  }

  public void select() throws Exception {
    this.element("BookLink").click();
  }

}
