package lec038;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnterTexaAndClickUsingJavascriptExecutor
{
//	@Test
	public void enterTextUsingJavascriptExecutor()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		ChromeDriver driver = new ChromeDriver();
//		JavascriptExecutor js = driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// Enter name
		
		// one way
//		driver.findElement(By.id("name")).sendKeys("John");
		
		// second way
		WebElement nameField = driver.findElement(By.id("name"));
//		js.executeScript("arguments[0].setAttribute('value', 'John Player');", nameField);
		js.executeScript("arguments[0].value='John Player';", nameField);
		
		// third way
//		js.executeScript("document.getElementById('name').value='John Bravo';");
		
	}
	
	@Test
	public void clickUsingJavascriptExexutor()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		ChromeDriver driver = new ChromeDriver();
//		JavascriptExecutor js = driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement maleRadioButton = driver.findElement(By.cssSelector("#male"));
//		maleRadioButton.click();
		
//		js.executeScript("arguments[0].checked=true", maleRadioButton);
		js.executeScript("arguments[0].click();", maleRadioButton);
	}
	
}
