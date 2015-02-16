package gabor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

  public boolean pageCheck() {
    return true;
  }

  public void addElement(String name, String cssSelector) {
    elements.put(name, cssSelector);
  }

  public WebElement element(String name) {
    return this.driver.findElement(By.cssSelector(elements.get(name)));
  }

  public void load() {
    String url = this.baseUrl + this.url;
    System.out.printf("Navigating to: " + url);
    this.driver.get(url);
  }

  public void load(HashMap<String, String> params) {
    String url = this.baseUrl + this.url;

    for(Map.Entry<String, String> entry : params.entrySet()) {
      url = url.replaceAll("\\{" + entry.getKey() + "\\}", entry.getValue());
    }

    System.out.printf("Navigating to: " + url + "\n");
    this.driver.get(url);
  }

  public boolean displayed() {
    Pattern pattern = Pattern.compile(this.urlMatcher);
    Matcher matcher = pattern.matcher(this.driver.getCurrentUrl());
    return matcher.find() && this.pageCheck();
  }
}
