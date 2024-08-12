package Rankspro;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SiteOverview {
	
	WebDriver d;
	Date date=new Date();
	String folder="SiteOverview_"+date.toString().replace(" ","_").replace(":","_");
	
	
	@BeforeClass 
	  public void setup() {
	  System.setProperty("Webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		//ChromeDriver driver=new ChromeDriver(); //Chrome constructor
	       
			d=new ChromeDriver(); //WebDriver is the parent of Chrome driver
			d.manage().window().maximize(); //Maximise the window
	     }//setup
	
	 @Test
	  public void Login() throws InterruptedException, IOException {
		  d.get("https://rankspro-frontend.vercel.app/login");
		  d.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("praveen.kumar@esearchlogix.in");
		  d.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("1234");
		  d.findElement(By.xpath("//button[normalize-space()='LOGIN']")).click();
		  Thread.sleep(10000);
		  
		//cancel the popup window  
		     d.switchTo().frame("sleek-widget");
			 WebElement popUp=d.findElement(By.xpath("//body/div[@id='app']/div/div/div/div/div/div[1]"));
		     popUp.click();
		     d.switchTo().defaultContent();
			 Thread.sleep(2000);
		  
		  
/*		  String title=d.getTitle();
		  System.out.println("Title="+d.getTitle());
		 
		
		  Assert.assertEquals(d.getTitle(),"RanksPro.io: Rank Tracking & SEO Analysis");
		  Thread.sleep(10000);
 */
		 }//login
	 
	 @Test(dependsOnMethods="Login")
	 public void siteoverview() throws InterruptedException, IOException {
		 
		 WebElement st_button=d.findElement(By.xpath("//img[@alt='Site Overview']"));
		 st_button.click();
		 Thread.sleep(5000);
		 
		 WebElement st_domain=d.findElement(By.xpath("//input[@placeholder='Enter a domain']"));
		 st_domain.sendKeys("esearchlogix.com");
		 WebElement enter=d.findElement(By.xpath("//form[@data-hs-cf-bound='true']//div//button"));
		 enter.click();
		 Thread.sleep(3000);
		 WebElement viewAll=d.findElement(By.xpath("//button[normalize-space()='View All']"));
		 
		 JavascriptExecutor j = (JavascriptExecutor) d;
		 j.executeScript("arguments[0].scrollIntoView(true);",viewAll);
		 
			//take screenshot
			TakesScreenshot ss1=(TakesScreenshot)d;
			File sourceFile1=ss1.getScreenshotAs(OutputType.FILE);
			String fileName1=date.toString().replace(" ", "_").replace(":","_")+"siteOverview.png";
			File destFile1=new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folder+"\\"+fileName1);
			FileUtils.copyFile(sourceFile1,destFile1);

		
		viewAll.click();
		Thread.sleep(2000);
		
		WebElement title=d.findElement(By.xpath("//h6[normalize-space()='Organic Search Results Positions']"));
		boolean r1=title.isDisplayed();
		String title_text=title.getText();		
		System.out.println("text="+title_text);
		Assert.assertEquals(true, r1);
		
		//take screenshot
		TakesScreenshot ss2=(TakesScreenshot)d;
		File sourceFile2=ss2.getScreenshotAs(OutputType.FILE);
		String fileName2=date.toString().replace(" ", "_").replace(":","_")+"searchResult.png";
		File destFile2=new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folder+"\\"+fileName2);
		FileUtils.copyFile(sourceFile2,destFile2);

	 
	 }//siteroverview   
	 
	 @Test(dependsOnMethods="siteoverview")
	 public void List() throws InterruptedException, IOException {
		 
		 WebElement list_button=d.findElement(By.xpath("//button[@title='View Keyword List']"));
		 list_button.click();
		 Thread.sleep(2000);
		 String listName1=d.findElement(By.xpath("//div[contains(text(),'SEO Keywords')]")).getText();
			System.out.println("List name1="+listName1);
		
			//take screenshot
			TakesScreenshot ss3=(TakesScreenshot)d;
			File sourceFile3=ss3.getScreenshotAs(OutputType.FILE);
			String fileName3=date.toString().replace(" ", "_").replace(":","_")+"List.png";
			File destFile3=new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folder+"\\"+fileName3);
			FileUtils.copyFile(sourceFile3,destFile3);
			
		 WebElement list_button2=d.findElement(By.xpath("//body/div[@id='root']/div/div/div/div[@id='home_layout']/div/div/div/div/div/div/div[1]/div[2]"));
		 list_button2.click();
		 Thread.sleep(2000);
		
		 WebElement listTitle=d.findElement(By.xpath("//h2[normalize-space()='SEO Keywords']"));
		 String listName2=listTitle.getText();
		 System.out.println("List name2="+listName2);
	Assert.assertEquals(listName1, listName2);
	 }
}
