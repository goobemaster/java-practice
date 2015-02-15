import org.junit.*;

public class JUnitTest3 extends gabor.WebTest {

  @Test
  public void verifyHotelSearch() {
    // Wizard
    hotelLaunchPage.load();
    hotelLaunchPage.wizard.searchForHotel("Las Vegas", 10, 15);

    // Search Results
    org.junit.Assert.assertTrue("Title doesn't include the destination!", hotelLaunchPage.element("ResultTitle").getText().contains("Las Vegas"));
  }
}
