package lec038;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetElementTextUsingJavascriptExecutor
{
	@Test
	public void getTextUsingJavascriptExecutor()
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		ChromeDriver driver = new ChromeDriver();
//		JavascriptExecutor js = driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// Get "Dynamic Button" text
		WebElement dynamicButton = driver.findElement(By.cssSelector("#HTML5>h2"));
//		System.out.println(dynamicButton.getText());
//		System.out.println(dynamicButton.getAttribute("innerText"));
		System.out.println(dynamicButton.getAttribute("textContent"));
		
//		String dynamicButtonText = (String)js.executeScript("return arguments[0].innerText;", dynamicButton);
//		String dynamicButtonText = js.executeScript("return arguments[0].textContent;", dynamicButton).toString();
//		System.out.println(dynamicButtonText);
	}
}
