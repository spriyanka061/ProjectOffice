package Rankspro;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ranktracking {
WebDriver d;

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
		  
		//cancel the popup window  
		     d.switchTo().frame("sleek-widget");
			 WebElement popUp=d.findElement(By.xpath("//body/div[@id='app']/div/div/div/div/div/div[1]"));
		     popUp.click();
		     d.switchTo().defaultContent();
			 Thread.sleep(2000);
		  
	/*	  String title=d.getTitle();
		  System.out.println("Title="+d.getTitle());
		 
		
		  Assert.assertEquals(d.getTitle(),"RanksPro.io: Rank Tracking & SEO Analysis");
		  Thread.sleep(10000);
		  */
		 }
	
	 @Test(dependsOnMethods="Login")
	 public void ranktracking() throws InterruptedException, IOException {
		 WebElement bl=d.findElement(By.xpath("//img[@alt='Rank Tracking']"));
		 Thread.sleep(5000);
		 bl.click();
		 String rt= d.getCurrentUrl();
		 System.out.println("rt_url="+rt);
		 Thread.sleep(10000);
		 
		 WebElement ct1=d.findElement(By.xpath("//button[normalize-space()='Competitors']"));
		 
		 
		 JavascriptExecutor j = (JavascriptExecutor) d;
			j.executeScript("arguments[0].scrollIntoView(true);",ct1);
			Thread.sleep(2000);
			
            /*		 
		  //take screenshot
		  // 1.convert webdriver to screenshot object.
			TakesScreenshot ss=(TakesScreenshot)d;
			
			//2. Call getScreenshotAs method to create image file
			File SrcFile=ss.getScreenshotAs(OutputType.FILE);
			
			Date date = new Date();
			 System.out.println("date="+date);
			
			//3.Copy file to Desired Location
			String FileName = date.toString().replace(" ", "_").replace(":", "_")+ "Ranktracking.png";
			File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\Rankspro.io_Screenshots\\"+FileName);
			
			//4.Copy file at destination
			FileUtils.copyFile(SrcFile, destFile);
			System.out.println("screenshot taken...");
			d.findElement(By.xpath("//img[@alt='Dashboard']")).click();
			Thread.sleep(5000);
                     */
	 
	 } 
          	 
	 @Test(dependsOnMethods="ranktracking")
	 public void addCompetitor() throws InterruptedException {
		 WebElement ct1=d.findElement(By.xpath("//button[normalize-space()='Competitors']")); 
		 ct1.click();
		 Thread.sleep(2000);
		 WebElement ct2=d.findElement(By.xpath("//button[normalize-space()='Add Competitors']"));
		 ct2.click();
		 Thread.sleep(5000);
		 WebElement ct_no=d.findElement(By.xpath("//b[normalize-space()]"));
		 String ct_data=ct_no.getText();
		 System.out.println("text="+ct_data);
		 if (ct_data!="4/4") {
			 
			 System.out.println("you can add competitor");
			 WebElement ct_textarea=d.findElement(By.xpath("//input[@placeholder='Add Competitors']"));
			 ct_textarea.sendKeys("ezrankings.com");
			 
			 ct_textarea.sendKeys(Keys.RETURN);   //enter pressed
			 System.out.println("enter pressed...");
			 WebElement submit_button=d.findElement(By.xpath("//button[normalize-space()='Submit']"));
			 submit_button.click();
			 Thread.sleep(10000);
			 WebElement ct3=d.findElement(By.xpath("//button[normalize-space()='Competitors']")); 
			 ct3.click();
			 Thread.sleep(10000);
			 WebElement new_ct=d.findElement(By.xpath("//th[normalize-space()='ezrankings.com']"));
			 boolean new_ct_text=new_ct.isDisplayed();
			 System.out.println("text present="+new_ct_text);
			 Assert.assertEquals(true, new_ct_text);
			 
		 }
		else { System.out.println("!!!you can not add competitor:-you have already added 4 competitors"); }
	 }
	 
	 
	 @Test(dependsOnMethods="ranktracking")
	 public void deleteCompetitor() throws InterruptedException {
		 
		 WebElement bl=d.findElement(By.xpath("//img[@alt='Rank Tracking']"));
		 Thread.sleep(10000);
		 bl.click();
		 
		// WebElement ct1=d.findElement(By.xpath("//button[normalize-space()='Competitors']"));
		 //ct1.click();
		 Thread.sleep(30000);
		 WebElement ct2=d.findElement(By.xpath("//button[normalize-space()='Add Competitors']"));
		 ct2.click();
		 Thread.sleep(5000);
		 WebElement ct_no=d.findElement(By.xpath("//b[normalize-space()]"));
		 String ct_data=ct_no.getText();
		 System.out.println("text="+ct_data);
		 if (ct_data!="0/4") {
			 
			 System.out.println("you can delete competitor");
			 WebElement ct_text=d.findElement(By.xpath("//li[normalize-space()='ezrankings.com']//span"));
			 ct_text.click();
			 WebElement submit_button=d.findElement(By.xpath("//button[normalize-space()='Submit']"));
			 submit_button.click();
			 Thread.sleep(30000);
			 WebElement ct3=d.findElement(By.xpath("//button[normalize-space()='Competitors']")); 
			 ct3.click();
			 Thread.sleep(10000);
			 List <WebElement> new_ct=(List<WebElement>) d.findElement(By.xpath("//th[normalize-space()]"));
			
			 boolean project_present=true;
			 for (WebElement e : new_ct) {
			     
			        if (new_ct.size() > 0) {
			            //Can iterate the list if you expect more than one div of type someDiv.
			            String myText = e.getText();
			            if (myText.contains("ezrankings.com")) {
			                project_present=false;
			            }//if
			        }//if
			    }//for
			 
			 Assert.assertEquals(false, project_present);
		 }
		else { System.out.println("!!!you can not delete competitor:- you have no competitor added"); }
	  }

	
}

