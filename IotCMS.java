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

public class IotCMS {
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
  public void addTestimonial() throws InterruptedException, IOException {
	  
	  d.findElement(By.xpath("//a[normalize-space()='CMS']")).click();
	  d.findElement(By.xpath("//a[normalize-space()='Testimonial']")).click();
	  
	  WebElement addtestimonial=d.findElement(By.xpath("(//button[normalize-space()='Add Testimonial'])[1]"));
	  addtestimonial.click();
	 System.out.println("name="+d.findElement(By.xpath("(//input[@id='name'])[1]")).getText());
	  d.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")).sendKeys("asdf");
	  d.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/input[1]")).sendKeys("Tester");
	  d.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[3]/div[1]/textarea[1]")).sendKeys("message content for testing");
	  d.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[3]/button[2]")).click();
	//d.wait(2000);
	  Thread.sleep(5000);
	  
	  
	  //take screenshot
	  // 1.convert webdriver to screenshot object.
		TakesScreenshot ss=(TakesScreenshot)d;
		
		//2. Call getScreenshotAs method to create image file
		File SrcFile=ss.getScreenshotAs(OutputType.FILE);
		
		//3.Copy file to Desired Location
		File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\ScreenshotsOfTesting\\DataAdd.png");
		
		//4.Copy file at destination
		FileUtils.copyFile(SrcFile, destFile);
	
	 /* WebElement toprow=d.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]"));
	    System.out.println(toprow.getText());
	 */ 
	
/*     d.findElement(By.xpath("//tbody/tr[1]/td[6]/a[1]")).click();
	 //System.out.println("edit clicked.");
	 // WebElement editText=d.findElement(By.xpath("(//h6[normalize-space()='Edit Testimonial'])[1]"));
	 // System.out.println(editText.getText());
	  //Assert.assertEquals(editText.getText(),"Edit Testimonial");
	  	  d.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]/button[2]")).click();
   
	  WebElement testimonialButton=d.findElement(By.xpath("//h2[normalize-space()='Manage Testimonial']"));
	  Assert.assertEquals(testimonialButton.getText(),"Manage Testimonial ");
*/	  
  }
  //---delete testimonial----
	
  @Test(dependsOnMethods="addTestimonial")
  public void deleteTestimonial() throws InterruptedException, IOException 
  {
	  d.findElement(By.xpath("//tbody/tr[1]/td[6]/a[2]")).click();
	  d.switchTo().alert().accept(); //ok clicked.
	  Thread.sleep(3000);
	  // 1.convert webdriver to screenshot object.
		TakesScreenshot ss=(TakesScreenshot)d;
		
		//2. Call getScreenshotAs method to create image file
		File SrcFile=ss.getScreenshotAs(OutputType.FILE);
		
		//3.Copy file to Desired Location
		File destFile= new File("C:\\Users\\Esearchlogix\\Desktop\\TestData\\ScreenshotsOfTesting\\dataDeleted.png");
		
		//4.Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, destFile);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  @BeforeClass
  public void setups() {
	  System.setProperty("Webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
      d=new ChromeDriver();
      d.manage().window().maximize();
    }

  @AfterClass
  public void exit(){
	  d.close();
  }

}
