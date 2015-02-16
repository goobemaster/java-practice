package gabor.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import gabor.WebTestSection;
import org.openqa.selenium.WebElement;

public class ResultsSection extends WebTestSection {
  ArrayList<ResultSection> results;

  public ResultsSection(WebDriver driver, String rootSelector) {
    super(driver, rootSelector);

    this.results = new ArrayList<ResultSection>(0);
  }

  public void parseResults() {
    String hotelId = "";

    this.results.clear();

    System.out.printf("Parsing results...\n");
    List<WebElement> hotels = this.driver.findElements(By.cssSelector(".hotelWrapper"));
    for (WebElement hotel : hotels) {
      hotelId = hotel.findElement(By.cssSelector("article[data-hotelid]")).getAttribute("data-hotelid");
      this.results.add(new ResultSection(this.driver, "[data-hotelid=\"" + hotelId + "\"]"));
    }
    System.out.printf("Found " + this.results.size() + " result(s)\n");
  }

  public Integer size() {
    if (this.results.isEmpty()) { this.parseResults(); }
    return this.results.size();
  }

  public ResultSection byIndex(Integer index) {
    if (this.results.isEmpty()) { this.parseResults(); }
    return this.results.get(index);
  }

}
