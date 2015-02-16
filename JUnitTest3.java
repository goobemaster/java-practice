import org.junit.*;

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

  @Test
  public void verifyHotelSearchResults() {
    hotelSearchPage.loadResultsFor("Las Vegas", 10, 15);

    org.junit.Assert.assertTrue("There are no results displayed on Hotel Search Page!", hotelSearchPage.results.size() > 0);

    // Sanity check elements on first result
    org.junit.Assert.assertFalse("Hotel name is not displayed!", hotelSearchPage.results.byIndex(0).hotelName().isEmpty());
    org.junit.Assert.assertTrue("Price is incorrect!", hotelSearchPage.results.byIndex(0).price() > 0);
  }
}
