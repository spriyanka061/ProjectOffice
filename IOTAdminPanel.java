package SeleniumWebdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class IOTAdminPanel {
	WebDriver d;
	
  @Test
  public void Login() {
	  d.get("https://demo4app.com/iot_app/admin");
      d.findElement(By.name("email")).sendKeys("admin@gmail.com");
      d.findElement(By.id("password")).sendKeys("123456");
      d.findElement(By.name("submit")).click();
      Assert.assertEquals(d.getTitle(), "Silva-Freire");
     }
  
  @Test(dependsOnMethods="Login")
  public void Home() {
	/*  WebElement usersGraph=d.findElement(By.xpath("//canvas[@id='userChart']"));
	  WebElement deviceGraph=d.findElement(By.xpath("//canvas[@id='deviceChart']"));
	  WebElement Logo=d.findElement(By.xpath("//a[@id='navbarDropdown']//img"));
	  */
	  Assert.assertTrue(d.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/canvas[1]")).isDisplayed());
	  Assert.assertTrue(d.findElement(By.xpath("//canvas[@id='userChart']")).isDisplayed());
	  Assert.assertTrue(d.findElement(By.xpath("//a[@id='navbarDropdown']//img")).isDisplayed());
			 
  }
 @BeforeClass
  public void setups() {
	  System.setProperty("Webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
      d=new ChromeDriver();
      d.manage().window().maximize();
      }
 
 
@SuppressWarnings("deprecation")
@Test(dependsOnMethods="Home",enabled=false)

public void screenshot() throws IOException {
	 // 1.convert webdriver to screenshot object.
	TakesScreenshot ss=(TakesScreenshot)d;
	
	//2. Call getScreenshotAs method to create image file
	File SrcFile=ss.getScreenshotAs(OutputType.FILE);
	
	//3.Copy file to Desired Location
	File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\ScreenshotsOfTesting\\home.png");
	
	//4.Copy file at destination
	FileUtils.copyFile(SrcFile, destFile);
 }

@SuppressWarnings("deprecation")
@Test(dependsOnMethods="Home")
public void profile() throws IOException {
	d.findElement(By.xpath("//a[@id='navbarDropdown']//img")).click();
	d.findElement(By.xpath("//div[@aria-labelledby='navbarDropdown']//a[contains(text(),'Profile')]")).click();
	d.findElement(By.xpath("//input[@value='Submit']")).click();
	Boolean msg=d.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed();
	Assert.assertTrue(msg);
	WebElement msgText=d.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
System.out.println("="+msgText.getText()+"=");
	Assert.assertEquals(msgText.getText(),"×\n"
			+ "Success! Profile updated successfully !");
	
	//change password--
	d.findElement(By.xpath("//a[@id='navbarDropdown']//img")).click();
	d.findElement(By.xpath("//div[@aria-labelledby='navbarDropdown']//a[contains(text(),'Change Password')]")).click();
	d.findElement(By.xpath("//input[@placeholder='Old Password']")).sendKeys("123456");
	d.findElement(By.xpath("//input[@placeholder='New Password']")).sendKeys("123456");
	d.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("123456");
	d.findElement(By.xpath("//input[@value='Submit']")).click();
	WebElement errormsg=d.findElement(By.xpath("//p[normalize-space()='The new and old must be different.']"));
	Assert.assertEquals(errormsg.getText(),"The new and old must be different.");
	
	
/*	 // 1.convert webdriver to screenshot object.
		TakesScreenshot ss=(TakesScreenshot)d;
		
		//2. Call getScreenshotAs method to create image file
		File SrcFile=ss.getScreenshotAs(OutputType.FILE);
		
		//3.Copy file to Desired Location
		File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\ScreenshotsOfTesting\\password.png");
		
		//4.Copy file at destination
		FileUtils.copyFile(SrcFile, destFile);
*/		
}



  @AfterClass
  public void exit(){
	  d.close();
  }
}
