package gabor;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebTestPage {
  WebDriver driver;
  String pageName;
  String baseUrl;
  String url;
  String urlMatcher;
  static Map<String, String> elements;

  public WebTestPage(WebDriver driver, String baseUrl) {
    this.driver = driver;
    this.url = "";
    this.urlMatcher = "";
    this.baseUrl = baseUrl;
    this.pageName = this.getClass().getName().replaceAll(".+\\.", "");
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
    System.out.printf("Locating element: " + name + "\n");
    return this.driver.findElement(By.cssSelector(elements.get(name)));
  }

  public boolean hasElement(String name) {
    try {
      WebElement element = this.element(name);
      return true;
    } catch (ElementNotFoundException e) {
      return false;
    }
  }

  public boolean hasAllElements() {
    for(Map.Entry<String, String> element : elements.entrySet()) {
      if (!this.hasElement(element.getKey())) return false;
    }
    return true;
  }

  public void load() throws Exception {
    String url = this.baseUrl + this.url;

    if (this.driver.getCurrentUrl().equals(url)) {
      System.out.printf("Already on " + this.pageName  + "\n");
    } else {
      System.out.printf("Navigating to " + this.pageName + " with url: " + url + "\n");
      StopWatch watch = new StopWatch();
      this.driver.get(url);
      watch.stop();

      if (!this.displayed()) throw new Exception("Landed on unexpected page!");
      System.out.printf("Page loaded in " + watch.elapsed() + "\n");
    }
  }

  public void load(HashMap<String, String> params) throws Exception {
    String url = this.baseUrl + this.url;

    for(Map.Entry<String, String> entry : params.entrySet()) {
      url = url.replaceAll("\\{" + entry.getKey() + "\\}", entry.getValue());
    }

    if (this.driver.getCurrentUrl().equals(url)) {
      System.out.printf("Already on " + this.pageName  + "\n");
    } else {
      System.out.printf("Navigating to " + this.pageName + " with url: " + url + "\n");
      StopWatch watch = new StopWatch();
      this.driver.get(url);
      watch.stop();

      if (!this.displayed()) throw new Exception("Landed on unexpected page!");
      System.out.printf("Page loaded in " + watch.elapsed() + "\n");
    }
  }

  public boolean displayed() {
    Pattern pattern = Pattern.compile(this.urlMatcher);
    Matcher matcher = pattern.matcher(this.driver.getCurrentUrl());
    return matcher.find() && this.pageCheck();
  }
}
