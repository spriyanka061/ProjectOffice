package SeleniumWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/* synchronization problem--
 * Wait Commands= 
 * 1)Thread.sleep(milliseconds)-java method. It is not of selenium.
 * -time is fixed in this case ->exception
 * -wait till time is over even if the elements is fetched->time wastage.
 * -multiple times have to write wherever needed.
 * 2)driver.wait()
 * Selenium wait statements types-
 * 1)implicit wait
 * 2)explicit wait
 * Exception-
 * 1)NoSuchElementException-element is not present in the page. 
 * 2)ElementNotFoundException-locator is incorrect.
 * 
 */

public class WaitingStrategies {
	 WebDriver d;
  @Test
  public void f() {
	  System.setProperty("Webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
     
	  d=new ChromeDriver();
      d.manage().window().maximize();
      d.findElement(By.xpath(""));
    }
  @Test
  public void implicitWait() {
	/*write once use anywhere till driver is closed. 
	  No need to know the place where synchronization problem is present.
	  Once the 5 seconds wait will over then it will throw the exception.
	  Standard time is 10 sec else it is a performance issue.
	*/
	  d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
 }
  @Test
  public void explicitWait() {
	  /*declaration-
	   	   
	  */
	  //1. Declaration
	  WebDriverWait ww=new WebDriverWait(d, Duration.ofSeconds(10));
	  //2. 
  }
}
