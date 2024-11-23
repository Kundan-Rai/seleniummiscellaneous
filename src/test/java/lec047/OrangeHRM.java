package lec047;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners (lec047.MyListener.class)	// Not recommended approach
public class OrangeHRM
{
	WebDriver driver;
	
	@BeforeClass
	 public void setUp() throws InterruptedException
	 {
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 }
	
	@AfterClass
	public void testDown()
	{
		driver.close();
	}
	 
	 @Test (priority = 1)
	 public void verifyLogo()
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[alt='company-branding']")));
		 
		 boolean isLogoPresent = logo.isDisplayed();
		 Assert.assertTrue(isLogoPresent);
	 }
	 
	 @Test (priority = 2, description = "Failing this test case intentionally")
	 public void testAppURL()
	 {
		 String expectedURL = "https://opensource-demo.orangehrmlive.com/";
		 
		 Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
	 }
	 
	 @Test (dependsOnMethods = "testAppURL")
	 public void testHomePageTitle()
	 {
		 String expectedTitle = "OrangeHRM";
		 Assert.assertEquals(driver.getTitle(), expectedTitle);
	 }
}
