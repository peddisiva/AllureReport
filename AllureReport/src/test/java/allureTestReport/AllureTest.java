package allureTestReport;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class AllureTest {
	WebDriver driver;
	
  @Test(priority=1)
  public void logoTest() {
	  boolean status = driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
	  Assert.assertEquals(status, true);
  }
  
  @Test(priority=2)
  public void loginTest() {
	  driver.findElement(By.xpath("//a[@class='ico-login']")).click();
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("pavanoltraning@gmail.com");
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test@123");
	  driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	  
	  Assert.assertEquals(driver.getTitle(), "nopCommerce demo store123");
  }
  
  @Test(priority=3)
  public void skipTest() {
	  throw new SkipException("This test is skipped");
  }
  
  @BeforeClass
  public void beforeClass() {
	  	System.setProperty("webdriver.chrome.driver", "E:\\developing\\java\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "https://demo.nopcommerce.com/";
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
