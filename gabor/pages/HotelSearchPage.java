package gabor.pages;

import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.HashMap;
import gabor.WebTestPage;
import gabor.sections.*;

public class HotelSearchPage extends WebTestPage {
  public ResultsSection results;

  public HotelSearchPage(WebDriver driver, String baseUrl) {
    super(driver, baseUrl);

    setUrl("Hotel-Search?storedCheckoutField=&storedCheckinField=&lang=2057#destination={destination}&startDate={startDate}&endDate={endDate}&adults={adults}&star={star}");
    setUrlMatcher("\\/Hotel-Search?.+");

    results = new ResultsSection(driver, "#resultsContainer");
    addElement("PageId", "#pageId");
    addElement("ResultTitle", "#hotelResultTitle");
  }

  public boolean pageCheck() {
    return this.element("PageId").getAttribute("value").equals("page.Hotel-Search");
  }

  public void loadResultsFor(String destination, int checkInLambda, int checkOutLambda) {
    HashMap<String, String> params = new HashMap<String, String>(0);

    Calendar fromDate = Calendar.getInstance();
    fromDate.add(Calendar.DAY_OF_MONTH, checkInLambda);
    Calendar toDate = Calendar.getInstance();
    toDate.add(Calendar.DAY_OF_MONTH, checkOutLambda);

    params.put("destination", destination);
    params.put("startDate", String.format("%1$te/%1$tm/%1$tY", fromDate));
    params.put("endDate", String.format("%1$te/%1$tm/%1$tY", toDate));
    params.put("adults", "2");
    params.put("star", "0");

    this.load(params);
  }
}