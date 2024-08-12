package Rankspro;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Rankspro {
	WebDriver d;
	Date date = new Date();
	String folder="Backlinks"+date.toString().replace(" ", "_").replace(":", "_");
	
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
	 
	
	  Assert.assertEquals(d.getTitle(),"RanksPro.io: Rank Tracking & SEO Analysis");
	  Thread.sleep(10000);
	 }//login

 
 @Test(dependsOnMethods="Login")
 public void Backlinks() throws InterruptedException {
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
	 
	 d.switchTo().frame("sleek-widget");
     WebElement popUp=d.findElement(By.xpath("//body/div[@id='app']/div/div/div/div/div/div[1]"));
     popUp.click();
     d.switchTo().defaultContent();
	 Thread.sleep(2000);
	 
	 WebElement viewAllButton=d.findElement(By.xpath("//button[normalize-space()='View All']"));
	 JavascriptExecutor js=(JavascriptExecutor)d;
	 js.executeScript("arguments[0].scrollIntoView(true);",viewAllButton);
	 Thread.sleep(2000);
	 
	 
	 viewAllButton.click();
	 Thread.sleep(2000);
	 
	 //Take screenshot
	 TakesScreenshot ss=(TakesScreenshot)d;
	 File srcFile=ss.getScreenshotAs(OutputType.FILE);
	 String fileName=date.toString().replace(":", "_").replace(" ", "_")+"backlinkAnalysis.png";
	 File destFile=new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folder+"\\"+fileName);
    }
}

/*
@Test(dependsOnMethods="Mainpage")
public void add_project() throws InterruptedException {
	
	// creating the instance of class BufferedReader
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String name = null,url = null;
    try {
    	System.out.println("Enter your project url");
    	url= reader.readLine(); // taking string input
        System.out.println("url=" + url);
        
       
    	  System.out.println("Enter your project name");
        name = reader.readLine(); // taking string input
        System.out.println("Name=" + name);
    }
    catch (Exception e) {
    	System.out.println("test caught exception="+e);
    }
    
    d.findElement(By.xpath("//a[@href='/addpr']")).click();
	WebElement pr_url=d.findElement(By.xpath("//input[@placeholder='Website URL:']"));
	WebElement pr_name=d.findElement(By.xpath("//input[@placeholder='Project Name:']"));
	pr_url.sendKeys(url);
	pr_name.sendKeys(name);
	d.findElement(By.xpath("//button[normalize-space()='Next']")).click();
    //d.wait(5000);
	
	
   }
*/