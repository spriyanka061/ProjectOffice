package SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GreyGhost {
	WebDriver d;
 
 @BeforeClass 
  public void setup() {
  System.setProperty("Webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
	//ChromeDriver driver=new ChromeDriver(); //Chrome constructor
		d=new ChromeDriver(); //WebDriver is the parent of Chrome driver
		d.manage().window().maximize(); //Maximise the window
        
 }
@Test(description="launch browser and find the title of the page")	
 public void homepage() {
	d.get("https://demo4esl.com/greyghostcigars/");
         d.findElement(By.xpath("//button[normalize-space()='YES']")).click();
		 Assert.assertEquals(d.getTitle(),"Cigar – My WordPress Blog","passed");
       }
	
	@AfterClass
		public void exit() {		
	        d.quit();
		} 
  
}
