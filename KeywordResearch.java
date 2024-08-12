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
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeywordResearch {
	
	WebDriver d;
	  Date date = new Date();
	  String folderName="KeywordResearch"+date.toString().replace(" ", "_").replace(":", "_");
		
	  
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
			  
		//cancel the popup window	 
			  d.switchTo().frame("sleek-widget");
				 WebElement popUp=d.findElement(By.xpath("//body/div[@id='app']/div/div/div/div/div/div[1]"));
			     popUp.click();
			     d.switchTo().defaultContent();
				 Thread.sleep(2000);
			  
			  
			  Assert.assertEquals(d.getTitle(),"RanksPro.io: Rank Tracking & SEO Analysis");
			  Thread.sleep(10000);
			 }
	
	@Test(dependsOnMethods="Login")
	 public void KeywordResearch() throws InterruptedException, IOException {
		
		
		
		 WebElement kr=d.findElement(By.xpath("//img[@alt='Keyword Research']"));
		 Thread.sleep(5000);
		 kr.click();
		 String rt= d.getCurrentUrl();
		 System.out.println("url="+rt);
		 Thread.sleep(2000);
		 
			
			  //take screenshot // 1.convert webdriver to screenshot object.
			  TakesScreenshot ss=(TakesScreenshot)d;
			  
			  //2. Call getScreenshotAs method to create image file
			  File SrcFile=ss.getScreenshotAs(OutputType.FILE);
			  
			  //3.Copy file to Desired Location
			  String FileName = date.toString().replace(":", "_").replace(" ", "_") +"KeywordResearch.png";
			  System.out.println("Filename="+FileName); 
			  File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName);
			  
			  //4.Copy file at destination
			  FileUtils.copyFile(SrcFile, destFile);
			  System.out.println("screenshot taken...");
			 
		 
			d.findElement(By.xpath("//input[@placeholder='Enter a keyword']")).sendKeys("digital marketing");
			d.findElement(By.xpath("//form[@data-hs-cf-bound='true']//div//button//img")).click();
			Thread.sleep(2000);
			
			
			  //take screenshot // 1.convert webdriver to screenshot object.
			  TakesScreenshot ss2=(TakesScreenshot)d;
			  
			  //2. Call getScreenshotAs method to create image file 
			  File SrcFile2=ss2.getScreenshotAs(OutputType.FILE);
			  
			  //3.Copy file to Desired Location
			  
			  String FileName2 = date.toString().replace(":", "_").replace(" ", "_") +"Keyword_Entered.png"; 
			  System.out.println("Filename="+FileName2); File
			  destFile2= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName2);
			  
			  //4.Copy file at destination 
			  FileUtils.copyFile(SrcFile2, destFile2);
			  System.out.println("screenshot taken...");
			 
			
			
			
				//WebElement chart=d.findElement(By.xpath("//body/div[@id='root']/div/div/div/div[@id='home_layout']/div/main/section/div/section/div[1]/div[1]"));
				WebElement viewAllButton=d.findElement(By.xpath("//button[normalize-space()='View All']"));
				 JavascriptExecutor js=(JavascriptExecutor)d;
				 js.executeScript("arguments[0].scrollIntoView(true);",viewAllButton);
				 Thread.sleep(2000);
				 
				 viewAllButton.click();
				 Thread.sleep(2000);
					  //take screenshot
				 TakesScreenshot ss3=(TakesScreenshot)d; 
File SrcFile3=ss3.getScreenshotAs(OutputType.FILE); 
String FileName3 =date.toString().replace(" ", "_").replace(":", "_")+ "keywordResearcTable.png";
File destFile3= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName3);
FileUtils.copyFile(SrcFile3, destFile3);
					 
				 
				d.close();				 
	   }
}
