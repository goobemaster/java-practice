import org.junit.*;

import java.util.HashMap;

public class JUnitTest3 extends gabor.WebTest {

  @Test
  public void verifyHotelSearch() {
    // Wizard
    hotelLaunchPage.load();
    hotelLaunchPage.wizard.searchForHotel("Las Vegas", 10, 15);

    // Search Results
    org.junit.Assert.assertTrue("Title doesn't include the destination!", hotelSearchPage.element("ResultTitle").getText().contains("Las Vegas"));
  }

  @Test
  public void verifyDeepLinkHotelSearch() {
    hotelSearchPage.loadResultsFor("Las Vegas", 10, 15);

    org.junit.Assert.assertTrue("Title doesn't include the destination!", hotelSearchPage.element("ResultTitle").getText().contains("Las Vegas"));
  }
}
