package gabor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;

public class WebTestSection {
  WebDriver driver;
  String rootSelector;
  static Map<String, String> elements;

  public WebTestSection(WebDriver driver, String rootSelector) {
    this.driver = driver;
    this.rootSelector = rootSelector;
    elements = new HashMap<String, String>(0);
  }

  public void addElement(String name, String cssSelector) {
    elements.put(name, cssSelector);
  }

  public WebElement element(String name) {
    WebElement root = this.driver.findElement(By.cssSelector(this.rootSelector));
    return root.findElement(By.cssSelector(elements.get(name)));
  }
}
