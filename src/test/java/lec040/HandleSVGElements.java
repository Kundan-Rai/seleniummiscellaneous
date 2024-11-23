package lec040;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSVGElements
{
	@Test
	public void testSVGElements()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.cssSelector("[type='password']")).sendKeys("admin123");
		
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		// Click on svg element
		driver.findElement(By.xpath("//*[contains(@href,'viewTimeModule')]//*[name()='svg']")).click();
	}
}
