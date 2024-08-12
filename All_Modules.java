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

public class All_Modules {
 
  WebDriver d;
  Date date = new Date();
  String folderName=date.toString().replace(" ", "_").replace(":", "_");
	
  
	@BeforeClass 
	  public void setup() {
	  System.setProperty("Webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		//ChromeDriver driver=new ChromeDriver(); //Chrome constructor
	       
			d=new ChromeDriver(); //WebDriver is the parent of Chrome driver
			d.manage().window().maximize(); //Maximise the window
	 }
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
		  
		//cancel the popup window  
		  d.switchTo().frame("sleek-widget");
			 WebElement popUp=d.findElement(By.xpath("//body/div[@id='app']/div/div/div/div/div/div[1]"));
		     popUp.click();
		     d.switchTo().defaultContent();
			 Thread.sleep(2000);
		  
		 }
	 
	 @Test(dependsOnMethods="Login" )
	  public void Mainpage() throws IOException, InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) d;
		 js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 Thread.sleep(3000);
			 
		 WebElement projectName=d.findElement(By.xpath("//p[normalize-space()='esearchlogix.com']"));
		 System.out.println("Project Name="+projectName.getText());
		 
		 WebElement bl=d.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/main[1]/section[5]/div[1]/div[1]/div[1]"));
		 WebElement domains_graph=d.findElement(By.xpath("//body/div[@id='root']/div/div/div/div[@id='home_layout']/div/main/section[5]/div[1]/div[1]/div[1]"));
		 WebElement keywords_graph=d.findElement(By.xpath("//body/div[@id='root']/div/div/div/div[@id='home_layout']/div/main/section[5]/div[1]/div[1]/div[1]"));
		 WebElement backlinks_graph=d.findElement(By.xpath("//body/div[@id='root']/div/div/div/div[@id='home_layout']/div/main/section[5]/div[1]/div[1]/div[1]"));
	     WebElement traffic_graph=d.findElement(By.xpath("//body/div[@id='root']/div/div/div/div[@id='home_layout']/div/main/section[5]/div[1]/div[1]/div[1]"));
	     	
			boolean g1=domains_graph.isDisplayed();
			boolean g2=keywords_graph.isDisplayed();
			boolean g3=backlinks_graph.isDisplayed();
			boolean g4=traffic_graph.isDisplayed();
			
			//((JavascriptExecutor) d).executeScript("window.scrollBy(0, document.body.scrollHeight)");
			 
			JavascriptExecutor j = (JavascriptExecutor) d;
			js.executeScript("arguments[0].scrollIntoView(true);",traffic_graph);
			Thread.sleep(2000);
			
			 //take screenshot
			  // 1.convert webdriver to screenshot object.
				TakesScreenshot ss=(TakesScreenshot)d;
				
				//2. Call getScreenshotAs method to create image file
				File srcFile=ss.getScreenshotAs(OutputType.FILE);
				
				// Date date = new Date();
				 System.out.println("date="+date);
				 
				//3.Copy file to Desired Location
				// String folderName=date.toString().replace(" ", "_").replace(":", "_");
				String FileName = date.toString().replace(" ", "_").replace(":", "_")+ "Dashboard.png";
				 //String FileName = date.toString() + "Dashboard.png";
				System.out.println("Filename="+FileName);
				File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName);
				
				//4.Copy file at destination
				FileUtils.copyFile(srcFile, destFile);
				System.out.println("screenshot taken...");
		
			Assert.assertEquals(true, g1);
			Assert.assertEquals(true, g2);
			Assert.assertEquals(true, g3);
			Assert.assertEquals(true, g4);
	    }	
	 
	 @Test(dependsOnMethods="Mainpage")
	 public void ranktracking() throws InterruptedException, IOException {
		 WebElement bl=d.findElement(By.xpath("//img[@alt='Rank Tracking']"));
		 Thread.sleep(5000);
		 bl.click();
		 String rt= d.getCurrentUrl();
		 System.out.println("rt_url="+rt);
		 Thread.sleep(5000);
		 
		 //click the dashboard button
		 d.findElement(By.xpath("//img[@alt='toggleSvg']")).click();
		 Thread.sleep(2000);
		 
		  //take screenshot
		  // 1.convert webdriver to screenshot object.
			TakesScreenshot ss=(TakesScreenshot)d;
			
			//2. Call getScreenshotAs method to create image file
			File SrcFile=ss.getScreenshotAs(OutputType.FILE);
			
			
			
			//3.Copy file to Desired Location
			
		//	Date date = new Date();
			//String folderName=date.toString().replace(" ", "_").replace(":", "_");
			String FileName = date.toString().replace(" ", "_").replace(":", "_")+ "ranktracking.png";
			 //String FileName = date.toString() + "Dashboard.png";
			System.out.println("Filename="+FileName);
			File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName);
			
			
			//File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\ranktracking.png");
			
			//4.Copy file at destination
			FileUtils.copyFile(SrcFile, destFile);
			System.out.println("screenshot taken...");
			d.findElement(By.xpath("//img[@alt='Dashboard']")).click();
			Thread.sleep(5000);
	 } 
	 
	 @Test(dependsOnMethods="ranktracking")
	 public void KeywordResearch() throws InterruptedException, IOException {
		 WebElement bl=d.findElement(By.xpath("//img[@alt='Keyword Research']"));
		 Thread.sleep(5000);
		 bl.click();
		 
		 //click the dashboard button
		 d.findElement(By.xpath("//img[@alt='toggleSvg']")).click();
		 Thread.sleep(2000);
		 
		 String rt= d.getCurrentUrl();
		 System.out.println("url="+rt);
		 Thread.sleep(10000);
		 //Date date = new Date();
		 System.out.println("Date="+date);
		 
		  //take screenshot
		  // 1.convert webdriver to screenshot object.
			TakesScreenshot ss=(TakesScreenshot)d;
			
			//2. Call getScreenshotAs method to create image file
			File SrcFile=ss.getScreenshotAs(OutputType.FILE);
			
			//3.Copy file to Desired Location
			
			//String folderName=date.toString().replace(" ", "_").replace(":", "_");
			
			
			String FileName = date.toString().replace(":", "_").replace(" ", "_") + "KeywordResearch.png";
			System.out.println("Filename="+FileName);
			File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName);
			
			//4.Copy file at destination
			FileUtils.copyFile(SrcFile, destFile);
			System.out.println("screenshot taken...");
			
			d.findElement(By.xpath("//input[@placeholder='Enter a keyword']")).sendKeys("digital marketing");
			d.findElement(By.xpath("//form[@data-hs-cf-bound='true']//div//button//img")).click();
			Thread.sleep(20000);
			
			//take screenshot
			  // 1.convert webdriver to screenshot object.
				TakesScreenshot ss2=(TakesScreenshot)d;
				
				//2. Call getScreenshotAs method to create image file
				File SrcFile2=ss2.getScreenshotAs(OutputType.FILE);
				
				//3.Copy file to Desired Location
				
				String FileName2 = date.toString().replace(":", "_").replace(" ", "_") + "Keyword_Entered.png";
				System.out.println("Filename="+FileName2);
				File destFile2= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName2);
				
				//4.Copy file at destination
				FileUtils.copyFile(SrcFile2, destFile2);
				System.out.println("screenshot taken...");
			//d.findElement(By.xpath("//img[@alt='Dashboard']")).click();
	     }
	 
	 @Test(dependsOnMethods="KeywordResearch")
	 public void siteoverview() throws InterruptedException, IOException {
			 WebElement st=d.findElement(By.xpath("//img[@alt='Site Overview']"));
			 Thread.sleep(5000);
			 st.click();
			 String rt= d.getCurrentUrl();
			 System.out.println("url site overview="+rt);
			 Thread.sleep(5000);
			 
			d.findElement(By.xpath("//input[@placeholder='Enter a domain']")).sendKeys("esearchlogix.com");
			d.findElement(By.xpath("//form[@data-hs-cf-bound='true']//div//button")).click();
			Thread.sleep(5000);
			
			
			 
			
			  //take screenshot
			  // 1.convert webdriver to screenshot object.
				TakesScreenshot ss=(TakesScreenshot)d;
				
				//2. Call getScreenshotAs method to create image file
				File SrcFile=ss.getScreenshotAs(OutputType.FILE);
				
				//3.Copy file to Desired Location
				String FileName = date.toString().replace(":", "_").replace(" ", "_") + "siteOverview.png";
				System.out.println("Filename="+FileName);
				File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName);
				
				//4.Copy file at destination
				FileUtils.copyFile(SrcFile, destFile);
				System.out.println("screenshot taken...");
        	 }
	
	 @Test(dependsOnMethods="siteoverview")
	 public void Backlink() throws InterruptedException, IOException {
		 
		 WebElement bl=d.findElement(By.xpath("//div[@aria-hidden='true']//div//div//ul//li//div//div"));
		
		 bl.click();
		 Thread.sleep(2000);
		 WebElement bl_analysis=d.findElement(By.xpath("//a[@href='/backlinks']"));
		 Thread.sleep(2000);
		 
		 bl_analysis.click();
		 Thread.sleep(2000);
		 
		 WebElement domain_text=d.findElement(By.xpath("//input[@placeholder='Enter your domain']"));
		 domain_text.sendKeys("esearchlogix.com");
		 d.findElement(By.xpath("//form[@data-hs-cf-bound='true']//div//button")).click();
		 Thread.sleep(2000);
		 
		//take screenshot
		  // 1.convert webdriver to screenshot object.
			TakesScreenshot ss=(TakesScreenshot)d;
			
			//2. Call getScreenshotAs method to create image file
			File SrcFile=ss.getScreenshotAs(OutputType.FILE);
			
			//3.Copy file to Desired Location
			String FileName = date.toString().replace(" ", "_").replace(":", "_")+ "overview_tab.png";
			 //String FileName = date.toString() + "Dashboard.png";
			System.out.println("Filename="+FileName);
			File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName);
			
			//4.Copy file at destination
			FileUtils.copyFile(SrcFile, destFile);
			System.out.println("screenshot taken...");
			 Thread.sleep(2000);
		 
		 WebElement backlinks=d.findElement(By.xpath("//li[normalize-space()='Backlinks']"));
		 backlinks.click();
		 Thread.sleep(2000);
		  //take screenshot
			  // 1.convert webdriver to screenshot object.
				TakesScreenshot ss1=(TakesScreenshot)d;
				
				//2. Call getScreenshotAs method to create image file
				File SrcFile1=ss1.getScreenshotAs(OutputType.FILE);
				
				//3.Copy file to Desired Location
				String FileName1 = date.toString().replace(" ", "_").replace(":", "_")+ "backlinks_tab.png";
				 
				System.out.println("Filename="+FileName1);
				File destFile1= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName1);
				
				//4.Copy file at destination
				FileUtils.copyFile(SrcFile1, destFile1);
				System.out.println("screenshot taken...");
	    bl.click();	 
	    Thread.sleep(2000);
	    
	    WebElement bl_gap=d.findElement(By.xpath("//span[normalize-space()='Backlink Gap']"));
		bl_gap.click();
		Thread.sleep(2000);
		WebElement your_domain=d.findElement(By.xpath("//input[@placeholder='Your domain']"));
		WebElement competitor_domain=d.findElement(By.xpath("//input[@placeholder='Competitor domain']"));
		WebElement submit_button=d.findElement(By.xpath("//button[normalize-space()='Submit & Analyse']"));
		your_domain.sendKeys("esearchlogix.com");
		competitor_domain.sendKeys("ezrankings.com");
		submit_button.click();
		 Thread.sleep(2000);
		  //take screenshot
			  // 1.convert webdriver to screenshot object.
				TakesScreenshot ss2=(TakesScreenshot)d;
				
				//2. Call getScreenshotAs method to create image file
				File SrcFile2=ss2.getScreenshotAs(OutputType.FILE);
				
				//3.Copy file to Desired Location
				String FileName2 = date.toString().replace(" ", "_").replace(":", "_")+ "backlinks_gap.png";
				 
				System.out.println("Filename="+FileName2);
				File destFile2= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+folderName+"\\"+FileName2);
				
				//4.Copy file at destination
				FileUtils.copyFile(SrcFile2, destFile2);
				System.out.println("screenshot taken...");
	 }
}
