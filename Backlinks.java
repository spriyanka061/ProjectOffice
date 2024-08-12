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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Backlinks {
	WebDriver d;
	Date date = new Date();
	String folder="Backlinks_"+date.toString().replace(" ", "_").replace(":", "_");
	
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
		  String title=d.getTitle();
		  System.out.println("Title="+d.getTitle());
		 
		  d.switchTo().frame("sleek-widget");
		     WebElement popUp=d.findElement(By.xpath("//body/div[@id='app']/div/div/div/div/div/div[1]"));
		     popUp.click();
		     d.switchTo().defaultContent();
			 Thread.sleep(2000);
		  
		  Assert.assertEquals(d.getTitle(),"RanksPro.io: Rank Tracking & SEO Analysis");
		  Thread.sleep(10000);
		 }//login
	
	@Test(dependsOnMethods="Login")
	 public void Backlinks_Analysis() throws InterruptedException, IOException {
		 WebElement bl=d.findElement(By.xpath("//div[@aria-hidden='true']//div//div//ul//li//div//div"));
			
		 bl.click();
		 Thread.sleep(2000);
		 WebElement bl_analysis=d.findElement(By.xpath("//a[@href='/backlinks']"));
		 
		 // JavascriptExecutor j = (JavascriptExecutor) d;
		 //j.executeScript("arguments[0].scrollIntoView(true);",viewAll);
		 
		 bl_analysis.click();
		 Thread.sleep(2000);
		 
		 WebElement domain_text=d.findElement(By.xpath("//input[@placeholder='Enter your domain']"));
		 domain_text.sendKeys("esearchlogix.com");
		 d.findElement(By.xpath("//form[@data-hs-cf-bound='true']//div//button")).click();
		 Thread.sleep(3000);
		 
		 WebElement viewAllButton=d.findElement(By.xpath("//button[normalize-space()='View All']"));
		 JavascriptExecutor js=(JavascriptExecutor)d;
		 js.executeScript("arguments[0].scrollIntoView(true);",viewAllButton);
		 Thread.sleep(2000);
		 
		 
		 viewAllButton.click();
		 Thread.sleep(2000);
		 
			
			 TakesScreenshot ss1=(TakesScreenshot)d; 
			 File sourceFile1=ss1.getScreenshotAs(OutputType.FILE); 
			 String fileName1=date.toString().replace(" ", "_").replace(":","_")+"backlinkAnalysis.png"; 
			 File destFile1=new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folder+"\\"+fileName1); 
			 FileUtils.copyFile(sourceFile1,destFile1);
			
		 }
	@Test
	
	public void Backlink_gap() throws InterruptedException, IOException {
		WebElement bl=d.findElement(By.xpath("//div[@aria-hidden='true']//div//div//ul//li//div//div"));
		
		 bl.click();
		 Thread.sleep(2000);
		 WebElement bl_gap=d.findElement(By.xpath("//span[normalize-space()='Backlink Gap']"));
			bl_gap.click();
			Thread.sleep(2000);
			WebElement your_domain=d.findElement(By.xpath("//input[@placeholder='Your domain']"));
			WebElement competitor_domain=d.findElement(By.xpath("//input[@placeholder='Competitor domain']"));
			WebElement submit_button=d.findElement(By.xpath("//button[normalize-space()='Submit & Analyse']"));
			your_domain.sendKeys("esearchlogix.com");
			competitor_domain.sendKeys("orangemantra.com");
			submit_button.click();
			 Thread.sleep(2000);
			 	//take screenshot
			 TakesScreenshot ss2=(TakesScreenshot)d; 
			      File SrcFile2=ss2.getScreenshotAs(OutputType.FILE); 
			      String FileName2 =date.toString().replace(" ", "_").replace(":", "_")+ "backlinks_gap.png";
File destFile2= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folder+"\\"+FileName2);
FileUtils.copyFile(SrcFile2, destFile2);
			 
	}
}
