package gabor;

import org.openqa.selenium.WebDriver;

public class WebTestPage {
  WebDriver driver;
  String baseUrl;
  String url;
  String urlMatcher;

  public WebTestPage(WebDriver driver, String baseUrl) {
    this.driver = driver;
    this.url = "";
    this.urlMatcher = "";
    this.baseUrl = baseUrl;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setUrlMatcher(String urlMatcher) {
    this.urlMatcher = urlMatcher;
  }

  public void load() {
    String url = this.baseUrl + this.url;
    System.out.printf("Navigating to: " + url);
    this.driver.get(url);
  }

}
