package gabor;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class WebTestSection {
  public WebDriver driver;
  public String rootSelector;
  public String sectionName;
  public Map<String, String> elements;

  public WebTestSection(WebDriver driver, String rootSelector) {
    this.driver = driver;
    this.rootSelector = rootSelector;
    this.sectionName = this.getClass().getName().replaceAll(".+\\.", "");
    elements = new HashMap<String, String>(0);
  }

  public void addElement(String name, String cssSelector) {
    elements.put(name, cssSelector);
  }

  public WebElement element(String name) throws Exception {
    if (!this.displayed()) {
      throw new Exception("Section " + this.sectionName + " is not displayed!\n");
    } else {
      System.out.printf("Locating element: " + name + " on section: " + this.sectionName + "\n");
      WebElement root = this.driver.findElement(By.cssSelector(this.rootSelector));
      return root.findElement(By.cssSelector(elements.get(name)));
    }
  }

  public boolean hasElement(String name) throws Exception {
    try {
      WebElement element = this.element(name);
      return true;
    } catch (ElementNotFoundException e) {
      return false;
    }
  }

  public boolean hasAllElements() throws Exception {
    for(Map.Entry<String, String> element : elements.entrySet()) {
      if (!this.hasElement(element.getKey())) return false;
    }
    return true;
  }

  public boolean displayed() throws Exception {
    try {
      WebElement root = this.driver.findElement(By.cssSelector(this.rootSelector));
      return root.isDisplayed();
    } catch (ElementNotFoundException e) {
      return false;
    }
  }
}
