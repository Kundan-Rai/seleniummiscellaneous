package lec038;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingUsingJavascriptExecutor
{
	@Test
	public void scrollUsingJavascriptExecutor() throws InterruptedException
	{
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		ChromeDriver driver = new ChromeDriver();
//		JavascriptExecutor js = driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/geography/flags-of-the-world/");
	
		// Scroll by pixel
//		js.executeScript("window.scrollBy(0, 1500)");
//		System.out.println(js.executeScript("return window.pageYOffset"));
//		System.out.println(js.executeScript("return window.scrollY"));
	
		// Scroll to specific element
//		WebElement indiaFlag = driver.findElement(By.xpath("//div[text()='India']"));
//		js.executeScript("arguments[0].scrollIntoView()", indiaFlag);
//		System.out.println(js.executeScript("return window.scrollY"));
		
		// Scroll till the bottom of the page (vertical scrolling)
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
//		js.executeScript("window.scrollBy(0, window.document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.scrollY"));
	
		// Scroll back to the initial position (vertical scrolling)
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.scrollY"));
	
		// for scrolling horizontally, we have to use 1st argument. It represents x axis
		// Instead of scrollHeight we have to use scrollWidth
	}
}
