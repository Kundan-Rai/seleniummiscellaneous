package lec039;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessTesting 
{
//	1.	headless testing
	@Test
	public void testHeadless()
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");	// setting for headless mode of execution
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://demo.opencart.com/");
		Reporter.log(driver.getTitle(),true);
	}
}
