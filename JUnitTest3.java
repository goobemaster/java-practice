import org.junit.*;

public class JUnitTest3 extends gabor.WebTest {

  @Test
  public void verifyHotelSearch() {
    page("HotelLaunchPage").load();
  }
}
