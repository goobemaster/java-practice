package gabor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;

public class WebTestPage {
  WebDriver driver;
  String baseUrl;
  String url;
  String urlMatcher;
  static Map<String, String> elements;

  public WebTestPage(WebDriver driver, String baseUrl) {
    this.driver = driver;
    this.url = "";
    this.urlMatcher = "";
    this.baseUrl = baseUrl;
    elements = new HashMap<String, String>(0);
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

  public void addElement(String name, String cssSelector) {
    elements.put(name, cssSelector);
  }

  public WebElement element(String name) {
    return this.driver.findElement(By.cssSelector(elements.get(name)));
  }
}
